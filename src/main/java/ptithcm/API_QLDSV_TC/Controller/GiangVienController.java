package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.API_QLDSV_TC.Service.GiangVienService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/giang-vien")
public class GiangVienController {
    @Autowired
    GiangVienService giangVienService;
    @RequestMapping(value = "/thong-tin-ca-nhan", method = RequestMethod.GET)
    public ResponseEntity<Map<String, ?>> thongTinCaNhanGianGiangVien(@RequestParam("ma-gv") String magv){
        Map<String, ?> thongTinCaNhan = giangVienService.thongTinCaNhanGiangVien(magv);
        return new ResponseEntity<>(thongTinCaNhan, HttpStatus.OK);
    }
}
