package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.Estado_EmergenciaEntity;
import cl.tbd.proyecto.repositories.Estado_EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Estado_EmergenciaService {


    @Autowired
    Estado_EmergenciaRepository estadoEmergenciaRepository;

    public List<Estado_EmergenciaEntity> getAllEstadoEmergencias(){
        return estadoEmergenciaRepository.findAll();
    }

    public List<Estado_EmergenciaEntity> getPageEstadoEmergencias(int size, int page){
        return estadoEmergenciaRepository.findAllPagination(size, page);
    }

    public Estado_EmergenciaEntity createEstadoEmergencia(Estado_EmergenciaEntity estadoEmergencia) {
        return estadoEmergenciaRepository.create(estadoEmergencia);
    }

    public Boolean deleteEstadoEmergencia(Long id){
        return estadoEmergenciaRepository.delete(id);
    }

    public Estado_EmergenciaEntity updateEstadoEmergencia(Estado_EmergenciaEntity estadoEmergencia) {
        return estadoEmergenciaRepository.update(estadoEmergencia);
    }
}
