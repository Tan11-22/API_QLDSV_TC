package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.SinhVienData;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Service.SinhVienService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Base64;

@RestController
@RequestMapping("/api/sinhvien")
public class SinhVienController1 {
    private static final String FILE_DIRECTORY = "C:\\Users\\Admin\\Desktop\\New folder\\API_QLDSV_TC\\src\\main\\java\\ptithcm\\API_QLDSV_TC\\Image\\";
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
        System.out.println(id);
        Map<String, Object> thongtin = sinhVienService.thongtinSV(id);
        if (thongtin == null) {
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        }

//        for (Map.Entry<String, Object> entry : thongtin.entrySet()) {
//            if (entry.getValue() == null) {
//                entry.setValue("");
//                System.out.println("Có hoạt động");
//            }
//        }

        SinhVienData sinhVienData = new SinhVienData();
        sinhVienData.setMASV((String) thongtin.get("MASV"));
        sinhVienData.setHO((String)thongtin.get("HO"));
        sinhVienData.setTEN((String) thongtin.get("TEN"));
        sinhVienData.setNGAYSINH(thongtin.get("NGAYSINH").toString());
        sinhVienData.setEMAIL((String)thongtin.get("EMAIL"));
        sinhVienData.setKHOA((String)thongtin.get("TENKHOA"));
        sinhVienData.setSDT((String)thongtin.get("SDT"));
        sinhVienData.setDIACHI((String)thongtin.get("DIACHI"));
        sinhVienData.setPHAI(thongtin.get("PHAI").toString());
        sinhVienData.setLOP((String)thongtin.get("TENLOP"));
        sinhVienData.setHINHANH((String) thongtin.get("HINHANH"));
        Path imgPath = Paths.get(FILE_DIRECTORY+sinhVienData.getHINHANH());
        if (Files.exists(imgPath)) {
            // Nếu hình ảnh tồn tại, đọc nó và tạo ByteArrayResource
            try {
                // Đọc dữ liệu của hình ảnh
                byte[] imageBytes = Files.readAllBytes(imgPath);
                String imgString = Base64.getEncoder().encodeToString(imageBytes);
                sinhVienData.setImgResource(imgString);

                // Thiết lập phần header cho phản hồi
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.);
//                headers.set("Content-Disposition", "inline; filename=" + sinhVienData.getHINHANH());

                // Trả về một phản hồi multipart kèm theo dữ liệu và hình ảnh
                return ResponseEntity.ok(sinhVienData);
            } catch (IOException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
//        Resource img = new InputStreamResource(Files.newInputStream(imgPath));
//        sinhVienData.setImgResource(img);
        return ResponseEntity.ok(sinhVienData);
    }

    @PostMapping ("/update")
    public String update(@RequestBody SinhVienData sinhVienData) throws IOException {
        if (sinhVienData.getHINHANH() != null){
            saveBase64Image(sinhVienData.getImgResource(),sinhVienData.getHINHANH());
            SinhVien sinhVien = sinhVienService.sinhVienTheoMa(sinhVienData.getMASV());
            sinhVien.setDiachi(sinhVienData.getDIACHI());
            sinhVien.setHinhanh(sinhVienData.getHINHANH());
            sinhVienService.save(sinhVien);
        }else{
            SinhVien sinhVien = sinhVienService.sinhVienTheoMa(sinhVienData.getMASV());
            sinhVien.setDiachi(sinhVienData.getDIACHI());
            sinhVienService.save(sinhVien);
        }
        System.out.println(sinhVienData.toString());
        return "Thành công";
    }

    public void saveBase64Image(String base64Image, String imageName) throws IOException {
        // Loại bỏ phần tiêu đề của chuỗi base64 nếu có
//        String base64ImageWithoutHeader = base64Image.split(",")[1];

        // Giải mã chuỗi base64 thành mảng byte

        byte[] imageBytes;
        imageBytes = Base64.getDecoder().decode(base64Image);

        // Tạo đường dẫn đến thư mục và tên file
        Path destinationFile = Paths.get("C:\\Users\\Admin\\Desktop\\New folder\\API_QLDSV_TC\\src\\main\\java\\ptithcm\\API_QLDSV_TC\\Image", imageName);

        // Lưu mảng byte thành file hình ảnh
        Files.write(destinationFile, imageBytes);
    }
}