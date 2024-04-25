package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.API_QLDSV_TC.DTO.SinhVienData;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Service.SinhVienService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienController1 {
    private static final String FILE_DIRECTORY = "D:\\PTUDDD\\QLSVHTC\\src\\main\\java\\ptithcm\\API_QLDSV_TC\\Image\\";
    @Autowired
    SinhVienService sinhVienService;

//    @GetMapping
//    public ResponseEntity<List<Map<String,Object>>> getAll() {
//        List<Map<String, Object>> list = new ArrayList<>();
//        list = sinhVienService.findAlll();
//        if (list.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(list, HttpStatus.OK);
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) throws IOException {

        Map<String, Object> thongtin = sinhVienService.thongtinSV(id);
        if (thongtin == null) {
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        }

        for (Map.Entry<String, Object> entry : thongtin.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue("");
            }
        }

        SinhVienData sinhVienData = new SinhVienData();
        sinhVienData.setMASV(thongtin.get("MASV").toString());
        sinhVienData.setHO(thongtin.get("HO").toString());
        sinhVienData.setTEN(thongtin.get("TEN").toString());
        sinhVienData.setNGAYSINH(thongtin.get("NGAYSINH").toString());
        sinhVienData.setEMAIL(thongtin.get("EMAIL").toString());
        sinhVienData.setKHOA(thongtin.get("TENKHOA").toString());
        sinhVienData.setSDT(thongtin.get("SDT").toString());
        sinhVienData.setDIACHI(thongtin.get("DIACHI").toString());
        sinhVienData.setPHAI(thongtin.get("PHAI").toString());
        sinhVienData.setLOP(thongtin.get("TENLOP").toString());
        sinhVienData.setHINHANH(thongtin.get("HINHANH").toString());
        Path imgPath = Paths.get(FILE_DIRECTORY+sinhVienData.getHINHANH());
        if (Files.exists(imgPath)) {
            // Nếu hình ảnh tồn tại, đọc nó và tạo ByteArrayResource
            try {
                // Đọc dữ liệu của hình ảnh
                byte[] imageBytes = Files.readAllBytes(imgPath);
                sinhVienData.setImgResource(imageBytes);

                // Thiết lập phần header cho phản hồi
                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.);
                headers.set("Content-Disposition", "inline; filename=" + sinhVienData.getHINHANH());

                // Trả về một phản hồi multipart kèm theo dữ liệu và hình ảnh
                return new ResponseEntity<>(sinhVienData, headers, HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
//        Resource img = new InputStreamResource(Files.newInputStream(imgPath));
//        sinhVienData.setImgResource(img);
        return new ResponseEntity<>(sinhVienData, HttpStatus.OK);
    }
}