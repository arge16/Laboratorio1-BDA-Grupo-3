package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.Estado_TareaEntity;

import java.util.List;
public interface EmergenciaRepository {

    List<EmergenciaEntity> findAll();
    void create(EmergenciaEntity emergencia);
    EmergenciaEntity findById(Long id);
    void update(EmergenciaEntity emergencia);
    void delete(Long id);
}
