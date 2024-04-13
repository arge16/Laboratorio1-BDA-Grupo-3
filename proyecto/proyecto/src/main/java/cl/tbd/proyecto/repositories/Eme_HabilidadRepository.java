package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
<<<<<<< HEAD
=======
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.HabilidadEntity;
import org.sql2o.Query;
>>>>>>> 88b3898254e551c3585e64f7873264c852901124

import java.util.List;

public interface Eme_HabilidadRepository {

    List<Eme_HabilidadEntity> findAll();

    List<Eme_HabilidadEntity> findAllPagination(int size, int page);

    Eme_HabilidadEntity create(Eme_HabilidadEntity eme_habilidad);

    List<HabilidadEntity> findHabilidadesByEmergencia(Long id_emergencia);

    Eme_HabilidadEntity findById(Long id);

    Eme_HabilidadEntity update(Eme_HabilidadEntity eme_habilidad);

    Boolean delete(Long id);

}
