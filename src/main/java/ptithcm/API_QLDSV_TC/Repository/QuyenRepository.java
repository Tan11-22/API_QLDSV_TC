package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ptithcm.API_QLDSV_TC.Model.Quyen;

import java.util.List;
import java.util.Map;

public interface QuyenRepository extends JpaRepository<Quyen, Integer> {
    @Query(value = "SELECT * FROM QUYEN", nativeQuery = true)
    List<Map<String,Object>> getDanhSachQuyen();
}