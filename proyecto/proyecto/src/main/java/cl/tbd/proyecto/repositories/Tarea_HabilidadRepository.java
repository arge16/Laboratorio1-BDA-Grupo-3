package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.Tarea_HabilidadEntity;


import java.util.List;
public interface Tarea_HabilidadRepository {

    List<Tarea_HabilidadEntity> findAll();
    List<Tarea_HabilidadEntity> findAllPagination(int size, int page);
    Tarea_HabilidadEntity findById(Long id);


    Tarea_HabilidadEntity create(Tarea_HabilidadEntity tarea_habilidad);
<<<<<<< HEAD
    Tarea_HabilidadEntity update(Tarea_HabilidadEntity tarea_habilidad);
=======
    Tarea_HabilidadEntity createByValues(Long id_tarea, Long id_habilidad);
    void update(Tarea_HabilidadEntity tarea_habilidad);
>>>>>>> 88b3898254e551c3585e64f7873264c852901124
    Boolean delete(Long id);
}
