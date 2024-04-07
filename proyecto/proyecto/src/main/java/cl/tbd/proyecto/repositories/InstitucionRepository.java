package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.InstitucionEntity;
import cl.tbd.proyecto.entities.RankingEntity;

import java.util.List;
public interface InstitucionRepository {

    List<InstitucionEntity> findAll();
    void create(InstitucionEntity institucion);
    InstitucionEntity findById(Long id);
    void update(InstitucionEntity institucion);
    void delete(Long id);
}
