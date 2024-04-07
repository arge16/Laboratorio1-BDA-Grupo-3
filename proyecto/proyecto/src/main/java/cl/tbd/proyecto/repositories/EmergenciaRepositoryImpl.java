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
    public EmergenciaEntity findById(Long id) {
        String sqlQuery = "SELECT * FROM emergencia WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public void create(EmergenciaEntity emergencia) {

    }

    @Override
    public void update(EmergenciaEntity emergencia) {

    }

    @Override
    public void delete(Long id) {

    }
}
