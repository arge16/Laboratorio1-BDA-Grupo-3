package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Estado_EmergenciaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Estado_EmergenciaRepositoryImpl implements Estado_EmergenciaRepository {
    @Autowired
    private Sql2o sql2o;

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public List<Estado_EmergenciaEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM estado_emergencia";
            return connection.createQuery(query).executeAndFetch(Estado_EmergenciaEntity.class);
        }
    }

    @Override
    public List<Estado_EmergenciaEntity> findAllPagination(int size, int page){
        String sqlQuery = "Select * FROM estado_emergencia LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(Estado_EmergenciaEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    @Override
    public Estado_EmergenciaEntity findById(Long id_estado_emergencia) {
        String sqlQuery = "SELECT * FROM estado_emergencia WHERE id_estado_emergencia = :id_estado_emergencia";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_estado_emergencia", id_estado_emergencia)
                    .executeAndFetchFirst(Estado_EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public Estado_EmergenciaEntity create(Estado_EmergenciaEntity estado_emergencia, String actualUser) {
        String sqlInsertQuery = "INSERT INTO estado_emergencia(descripcion) VALUES(:descripcion)";
        try (Connection connection = sql2o.open()){
            Long id = connection.createQuery(sqlInsertQuery).bind(estado_emergencia).executeUpdate().getKey(Long.class);
            return findById(id);
        } catch (Exception e){
            System.out.println("Error: " + e );
            return null;
        }
    }




    @Override
    public Estado_EmergenciaEntity update(Estado_EmergenciaEntity estado_emergencia, String actualUser) {
        String sqlUpdateQuery = "UPDATE estado_emergencia SET descripcion = :descripcion WHERE id_estado_emergencia = :id_estado_emergencia";
        try (Connection con = sql2o.open()) {
            usuarioRepository.setUsername(actualUser, con);
            con.createQuery(sqlUpdateQuery)
                    .addParameter("descripcion", estado_emergencia.getDescripcion())
                    .addParameter("id_estado_emergencia", estado_emergencia.getId_estado_emergencia())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el estado de la emergencia: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean delete(Long id, String actualUser) {
        String sqlDeleteQuery = "DELETE FROM estado_emergencia WHERE id_estado_emergencia = :id";
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
