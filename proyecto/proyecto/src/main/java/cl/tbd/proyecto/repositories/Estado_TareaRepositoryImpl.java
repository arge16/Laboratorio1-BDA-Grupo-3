package cl.tbd.proyecto.repositories;

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


    @Override
    public List<Estado_TareaEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM estado_tarea";
            return connection.createQuery(query).executeAndFetch(Estado_TareaEntity.class);
        }
    }

    @Override
    public Estado_TareaEntity findById(Long id_estado_tarea) {
        String sqlQuery = "SELECT * FROM estado_tarea WHERE id_estado_tarea = :id_estado_tarea";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id_estado_tarea)
                    .executeAndFetchFirst(Estado_TareaEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public void create(Estado_TareaEntity estado_tarea) {

    }


    @Override
    public void update(Estado_TareaEntity estado_tarea) {

    }

    @Override
    public void delete(Long id) {

    }
}
