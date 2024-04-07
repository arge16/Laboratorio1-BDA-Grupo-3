package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.Estado_TareaEntity;
import cl.tbd.proyecto.entities.HabilidadEntity;

import java.util.List;
public interface Estado_TareaRepository {

    List<Estado_TareaEntity> findAll();
    void create(Estado_TareaEntity estado_tarea);
    Estado_TareaEntity findById(Long id);
    void update(Estado_TareaEntity estado_tarea);
    void delete(Long id);
}
