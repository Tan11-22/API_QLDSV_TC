package ptithcm.API_QLDSV_TC.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ptithcm.API_QLDSV_TC.Model.DangKy;
import ptithcm.API_QLDSV_TC.Model.DangKyId;

public interface DangKyRepository extends JpaRepository<DangKy, DangKyId>{
    List<DangKy> findById_Masv(String maSV);

}
