package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.Estado_TareaEntity;
import cl.tbd.proyecto.entities.HabilidadEntity;

import java.util.List;
public interface Estado_TareaRepository {

    List<Estado_TareaEntity> findAll();
    List<Estado_TareaEntity> findAllPagination(int size, int page);
    Estado_TareaEntity findById(Long id);


    Estado_TareaEntity create(Estado_TareaEntity estado_tarea);

    void update(Estado_TareaEntity estado_tarea);

    void delete(Long id);
}
