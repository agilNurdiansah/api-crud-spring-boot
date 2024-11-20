package belajar_springboot_restfull_api.Controller;


import belajar_springboot_restfull_api.Dto.MataPelajaranDTO;
import belajar_springboot_restfull_api.Dto.RankingDTO;
import belajar_springboot_restfull_api.Entity.Ranking;
import belajar_springboot_restfull_api.Service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @PostMapping("/createRankning")
    public ResponseEntity<?> createRanking(@RequestBody Ranking ranking){
        RankingDTO.ResponseCreateRanking response = new RankingDTO.ResponseCreateRanking();
        rankingService.saveRanking(ranking);
        response.setData(ranking);
        response.setMessage("Success Create Ranking");
        response.setStatus(201);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getRankings")
    public ResponseEntity<?> getAllRanking(){
        RankingDTO.ResponseRanking response = rankingService.getAllRanking();

        if (response.getData().isEmpty()) {
            String message = "Data is empty.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @GetMapping("/getRankingById/{id}")
    public Ranking getRankingById (@PathVariable int id){
        return rankingService.getRankingById(id);
    }

    @PutMapping("/updateRanking")
    public ResponseEntity<?> updateRanking (@RequestBody Ranking ranking){
        return rankingService.updateRanking(ranking);
    }

    @DeleteMapping("deleteRankingById/{id}")
    public ResponseEntity<?> deleteRanking(@PathVariable int id){
        return rankingService.deleteRanking(id);
    }



}
