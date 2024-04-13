package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.Eme_HabilidadEntity;
import cl.tbd.proyecto.service.Eme_HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/eme_habilidad")
public class Eme_HabilidadController {
    @Autowired
    Eme_HabilidadService emeHabilidadService;

    @GetMapping("")
    public ResponseEntity<?> getAllVoluntarios(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ){
        if(size!=null){
            return ResponseEntity.ok(emeHabilidadService.getPageEmeHabilidades(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(emeHabilidadService.getAllEmeHabilidades());
    }

    @GetMapping("/emergencia")
    public ResponseEntity<?> getHabilidadesByEmergencia(@RequestParam("id_emergencia") Long id_emergencia){
        return ResponseEntity.ok(emeHabilidadService.findHabilidadesByEmergencia(id_emergencia));
    }


    @PostMapping("")
    public ResponseEntity<?> postEmeHabilidad(@RequestBody Eme_HabilidadEntity eme) {
        Eme_HabilidadEntity eme_habilidad = emeHabilidadService.createEmeHabilidad(eme);
        if (eme_habilidad!=null)
            return ResponseEntity.ok(eme_habilidad);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("")
    public ResponseEntity<Eme_HabilidadEntity> updateEmeHabilidad(@RequestBody Eme_HabilidadEntity eme_habilidad) {
        Eme_HabilidadEntity updated = emeHabilidadService.updateEmeHabilidad(eme_habilidad);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteEmeHabilidad(@RequestParam("id") Long id) {
        if(emeHabilidadService.deleteEmeHabilidad(id)) { // TODO: Force delete? con bool como param
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }



}
