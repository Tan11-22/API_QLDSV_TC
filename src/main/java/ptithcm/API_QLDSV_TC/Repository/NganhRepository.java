package ptithcm.API_QLDSV_TC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ptithcm.API_QLDSV_TC.Model.Nganh;

public interface NganhRepository extends JpaRepository<Nganh, Integer> {
    public Nganh findByid(int id);

    public Nganh findByten(String tenNganh);
}
