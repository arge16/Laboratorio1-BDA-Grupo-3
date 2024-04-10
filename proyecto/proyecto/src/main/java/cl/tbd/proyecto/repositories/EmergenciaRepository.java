package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.Estado_TareaEntity;

import java.util.List;
public interface EmergenciaRepository {

    List<EmergenciaEntity> findAll();
    EmergenciaEntity findById(Long id);
    EmergenciaEntity create(EmergenciaEntity emergencia);
    EmergenciaEntity update(EmergenciaEntity emergencia);
    Boolean delete(Long id); // en caso de q de error da false
}
