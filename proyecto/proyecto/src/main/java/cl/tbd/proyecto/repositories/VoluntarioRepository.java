package cl.tbd.proyecto.repositories;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import java.util.List;
public interface VoluntarioRepository {

    List<VoluntarioEntity> findAll();

    List<VoluntarioEntity> findAllPagination(int size, int page);

    VoluntarioEntity findById(Long id);

    VoluntarioEntity create(VoluntarioEntity voluntario);


    void update(VoluntarioEntity voluntario);

    Boolean delete(Long id);

}
