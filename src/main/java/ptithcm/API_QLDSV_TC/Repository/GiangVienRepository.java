package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ptithcm.API_QLDSV_TC.Model.GiangVien;

import java.util.List;
import java.util.Map;

public interface GiangVienRepository extends JpaRepository<GiangVien, String> {
    @Query(value = "{call SP_THONG_TIN_GV(:magv)}", nativeQuery = true)
    public Map<String, ?> thongTinCaNhanGiangVien(@Param("magv") String magv);
}
