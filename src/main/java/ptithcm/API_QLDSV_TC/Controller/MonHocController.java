package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.MonHocDTO;
import ptithcm.API_QLDSV_TC.Model.MonHoc;
import ptithcm.API_QLDSV_TC.Service.MonHocService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mon-hoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<MonHoc> monHocTheoMa(@RequestParam("ma-mon-hoc") String maMh) {
        MonHoc monHoc = monHocService.monHocTheoMa(maMh);
        if (monHoc == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(monHoc, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/danh-sach-mon-hoc", method = RequestMethod.GET)
    public ResponseEntity<List<MonHoc>> danhSachMonHoc() {
        List<MonHoc> danhSachMonHoc = monHocService.danhSachTatCaMonHoc();
        if (danhSachMonHoc.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT); // trả về mã lỗi 204
        }
        return new ResponseEntity<>(danhSachMonHoc, HttpStatus.OK);
    }

    @RequestMapping(value = "/them-mon-hoc", method = RequestMethod.POST)
    public ResponseEntity<?> themMonHoc(@Validated @RequestBody MonHoc monHoc) {
        if (monHocService.themMonHoc(monHoc) == 0) { // them mon hoc that bai
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build(); // them mon hoc thanh cong
        }
    }

    @RequestMapping(value = "/so-tc", method = RequestMethod.GET)
    public ResponseEntity<Map<String, ?>> soTCMonHoc(@RequestParam("ten-mh") String tenMH) {
        Map<String, ?> x = monHocService.soTCMonHoc(tenMH);
        return new ResponseEntity<>(x, HttpStatus.OK);
    }

    @RequestMapping(value = "/them-mon-hoc-moi", method = RequestMethod.POST)
    public ResponseEntity<?> themMonHocMoi(@Validated @RequestBody MonHoc monHoc) {
        if (monHocService.themMonHocMoi(monHoc) == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/update-mon-hoc", method = RequestMethod.POST)
    public ResponseEntity<?> updateMonHoc(@Validated @RequestBody MonHoc monHoc) {
        if (monHocService.updateMonHoc(monHoc) == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/xoa-mon-hoc", method = RequestMethod.POST)
    public ResponseEntity<?> xoaMonHoc(@Validated @RequestParam("mamh") String mamh) {
        if (monHocService.xoaMonHoc(mamh) == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
