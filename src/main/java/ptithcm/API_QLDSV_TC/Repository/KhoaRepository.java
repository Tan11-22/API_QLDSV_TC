package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.API_QLDSV_TC.Model.Khoa;

public interface KhoaRepository extends JpaRepository<Khoa, String> {
    public Khoa findBymakhoa(String makhoa);
}
