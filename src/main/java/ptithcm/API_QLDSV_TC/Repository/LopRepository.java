package ptithcm.API_QLDSV_TC.Repository;
import ptithcm.API_QLDSV_TC.Model.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LopRepository extends JpaRepository<Lop, String>{
    Lop findBymalop(String maLop);
}
