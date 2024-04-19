package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.Estado_EmergenciaEntity;
import cl.tbd.proyecto.service.Estado_EmergenciaService;
import cl.tbd.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/estado_emergencia")
public class Estado_EmergenciaController {
    @Autowired
    Estado_EmergenciaService estadoEmergenciaService;
    @Autowired
    UsuarioService usuarioService;
    @GetMapping("")
    public ResponseEntity<?> getAllEstadoEmergencias(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestHeader(value = "Authorization", required = false) String token
    ){

        String actualUser= usuarioService.getUser(token);


        if(size!=null){
            return ResponseEntity.ok(estadoEmergenciaService.getPageEstadoEmergencias(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(estadoEmergenciaService.getAllEstadoEmergencias());
    }

    @PostMapping("")
    public ResponseEntity<?> postEstadoEmergencia(
            @RequestBody Estado_EmergenciaEntity estadoEmergencia,
            @RequestHeader(value = "Authorization", required = false) String token){

        String actualUser= usuarioService.getUser(token);


        Estado_EmergenciaEntity estadoEmergenciaEntity = estadoEmergenciaService.createEstadoEmergencia(estadoEmergencia,actualUser);
        if(estadoEmergenciaEntity != null)
            return  ResponseEntity.ok(estadoEmergenciaEntity);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("")
    public ResponseEntity<Estado_EmergenciaEntity> updateEstadoEmergencia(
            @RequestBody Estado_EmergenciaEntity estadoEmergenciaActualizado,
            @RequestHeader(value = "Authorization",required = false) String token) {

        String actualUser= usuarioService.getUser(token);


        Estado_EmergenciaEntity updateEstadoEmergencia = estadoEmergenciaService.updateEstadoEmergencia(estadoEmergenciaActualizado,actualUser);
        if (updateEstadoEmergencia != null) {
            return ResponseEntity.ok(updateEstadoEmergencia);
        } else {
            // Este código puede variar dependiendo de cómo desees manejar los casos donde el estado de la tarea no existe.
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteEstadoEmergencia(
            @RequestParam("id") Long id,
            @RequestHeader(value = "Authorization",required = false) String token ) {

        String actualUser= usuarioService.getUser(token);


        if(estadoEmergenciaService.deleteEstadoEmergencia(id, actualUser)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
