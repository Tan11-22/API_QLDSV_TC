package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.DTO.SinhVienData;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Repository.SinhVienRepository;

import java.util.*;

import org.springframework.dao.DataAccessException;
import ptithcm.API_QLDSV_TC.DTO.SinhVienDTO;

import java.util.List;


@Service
public class SinhVienService {
    @Autowired
    SinhVienRepository sinhVienRepository;


    // Lay danh sach sinh vien
    public List<SinhVien> findAll() {
        return sinhVienRepository.findAll();
    }


    public Map<String, Object> thongtinSV(String masv){
        return sinhVienRepository.thongtinSV(masv);
    }

    // Lay thong tin sinh vien
    public Optional<SinhVien> findById(String id) {
        return sinhVienRepository.findById(id);
    }

    // Luu va sua thong tin sinh vien
    public SinhVien save(SinhVien sinhVien) {
        return sinhVienRepository.save(sinhVien);
    }

    // Xoa sinh vien
    public void deleteById(String id) {
        sinhVienRepository.deleteById(id);
    }

    // Kiem tra ton tai
    public boolean existsById(String id) {
        return sinhVienRepository.existsById(id);
    }
    public SinhVien sinhVienTheoMa(String maSV){
        return sinhVienRepository.findBymasv(maSV);
    }


    public int themSinhVienMoi(SinhVienDTO sinhVien, String password) {
        System.out.println(sinhVien.toString());
        try {
            sinhVienRepository.themSinhVienMoi(
                    sinhVien.getMasv(),
                    sinhVien.getHo(),
                    sinhVien.getTen(),
                    sinhVien.getNgaysinh(),
                    sinhVien.getPhai(),
                    sinhVien.getSdt(),
                    sinhVien.getDiachi(),
                    sinhVien.getMalop(),
                    false,
                    sinhVien.getHinhanh(),
                    sinhVien.getMasv().trim()+"@student.ptithcm.edu.vn",
                    password
            );
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int xoaSinhVien(String masv){
        try {
            sinhVienRepository.xoaSinhVien(masv);

        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }

    public int updateSinhVien(SinhVienDTO sinhVien) {
        System.out.println(sinhVien.toString());
        try {
            sinhVienRepository.updateSinhVien(
                    sinhVien.getMasv(),
                    sinhVien.getHo(),
                    sinhVien.getTen(),
                    sinhVien.getNgaysinh(),
                    sinhVien.getPhai(),
                    sinhVien.getSdt(),
                    sinhVien.getDiachi(),
                    sinhVien.getMalop(),
                    sinhVien.getDanghihoc(),
                    sinhVien.getHinhanh(),
                    sinhVien.getEmail()
            );
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public List<SinhVien> danhSachSVMaLop(String malop){

        return  sinhVienRepository.danhSachSinhVien(malop);
    }
    public List<String> locMaLop()
    {
        return sinhVienRepository.locMaLop();
    }
    public int updateDaNghiHoc(String masv) {

        try {
            sinhVienRepository.updateDaNghiHoc(masv);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int quenMatKhau(String email,String password) {

        try {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String newPass = encoder.encode(password);
            sinhVienRepository.quenMatKhau(email,newPass);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int doiMatKhau(String username,String password) {

        try {
            sinhVienRepository.doiMatKhau(username,password);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public SinhVienDTO timSinhVen(String masv)
    {
        return sinhVienRepository.timSinhVien(masv);
    }
}
