package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.API_QLDSV_TC.Model.CTDongHocPhi;
import ptithcm.API_QLDSV_TC.Model.CTDongHocPhiId;
import java.util.List;


public interface CTDongHocPhiRepository extends JpaRepository<CTDongHocPhi, CTDongHocPhiId>{
    CTDongHocPhi findByid(CTDongHocPhiId id);
}
