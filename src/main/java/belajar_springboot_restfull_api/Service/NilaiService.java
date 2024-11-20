package belajar_springboot_restfull_api.Service;

import belajar_springboot_restfull_api.Dto.NilaiDTO;
import belajar_springboot_restfull_api.Entity.MataPelajaran;
import belajar_springboot_restfull_api.Entity.Nilai;
import belajar_springboot_restfull_api.Repository.NilaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NilaiService {

    @Autowired
    private NilaiRepository nilaiRepository;

    public Nilai saveNilai(Nilai nilai){
        nilaiRepository.save(nilai);
        return nilai;
    }

    public NilaiDTO.ResponseNilai getAllNilai(){
        NilaiDTO.ResponseNilai res = new NilaiDTO.ResponseNilai();
        res.setData(nilaiRepository.findAll());
        res.setMessage("Success Get Data Nilai");
        res.setStatus(200);

        return res;
    }

    public Nilai getNilaiById(int id) {
        NilaiDTO.ResponseNilai res = new NilaiDTO.ResponseNilai();
        return nilaiRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> deleteNilai(int id){
        NilaiDTO.ResponseDeleteNilai response = new NilaiDTO.ResponseDeleteNilai();
        nilaiRepository.deleteById(id);
        response.setMessage("Success Delete Nilai " + id);
        response.setStatus(200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> updateNilai(Nilai nilai){
        NilaiDTO.ResponseUpdateNilai response = new NilaiDTO.ResponseUpdateNilai();
        response.setData(nilaiRepository.save(nilai));
        response.setMessage("Success Update Nilai");
        response.setStatus(201);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
