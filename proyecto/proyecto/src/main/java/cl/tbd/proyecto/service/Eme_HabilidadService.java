package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.repositories.Eme_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Eme_HabilidadService {
    @Autowired
    Eme_HabilidadRepository emeHabilidadRepository;

    @PostMapping("/eme_habilidad")
    public ResponseEntity<?> HelloWorld(@RequestBody Eme_HabilidadEntity eme) {
        Eme_HabilidadEntity eme_habilidad = emeHabilidadRepository.create(eme);
        if (eme_habilidad!=null)
            return ResponseEntity.ok(eme_habilidad);
        return ResponseEntity.badRequest().build();
    }

}
