package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.UsuarioEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<UsuarioEntity> findAll() {
        final String sqlQuery = "SELECT * FROM usuarios";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery).executeAndFetch(UsuarioEntity.class);
        }
    }

    @Override
    public UsuarioEntity findById(Long id) {
        final String sqlQuery = "SELECT * FROM usuarios WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("id", id)
                    .executeAndFetchFirst(UsuarioEntity.class);
        }
    }

    @Override
    public UsuarioEntity findByUsername(String username){
        String sqlQuery = "SELECT * FROM usuarios WHERE username = :username";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("username", username)
                    .executeAndFetchFirst(UsuarioEntity.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    @Override
    public Boolean Login(String username, String password) {
        String sqlQuery = "SELECT exists(SELECT *  FROM usuarios WHERE username = :username and password = :password)";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sqlQuery)
                    .addParameter("username", username)
                    .addParameter("password",password)
                    .executeAndFetchFirst(Boolean.class);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    @Override
    public UsuarioEntity create(UsuarioEntity usuario) {
        final String sqlInsertQuery = "INSERT INTO usuarios (username, password, email, rol_id) " +
                "VALUES (:username, :password, :email, :rolId)";
        try (Connection con = sql2o.open()) {
            Long insertedId = con.createQuery(sqlInsertQuery, true)
                    .bind(usuario)
                    .executeUpdate()
                    .getKey(Long.class);
            usuario.setId(insertedId);
            return usuario;
        }
    }

    @Override
    public UsuarioEntity update(UsuarioEntity usuario) {
        final String sqlUpdateQuery = "UPDATE usuarios SET username = :username, password = :password, email = :email, rol_id = :rolId WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlUpdateQuery)
                    .bind(usuario)
                    .executeUpdate();
            return usuario;
        }
    }

    @Override
    public Boolean delete(Long id) {
        final String sqlDeleteQuery = "DELETE FROM usuarios WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sqlDeleteQuery)
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        }
    }
}
