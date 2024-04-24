package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.Khoa;
import ptithcm.API_QLDSV_TC.Repository.KhoaRepository;
@Service
public class KhoaService {
    @Autowired
    KhoaRepository khoaRepository;

    public Khoa khoaTheoMa(String maKhoa){
        return khoaRepository.findBymakhoa(maKhoa);
    }
}
