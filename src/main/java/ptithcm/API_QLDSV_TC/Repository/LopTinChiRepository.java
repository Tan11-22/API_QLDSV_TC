package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import ptithcm.API_QLDSV_TC.DTO.LopTinChiDTO;
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

    @Query(value = "{call SP_DANH_SACH_LTC(:makhoa)}", nativeQuery = true)
    public List<Map<String, ?>> danhSachLTC(@Param("makhoa") String maKhoa);

    @Query(value = "{call SP_GET_DANH_SACH_DK_LOC(:loai, :makhoa)}", nativeQuery = true)
    public List<String> danhSachDKLoc(@Param("loai") int loai, @Param("makhoa") String maKhoa);
    @Query(value = "{call SP_DANH_SACH_LOC_THEM_LTC(:loai, :makhoa)}", nativeQuery = true)
    public List<String> danhSachLocThemLTC(@Param("loai") int loai, @Param("makhoa") String maKhoa);

    @Query(value = "{call SP_THEM_LTC(:tenmh, :tenlop, :tengiangvien, :nienkhoa, :nhom, :sosv, :hocki, :makhoa)}", nativeQuery = true)
    public int themLTC(@Param("tenmh") String tenMH,
                       @Param("tenlop") String tenLop,
                       @Param("tengiangvien") String tenGiangVien,
                       @Param("nienkhoa") String nienKhoa,
                       @Param("nhom") int nhom,
                       @Param("sosv") int soSV,
                       @Param("hocki") int hocKi,
                       @Param("makhoa") String maKhoa);

    @Query(value = "{call SP_GET_MA_LTC_MOI_THEM(:tenmh, :nienkhoa, :nhom, :hocki)}", nativeQuery = true)
    public Map<String, ?> getMaLopTC(@Param("tenmh") String tenMH,
                                     @Param("nienkhoa") String nienKhoa,
                                     @Param("nhom") int nhom,
                                     @Param("hocki") int hocKi);

    @Query(value = "{call SP_UPDATE_LTC(:maltc, :tenmh, :tenlop, :tengiangvien, :nienkhoa, :nhom, :sosv, :hocki, :huylop)}", nativeQuery = true)
    public int updateLTC(@Param("maltc") int maLTC,
                         @Param("tenmh") String tenMH,
                         @Param("tenlop") String tenLop,
                         @Param("tengiangvien") String tenGiangVien,
                         @Param("nienkhoa") String nienKhoa,
                         @Param("nhom") int nhom,
                         @Param("sosv") int soSV,
                         @Param("hocki") int hocKi,
                         @Param("huylop") int huyLop);

    @Query(value = "{call SP_DELETE_LTC(:maltc)}", nativeQuery = true)
    public int xoaLTC(@Param("maltc") int maltc);
}
