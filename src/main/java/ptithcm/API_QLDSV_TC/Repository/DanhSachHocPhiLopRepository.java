package ptithcm.API_QLDSV_TC.Repository;

import jakarta.persistence.StoredProcedureQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptithcm.API_QLDSV_TC.Model.DanhSachHocPhiLop;

import java.util.List;


public interface DanhSachHocPhiLopRepository extends JpaRepository<DanhSachHocPhiLop,String> {
    DanhSachHocPhiLop findDanhSachHocPhiLopBymasv(String masv);

    @Query(value = " EXECUTE DS_HOCPHI_THEOLOP :LOP,:NIENKHOA,:HOCKY",nativeQuery = true)
    List<DanhSachHocPhiLop> getDanhSachHocPhiLopsByLop(
            @Param("LOP") String lop,
            @Param("NIENKHOA") String nienkhoa,
            @Param("HOCKY") int hocky);

    @Query(value="EXECUTE DS_NIENKHOA",nativeQuery = true)
    List<String> getNienKhoa();
}