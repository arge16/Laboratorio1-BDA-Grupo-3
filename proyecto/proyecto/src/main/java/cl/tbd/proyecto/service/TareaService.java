package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.HabilidadEntity;
import cl.tbd.proyecto.entities.TareaEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import cl.tbd.proyecto.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

    public List<TareaEntity> getAllTareas(){
        return tareaRepository.findAll();
    }

    public List<TareaEntity> getPageTareas(int size, int page){
        return tareaRepository.findAllPagination(size, page);
    }

    public TareaEntity createTarea(TareaEntity tarea) {
        return tareaRepository.create(tarea);
    }

    public Boolean deleteTarea(Long id){
        return tareaRepository.delete(id);
    }

}
