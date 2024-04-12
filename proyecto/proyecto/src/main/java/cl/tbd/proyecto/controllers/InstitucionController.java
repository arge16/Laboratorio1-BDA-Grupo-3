package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.InstitucionEntity;
import cl.tbd.proyecto.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/institucion")
public class InstitucionController {
    @Autowired
    InstitucionService institucionService;

    @GetMapping("")
    public ResponseEntity<?> getAllInstituciones(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ){
        if(size!=null){
            return ResponseEntity.ok(institucionService.getPageInstituciones(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(institucionService.getAllInstituciones());
    }

    @PostMapping("")
    public ResponseEntity<?> postInstitucion(@RequestBody InstitucionEntity institucion) {
        InstitucionEntity institucionEntity = institucionService.createInstitucion(institucion);
        if (institucionEntity!=null)
            return ResponseEntity.ok(institucionEntity);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteInstitucion(@RequestParam("id") Long id) {
        if(institucionService.deleteInstitucion(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
