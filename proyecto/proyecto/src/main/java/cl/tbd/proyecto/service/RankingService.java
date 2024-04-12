package cl.tbd.proyecto.service;

import cl.tbd.proyecto.entities.HabilidadEntity;
import cl.tbd.proyecto.entities.RankingEntity;
import cl.tbd.proyecto.entities.VoluntarioEntity;
import cl.tbd.proyecto.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    RankingRepository rankingRepository;

    public List<RankingEntity> getAllRankings(){
        return rankingRepository.findAll();
    }

    public List<RankingEntity> getPageRankings(int size, int page){
        return rankingRepository.findAllPagination(size, page);
    }

    public RankingEntity createRanking(RankingEntity ranking) {
        return rankingRepository.create(ranking);
    }

    public Boolean deleteRanking(Long id){
        return rankingRepository.delete(id);
    }
}
