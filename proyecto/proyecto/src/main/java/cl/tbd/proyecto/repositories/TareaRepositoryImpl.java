package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.TareaEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImpl implements TareaRepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<TareaEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM tarea";
            return connection.createQuery(query).executeAndFetch(TareaEntity.class);
        }
    }
    @Override
    public List<TareaEntity> findAllPagination(int size, int page){
        String sqlQuery = "Select * FROM tarea LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(TareaEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public TareaEntity findById(Long id_tarea) {
        String sqlQuery = "SELECT * FROM tarea WHERE id_tarea = :id_tarea";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetchFirst(TareaEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public TareaEntity create(TareaEntity tarea) {
        String sqlInsertQuery = "INSERT INTO tarea(descripcion, id_emergencia, completada) VALUES(:descripcion, :id_emergencia, :completada)";
        try (Connection con = sql2o.open()){
            Long id = con.createQuery(sqlInsertQuery).bind(tarea).executeUpdate().getKey(Long.class);
            return findById(id);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public TareaEntity update(TareaEntity tarea) {
        String sqlUpdateQuery = "UPDATE tarea SET descripcion = :descripcion, id_emergencia = :id_emergencia, completada = :completada WHERE id_tarea = :id_tarea";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlUpdateQuery)
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("completada", tarea.getCompletada())
                    .addParameter("id_tarea", tarea.getId())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar la tarea: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        String sqlDeleteQuery = "DELETE FROM tarea WHERE id_tarea = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlDeleteQuery)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
}
