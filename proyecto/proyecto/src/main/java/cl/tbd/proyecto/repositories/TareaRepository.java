package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.TareaEntity;
import cl.tbd.proyecto.entities.Vol_HabilidadEntity;

import java.util.List;
public interface TareaRepository {

    List<TareaEntity> findAll();
    List<TareaEntity> findAllPagination(int size, int page);
    TareaEntity create(TareaEntity tarea);
    TareaEntity findById(Long id);
    void update(TareaEntity tarea);
    Boolean delete(Long id);

    List<TareaEntity> findByEmergencia(Long id_emergencia);

}
