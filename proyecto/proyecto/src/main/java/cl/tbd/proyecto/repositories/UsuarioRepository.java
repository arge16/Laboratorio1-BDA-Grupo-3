package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.UsuarioEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UsuarioRepository {

    List<UsuarioEntity> findAll();

    UsuarioEntity findById(Long id);

    UsuarioEntity findByUsername(String username);

    Boolean Login(String username, String Password);

    UsuarioEntity create(UsuarioEntity usuario);

    UsuarioEntity update(UsuarioEntity usuario);

    Boolean delete(Long id);

}
