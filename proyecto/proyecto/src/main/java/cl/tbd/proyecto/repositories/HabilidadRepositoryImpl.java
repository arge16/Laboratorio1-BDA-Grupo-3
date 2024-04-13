package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.HabilidadEntity;
import cl.tbd.proyecto.entities.InstitucionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepositoryImpl implements HabilidadRepository {

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<HabilidadEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM habilidad";
            return connection.createQuery(query).executeAndFetch(HabilidadEntity.class);
        }
    }

    @Override
    public List<HabilidadEntity> findAllPagination(int size, int page){
        String sqlQuery = "Select * FROM habilidad LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(HabilidadEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public HabilidadEntity findById(Long id_habilidad) {
        String sqlQuery = "SELECT * FROM habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_habilidad", id_habilidad)
                    .executeAndFetchFirst(HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public List<HabilidadEntity> findHabilidadesByEmergencia(Long id_emergencia) {
        String sqlQuery = "SELECT h.id_habilidad, h.nombre, h.descripcion, h.certificacion_requerida FROM habilidad h JOIN public.eme_habilidad eh on h.id_habilidad = eh.id_habilidad JOIN public.emergencia e on eh.id_emergencia = e.id_emergencia WHERE e.id_emergencia = :id_emergencia";
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("id_emergencia",id_emergencia).executeAndFetch(HabilidadEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    @Override
    public HabilidadEntity create(HabilidadEntity habilidad) {
        String sqlInsertQuery = "INSERT INTO habilidad(nombre, descripcion, certificacion_requerida) VALUES(:nombre, :descripcion, :certificacion_requerida)";
        try (Connection con = sql2o.open()){
            Long id = con.createQuery(sqlInsertQuery).bind(habilidad).executeUpdate().getKey(Long.class);
            return findById(id);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public void update(HabilidadEntity habilidad) {

    }

    @Override
    public Boolean delete(Long id) {
        String sqlDeleteQuery = "DELETE FROM habilidad WHERE id_habilidad = :id";
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

