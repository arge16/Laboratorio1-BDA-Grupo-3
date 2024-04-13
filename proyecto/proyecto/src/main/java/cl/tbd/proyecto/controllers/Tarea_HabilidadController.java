package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.Tarea_HabilidadEntity;
import cl.tbd.proyecto.service.Tarea_HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tarea_habilidad")
public class Tarea_HabilidadController {
    @Autowired
    Tarea_HabilidadService tareaHabilidadService;

    @GetMapping("")
    public ResponseEntity<?> getAllTareaHabilidades(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ){
        if(size!=null){
            return ResponseEntity.ok(tareaHabilidadService.getPageTareaHabilidades(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(tareaHabilidadService.getAllTareaHabilidades());
    }

    @PostMapping("")
    public ResponseEntity<?> postTareaHabilidad(@RequestBody Tarea_HabilidadEntity tareaHabilidad) {
        Tarea_HabilidadEntity tareaHabilidadEntity = tareaHabilidadService.createTareaHabilidades(tareaHabilidad);
        if (tareaHabilidadEntity!=null)
            return ResponseEntity.ok(tareaHabilidadEntity);
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("")
    public ResponseEntity<Tarea_HabilidadEntity> updateTareaHabilidad(@RequestBody Tarea_HabilidadEntity tareaHabilidad) {
        Tarea_HabilidadEntity updatedTareaHabilidad = tareaHabilidadService.updateTareaHabilidades(tareaHabilidad);
        if (updatedTareaHabilidad != null) {
            return ResponseEntity.ok(updatedTareaHabilidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteTareaHabilidad(@RequestParam("id") Long id) {
        if(tareaHabilidadService.deleteTareaHabilidad(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
