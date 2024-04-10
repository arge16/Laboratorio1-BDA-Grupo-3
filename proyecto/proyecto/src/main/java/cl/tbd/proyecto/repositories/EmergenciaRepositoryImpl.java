package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.Estado_TareaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImpl implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<EmergenciaEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM emergencia";
            return connection.createQuery(query).executeAndFetch(EmergenciaEntity.class);
        }
    }

    @Override
    public EmergenciaEntity findById(Long id_emergencia) {
        String sqlQuery = "SELECT * FROM emergencia WHERE id_emergencia = :id_emergencia";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetchFirst(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public EmergenciaEntity create(EmergenciaEntity emergencia) {
        String sqlInsertQuery =  "INSERT INTO emergencia VALUES(:id, :nombre, :descripcion, :fecha_inicio, :fecha_fin, :id_institucion)";
        try(Connection connection = sql2o.open()){
            connection.createQuery(sqlInsertQuery).bind(emergencia).executeUpdate();
            return findById(emergencia.getId()); // ver si es efectivo asi, si no, devolver emergencia
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public EmergenciaEntity update(EmergenciaEntity emergencia) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
