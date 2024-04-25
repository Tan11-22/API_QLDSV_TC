package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.Model.He;
import ptithcm.API_QLDSV_TC.Service.HeService;

import java.util.List;

@RestController
@RequestMapping("api/he-dao-tao")

public class HeController {
    @Autowired
    private HeService heService;

    @RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
    public ResponseEntity<List<He>> danhSachHeDaoTao(){
        List<He> danhSachHeDaoTao = heService.danhSachHeDaoTao();
        return new ResponseEntity<>(danhSachHeDaoTao, HttpStatus.OK);
    }

    @RequestMapping(value = "/cap-nhat", method = RequestMethod.PATCH)
    public ResponseEntity<?> capNhatHeDaoTao(@Validated @RequestBody He he){
        if(heService.capNhathe(he) == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/them-moi", method = RequestMethod.POST)
    public ResponseEntity<?> themMoiHeDaoTao(@Validated @RequestBody He he){
        if(heService.capNhathe(he) == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/xoa-he", method = RequestMethod.DELETE)
    public ResponseEntity<?> xoaHeDaoTao(@RequestParam("id") int id){
        if(heService.xoaHe(id) == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/tim-he", method = RequestMethod.GET)
    public ResponseEntity<He> timHeTheoTen(@RequestParam("ten-he") String tenHe){
        He he = heService.heTheoTen(tenHe);
        if(he != null)
            return new ResponseEntity<>(he, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
