package belajar_springboot_restfull_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nilai")
public class Nilai {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "semester")
    private String semester;

    @Column(name = "nilai")
    private String nilai;

    @Column(name = "kode_nilai")
    private String kodeNilai;

}
