package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.TareaEntity;
import cl.tbd.proyecto.entities.Vol_HabilidadEntity;

import java.util.List;
public interface TareaRepository {

    List<TareaEntity> findAll();
    void create(TareaEntity tarea);
    TareaEntity findById(Long id);
    void update(TareaEntity tarea);
    void delete(Long id);

}
