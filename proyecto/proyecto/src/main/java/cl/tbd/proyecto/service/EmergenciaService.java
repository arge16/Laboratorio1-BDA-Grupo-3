package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.repositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EmergenciaService {

    @Autowired
    EmergenciaRepository emergenciaRepository;

    @PostMapping("/emergencia")
    public ResponseEntity<?> HelloWorld(@RequestBody EmergenciaEntity eme) {
        EmergenciaEntity emergencia = emergenciaRepository.create(eme);
        if (emergencia!=null)
            return ResponseEntity.ok(emergencia);
        return ResponseEntity.badRequest().build();
    }


}
