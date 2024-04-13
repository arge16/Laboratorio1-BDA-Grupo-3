package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.RolEntity;
import java.util.List;

public interface RolRepository {

    List<RolEntity> findAll();

    RolEntity findById(Long id);

    RolEntity create(RolEntity rol);

    RolEntity update(RolEntity rol);

    Boolean delete(Long id);

}
