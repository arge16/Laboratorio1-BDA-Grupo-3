package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.RankingEntity;
import cl.tbd.proyecto.entities.Tarea_HabilidadEntity;

import java.util.List;
public interface RankingRepository {

    List<RankingEntity> findAll();
    List<RankingEntity> findAllPagination(int size, int page);
    RankingEntity findById(Long id);


    RankingEntity create(RankingEntity ranking);
    void update(RankingEntity ranking);
    Boolean delete(Long id);
}
