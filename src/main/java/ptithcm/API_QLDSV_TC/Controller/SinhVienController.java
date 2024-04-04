package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Service.SinhVienService;

@RestController
@RequestMapping("/api/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;

    @RequestMapping(value = "thong-tin-ca-nhan", method = RequestMethod.GET)
    public ResponseEntity<SinhVien> thongTinCaNhan(@RequestParam("ma-sv") String maSV){
        SinhVien sv = sinhVienService.sinhVienTheoMa(maSV);
        if(sv != null){
            return new ResponseEntity<>(sv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
