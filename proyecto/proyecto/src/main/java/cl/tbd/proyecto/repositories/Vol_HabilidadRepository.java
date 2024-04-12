package cl.tbd.proyecto.repositories;

import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.Vol_HabilidadEntity;
import java.util.List;
public interface Vol_HabilidadRepository {

    List<Vol_HabilidadEntity> findAll();
    List<Vol_HabilidadEntity> findAllPagination(int size, int page);
    Vol_HabilidadEntity findById(Long id);

    Vol_HabilidadEntity create(Vol_HabilidadEntity vol_habilidad);
    void update(Vol_HabilidadEntity vol_habilidad);
    Boolean delete(Long id);
}
