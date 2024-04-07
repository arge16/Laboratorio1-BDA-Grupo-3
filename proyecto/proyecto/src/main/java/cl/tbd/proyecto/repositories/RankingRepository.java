package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.RankingEntity;
import cl.tbd.proyecto.entities.Tarea_HabilidadEntity;

import java.util.List;
public interface RankingRepository {

    List<RankingEntity> findAll();
    void create(RankingEntity ranking);
    RankingEntity findById(Long id);
    void update(RankingEntity ranking);
    void delete(Long id);
}
