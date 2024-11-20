package belajar_springboot_restfull_api.Repository;

import belajar_springboot_restfull_api.Entity.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NilaiRepository extends JpaRepository<Nilai, Integer> {
}
