package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.LopDTO;
import ptithcm.API_QLDSV_TC.Model.He;
import ptithcm.API_QLDSV_TC.Model.Khoa;
import ptithcm.API_QLDSV_TC.Model.Lop;
import ptithcm.API_QLDSV_TC.Service.HeService;
import ptithcm.API_QLDSV_TC.Service.KhoaService;
import ptithcm.API_QLDSV_TC.Service.LopService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/lop")

public class LopController {
    @Autowired
    private LopService lopService;

    @Autowired
    private KhoaService khoaService;

    @Autowired
    private HeService heService;

    @RequestMapping(value = "/danh-sach-lop", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, ?>>> danhSachLopCuaKhoa(@RequestParam("ma-gv") String maGv, @RequestParam("trang-thai") int trangThai){
        List<Map<String, ?>> data = lopService.danhSachLopCuaKhoa(maGv, trangThai);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @RequestMapping(value = "/them-lop", method = RequestMethod.POST)
    public ResponseEntity<?> themLop(@RequestBody @Validated LopDTO lopDTO){
        Lop lop = new Lop();
        lop.setMalop(lopDTO.getMaLop());
        lop.setTenlop(lopDTO.getTenLop());
        lop.setKhoahoc(lopDTO.getKhoaHoc());
        lop.setTrangThai(lopDTO.isTrangThai());

        //set khoa cho lop
        Khoa khoa = khoaService.khoaTheoMa(lopDTO.getMaKhoa());
        lop.setMakhoa(khoa);
        //set he cho lop
        He he = heService.heTheoId(lopDTO.getIdHe());
        lop.setIdHe(he);
        System.out.println(lopDTO.getMaKhoa());
        System.out.println(lop.toString());

        if(lopService.addLop(lop) == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
