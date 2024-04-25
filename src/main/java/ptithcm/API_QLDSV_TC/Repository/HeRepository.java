package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.API_QLDSV_TC.Model.He;

public interface HeRepository extends JpaRepository<He, Integer> {
    public He findByid(int id);
    public He findBytenHe(String tenhe);
}
