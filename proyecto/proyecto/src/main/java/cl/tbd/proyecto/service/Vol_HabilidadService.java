package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.Vol_HabilidadEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import cl.tbd.proyecto.repositories.Vol_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Vol_HabilidadService {
    @Autowired
    Vol_HabilidadRepository volHabilidadRepository;

    public List<Vol_HabilidadEntity> getAllVolHabilidades(){
        return volHabilidadRepository.findAll();
    }

    public List<Vol_HabilidadEntity> getPageVolHabilidades(int size, int page){
        return volHabilidadRepository.findAllPagination(size, page);
    }

    public Vol_HabilidadEntity createVolHabilidades(Vol_HabilidadEntity volHabilidad) {
        return volHabilidadRepository.create(volHabilidad);
    }

    public Vol_HabilidadEntity updateVolHabilidades(Vol_HabilidadEntity volHabilidad) {
        return volHabilidadRepository.update(volHabilidad);
    }

    public Boolean deleteVolHabilidad(Long id){
        return volHabilidadRepository.delete(id);
    }
}
