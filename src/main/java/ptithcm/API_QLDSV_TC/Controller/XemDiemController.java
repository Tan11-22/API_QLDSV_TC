package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.API_QLDSV_TC.Service.XemDiemService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/xem-diem")
public class XemDiemController {
    @Autowired
    private XemDiemService xemDiemService;

    @RequestMapping(value = "/danh-sach-nam-hoc", method = RequestMethod.GET)
    public ResponseEntity<List<String>> danhSachNamHoc(@RequestParam("ma-sinh-vien") String maSV){
        List<String> danhSachNH = xemDiemService.danhSachNamHoc(maSV);
        return ResponseEntity.ok(danhSachNH);
    }

    @RequestMapping(value = "danh-sach-hoc-ki", method = RequestMethod.GET)
    public ResponseEntity<List<String>> danhSachHocKi(@RequestParam("ma-sinh-vien") String maSV,
                                                      @RequestParam("nien-khoa") String nienKhoa){
        List<String> danhSachHK = xemDiemService.danhSachHocKi(maSV, nienKhoa);
        return ResponseEntity.ok(danhSachHK);
    }

    @RequestMapping(value = "diem-hoc-ki", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, ?>>> diemHocKi(@RequestParam("ma-sinh-vien") String maSV,
                                                          @RequestParam("nien-khoa") String nienKhoa,
                                                          @RequestParam("hoc-ki") int hocKi){
        List<Map<String, ?>> diemHK = xemDiemService.danhSachDiemHocKi(maSV, nienKhoa, hocKi);
        return ResponseEntity.ok(diemHK);
    }
}
