package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.InstitucionEntity;
import cl.tbd.proyecto.repositories.InstitucionRepository;
import cl.tbd.proyecto.repositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class InstitucionService{
    @Autowired
    InstitucionRepository institucionRepository;

    @PostMapping("/institucion")
    public ResponseEntity<?> HelloWorld(@RequestBody InstitucionEntity institucion) {
        InstitucionEntity institucionEntity = institucionRepository.create(institucion);
        if (institucionEntity!=null)
            return ResponseEntity.ok(institucionEntity);
        return ResponseEntity.badRequest().build();
    }
}
