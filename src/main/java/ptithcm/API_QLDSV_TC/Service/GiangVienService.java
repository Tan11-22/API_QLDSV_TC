package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.DTO.GiangVienDTO;
import ptithcm.API_QLDSV_TC.DTO.SinhVienDTO;
import ptithcm.API_QLDSV_TC.Model.GiangVien;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Repository.GiangVienRepository;

import java.util.List;

import java.util.Optional;

import java.util.Map;


@Service
public class GiangVienService {
    @Autowired
    GiangVienRepository giangVienRepository;

    // Lay danh sach GV
    public List<GiangVien> findAll() {
        return giangVienRepository.findAll();
    }

    //Lay GV theo id
    public Optional<GiangVien> findById(String id) {
        return giangVienRepository.findById(id);
    }

    //Them, cap nhat giang vien
    public GiangVien save(GiangVien giangVien) {
        return giangVienRepository.save(giangVien);
    }

    // Xoa giang vien
    public void delete(GiangVien giangVien){
        giangVienRepository.delete(giangVien);
    }

    // Kiem tra ton tai
    public boolean isExistsById(String id) {
        return giangVienRepository.existsById(id);
    }
    public Map<String, ?> thongTinCaNhanGiangVien(String magv){
        return giangVienRepository.thongTinCaNhanGiangVien(magv);
    }


    public GiangVien findByMAGV(String magv){
        return giangVienRepository.findBymagv(magv);
    }


    public int themGiangVienMoi(GiangVienDTO giangVien, String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPass = encoder.encode(password);
        try {
            giangVienRepository.themGiangVienMoi(
                    giangVien.getMagv(),
                    giangVien.getHo(),
                    giangVien.getTen(),
                    giangVien.getHocham(),
                    giangVien.getHocvi(),
                    giangVien.getChuyenmon(),
                    giangVien.getSdt(),
                    giangVien.getHinhanh(),
                    giangVien.getMagv().trim()+"@student.ptithcm.edu.vn",
                    giangVien.getMakhoa(),
                    newPass            );
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public int xoaGiangVien(String magv){
        try {
            giangVienRepository.xoaGiangVien(magv);

        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }

    public int updateGiangVien(GiangVienDTO giangVien) {

        try {
            giangVienRepository.updateGiangVien(
                    giangVien.getMagv(),
                    giangVien.getHo(),
                    giangVien.getTen(),
                    giangVien.getHocham(),
                    giangVien.getHocvi(),
                    giangVien.getChuyenmon(),
                    giangVien.getSdt(),
                    giangVien.getHinhanh(),
                    giangVien.getEmail(),
                    giangVien.getMakhoa()
            );
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
    public List<GiangVien> danhSachGVMaKhoa(String makhoa){

        return  giangVienRepository.danhSachGiangVien(makhoa);
    }
    public List<String> locMaKhoa()
    {
        return giangVienRepository.locMaKhoa();
    }
}
