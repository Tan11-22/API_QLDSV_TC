package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.SinhVienDTO;
import ptithcm.API_QLDSV_TC.Model.Lop;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Service.LopService;
import ptithcm.API_QLDSV_TC.Service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;
    @Autowired
    LopService lopService;

    @RequestMapping(value = "thong-tin-ca-nhan", method = RequestMethod.GET)
    public ResponseEntity<SinhVien> thongTinCaNhan(@RequestParam("ma-sv") String maSV){
        SinhVien sv = sinhVienService.sinhVienTheoMa(maSV);
        if(sv != null){
            return new ResponseEntity<>(sv, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/tim-sinh-vien")
    public ResponseEntity<SinhVienDTO> timSinhVien(@RequestParam("ma-sv") String masv) {
        SinhVien sv = sinhVienService.sinhVienTheoMa(masv);

        SinhVienDTO sinhVienDTO = (new SinhVienDTO(sv.getMasv(), sv.getHo(), sv.getTen(),sv.getPhai(),sv.getDiachi(),sv.getNgaysinh(),sv.getMalop().getMalop(),sv.getDanghihoc(),sv.getSdt(),sv.getHinhanh(),sv.getEmail()));

        return new ResponseEntity<>(sinhVienDTO, HttpStatus.OK);
    }

    @GetMapping("/danh-sach-sv-lop")
    public ResponseEntity<List<SinhVienDTO>> danhSachSVLop(@RequestParam("ma-lop") String malop) {
        List<SinhVien> danhSach = sinhVienService.danhSachSVMaLop(malop);
        List<SinhVienDTO> DSSV = new ArrayList<>();

        for (SinhVien sv : danhSach)
        {

            DSSV.add(new SinhVienDTO(sv.getMasv(), sv.getHo(), sv.getTen(),sv.getPhai(),sv.getDiachi(),sv.getNgaysinh(),sv.getMalop().getMalop(),sv.getDanghihoc(),sv.getSdt(),sv.getHinhanh(),sv.getEmail()));
        }
        return new ResponseEntity<>(DSSV, HttpStatus.OK);
    }


    @GetMapping(value = "danh-sach-lop")
    @ResponseStatus(HttpStatus.OK)
    public List<Lop> danhSachLop() {
        return lopService.findAll();
    }
    @RequestMapping(value = "/them-sinh-vien-moi", method = RequestMethod.POST)
    public ResponseEntity<?> themSinhVien(@Validated @RequestBody SinhVienDTO sinhvien){
        String password = "123456";
        if(sinhVienService.themSinhVienMoi(sinhvien,password) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
    @RequestMapping(value = "/xoa-sinh-vien", method = RequestMethod.POST)
    public ResponseEntity<?> xoaSinhVien(@Validated  @RequestParam("ma-sv") String maSV){
        if(sinhVienService.xoaSinhVien(maSV) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/update-sinh-vien", method = RequestMethod.POST)
    public ResponseEntity<?> updateSinhVien(@Validated @RequestBody SinhVienDTO sinhvien){
        if(sinhVienService.updateSinhVien(sinhvien) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
    @RequestMapping(value = "/loc-ma-lop", method = RequestMethod.GET)
    public ResponseEntity<List<String>> locMaLop()
    {
        return new ResponseEntity<>(sinhVienService.locMaLop(), HttpStatus.OK);

    }
    @RequestMapping(value = "/da-nghi-hoc", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>  updateDaNghiHoc(@Validated  @RequestParam("masv") String masv)
    {
        if(sinhVienService.updateDaNghiHoc(masv) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }


    }

    @RequestMapping(value = "/quen-mat-khau", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>  quenMatKhau(@Validated  @RequestParam("email") String email,
                                          @RequestParam("password") String password)
    {
        if(sinhVienService.quenMatKhau(email, password) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
    @RequestMapping(value = "/doi-mat-khau", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>  doiMatKhau(@Validated  @RequestParam("username") String username,
                                         @RequestParam("password") String password)
    {
        if(sinhVienService.doiMatKhau(username, password) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }


    }
}
