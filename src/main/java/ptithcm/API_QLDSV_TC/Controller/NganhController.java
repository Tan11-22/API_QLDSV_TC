package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.Model.Nganh;
import ptithcm.API_QLDSV_TC.Service.NganhService;

import java.util.List;

@RestController
@RequestMapping("api/nganh")

public class NganhController {
    @Autowired
    NganhService nganhService;
    @RequestMapping(value = "/danh-sach-nganh", method = RequestMethod.GET)
    public ResponseEntity<List<Nganh>> danhSachNganh(){
        List<Nganh> danhSachNganh = nganhService.danhSachNganh();
        return new ResponseEntity<>(danhSachNganh, HttpStatus.OK);
    }

    @RequestMapping(value = "/them-moi", method = RequestMethod.POST)
    public ResponseEntity<?> themMoiNganh(@Validated @RequestBody Nganh nganh){
        int x = nganhService.themNganh(nganh);
        if(x == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/cap-nhat", method = RequestMethod.PATCH)
    public ResponseEntity<?> capNhatNganh(@Validated @RequestBody Nganh nganh){
        int x = nganhService.capNhatNganh(nganh);
        if(x == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/xoa-nganh", method = RequestMethod.DELETE)
    public ResponseEntity<?> xoaNganh(@RequestParam("id") int id){
        if(nganhService.xoaNganh(id) == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/tim-nganh", method = RequestMethod.GET)
    public ResponseEntity<Nganh> timNganh(@RequestParam("ten-nganh") String tenNganh){
        Nganh nganh = nganhService.nganhTheoTen(tenNganh);
        if(nganh != null)
            return new ResponseEntity<>(nganh, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
