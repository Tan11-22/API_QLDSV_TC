package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.Khoa;
import ptithcm.API_QLDSV_TC.Repository.KhoaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class KhoaService {
    @Autowired
    KhoaRepository khoaRepository;

    public Khoa khoaTheoMa(String maKhoa){
        return khoaRepository.findBymakhoa(maKhoa);
    }

    public List<Map<String, Object>> findDanhSachKhoa() {
        return khoaRepository.findDanhSachKhoa();
    }

    public boolean taoKhoaMoi(String maKhoa, String tenKhoa, int idNganh) {
        Optional<Khoa> khoa = khoaRepository.findById(maKhoa);
        if (khoa.isEmpty()) {
            khoaRepository.taoThemKhoaMoi(maKhoa, tenKhoa, idNganh);
            return true;
        }
        return false;
    }

    public void thayDoiKhoa(String maKhoa, String tenKhoa, int idNganh) {
        khoaRepository.thayDoiKhoa(maKhoa,tenKhoa,idNganh);
    }

    public boolean deleteKhoa(String maKhoa) {
        return khoaRepository.deleteKhoa(maKhoa);
    }
}
