package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ptithcm.API_QLDSV_TC.DTO.SinhVienDTO;
import ptithcm.API_QLDSV_TC.Model.SinhVien;

import java.util.List;
import java.util.Map;

public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
    SinhVien findBymasv(String maSV);
    List<SinhVien> findAll();
    @Procedure(procedureName = "SP_THEM_SV_LOP")
    void themSinhVienMoi(
            @Param("masv") String masv,
            @Param("ho") String ho,
            @Param("ten") String ten,
            @Param("ngaysinh") String ngaysinh,
            @Param("phai") Boolean phai,
            @Param("sdt") String sdt,
            @Param("diachi") String diachi,
            @Param("malop") String malop,
            @Param("danghihoc") Boolean danghihoc,
            @Param("hinhanh") String hinhanh,
            @Param("email") String email,
            @Param("password") String password
    );
    @Procedure (procedureName = "SP_DELETE_SV")
    void xoaSinhVien(
            @Param("masv") String masv
    );
    @Query(value = "EXEC SP_LOC_MA_LOP", nativeQuery = true)
    List<String> locMaLop();
    @Procedure (procedureName = "SP_UPDATE_INFO_SV")
    void updateSinhVien(
            @Param("masv") String masv,
            @Param("ho") String ho,
            @Param("ten") String ten,
            @Param("ngaysinh") String ngaysinh,
            @Param("phai") Boolean phai,
            @Param("sdt") String sdt,
            @Param("diachi") String diachi,
            @Param("malop") String malop,
            @Param("danghihoc") Boolean danghihoc,
            @Param("hinhanh") String hinhanh,
            @Param("email") String email
    );


    @Query(value = "EXEC SP_LOC_DANH_SACH_LOP :malop", nativeQuery = true)
    List<SinhVien> danhSachSinhVien(@Param("malop") String malop);
    @Procedure (procedureName = "SP_DA_NGHI_HOC")
    void updateDaNghiHoc(
            @Param("masv") String masv

    );


    @Procedure (procedureName = "SP_DOI_MAT_KHAU")
    void doiMatKhau(
            @Param("username") String username,
            @Param("password") String password
    );
    @Query(value = "EXEC SP_TIM_SINH_VIEN :masv", nativeQuery = true)
    SinhVienDTO timSinhVien(@Param("masv") String masv);

    @Query(value = "EXEC SP_TAI_KHOAN_BY_EMAIL :Email", nativeQuery = true)
    public Map<String, Object> taiKhoanByEMail(@Param("Email") String Email);

}
