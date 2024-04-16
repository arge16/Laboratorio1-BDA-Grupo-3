package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.HabilidadEntity;


import java.util.List;
public interface HabilidadRepository {

    List<HabilidadEntity> findAll();
    List<HabilidadEntity> findAllPagination(int size, int page);
    public List<HabilidadEntity> findHabilidadesByEmergencia(Long id_emergencia);
    HabilidadEntity create(HabilidadEntity habilidad, String actualUser);
    HabilidadEntity findById(Long id);
    HabilidadEntity update(HabilidadEntity habilidad, String actualUser);
    Boolean delete(Long id, String actualUser);
}
