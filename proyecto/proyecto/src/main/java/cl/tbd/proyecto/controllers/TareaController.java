package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.TareaEntity;
import cl.tbd.proyecto.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tarea")
public class TareaController {
    @Autowired
    TareaService tareaService;

    @GetMapping("")
    public ResponseEntity<?> getAllTareas(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ){
        if(size!=null){
            return ResponseEntity.ok(tareaService.getPageTareas(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(tareaService.getAllTareas());
    }
    @PostMapping("")
    public ResponseEntity<?> postTarea(@RequestBody TareaEntity tarea) {
        TareaEntity tareaEntity = tareaService.createTarea(tarea);
        if (tareaEntity!=null)
            return ResponseEntity.ok(tareaEntity);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("")
    public ResponseEntity<TareaEntity> updateTarea(@RequestBody TareaEntity tarea) {
        TareaEntity updatedTarea = tareaService.updateTarea(tarea);
        if (updatedTarea != null) {
            return ResponseEntity.ok(updatedTarea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteTarea(@RequestParam("id") Long id) {
        if(tareaService.deleteTarea(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
