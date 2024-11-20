package belajar_springboot_restfull_api.Service;

import belajar_springboot_restfull_api.Dto.SiswaDto;
import belajar_springboot_restfull_api.Entity.Siswa;
import belajar_springboot_restfull_api.Repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiswaService {

    @Autowired
    private SiswaRepository siswaRepository;

    public Siswa saveSiswa(Siswa siswa){
        siswaRepository.save(siswa);
        return  siswa;
    }

    public List<Siswa> saveSiswa(List<Siswa> siswas){
        return siswaRepository.saveAll(siswas);
    }

    public SiswaDto.ResponseSiswa getAllsiswa(){
        SiswaDto.ResponseSiswa res = new SiswaDto.ResponseSiswa();
        res.setData(siswaRepository.findAll());
        res.setMessage("Succes Get Data");
        res.setStatus(200);

        return res;
    }

    public Siswa getSiswaById(int id) {
        return siswaRepository.findById(id).orElse(null);
    }

    public List<Siswa> getSiswaByNis(String nama){
        return siswaRepository.findBynis(nama);
    }

    public ResponseEntity<?> deleteSiswa(int id){
        SiswaDto.ResponseDeleteSiswa response = new SiswaDto.ResponseDeleteSiswa();
        siswaRepository.deleteById(id);
        response.setMessage("Success Delete Siswa" + id);
        response.setStatus(200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> updateSiswa(Siswa siswa){
        SiswaDto.ResponseUpdateSiswa response = new SiswaDto.ResponseUpdateSiswa();
        response.setData(siswaRepository.save(siswa));
        response.setMessage("Success Update Siswa");
        response.setStatus(201);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}

