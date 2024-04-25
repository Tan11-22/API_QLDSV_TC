package ptithcm.API_QLDSV_TC.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ptithcm.API_QLDSV_TC.Model.DangKy;
import ptithcm.API_QLDSV_TC.Model.DangKyId;

public interface DangKyRepository extends JpaRepository<DangKy, DangKyId>{
    List<DangKy> findById_Masv(String maSV);
    
    @Query(value = " EXECUTE SP_BO_DANG_KY :MASV,:MALTC",nativeQuery = true)
    Map<String, ?> huyDangKy(
            @Param("MASV") String maSV,
            @Param("MALTC") Integer maLTC);
}
