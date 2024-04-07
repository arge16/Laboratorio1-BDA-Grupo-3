package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.RankingEntity;
import cl.tbd.proyecto.entities.Tarea_HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImpl implements RankingRepository {

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<RankingEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM ranking";
            return connection.createQuery(query).executeAndFetch(RankingEntity.class);
        }
    }

    @Override
    public RankingEntity findById(Long id) {
        String sqlQuery = "SELECT * FROM ranking WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(RankingEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public void create(RankingEntity ranking) {

    }


    @Override
    public void update(RankingEntity ranking) {

    }

    @Override
    public void delete(Long id) {

    }
}
