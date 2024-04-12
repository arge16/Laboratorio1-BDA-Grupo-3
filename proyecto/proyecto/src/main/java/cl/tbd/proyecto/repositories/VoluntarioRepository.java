package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import java.util.List;
public interface VoluntarioRepository {

    List<VoluntarioEntity> findAll();

    List<VoluntarioEntity> findAllPagination(int size, int page);

    VoluntarioEntity create(VoluntarioEntity voluntario);

    VoluntarioEntity findById(Long id);

    void update(VoluntarioEntity voluntario);

    void delete(Long id);

}
