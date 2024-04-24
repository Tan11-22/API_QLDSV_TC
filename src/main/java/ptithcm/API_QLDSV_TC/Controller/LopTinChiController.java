package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.DiemDTO;
import ptithcm.API_QLDSV_TC.DTO.LopTinChiDTO;
import ptithcm.API_QLDSV_TC.Service.LopTinChiService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    @RequestMapping(value = "/danh-sach-lop-tin-chi", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, ?>>> danhSachLTC(@RequestParam("ma-khoa") String maKhoa){
        List<Map<String, ?>> danhSach = lopTinChiService.danhSachLTC(maKhoa);
        return new ResponseEntity<>(danhSach, HttpStatus.OK);
    }

    @RequestMapping(value = "/danh-sach-dieu-kien-loc-ltc", method = RequestMethod.GET)
    public ResponseEntity<List<String>> danhSachDieuKienLocLTC(@RequestParam("loai") int loai,
                                                               @RequestParam("ma-khoa") String maKhoa){
        List<String> danhSach = lopTinChiService.danhSachDkLoc(loai, maKhoa);
        return new ResponseEntity<>(danhSach, HttpStatus.OK);
    }

    @RequestMapping(value = "/danh-sach-loc-them-ltc", method = RequestMethod.GET)
    public ResponseEntity<List<String>> danhSachLocThemLTC(@RequestParam("loai") int loai,
                                                           @RequestParam("ma-khoa") String maKhoa){
        List<String> danhSach = lopTinChiService.danhSachLocThemLTC(loai, maKhoa);
        return new ResponseEntity<>(danhSach, HttpStatus.OK);
    }

    @RequestMapping(value = "/them-ltc", method = RequestMethod.POST)
    public ResponseEntity<LopTinChiDTO> themLTC(@Validated @RequestBody LopTinChiDTO ltc){
        int x = lopTinChiService.themLTC(ltc.getTenMH(), ltc.getTenLop(), ltc.getTenGV(), ltc.getNienKhoa(), ltc.getNhom(), ltc.getSoSV(), ltc.getHocKi(), ltc.getMaKhoa());
        if(x == 1)
            return new ResponseEntity<>(ltc, HttpStatus.OK);
        return new ResponseEntity<>(ltc, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/cap-nhat", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateLTC(@Validated @RequestBody LopTinChiDTO ltc){
        System.out.println(ltc.getMaLTC());
        int x = lopTinChiService.updateLTC(ltc.getMaLTC(), ltc.getTenMH(), ltc.getTenLop(),
                                            ltc.getTenGV(), ltc.getNienKhoa(), ltc.getNhom(),
                                            ltc.getSoSV(), ltc.getHocKi(), ltc.isHuyLop() == true ? 1 : 0);
        if(x == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/xoa-ltc", method = RequestMethod.DELETE)
    public ResponseEntity<?> xoaLTC(@RequestParam("ma-ltc") int maLTC){
        int x = lopTinChiService.xoaLTC(maLTC);
        if(x == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/lay-ma-ltc", method = RequestMethod.GET)
    public ResponseEntity<Map<String, ?>> maLTCVuaThem(@RequestParam("ten-mh") String tenMH,
                                                       @RequestParam("nien-khoa") String nienKhoa,
                                                       @RequestParam("nhom") int nhom,
                                                       @RequestParam("hoc-ki") int hocKi){
        Map<String, ?> maLTC = lopTinChiService.getMaLopTC(tenMH, nienKhoa, nhom, hocKi);
        return new ResponseEntity<>(maLTC, HttpStatus.OK);
    }
}
