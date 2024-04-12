package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Eme_HabilidadRepositoryImpl implements Eme_HabilidadRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Eme_HabilidadEntity> findAll() {
        try (Connection connection = sql2o.open()){
            String query = "SELECT * FROM eme_habilidad";
            return connection.createQuery(query).executeAndFetch(Eme_HabilidadEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

     @Override
     public List<Eme_HabilidadEntity> findAllPagination(int size, int page){
        String sqlQuery = "Select * FROM eme_habilidad LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(Eme_HabilidadEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
     }

    @Override
    public Eme_HabilidadEntity findById(Long id_eme_habilidad) {
        String sqlQuery = "SELECT * FROM eme_habilidad WHERE id_eme_habilidad = :id_eme_habilidad";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_eme_habilidad", id_eme_habilidad)
                    .executeAndFetchFirst(Eme_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public Eme_HabilidadEntity create(Eme_HabilidadEntity eme_habilidad) {
        String sqlInsertQuery = "INSERT INTO eme_habilidad(id_emergencia, id_habilidad) VALUES(:id_emergencia, :id_habilidad)";
        try (Connection con = sql2o.open()){
            Long id = con.createQuery(sqlInsertQuery).bind(eme_habilidad).executeUpdate().getKey(Long.class);
            return findById(id);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public void update(Eme_HabilidadEntity eme_habilidad) {
        String sqlUpdateQuery = "UPDATE eme_habilidad set id_emergencia = :id_emergencia WHERE id = :id_eme_habilidad";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlUpdateQuery)
                    .addParameter("id_emergencia", eme_habilidad.getId_emergencia())
                    .addParameter("id_eme_habilidad", eme_habilidad.getId())
                    .executeUpdate();
        }
    }

    @Override
    public void delete(Long id) {

    }
}
