package ptithcm.API_QLDSV_TC.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.JWTAuthResponse;
import ptithcm.API_QLDSV_TC.DTO.LoginDTO;
import ptithcm.API_QLDSV_TC.DTO.TaiKhoanDTO;
import ptithcm.API_QLDSV_TC.Security.SpringSecurityConfig;
import ptithcm.API_QLDSV_TC.Service.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    TaiKhoanService taiKhoanService;

    @Autowired
    LopService lopService;

    @Autowired
    KhoaService khoaService;
    @Autowired
    QuyenService quyenService;


    @Autowired
    NganhService nganhService;
    @Autowired
    private IAuthService authService;

    @Autowired
    ChuongTrinhDaoTaoService chuongTrinhDaoTaoService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestParam("username") String username,
                                                        @RequestParam("password") String password){
        if(taiKhoanService.checkStatus(username)){
            return ResponseEntity.badRequest().body("User is not active");
        }
        LoginDTO loginDTO = new LoginDTO(username, password);


        String token = authService.login(loginDTO);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        System.out.println(jwtAuthResponse.toString());
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @GetMapping(value = "/info")
    public ResponseEntity<TaiKhoanDTO> getInfo(@RequestParam("username") String username){
        return ResponseEntity.ok(taiKhoanService.getInfo(username));
    }
    @GetMapping(value = "check-role")
    public String checkrole(){
        return "role sinh vien";
    }

    @GetMapping(value = "check-role-gv")
    public String checkrole1(){
        return "role giang vien";
    }
    @GetMapping(value = "danh-sach-lop")
    public ResponseEntity<List<Map<String, Object>>> getAllLop() {
        return ResponseEntity.ok( lopService.findDanhSachLop());
    }

    @GetMapping(value = "danh-sach-nganh")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Map<String, Object>>> getAllNganh() {
        return ResponseEntity.ok( nganhService.findDanhSachNganh());
    }
    @GetMapping(value = "danh-sach-khoa")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Map<String, Object>>> getAllKhoa() {
        return ResponseEntity.ok( khoaService.findDanhSachKhoa());
    }
    @GetMapping(value = "danh-sach-quyen")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Map<String,Object>>> getAllQuyen() {
        return ResponseEntity.ok( quyenService.getAllQuyen());
    }

    @PutMapping(value = "tao-tai-khoan")
    public boolean taoTaiKhoan(@RequestBody TaiKhoanDTO account) {
        System.out.println(account.toString());
        PasswordEncoder encoder = SpringSecurityConfig.passwordEncoder();
        System.out.println(encoder.encode(account.getPassword()));
        return taiKhoanService.saveNewLogin(account);
    }

    @PutMapping(value = "add-khoa")
    public boolean taoKhoaMoi(@RequestParam("ma") String ma,
                               @RequestParam("ten") String ten,
                              @RequestParam("id") int id) {
        return khoaService.taoKhoaMoi(ma,ten,id);
    }

    @PutMapping(value = "edit-khoa")
    public boolean thayDoiThongTinKhoa(@RequestParam("ma") String ma,
                              @RequestParam("ten") String ten,
                              @RequestParam("id") int id) {
        khoaService.thayDoiKhoa(ma,ten,id);
        return true;
    }

    @PutMapping(value = "delete-khoa")
    public boolean deleteKhoa(@RequestParam("makhoa") String maKhoa) {
        return khoaService.deleteKhoa(maKhoa);
    }

    @GetMapping(value = "kiem-tra-username")
    @ResponseStatus(HttpStatus.OK)
    public boolean checkUserName(@RequestParam("username") String username) {
        return taiKhoanService.checkUsername(username);
    }

    @GetMapping(value = "danh-sach-tai-khoan")
    public ResponseEntity<List<Map<String,Object>>> getTK(@RequestParam("id") int id) {

        return ResponseEntity.ok( taiKhoanService.findDanhSachTaiKhoan(id));
    }

    @PutMapping(value = "reset-pass")
    public boolean resetPass(@RequestParam("username") String username) {
        return taiKhoanService.resetPassword(username);
    }

    @PutMapping(value = "set-status")
    public boolean resetPass(@RequestParam("username") String username,
                             @RequestParam("status") boolean status) {
        System.out.println("check vao duoc route danh-sach-tai-khoan");
        return taiKhoanService.setStatusTK(username,status);
    }

    @GetMapping(value = "get-ctdt")
    public ResponseEntity<List<Map<String,Object>>> getCTDT(@RequestParam("ma-lop") String maLop,
                                                            @RequestParam("nien-khoa")String nienKhoa) {

        return ResponseEntity.ok( chuongTrinhDaoTaoService.findCTDT(maLop, nienKhoa));
    }


}
