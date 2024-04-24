package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Repository.SinhVienRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SinhVienService {
    @Autowired
    SinhVienRepository sinhVienRepository;

    // Lay danh sach sinh vien
    public List<SinhVien> findAll() {
        return sinhVienRepository.findAll();
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
}
