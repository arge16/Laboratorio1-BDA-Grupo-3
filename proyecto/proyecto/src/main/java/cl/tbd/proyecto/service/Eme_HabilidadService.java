package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.repositories.Eme_HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class Eme_HabilidadService {
    @Autowired
    Eme_HabilidadRepository emeHabilidadRepository;

    @PostMapping("/")
    public ResponseEntity<?> HelloWorld(@RequestBody Eme_HabilidadEntity eme) {
        return ResponseEntity.ok(emeHabilidadRepository.create(eme));
    }

}
