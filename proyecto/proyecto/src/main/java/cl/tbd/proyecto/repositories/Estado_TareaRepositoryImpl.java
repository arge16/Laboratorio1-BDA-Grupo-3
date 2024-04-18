package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.Estado_TareaEntity;
import cl.tbd.proyecto.entities.HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Estado_TareaRepositoryImpl implements Estado_TareaRepository {

    @Autowired
    private Sql2o sql2o;

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public List<Estado_TareaEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM estado_tarea";
            return connection.createQuery(query).executeAndFetch(Estado_TareaEntity.class);
        }
    }

    @Override
    public List<Estado_TareaEntity> findAllPagination(int size, int page){
        String sqlQuery = "Select * FROM estado_tarea LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(Estado_TareaEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    @Override
    public Estado_TareaEntity findById(Long id_estado_tarea) {
        String sqlQuery = "SELECT * FROM estado_tarea WHERE id_estado_tarea = :id_estado_tarea";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_estado_tarea", id_estado_tarea)
                    .executeAndFetchFirst(Estado_TareaEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public Estado_TareaEntity create(Estado_TareaEntity estado_tarea, String actualUser) {
        String sqlInsertQuery = "INSERT INTO estado_tarea(descripcion) VALUES(:descripcion)";
        try (Connection connection = sql2o.open()){
            Long id = connection.createQuery(sqlInsertQuery).bind(estado_tarea).executeUpdate().getKey(Long.class);
            return findById(id);
        } catch (Exception e){
            System.out.println("Error: " + e );
            return null;
        }
    }




    @Override
    public Estado_TareaEntity update(Estado_TareaEntity estado_tarea, String actualUser) {
        String sqlUpdateQuery = "UPDATE estado_tarea SET descripcion = :descripcion WHERE id_estado_tarea = :id_estado_tarea";
        try (Connection con = sql2o.open()) {
            usuarioRepository.setUsername(actualUser, con);
            con.createQuery(sqlUpdateQuery)
                    .addParameter("descripcion", estado_tarea.getDescripcion())
                    .addParameter("id_estado_tarea", estado_tarea.getId_estado_tarea())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el estado de la tarea: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean delete(Long id, String actualUser) {
        String sqlDeleteQuery = "DELETE FROM estado_tarea WHERE id_estado_tarea = :id";
        try (Connection con = sql2o.open()) {
            usuarioRepository.setUsername(actualUser, con);
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
