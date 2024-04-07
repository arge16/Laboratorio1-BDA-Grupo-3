package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.Vol_HabilidadEntity;
import java.util.List;
public interface Vol_HabilidadRepository {

    List<Vol_HabilidadEntity> findAll();
    void create(Vol_HabilidadEntity vol_habilidad);
    Vol_HabilidadEntity findById(Long id);
    void update(Vol_HabilidadEntity vol_habilidad);
    void delete(Long id);
}
