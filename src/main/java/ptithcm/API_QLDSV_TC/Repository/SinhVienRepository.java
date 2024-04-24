package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.API_QLDSV_TC.Model.Lop;
import ptithcm.API_QLDSV_TC.Model.SinhVien;

import java.util.List;

public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
    SinhVien findBymasv(String maSV);
    List<SinhVien> findBymalop(Lop maLop);
}
