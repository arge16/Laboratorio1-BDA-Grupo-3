package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class VoluntarioRepositoryImpl implements VoluntarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<VoluntarioEntity> findAll() {
        try (Connection connection = sql2o.open()) {
            String query = "SELECT * FROM voluntario";
            return connection.createQuery(query).executeAndFetch(VoluntarioEntity.class);
        }
    }


    @Override
    public List<VoluntarioEntity> findAllPagination(int size, int page){
        String sqlQuery = "Select * FROM voluntario LIMIT :size OFFSET :offset";
        int offset = (page - 1) * size;
        try(Connection con = sql2o.open()){
            return con.createQuery(sqlQuery).addParameter("size", size)
                    .addParameter("offset",offset).executeAndFetch(VoluntarioEntity.class);
        }catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    @Override
    public VoluntarioEntity findById(Long id_voluntario) {
        String sqlQuery = "SELECT * FROM voluntario WHERE id_voluntario = :id_voluntario";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetchFirst(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public VoluntarioEntity create(VoluntarioEntity voluntario) {
        String sqlInsertQuery = "INSERT INTO voluntario (nombre, edad, direccion, genero, email, telefono) " +
                "VALUES(:nombre, :edad, :direccion, :genero, :email, :telefono)";
        try (Connection con = sql2o.open()){
            Long id = con.createQuery(sqlInsertQuery).bind(voluntario).executeUpdate().getKey(Long.class);
            return findById(id);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }


    @Override
    public void update(VoluntarioEntity voluntario) {

    }

    @Override
    public Boolean delete(Long id) {
        String sqlDeleteQuery = "DELETE FROM voluntario WHERE id_voluntario = :id";
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
