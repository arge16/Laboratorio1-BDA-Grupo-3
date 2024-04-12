package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.Estado_TareaEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import cl.tbd.proyecto.repositories.Estado_TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class Estado_TareaService {
    @Autowired
    Estado_TareaRepository estadoTareaRepository;

    public List<Estado_TareaEntity> getAllEstadoTareas(){
        return estadoTareaRepository.findAll();
    }

    public List<Estado_TareaEntity> getPageEstadoTareas(int size, int page){
        return estadoTareaRepository.findAllPagination(size, page);
    }

    public Estado_TareaEntity cresteEstadoTarea(Estado_TareaEntity estadoTarea) {
        return estadoTareaRepository.create(estadoTarea);
    }

    public Boolean deleteEstadoTarea(Long id){
        return estadoTareaRepository.delete(id);
    }
}
