package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.Tarea_HabilidadEntity;


import java.util.List;
public interface Tarea_HabilidadRepository {

    List<Tarea_HabilidadEntity> findAll();
    void create(Tarea_HabilidadEntity tarea_habilidad);
    Tarea_HabilidadEntity findById(Long id);
    void update(Tarea_HabilidadEntity tarea_habilidad);
    void delete(Long id);
}
