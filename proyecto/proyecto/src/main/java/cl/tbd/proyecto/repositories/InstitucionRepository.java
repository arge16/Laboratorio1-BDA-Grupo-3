package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.InstitucionEntity;
import cl.tbd.proyecto.entities.RankingEntity;

import java.util.List;
public interface InstitucionRepository {

    List<InstitucionEntity> findAll();
    List<InstitucionEntity> findAllPagination(int size, int page);

    InstitucionEntity create(InstitucionEntity institucion);
    InstitucionEntity findById(Long id);
    void update(InstitucionEntity institucion);
    Boolean delete(Long id);
}
