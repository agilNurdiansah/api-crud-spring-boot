package belajar_springboot_restfull_api.Repository;

import belajar_springboot_restfull_api.Entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Integer> {

    List<Siswa> findBynis (String name);
}
