package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ptithcm.API_QLDSV_TC.Model.Khoa;

import java.util.List;
import java.util.Map;

public interface KhoaRepository extends JpaRepository<Khoa, String> {
    public Khoa findBymakhoa(String makhoa);

    @Query(value = "{call SP_FIND_LIST_MA_KHOA()}", nativeQuery = true)
    List<Map<String,Object>> findDanhSachKhoa();

    @Procedure(procedureName = "SP_CREATE_KHOA")
    void taoThemKhoaMoi(
            @Param("makhoa") String makhoa,
            @Param("tenkhoa") String tenkhoa,
            @Param("idnganh") int idnganh
    );

    @Procedure(procedureName = "SP_UPDATE_KHOA")
    void thayDoiKhoa(
            @Param("makhoa") String makhoa,
            @Param("tenkhoa") String tenkhoa,
            @Param("idnganh") int idnganh
    );

    @Query(value = "{call SP_DELETE_KHOA(:makhoa)}", nativeQuery = true)
    boolean deleteKhoa(@Param("makhoa") String maKhoa);
}
