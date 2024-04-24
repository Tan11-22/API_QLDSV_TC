package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ptithcm.API_QLDSV_TC.Model.MonHoc;

import java.util.List;
import java.util.Map;

public interface MonHocRepository extends JpaRepository<MonHoc, String> {
    MonHoc findBymamh(String maMh);

    @Query(value = "{call SP_GET_STC_MON_HOC(:tenmh)}", nativeQuery = true)
    public Map<String, ?> soTCMonHoc(@Param("tenmh") String tenMH);
}