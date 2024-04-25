package ptithcm.API_QLDSV_TC.Controller;


import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.GiangVienDTO;
import ptithcm.API_QLDSV_TC.DTO.SinhVienDTO;
import ptithcm.API_QLDSV_TC.Model.GiangVien;
import ptithcm.API_QLDSV_TC.Model.Lop;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Service.GiangVienService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api/giang-vien")
public class GiangVienController {
    @Autowired
    GiangVienService giangVienService;
    private String imgDirectory ="src/main/java/ptithcm/API_QLDSV_TC/Image";
    @RequestMapping(value = "/thong-tin-ca-nhan", method = RequestMethod.GET)
    public ResponseEntity<Map<String, ?>> thongTinCaNhanGianGiangVien(@RequestParam("ma-gv") String magv){
        Map<String, ?> thongTinCaNhan = giangVienService.thongTinCaNhanGiangVien(magv);
        return new ResponseEntity<>(thongTinCaNhan, HttpStatus.OK);
    }

    @GetMapping("/tim-giang-vien")
    public ResponseEntity<GiangVienDTO> timGiangVien(@RequestParam("ma-gv") String magv) {

        GiangVien gv = giangVienService.findByMAGV(magv);
        GiangVienDTO gvDTO = (new GiangVienDTO(gv.getMagv(),gv.getHo(),gv.getTen(),gv.getHocham(),gv.getHocvi(),gv.getChuyenmon(),gv.getSdt(),gv.getHinhanh(),gv.getEmail(),gv.getMakhoa().getMakhoa()));
        return new ResponseEntity<>(gvDTO, HttpStatus.OK);
    }

    @PostMapping("/encode-ten-anh")
    public ResponseEntity<Map<String,String>> encode(@RequestParam("ten-anh") String tenanh) {
        String base64String = null;
        try {
            String imagePath = imgDirectory + "/" +tenanh; // Thay đổi đường dẫn đến tệp ảnh của bạn
            base64String = encodeImageToBase64(imagePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String,String> result= new HashMap<String,String>();
        result.put("image",base64String);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/danh-sach-gv-khoa")
    public ResponseEntity<List<GiangVienDTO>> danhSachGVKhoa(@RequestParam("ma-khoa") String makhoa) {

        List<GiangVien> gvs = giangVienService.danhSachGVMaKhoa(makhoa);
        List<GiangVienDTO> DSGV = new ArrayList<>();

        for (GiangVien gv : gvs)
        {

            DSGV.add(new GiangVienDTO(gv.getMagv(),gv.getHo(),gv.getTen(),gv.getHocham(),gv.getHocvi(),gv.getChuyenmon(),gv.getSdt(),gv.getHinhanh(),gv.getEmail(),gv.getMakhoa().getMakhoa()));
        }
        return new ResponseEntity<>(DSGV, HttpStatus.OK);
    }

    @RequestMapping(value = "/them-giang-vien-moi", method = RequestMethod.POST)
    public ResponseEntity<?> themGiangVien(@Validated @RequestBody GiangVienDTO giangVien) throws IOException {
        String password = "123456";
        String file = decodeBase64ToImage(giangVien.getMagv(),giangVien.getHinhanh(),imgDirectory);
        giangVien.setHinhanh(file);
        if(giangVienService.themGiangVienMoi(giangVien,password) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
    @RequestMapping(value = "/xoa-giang-vien", method = RequestMethod.POST)
    public ResponseEntity<?> xoaGiangVien(@Validated  @RequestParam("ma-gv") String magv){
        if(giangVienService.xoaGiangVien(magv) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/update-giang-vien", method = RequestMethod.POST)
    public ResponseEntity<?> updateGiangVien(@Validated @RequestBody GiangVienDTO giangVien){
        if(giangVienService.updateGiangVien(giangVien) == 0){
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }
    @RequestMapping(value = "/loc-ma-khoa", method = RequestMethod.GET)
    public ResponseEntity<List<String>> locMaKhoa()
    {
        return new ResponseEntity<>(giangVienService.locMaKhoa(), HttpStatus.OK);

    }

    public String decodeBase64ToImage(String masv,String base64ImageString, String pathFolder) throws IOException {
        // Tạo folder nếu không tồn tại
        File directory = new File(pathFolder);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Tạo tên file theo định dạng ngày giờ
        String fileName = masv + new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + ".png";
        Path destinationFile = Paths.get(pathFolder, fileName);

        // Decode base64 string và lưu thành file
        byte[] imageBytes = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(base64ImageString);
        try (FileOutputStream imageOutFile = new FileOutputStream(destinationFile.toString())) {
            imageOutFile.write(imageBytes);
        }
        catch (Exception e)
        {
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
