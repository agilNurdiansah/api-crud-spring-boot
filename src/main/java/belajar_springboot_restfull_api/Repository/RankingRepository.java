package belajar_springboot_restfull_api.Repository;

import belajar_springboot_restfull_api.Entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<Ranking, Integer> {
    
}
