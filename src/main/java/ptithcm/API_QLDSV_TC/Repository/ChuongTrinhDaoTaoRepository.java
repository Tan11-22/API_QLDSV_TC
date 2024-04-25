package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ptithcm.API_QLDSV_TC.Model.ChuongTrinhDaoTao;

import java.util.List;
import java.util.Map;

public interface ChuongTrinhDaoTaoRepository extends JpaRepository<ChuongTrinhDaoTao,Integer> {

    @Query(value = "{call SP_FIND_CTDT(:malop, :nienkhoa)}", nativeQuery = true)
    List<Map<String,Object>> findCTDT(@Param("malop") String malop,
                                      @Param("nienkhoa") String nienkhoa);
}
