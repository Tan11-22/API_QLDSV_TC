package ptithcm.API_QLDSV_TC.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ptithcm.API_QLDSV_TC.Model.Nganh;

import java.util.List;
import java.util.Map;

public interface NganhRepository extends JpaRepository<Nganh, Integer> {
    @Query(value = "{call SP_FIND_LIST_NGANH()}", nativeQuery = true)
    List<Map<String,Object>> findDanhSachNganh();
}
