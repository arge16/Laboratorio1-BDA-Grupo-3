package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.Estado_TareaEntity;
import cl.tbd.proyecto.service.Estado_TareaService;
import cl.tbd.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/estado_tarea")
public class Estado_TareaController{
    @Autowired
    Estado_TareaService estadoTareaService;

    @GetMapping("")
    public ResponseEntity<?> getAllEstadoTareas(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestHeader(value = "Authorization", required = false) String token
    ){

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        if(size!=null){
            return ResponseEntity.ok(estadoTareaService.getPageEstadoTareas(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(estadoTareaService.getAllEstadoTareas());
    }
    @PostMapping("")
    public ResponseEntity<?> postEstadoTarea(
            @RequestBody Estado_TareaEntity estadoTarea,
            @RequestHeader(value = "Authorization", required = false) String token){

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        Estado_TareaEntity estadoTareaEntity = estadoTareaService.createEstadoTarea(estadoTarea, actualUser);
        if(estadoTareaEntity != null)
            return  ResponseEntity.ok(estadoTareaEntity);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("")
    public ResponseEntity<Estado_TareaEntity> updateEstadoTarea(
            @RequestBody Estado_TareaEntity estadoTareaActualizado,
            @RequestHeader(value = "Authorization",required = false) String token) {

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        Estado_TareaEntity updatedEstadoTarea = estadoTareaService.updateEstadoTarea(estadoTareaActualizado,actualUser);
        if (updatedEstadoTarea != null) {
            return ResponseEntity.ok(updatedEstadoTarea);
        } else {
            // Este código puede variar dependiendo de cómo desees manejar los casos donde el estado de la tarea no existe.
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteEstadoTarea(
            @RequestParam("id") Long id,
            @RequestHeader(value = "Authorization",required = false) String token ) {

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        if(estadoTareaService.deleteEstadoTarea(id,actualUser)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
