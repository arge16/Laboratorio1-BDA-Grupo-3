package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Estado_EmergenciaEntity;
import java.util.List;
public interface Estado_EmergenciaRepository {

    List<Estado_EmergenciaEntity> findAll();
    List<Estado_EmergenciaEntity> findAllPagination(int size, int page);
    Estado_EmergenciaEntity findById(Long id);

    Estado_EmergenciaEntity create(Estado_EmergenciaEntity estado_emergencia, String actualUser);

    Estado_EmergenciaEntity update(Estado_EmergenciaEntity estado_emergencia, String actualUser);

    Boolean delete(Long id, String actualUser);
}
