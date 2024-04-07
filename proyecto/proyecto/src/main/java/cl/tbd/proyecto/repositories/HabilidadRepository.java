package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.HabilidadEntity;


import java.util.List;
public interface HabilidadRepository {

    List<HabilidadEntity> findAll();
    void create(HabilidadEntity habilidad);
    HabilidadEntity findById(Long id);
    void update(HabilidadEntity habilidad);
    void delete(Long id);
}
