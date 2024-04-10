package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.InstitucionEntity;
import cl.tbd.proyecto.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepositoryImpl implements InstitucionRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<InstitucionEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM institucion";
            return connection.createQuery(query).executeAndFetch(InstitucionEntity.class);
        }
    }

    @Override
    public InstitucionEntity findById(Long id_institucion) {
        String sqlQuery = "SELECT * FROM institucion WHERE id_institucion = :id_institucion";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_institucion", id_institucion)
                    .executeAndFetchFirst(InstitucionEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public void create(InstitucionEntity institucion) {

    }


    @Override
    public void update(InstitucionEntity institucion) {

    }

    @Override
    public void delete(Long id) {

    }
}
