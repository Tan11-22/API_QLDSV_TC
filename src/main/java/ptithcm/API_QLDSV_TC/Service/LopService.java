package ptithcm.API_QLDSV_TC.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.DTO.LopDTO;
import ptithcm.API_QLDSV_TC.Model.Lop;
import ptithcm.API_QLDSV_TC.Repository.LopRepository;

import java.util.List;
import java.util.Map;

@Service
public class LopService {
    @Autowired
    LopRepository lopRepository;

    public List<Map<String, ?>> danhSachLopCuaKhoa(String maGv, int trangThai){
        return lopRepository.danhSachLopCuaKhoa(maGv, trangThai);
    }

    public int addLop(Lop lop){
        int result = 0;
        if(lopRepository.findBymalop(lop.getMalop()) == null){
            if(lopRepository.save(lop) != null) result = 1;
        }
        return result;
    }

    public int updateLop(LopDTO lopDTO){
        return lopRepository.updateLop(lopDTO.getMaLop(), lopDTO.getTenLop(), lopDTO.getKhoaHoc(), lopDTO.isTrangThai() ? 1 : 0, lopDTO.getIdHe());
    }

    @Transactional
    public int xoaLop(String maLop){
        if(lopRepository.findBymalop(maLop) != null){
            lopRepository.deleteBymalop(maLop);
            return 1;
        } else {
            return 0;
        }
    }
}
