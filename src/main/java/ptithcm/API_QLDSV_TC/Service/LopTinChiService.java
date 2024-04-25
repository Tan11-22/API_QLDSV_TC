package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ptithcm.API_QLDSV_TC.DTO.LopTinChiDTO;
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

    public List<Map<String, ?>> danhSachLTC(String maKhoa){
        return lopTinChiRepository.danhSachLTC(maKhoa);
    }

    public List<String> danhSachDkLoc(int loai, String maKhoa){
        return lopTinChiRepository.danhSachDKLoc(loai, maKhoa);
    }

    public List<String> danhSachLocThemLTC(int loai, String maKhoa){
        return lopTinChiRepository.danhSachLocThemLTC(loai, maKhoa);
    }

    public int themLTC(String tenMH, String tenLop, String tenGiangVien, String nienKhoa, int nhom, int soSV, int hocKi, String maKhoa){
        return lopTinChiRepository.themLTC(tenMH, tenLop, tenGiangVien, nienKhoa, nhom, soSV, hocKi, maKhoa);
    }

    public int updateLTC(int maLTC, String tenMH, String tenLop, String tenGiangVien, String nienKhoa, int nhom, int soSV, int hocKi, int huyLop){
        return lopTinChiRepository.updateLTC(maLTC, tenMH, tenLop, tenGiangVien, nienKhoa, nhom, soSV, hocKi, huyLop);
    }

    public int xoaLTC(int maLTC){
        return lopTinChiRepository.xoaLTC(maLTC);
    }

    public Map<String, ?> getMaLopTC(String tenMH, String nienKhoa, int nhom, int hocKi){
        return lopTinChiRepository.getMaLopTC(tenMH, nienKhoa, nhom, hocKi);
    }
}
