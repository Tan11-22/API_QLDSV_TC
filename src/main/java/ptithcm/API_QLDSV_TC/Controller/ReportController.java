package ptithcm.API_QLDSV_TC.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.API_QLDSV_TC.Model.DanhSachHocPhiLop;
import ptithcm.API_QLDSV_TC.Model.Lop;
import ptithcm.API_QLDSV_TC.Service.DanhSachHocPhiLopService;
import ptithcm.API_QLDSV_TC.Service.LopService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    DanhSachHocPhiLopService danhSachHocPhiLopService;

    @Autowired
    LopService lopService;


    @GetMapping("/ds-hocphi-theolop")
    public ResponseEntity<List<DanhSachHocPhiLop>> getDanhSachHocPhiTheoLop(@RequestParam String lop, @RequestParam String nienkhoa, @RequestParam int hocky) {
        System.out.println(lop);
        System.out.println(nienkhoa);
        System.out.println(hocky);
        List<DanhSachHocPhiLop> danhSachHocPhiLopList;
        danhSachHocPhiLopList = danhSachHocPhiLopService.DsHocPhiTheoLop(lop, nienkhoa, hocky);
        if (danhSachHocPhiLopList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(danhSachHocPhiLopList, HttpStatus.OK);
        }
    }

    @GetMapping("/ds-lop")
    public ResponseEntity<List<String>> getDanhSachLop() {
        List<Lop> lopList = lopService.getAllLop();
        List<String> maLopList = new ArrayList<>();
        for (int i = 0; i < lopList.size(); i++) {
            maLopList.add(lopList.get(i).getMalop());
        }
        if (maLopList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(maLopList, HttpStatus.OK);
        }
    }

    @GetMapping("/ds-nienkhoa")
    public ResponseEntity<List<String>> getDanhSachNienKhoa() {
        List<String> ds = new ArrayList<>();
        ds = danhSachHocPhiLopService.getNienKhoa();
        if (ds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(ds, HttpStatus.OK);
        }
    }
}
