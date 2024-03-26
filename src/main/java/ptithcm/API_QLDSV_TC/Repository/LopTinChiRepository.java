package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import ptithcm.API_QLDSV_TC.Model.LopTinChi;

import java.util.List;
import java.util.Map;

public interface LopTinChiRepository extends JpaRepository<LopTinChi, Integer> {
    @Query(value = "{call SP_DANH_SACH_LTC_THEO_MAGV(:magv)}", nativeQuery = true)
    public List<Map<String, ?>> danhSachLTCTheoMaGV(String magv);

    @Query(value = "{call SP_DANH_SACH_SINH_VIEN_LTC(:maltc)}", nativeQuery = true)
    public List<Map<String, ?>> danhSachSinhVienLTC(@Param("maltc") int maLTC);

    @Query(value = "{call SP_GET_DIEM_SV_LTC(:masv, :maltc)}", nativeQuery = true)
    public Map<String, ?> diemSinhVienLTC(@Param("masv") String maSV, @Param("maltc") int maLTC);

    @Query(value = "{call SP_UPDATE_DIEM(:maltc, :masv, :diemcc, :diemgk, :diemck)}", nativeQuery = true)
    public int capNhatDiemSinhVienLTC(@Param("maltc") int maLTC,
                                                    @Param("masv") String maSV ,
                                                    @Param("diemcc") int diemCC,
                                                    @Param("diemgk") float diemGK,
                                                    @Param("diemck") float diemCK);
}
