package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.RankingEntity;
import cl.tbd.proyecto.service.RankingService;
import cl.tbd.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ranking")
public class RankingController {
    @Autowired
    RankingService rankingService;

    @GetMapping("")
    public ResponseEntity<?> getAllRankings(
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestHeader(value = "Authorization",required = false) String token
    ){
        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        if(size!=null){
            return ResponseEntity.ok(rankingService.getPageRankings(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(rankingService.getAllRankings());
    }

    @PostMapping("")
    public ResponseEntity<?> postRanking(
            @RequestBody RankingEntity ranking,
            @RequestHeader(value = "Authorization",required = false) String token) {

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        RankingEntity rankingEntity = rankingService.createRanking(ranking, actualUser);
        if (rankingEntity!=null)
            return ResponseEntity.ok(rankingEntity);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("")
    public ResponseEntity<RankingEntity> updateRanking(
            @RequestBody RankingEntity ranking,
            @RequestHeader(value = "Authorization",required = false) String token) {

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        RankingEntity updatedRanking = rankingService.updateRanking(ranking, actualUser);
        if (updatedRanking != null) {
            return ResponseEntity.ok(updatedRanking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteRanking(
            @RequestParam("id") Long id,
            @RequestHeader(value = "Authorization",required = false) String token) {

        UsuarioService UserServiceInstance = new UsuarioService();
        String actualUser= UserServiceInstance.getUser(token);


        if(rankingService.deleteRanking(id, actualUser)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
