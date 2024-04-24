package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Repository.NganhRepository;

import java.util.List;
import java.util.Map;

@Service
public class NganhService {
    @Autowired
    NganhRepository nganhRepository;

    public List<Map<String, Object>> findDanhSachNganh() {
        return nganhRepository.findDanhSachNganh();
    }
}
