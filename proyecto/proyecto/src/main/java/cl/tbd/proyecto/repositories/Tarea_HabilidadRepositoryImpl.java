package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
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
    public List<Tarea_HabilidadEntity> findAllPagination(int page, int size){
        String sqlQuery = "Select * FROM tarea_habilidad LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(Tarea_HabilidadEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    @Override
    public Tarea_HabilidadEntity findById(Long id_tarea_habilidad) {
        String sqlQuery = "SELECT * FROM tarea_habilidad WHERE id_tarea_habilidad = :id_tarea_habilidad";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_tarea_habilidad", id_tarea_habilidad)
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
