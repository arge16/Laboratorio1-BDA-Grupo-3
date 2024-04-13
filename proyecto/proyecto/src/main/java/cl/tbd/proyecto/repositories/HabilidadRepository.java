package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.HabilidadEntity;


import java.util.List;
public interface HabilidadRepository {

    List<HabilidadEntity> findAll();
    List<HabilidadEntity> findAllPagination(int size, int page);

    HabilidadEntity create(HabilidadEntity habilidad);
    HabilidadEntity findById(Long id);
    HabilidadEntity update(HabilidadEntity habilidad);
    Boolean delete(Long id);
}
