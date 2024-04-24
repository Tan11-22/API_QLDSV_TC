package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.DiemDTO;
import ptithcm.API_QLDSV_TC.Service.LopTinChiService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/lop-tin-chi")
public class LopTinChiController {
    @Autowired
    LopTinChiService lopTinChiService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, ?>>> danhSachLTCTheoMaGV(@RequestParam("ma-gv") String maGV){
        List<Map<String, ?>> danhSachLTC = lopTinChiService.danhSachLTCTheoMaGV(maGV);
        return new ResponseEntity<>(danhSachLTC, HttpStatus.OK);
    }

    @RequestMapping(value = "/danh-sach-sinh-vien", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, ?>>> danhSachSinhVienLTC(@RequestParam("ma-ltc") int maLTC){
        List<Map<String, ?>> danhSachSinhVien = lopTinChiService.danhSachSinhVienLTC(maLTC);
        return new ResponseEntity<>(danhSachSinhVien, HttpStatus.OK);
    }
    @RequestMapping(value = "/xem-diem", method = RequestMethod.GET)
    public ResponseEntity<Map<String, ?>> diemSinhVienLTC(@RequestParam("ma-ltc") int maLTC, @RequestParam("ma-sv") String maSV){
        Map<String, ?> diem = lopTinChiService.diemSinhVienLTC(maSV, maLTC);
        return new ResponseEntity<>(diem, HttpStatus.OK);
    }
    @RequestMapping(value = "/nhap-diem", method = RequestMethod.POST)
    public ResponseEntity<?> capNhatDiemSV(@Validated @RequestBody DiemDTO diemDTO){
        int x = lopTinChiService.capNhatDiemSvLTC(diemDTO.getMALTC(), diemDTO.getMASV(), diemDTO.getDIEM_CC(), diemDTO.getDIEM_GK(), diemDTO.getDIEM_CK());
        System.out.println(diemDTO.toString() + " " + x);
        if(x == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
