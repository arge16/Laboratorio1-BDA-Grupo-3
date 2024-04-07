package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.TareaEntity;
import cl.tbd.proyecto.entities.Tarea_HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Tarea_HabilidadRepositoryImpl implements Tarea_HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea_HabilidadEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM tarea_habilidad";
            return connection.createQuery(query).executeAndFetch(Tarea_HabilidadEntity.class);
        }
    }

    @Override
    public Tarea_HabilidadEntity findById(Long id) {
        String sqlQuery = "SELECT * FROM tarea_habilidad WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public void create(Tarea_HabilidadEntity tarea_habilidad) {

    }


    @Override
    public void update(Tarea_HabilidadEntity tarea_habilidad) {

    }

    @Override
    public void delete(Long id) {

    }
}
