package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.Vol_HabilidadEntity;
import cl.tbd.proyecto.service.Vol_HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/vol_habilidad")
public class Vol_HabilidadController {
    @Autowired
    Vol_HabilidadService volHabilidadService;

    @GetMapping("")
    public ResponseEntity<?> getAllVolHabilidades(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ){
        if(size!=null){
            return ResponseEntity.ok(volHabilidadService.getPageVolHabilidades(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(volHabilidadService.getAllVolHabilidades());
    }
    @PostMapping("")
    public ResponseEntity<?> postVolHabilidades(@RequestBody Vol_HabilidadEntity volHabilidad) {
        Vol_HabilidadEntity volHabilidadEntity = volHabilidadService.createVolHabilidades(volHabilidad);
        if (volHabilidadEntity!=null)
            return ResponseEntity.ok(volHabilidadEntity);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteVolHabilidad(@RequestParam("id") Long id) {
        if(volHabilidadService.deleteVolHabilidad(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
