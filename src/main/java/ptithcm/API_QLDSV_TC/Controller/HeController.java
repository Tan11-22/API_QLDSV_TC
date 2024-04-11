package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.API_QLDSV_TC.Model.He;
import ptithcm.API_QLDSV_TC.Service.HeService;

import java.util.List;

@RestController
@RequestMapping("api/he-dao-tao")

public class HeController {
    @Autowired
    private HeService heService;

    @RequestMapping(value = "danh-sach", method = RequestMethod.GET)
    public ResponseEntity<List<He>> danhSachHeDaoTao(){
        List<He> danhSachHeDaoTao = heService.danhSachHeDaoTao();
        return new ResponseEntity<>(danhSachHeDaoTao, HttpStatus.OK);
    }
}
