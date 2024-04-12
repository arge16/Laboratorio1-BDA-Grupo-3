package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.Vol_HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Vol_HabilidadRepositoryImpl implements Vol_HabilidadRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Vol_HabilidadEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM vol_habilidad";
            return connection.createQuery(query).executeAndFetch(Vol_HabilidadEntity.class);
        }
    }
    @Override
    public List<Vol_HabilidadEntity> findAllPagination(int size, int page){
        String sqlQuery = "Select * FROM vol_habilidad LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(Vol_HabilidadEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    @Override
    public Vol_HabilidadEntity findById(Long id_vol_habilidad) {
        String sqlQuery = "SELECT * FROM vol_habilidad WHERE id_vol_habilidad = :id_vol_habilidad";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_vol_habilidad", id_vol_habilidad)
                    .executeAndFetchFirst(Vol_HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public Vol_HabilidadEntity create(Vol_HabilidadEntity vol_habilidad) {
        String sqlInsertQuery = "INSERT INTO vol_habilidad(id_voluntario, id_habilidad, nivel_proficiencia) VALUES(:id_voluntario, :id_habilidad, :nivel_proficiencia)";
        try (Connection con = sql2o.open()){
            Long id = con.createQuery(sqlInsertQuery).bind(vol_habilidad).executeUpdate().getKey(Long.class);
            return findById(id);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public void update(Vol_HabilidadEntity vol_habilidad) {

    }

    @Override
    public void delete(Long id) {

    }
}
