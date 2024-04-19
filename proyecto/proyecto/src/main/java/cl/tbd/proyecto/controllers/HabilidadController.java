package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.HabilidadEntity;
import cl.tbd.proyecto.service.HabilidadService;
import cl.tbd.proyecto.service.UsuarioService;
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
            @RequestParam(value = "page", required = false) Integer page,
            @RequestHeader(value = "Authorization",required = false) String token
    ){
        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        if(size!=null){
            return ResponseEntity.ok(habilidadService.getPageHabilidades(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(habilidadService.getAllHabilidades());
    }

    @PostMapping("")
    public ResponseEntity<?> postHabilidad(
            @RequestBody HabilidadEntity habilidad,
            @RequestHeader(value = "Authorization",required = false) String token) {

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        HabilidadEntity habilidadEntity = habilidadService.createHabilidad(habilidad,actualUser);
        if (habilidadEntity!=null)
            return ResponseEntity.ok(habilidadEntity);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("")
    public ResponseEntity<HabilidadEntity> updateHabilidad(
            @RequestBody HabilidadEntity habilidadActualizada,
            @RequestHeader(value = "Authorization",required = false) String token) {

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        HabilidadEntity updatedHabilidad = habilidadService.updateHabilidad(habilidadActualizada,actualUser);
        if (updatedHabilidad != null) {
            return ResponseEntity.ok(updatedHabilidad);
        } else {
            // Este código puede variar dependiendo de cómo desees manejar los casos donde la habilidad no existe.
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteHabilidad(
            @RequestParam("id") Long id,
            @RequestHeader(value = "Authorization",required = false) String token) {

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        if(habilidadService.deleteHabilidad(id,actualUser)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
