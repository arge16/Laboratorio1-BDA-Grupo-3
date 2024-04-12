package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
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
    public List<RankingEntity> findAllPagination(int size, int page){
        String sqlQuery = "Select * FROM ranking LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(RankingEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    @Override
    public RankingEntity findById(Long id_ranking) {
        String sqlQuery = "SELECT * FROM ranking WHERE id_ranking = :id_ranking";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_ranking", id_ranking)
                    .executeAndFetchFirst(RankingEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public RankingEntity create(RankingEntity ranking) {
        String sqlInsertQuery = "INSERT INTO ranking(id_voluntario, id_tarea, puntuacion) VALUES(:id_voluntario, :id_tarea, :puntuacion)";
        try (Connection con = sql2o.open()){
            Long id = con.createQuery(sqlInsertQuery).bind(ranking).executeUpdate().getKey(Long.class);
            return findById(id);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public void update(RankingEntity ranking) {

    }

    @Override
    public Boolean delete(Long id) {
        String sqlDeleteQuery = "DELETE FROM ranking WHERE id_ranking = :id";
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
