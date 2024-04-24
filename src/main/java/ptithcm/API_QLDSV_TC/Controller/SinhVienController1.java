package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Service.SinhVienService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienController1 {
    @Autowired
    SinhVienService sinhVienService;

    @GetMapping
    public ResponseEntity<List<SinhVien>> getAll() {
        List<SinhVien> list = new ArrayList<>();
        list = sinhVienService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        Optional<SinhVien> sinhVien = sinhVienService.findById(id);
        if (sinhVien.isEmpty()) {
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(sinhVien, HttpStatus.OK);
        }
    }
}