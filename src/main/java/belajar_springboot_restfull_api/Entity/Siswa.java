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
@Table(name = "siswa")
public class Siswa {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nis")
    private String nis;

    @Column(name = "nama_siswa")
    private String namaSiswa;

    @Column(name = "kelas")
    private String kelas;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;





}
