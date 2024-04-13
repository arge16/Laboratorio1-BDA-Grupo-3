package cl.tbd.proyecto.service;


import cl.tbd.proyecto.entities.HabilidadEntity;
import cl.tbd.proyecto.entities.InstitucionEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import cl.tbd.proyecto.repositories.HabilidadRepository;
import cl.tbd.proyecto.repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class HabilidadService{

    @Autowired
    HabilidadRepository habilidadRepository;
    public List<HabilidadEntity> getAllHabilidades(){
        return habilidadRepository.findAll();
    }

    public List<HabilidadEntity> getPageHabilidades(int size, int page){
        return habilidadRepository.findAllPagination(size, page);
    }

    public HabilidadEntity createHabilidad(HabilidadEntity habilidad) {
        return habilidadRepository.create(habilidad);
    }

    public Boolean deleteHabilidad(Long id){
        return habilidadRepository.delete(id);
    }

    public HabilidadEntity updateHabilidad(HabilidadEntity habilidad) {return habilidadRepository.update(habilidad);}
}
