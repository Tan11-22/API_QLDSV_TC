package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ptithcm.API_QLDSV_TC.Model.HocPhi;

import ptithcm.API_QLDSV_TC.Model.HocPhiId;
@Repository
public interface HocPhiRepository extends JpaRepository<HocPhi,HocPhiId>{
    @Procedure
    void SP_AP_HOC_PHI(@Param("MASV")String maSV,@Param("NIENKHOA") String nienKhoa, @Param("HOCKY") int hocKy);
}
