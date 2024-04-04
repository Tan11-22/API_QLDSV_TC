package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.API_QLDSV_TC.Model.MonHoc;

public interface MonHocRepository extends JpaRepository<MonHoc, String> {
    MonHoc findBymamh(String maMh);
}