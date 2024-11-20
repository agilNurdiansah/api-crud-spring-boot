package belajar_springboot_restfull_api.Service;

import belajar_springboot_restfull_api.Dto.RankingDTO;
import belajar_springboot_restfull_api.Entity.Ranking;
import belajar_springboot_restfull_api.Repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public Ranking saveRanking(Ranking ranking){
        rankingRepository.save(ranking);
        return ranking;
    }

    public RankingDTO.ResponseRanking getAllRanking(){
        RankingDTO.ResponseRanking res = new RankingDTO.ResponseRanking();
        res.setData(rankingRepository.findAll());
        res.setMessage("Success Get Ranking");
        res.setStatus(200);

        return res;
    }

    public Ranking getRankingById(int id){
        return rankingRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> deleteRanking(int id){
        RankingDTO.ResponseDeleteRanking response = new RankingDTO.ResponseDeleteRanking();
        rankingRepository.deleteById(id);
        response.setMessage("Success Delete Ranking");
        response.setStatus(201);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> updateRanking (Ranking ranking){
        RankingDTO.ResponseUpdateRanking response = new RankingDTO.ResponseUpdateRanking();
        response.setData(rankingRepository.save(ranking));
        response.setMessage("Success Update Ranking");
        response.setStatus(201);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
