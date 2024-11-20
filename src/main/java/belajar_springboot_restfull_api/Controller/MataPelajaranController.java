package belajar_springboot_restfull_api.Controller;


import belajar_springboot_restfull_api.Dto.MataPelajaranDTO;
import belajar_springboot_restfull_api.Entity.MataPelajaran;
import belajar_springboot_restfull_api.Service.MataPelajaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pelajaran")

public class MataPelajaranController {

    @Autowired
    private MataPelajaranService pelajaranService;

    @PostMapping("/createMataPelajaran")
    public ResponseEntity<?> createMataPelajaran(@RequestBody MataPelajaran mataPelajaran) {
        MataPelajaranDTO.ResponseCreateMataPelajaran response = new MataPelajaranDTO.ResponseCreateMataPelajaran();
        pelajaranService.saveMataPelajaran(mataPelajaran);
        response.setData(mataPelajaran);
        response.setMessage("Success Create Mata Pelajaran");
        response.setStatus(201);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/getMataPelajarans")
    public ResponseEntity<?> getAllMataPelajaran() {
        MataPelajaranDTO.ResponseMataPelajaran response = pelajaranService.getAllMataPelajaran();

        if (response.getData().isEmpty()) {
            String message = "Data is empty.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @GetMapping("/getMataPelajaranById/{id}")
    public MataPelajaran getMataPelajaranById ( @PathVariable int id){
        return pelajaranService.getMataPelajaranById(id);
    }

    @DeleteMapping("/deleteMataPelajaran/{id}")
    public ResponseEntity<?> deleteMataPelajaran ( @PathVariable int id){
        return pelajaranService.deleteMataPelajaran(id);
    }

    @PutMapping("/updateMataPelajaran")
    public ResponseEntity<?> updateMataPelajaran (@RequestBody MataPelajaran mataPelajaran){
        return pelajaranService.updateMataPelajaran(mataPelajaran);
    }

}






