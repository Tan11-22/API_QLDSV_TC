package ptithcm.API_QLDSV_TC.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import ptithcm.API_QLDSV_TC.Model.SinhVien;

import ptithcm.API_QLDSV_TC.DTO.SinhVienDTO;
import ptithcm.API_QLDSV_TC.Model.Lop;

import ptithcm.API_QLDSV_TC.Service.LopService;
import ptithcm.API_QLDSV_TC.Service.SinhVienService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;
    @Autowired
    LopService lopService;
    // Thay đổi thành đường dẫn tới thư mục img trong file application.properties
    private String imgDirectory = "src/main/java/ptithcm/API_QLDSV_TC/Image";

    @RequestMapping(value = "thong-tin-ca-nhan", method = RequestMethod.GET)
    public ResponseEntity<SinhVien> thongTinCaNhan(@RequestParam("ma-sv") String maSV) {
        SinhVien sv = sinhVienService.sinhVienTheoMa(maSV);
        if (sv != null) {
            return ResponseEntity.ok(sv);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/tim-sinh-vien")
    public ResponseEntity<SinhVienDTO> timSinhVien(@RequestParam("ma-sv") String masv) {
        System.out.println("check tim sinh vien");
        SinhVien sv = sinhVienService.sinhVienTheoMa(masv);

        SinhVienDTO sinhVienDTO = (new SinhVienDTO(sv.getMasv(), sv.getHo(), sv.getTen(), sv.getPhai(), sv.getDiachi(),
                sv.getNgaysinh(), sv.getMalop().getMalop(), sv.getDanghihoc(), sv.getSdt(), sv.getHinhanh(),
                sv.getEmail()));

        return ResponseEntity.ok(sinhVienDTO);
    }

    @PostMapping("/encode-ten-anh")
    public ResponseEntity<Map<String, String>> encode(@RequestParam("ten-anh") String tenanh) {
        String base64String = null;
        try {
            String imagePath = imgDirectory + "/" + tenanh; // Thay đổi đường dẫn đến tệp ảnh của bạn
            base64String = encodeImageToBase64(imagePath);
            // System.out.println("Base64 string: " + base64String);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, String> result = new HashMap<String, String>();
        result.put("image", base64String);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/danh-sach-sv-lop")
    public ResponseEntity<List<SinhVienDTO>> danhSachSVLop(@RequestParam("ma-lop") String malop) {
        List<SinhVien> danhSach = sinhVienService.danhSachSVMaLop(malop);
        List<SinhVienDTO> DSSV = new ArrayList<>();

        for (SinhVien sv : danhSach) {

            DSSV.add(new SinhVienDTO(sv.getMasv(), sv.getHo(), sv.getTen(), sv.getPhai(), sv.getDiachi(),
                    sv.getNgaysinh(), sv.getMalop().getMalop(), sv.getDanghihoc(), sv.getSdt(), sv.getHinhanh(),
                    sv.getEmail()));
        }
        return new ResponseEntity<>(DSSV, HttpStatus.OK);
    }

    @GetMapping(value = "danh-sach-lop")
    @ResponseStatus(HttpStatus.OK)
    public List<Lop> danhSachLop() {
        return lopService.findAll();
    }

    @RequestMapping(value = "/them-sinh-vien-moi", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> themSinhVien(@RequestParam("sv") String svString,
            @RequestParam("img") MultipartFile file) throws IOException {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        SinhVienDTO sinhvien;
        try {
            sinhvien = objectMapper.readValue(svString, SinhVienDTO.class);
        } catch (Exception e) {
            result.put("status", "Invalid JSON data");
            return ResponseEntity.badRequest().body(result);
        }
        System.out.println(sinhvien.toString());
        String password = "123456";

        LocalDateTime currentDateTime = LocalDateTime.now();
        String fileName = sinhvien.getHinhanh().trim() + "_" +
                currentDateTime.getHour() + "h" +
                currentDateTime.getMinute() + "m" +
                currentDateTime.getSecond() + "s" + ".jpg";
        sinhvien.setHinhanh(fileName);
        Path root = Paths.get("src/main/resources/img/");
        try {
            Files.copy(file.getInputStream(), root.resolve(fileName));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        if (sinhVienService.themSinhVienMoi(sinhvien, password) == 0) {
            result.put("status", "Insert Fail!");
            return ResponseEntity.badRequest().body(result);
        } else {
            result.put("status", "OK");
            result.put("filename", fileName);
            return ResponseEntity.ok().body(result);
        }
    }

    @RequestMapping(value = "/xoa-sinh-vien", method = RequestMethod.POST)
    public ResponseEntity<?> xoaSinhVien(@Validated @RequestParam("ma-sv") String maSV) {
        if (sinhVienService.xoaSinhVien(maSV) == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/update-sinh-vien", method = RequestMethod.POST)
    public ResponseEntity<?> updateSinhVien(@Validated @RequestBody SinhVienDTO sinhvien) {
        if (sinhVienService.updateSinhVien(sinhvien) == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/loc-ma-lop", method = RequestMethod.GET)
    public ResponseEntity<List<String>> locMaLop() {
        return new ResponseEntity<>(sinhVienService.locMaLop(), HttpStatus.OK);

    }

    @RequestMapping(value = "/da-nghi-hoc", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateDaNghiHoc(@Validated @RequestParam("masv") String masv) {
        if (sinhVienService.updateDaNghiHoc(masv) == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }

    }

    @RequestMapping(value = "/doi-mat-khau", method = RequestMethod.POST)
    public ResponseEntity<?> doiMatKhau(@Validated @RequestParam("username") String username,
            @RequestParam("password") String password) {
        if (sinhVienService.doiMatKhau(username, password) == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }

    }

    @GetMapping("/tai-khoan-by-email")
    public ResponseEntity<Map<String, Object>> taiKhoanByEmail(@Validated @RequestParam("Email") String Email) {
        Map<String, Object> result = sinhVienService.taiKhoanByEmail(Email);
        if (result.get("ID") == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(result);
    }

    public String decodeBase64ToImage(String masv, String base64ImageString, String pathFolder) throws IOException {
        // Tạo folder nếu không tồn tại
        File directory = new File(pathFolder);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Tạo tên file theo định dạng ngày giờ
        String fileName = masv + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + ".png";
        Path destinationFile = Paths.get(pathFolder, fileName);

        // Decode base64 string và lưu thành file
        byte[] imageBytes = Base64.decodeBase64(base64ImageString);
        try (FileOutputStream imageOutFile = new FileOutputStream(destinationFile.toString())) {
            imageOutFile.write(imageBytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Trả về tên file đã lưu
        return fileName;
    }

    public static String encodeImageToBase64(String imagePath) throws Exception {
        // Đọc nội dung của tệp ảnh thành mảng byte
        byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

        // Mã hóa mảng byte thành chuỗi base64
        String base64ImageString = Base64.encodeBase64String(imageBytes);

        // Trả về chuỗi base64
        return base64ImageString;
    }

}
