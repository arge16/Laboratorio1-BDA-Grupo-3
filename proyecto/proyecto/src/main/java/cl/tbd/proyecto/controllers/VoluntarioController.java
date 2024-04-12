package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.VoluntarioEntity;
import cl.tbd.proyecto.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    @Autowired
    VoluntarioService voluntarioService;

    @GetMapping("")
    public ResponseEntity<?> getAllVoluntarios(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
            ){
        if(size!=null){
            return ResponseEntity.ok(voluntarioService.getPageVoluntarios(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(voluntarioService.getAllVoluntarios());
    }

    @PostMapping("")
    public ResponseEntity<?> postVoluntario(@RequestBody VoluntarioEntity voluntario) {
        VoluntarioEntity voluntarioEntity = voluntarioService.createVoluntario(voluntario);
        if (voluntarioEntity!=null)
            return ResponseEntity.ok(voluntarioEntity);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteVoluntario(@RequestParam("id") Long id) {
        if(voluntarioService.deleteVoluntario(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
