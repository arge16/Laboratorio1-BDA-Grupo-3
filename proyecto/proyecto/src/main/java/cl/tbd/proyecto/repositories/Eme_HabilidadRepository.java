package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import org.sql2o.Query;

import java.util.List;

public interface Eme_HabilidadRepository {

    List<Eme_HabilidadEntity> findAll();
    Eme_HabilidadEntity create(Eme_HabilidadEntity emergencia);
    Eme_HabilidadEntity findById(Long id);
    void update(Eme_HabilidadEntity emergencia);
    void delete(Long id);
}
