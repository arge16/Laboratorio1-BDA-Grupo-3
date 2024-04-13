package cl.tbd.proyecto.controllers;

import cl.tbd.proyecto.entities.RankingEntity;
import cl.tbd.proyecto.service.RankingService;
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
            @RequestParam(value = "page", required = false) Integer page
    ){
        if(size!=null){
            return ResponseEntity.ok(rankingService.getPageRankings(size, Objects.requireNonNullElse(page, 1)));
        }
        return ResponseEntity.ok(rankingService.getAllRankings());
    }

    @PostMapping("")
    public ResponseEntity<?> postRanking(@RequestBody RankingEntity ranking) {
        RankingEntity rankingEntity = rankingService.createRanking(ranking);
        if (rankingEntity!=null)
            return ResponseEntity.ok(rankingEntity);
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("")
    public ResponseEntity<RankingEntity> updateRanking(@RequestBody RankingEntity ranking) {
        RankingEntity updatedRanking = rankingService.updateRanking(ranking);
        if (updatedRanking != null) {
            return ResponseEntity.ok(updatedRanking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteRanking(@RequestParam("id") Long id) {
        if(rankingService.deleteRanking(id)) {
            return ResponseEntity.ok("deleted");
        }
        return ResponseEntity.badRequest().build();
    }
}
