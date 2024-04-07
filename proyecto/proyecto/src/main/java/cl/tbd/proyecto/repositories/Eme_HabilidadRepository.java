package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.EmergenciaEntity;

import java.util.List;

public interface Eme_HabilidadRepository {

    List<Eme_HabilidadEntity> findAll();
    void create(Eme_HabilidadEntity emergencia);
    Eme_HabilidadEntity findById(Long id);
    void update(Eme_HabilidadEntity emergencia);
    void delete(Long id);
}
