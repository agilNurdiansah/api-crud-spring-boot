package belajar_springboot_restfull_api.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mata_pelajaran")
public class MataPelajaran {

    @Id
    @GeneratedValue

    private int id;

    @Column(name = "kode_pelajaran")
    private String kodePelajaran;

    @Column(name = "mata_pelajaran")
    private String mataPelajaran;


}
