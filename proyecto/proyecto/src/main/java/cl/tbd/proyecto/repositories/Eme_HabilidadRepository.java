package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.Eme_HabilidadEntity;

import java.util.List;

public interface Eme_HabilidadRepository {

    List<Eme_HabilidadEntity> findAll();

    List<Eme_HabilidadEntity> findAllPagination(int size, int page);

    Eme_HabilidadEntity create(Eme_HabilidadEntity eme_habilidad);

    Eme_HabilidadEntity findById(Long id);

    Eme_HabilidadEntity update(Eme_HabilidadEntity eme_habilidad);

    Boolean delete(Long id);

}
