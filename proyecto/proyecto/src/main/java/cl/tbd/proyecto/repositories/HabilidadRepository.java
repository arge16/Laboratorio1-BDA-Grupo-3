package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.HabilidadEntity;


import java.util.List;
public interface HabilidadRepository {

    List<HabilidadEntity> findAll();
    List<HabilidadEntity> findAllPagination(int size, int page);
    public List<HabilidadEntity> findHabilidadesByEmergencia(Long id_emergencia);
    HabilidadEntity create(HabilidadEntity habilidad);
    HabilidadEntity findById(Long id);
    void update(HabilidadEntity habilidad);
    Boolean delete(Long id);
}
