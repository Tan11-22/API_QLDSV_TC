package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.GiangVien;
import ptithcm.API_QLDSV_TC.Repository.GiangVienRepository;

import java.util.List;
import java.util.Map;

@Service
public class GiangVienService {
    @Autowired
    GiangVienRepository giangVienRepository;

    public Map<String, ?> thongTinCaNhanGiangVien(String magv){
        return giangVienRepository.thongTinCaNhanGiangVien(magv);
    }
}
