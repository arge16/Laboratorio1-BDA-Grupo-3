package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.HabilidadEntity;
import cl.tbd.proyecto.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/habilidad")
public class HabilidadController {
    @Autowired
    HabilidadService habilidadService;

    @GetMapping("")
    public ResponseEntity<?> getAllHabilidades(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ){
        if(size!=null){
            return ResponseEntity.ok(habilidadService.getPageHabilidades(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(habilidadService.getAllHabilidades());
    }

    @PostMapping("")
    public ResponseEntity<?> postHabilidad(@RequestBody HabilidadEntity habilidad) {
        HabilidadEntity habilidadEntity = habilidadService.createHabilidad(habilidad);
        if (habilidadEntity!=null)
            return ResponseEntity.ok(habilidadEntity);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteHabilidad(@RequestParam("id") Long id) {
        if(habilidadService.deleteHabilidad(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
