package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.API_QLDSV_TC.Model.LopTinChi;
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
    public ResponseEntity<Map<String, ?>> danhSachSinhVienLTC(@RequestParam("ma-ltc") int maLTC){
        Map<String, ?> danhSachSinhVien = lopTinChiService.danhSachSinhVienLTC(maLTC);
        return new ResponseEntity<>(danhSachSinhVien, HttpStatus.OK);
    }
}
