package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import cl.tbd.proyecto.repositories.Eme_HabilidadRepository;
import cl.tbd.proyecto.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class VoluntarioService {
    @Autowired
    VoluntarioRepository voluntarioRepository;

    @PostMapping("/voluntario")
    public ResponseEntity<?> HelloWorld(@RequestBody VoluntarioEntity voluntario) {
        VoluntarioEntity voluntarioEntity = voluntarioRepository.create(voluntario);
        if (voluntarioEntity!=null)
            return ResponseEntity.ok(voluntarioEntity);
        return ResponseEntity.badRequest().build();
    }
}

