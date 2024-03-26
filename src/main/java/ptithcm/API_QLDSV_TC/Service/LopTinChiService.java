package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.GiangVien;
import ptithcm.API_QLDSV_TC.Model.LopTinChi;
import ptithcm.API_QLDSV_TC.Repository.GiangVienRepository;
import ptithcm.API_QLDSV_TC.Repository.LopTinChiRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LopTinChiService {
    @Autowired
    LopTinChiRepository lopTinChiRepository;

    public List<Map<String, ?>> danhSachLTCTheoMaGV(String maGV){
        return lopTinChiRepository.danhSachLTCTheoMaGV(maGV);
    }

    public List<Map<String, ?>> danhSachSinhVienLTC(int maLTC){
        return lopTinChiRepository.danhSachSinhVienLTC(maLTC);
    }

    public Map<String, ?> diemSinhVienLTC(String maSV, int maLTC){
        return lopTinChiRepository.diemSinhVienLTC(maSV, maLTC);
    }
    public int capNhatDiemSvLTC(int maLTC, String maSV, int diemCC, float diemGK, float diemCK){
        return lopTinChiRepository.capNhatDiemSinhVienLTC(maLTC, maSV, diemCC, diemGK, diemCK);
    }
}
