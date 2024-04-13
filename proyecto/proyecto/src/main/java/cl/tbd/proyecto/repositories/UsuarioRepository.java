package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.UsuarioEntity;
import java.util.List;

public interface UsuarioRepository {

    List<UsuarioEntity> findAll();

    UsuarioEntity findById(Long id);

    UsuarioEntity create(UsuarioEntity usuario);

    UsuarioEntity update(UsuarioEntity usuario);

    Boolean delete(Long id);

}
