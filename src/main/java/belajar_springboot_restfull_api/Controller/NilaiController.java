package belajar_springboot_restfull_api.Controller;

import belajar_springboot_restfull_api.Dto.NilaiDTO;
import belajar_springboot_restfull_api.Entity.MataPelajaran;
import belajar_springboot_restfull_api.Entity.Nilai;
import belajar_springboot_restfull_api.Service.NilaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/nilai")

public class NilaiController {

    @Autowired
    private NilaiService nilaiService;

    @PostMapping("/createNilai")
    public ResponseEntity<?> createNilai(@RequestBody Nilai nilai){
        NilaiDTO.ResponseCreateNilai reponse = new NilaiDTO.ResponseCreateNilai();
        nilaiService.saveNilai(nilai);
        reponse.setData(nilai);
        reponse.setMessage("Success Create Nilai");
        reponse.setStatus(201);

        return ResponseEntity.status(HttpStatus.OK).body(reponse);
    }

    @GetMapping("/getNilais")
    public ResponseEntity<?> getAllNilai(){
        NilaiDTO.ResponseNilai response = nilaiService.getAllNilai();

        if (response.getData().isEmpty()) {
            String message = "Data is empty.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @GetMapping("getNilaiById/{id}")
    public Nilai getNilaiById(@PathVariable int id){
        return nilaiService.getNilaiById(id);
    }

    @DeleteMapping("/deleteNilai/{id}")
    public ResponseEntity<?> deleteNilai(@PathVariable int id){
        return nilaiService.deleteNilai(id);
    }


    @PutMapping("/updateNilai")
    public ResponseEntity<?> updateNilai (@RequestBody Nilai nilai){
        return nilaiService.updateNilai(nilai);
    }
}
