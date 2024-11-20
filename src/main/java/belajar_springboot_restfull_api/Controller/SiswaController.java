package belajar_springboot_restfull_api.Controller;

import belajar_springboot_restfull_api.Dto.SiswaDto;
import belajar_springboot_restfull_api.Entity.Siswa;
import belajar_springboot_restfull_api.Service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")

public class SiswaController {

    @Autowired
    private SiswaService service;

    @PostMapping("/createSiswa")
    public ResponseEntity<?> createSiswa(@RequestBody Siswa siswa) {
      SiswaDto.ResponseCreateSiswa response = new SiswaDto.ResponseCreateSiswa();
      service.saveSiswa(siswa);
      response.setData(siswa);
      response.setMessage("Success Create Siswa");
      response.setStatus(201);

      return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getSiswas")
    public ResponseEntity<?> retrieveSiswas() {
        SiswaDto.ResponseSiswa response = service.getAllsiswa();

        if (response.getData().isEmpty()) {
            String message = "Data is empty.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

    }
    @GetMapping("/getSiswaById/{id}")
    public Siswa getSiswaById(@PathVariable int id) {
        return service.getSiswaById(id);
    }
    @GetMapping("/getSiswaByNis/{nis}")
    public List<Siswa> getSiswaByNis(@PathVariable String name) {
        return service.getSiswaByNis(name);
    }

    @DeleteMapping("/deleteSiswa/{id}")
    public ResponseEntity<?> deleteSiswa(@PathVariable int id) {
        return service.deleteSiswa(id);
    }
    @PutMapping("/updateSiswa")
    public ResponseEntity<?> updateSiswa(@RequestBody Siswa siswa) {
        return service.updateSiswa(siswa);
    }


}
