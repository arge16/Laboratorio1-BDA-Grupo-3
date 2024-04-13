package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.Estado_TareaEntity;

import java.util.List;
public interface EmergenciaRepository {

    List<EmergenciaEntity> findAll();
    List<EmergenciaEntity> findAllPagination(int size, int page);

    List<EmergenciaEntity> findAllUncompleted(int size, int page);

    public List<EmergenciaEntity> findHabilidadesByEmergencia(Long id_emergencia);

        EmergenciaEntity findById(Long id);
    EmergenciaEntity create(EmergenciaEntity emergencia);
    EmergenciaEntity update(EmergenciaEntity emergencia);


    Boolean delete(Long id); // en caso de q de error da false
}
