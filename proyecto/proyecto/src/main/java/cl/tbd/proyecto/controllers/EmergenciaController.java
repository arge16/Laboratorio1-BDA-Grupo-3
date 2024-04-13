package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.EmergenciaEntity;
import cl.tbd.proyecto.service.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/emergencia")
public class EmergenciaController {
    @Autowired
    EmergenciaService emergenciaService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmergencias(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ){
        if(size!=null){
            return ResponseEntity.ok(emergenciaService.getPageEmergencias(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(emergenciaService.getAllEmergencias());
    }
    @PostMapping("")
    public ResponseEntity<?> postEmergencia(@RequestBody EmergenciaEntity emergencia) {
        EmergenciaEntity emergenciaEntity = emergenciaService.createEmergencia(emergencia);
        if (emergencia!=null)
            return ResponseEntity.ok(emergenciaEntity);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("")
    public ResponseEntity<EmergenciaEntity> updateEmergencia(@RequestBody EmergenciaEntity emergencia) {
        EmergenciaEntity updatedEmergencia = emergenciaService.updateEmergencia(emergencia);
        if (updatedEmergencia != null) {
            return ResponseEntity.ok(updatedEmergencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteEmergencia(@RequestParam("id") Long id) {
        if(emergenciaService.deleteEmergencia(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }


}
