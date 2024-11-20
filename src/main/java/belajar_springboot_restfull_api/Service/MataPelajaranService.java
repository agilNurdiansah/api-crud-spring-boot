package belajar_springboot_restfull_api.Service;

import belajar_springboot_restfull_api.Dto.MataPelajaranDTO;
import belajar_springboot_restfull_api.Entity.MataPelajaran;
import belajar_springboot_restfull_api.Repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MataPelajaranService {

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;


    public MataPelajaran saveMataPelajaran(MataPelajaran mataPelajaran){
        mataPelajaranRepository.save(mataPelajaran);
        return  mataPelajaran;
    }

    public MataPelajaranDTO.ResponseMataPelajaran getAllMataPelajaran(){
        MataPelajaranDTO.ResponseMataPelajaran res = new MataPelajaranDTO.ResponseMataPelajaran();
        res.setData(mataPelajaranRepository.findAll());
        res.setMessage("Succes Get Data Mata Pelajaran");
        res.setStatus(200);

        return res;
    }

    public MataPelajaran getMataPelajaranById(int id) {
    return mataPelajaranRepository.findById(id).orElse(null);
    }

    public ResponseEntity<?> deleteMataPelajaran(int id){
        MataPelajaranDTO.ResponseDeleteMataPelajaran response = new MataPelajaranDTO.ResponseDeleteMataPelajaran();
        mataPelajaranRepository.deleteById(id);
        response.setMessage("Success Delete Mata Pelajaran" + id);
        response.setStatus(200);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> updateMataPelajaran(MataPelajaran mataPelajaran){
        MataPelajaranDTO.ResponseUpdateMataPelajaran response = new MataPelajaranDTO.ResponseUpdateMataPelajaran();
        response.setData(mataPelajaranRepository.save(mataPelajaran));
        response.setMessage("Success Update Mata Pelajaran");
        response.setStatus(201);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
