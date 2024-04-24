package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ptithcm.API_QLDSV_TC.Model.TaiKhoan;

import java.util.List;
import java.util.Map;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan,String> {

    @Procedure(procedureName = "SP_CREATE_LOGIN_SV")
    void taoTaiKhoanSinhVien(
            @Param("username") String username,
            @Param("password") String password,
            @Param("id_quyen") int id_quyen,
            @Param("ho") String ho,
            @Param("ten") String ten,
            @Param("phai") boolean phai,
            @Param("malop") String malop,
            @Param("danghihoc") boolean danghihoc,
            @Param("sdt") String sdt,
            @Param("email") String email
    );
    @Procedure(procedureName = "SP_CREATE_LOGIN_GV")
    void taoTaiKhoanGiangVien(
            @Param("username") String username,
            @Param("password") String password,
            @Param("id_quyen") int id_quyen,
            @Param("ho") String ho,
            @Param("ten") String ten,
            @Param("makhoa") String maKhoa,
            @Param("sdt") String sdt,
            @Param("email") String email
    );

    @Query(value = "{call SP_FIND_LIST_TK_GV()}", nativeQuery = true)
    List<Map<String,Object>> findDanhSachTK();
}
