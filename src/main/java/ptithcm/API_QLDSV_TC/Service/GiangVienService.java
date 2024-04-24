package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.GiangVien;
import ptithcm.API_QLDSV_TC.Repository.GiangVienRepository;

import java.util.List;
import java.util.Optional;

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
    public boolean isExistsById(String id){
        return giangVienRepository.existsById(id);
    }
}
