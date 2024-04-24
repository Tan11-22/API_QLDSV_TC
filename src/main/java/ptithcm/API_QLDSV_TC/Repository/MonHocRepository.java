package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import ptithcm.API_QLDSV_TC.Model.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, String> {
    MonHoc findBymamh(String maMh);
    @Procedure(procedureName = "SP_THEM_MON_HOC")
    void themMonHoc(
            @Param("mamh") String mamh,
            @Param("tenmh") String tenmh,
            @Param("sotietlt") int sotietlt,
            @Param("sotietth") int sotietth,
            @Param("sotinchi") int sotinchi
    );
    @Procedure(procedureName = "SP_UPDATE_MON_HOC")
    void updateMonHoc(
            @Param("mamh") String mamh,
            @Param("tenmh") String tenmh,
            @Param("sotietlt") int sotietlt,
            @Param("sotietth") int sotietth,
            @Param("sotinchi") int sotinchi
    );
    @Procedure(procedureName = "SP_DELETE_MON_HOC")
    void xoaMonHoc(
            @Param("mamh") String mamh
    );
}