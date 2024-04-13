package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.TareaEntity;
import cl.tbd.proyecto.service.TareaService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @GetMapping("/possibleHabilidades")
    public ResponseEntity<?> getHabilidadesByEmergencia(@RequestParam("id_tarea") Long id_tarea){
        return ResponseEntity.ok(tareaService.getHabilidadesByTareaEmergency(tareaService.getTareaByID(id_tarea)));
    }

    @PutMapping("/addHabilidades")
    public ResponseEntity<?> getHabilidadesByEmergencia(@RequestParam("id_tarea") Long id_tarea,
                                                        @RequestBody JsonNode id_habilidades){
        List<String> numerosCadenas = Arrays.asList(id_habilidades.get("id_habilidades").asText().split(","));
        List<Long> numerosLong = numerosCadenas.stream()
                .map(Long::parseLong)
                .toList();

        return ResponseEntity.ok( tareaService.addHabilidadesToTarea(tareaService.getTareaByID(id_tarea), numerosLong) );
    }

    @PostMapping("")
    public ResponseEntity<?> postTarea(@RequestBody TareaEntity tarea) {
        TareaEntity tareaEntity = tareaService.createTarea(tarea);
        if (tareaEntity!=null)
            return ResponseEntity.ok(tareaEntity);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteTarea(@RequestParam("id") Long id) {
        if(tareaService.deleteTarea(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/emergencia")
    public ResponseEntity<?> getTareasByEmergencia(@RequestParam("id_emergencia") Long id_emergencia){
        return ResponseEntity.ok(tareaService.getTareasByEmergencia(id_emergencia));
    }
}
