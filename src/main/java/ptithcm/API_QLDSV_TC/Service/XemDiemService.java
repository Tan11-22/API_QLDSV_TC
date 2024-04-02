package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Repository.XemDiemRepository;

import java.util.List;
import java.util.Map;

@Service
public class XemDiemService {
    @Autowired
    private XemDiemRepository xemDiemRepository;

    public List<String> danhSachNamHoc(String maSV){
        return xemDiemRepository.danhSachNamHoc(maSV);
    }

    public List<String> danhSachHocKi(String maSV, String nienKhoa){
        return xemDiemRepository.danhSachHocKi(maSV, nienKhoa);
    }

    public List<Map<String, ?>> danhSachDiemHocKi(String maSV, String nienKhoa, int hocKi){
        return xemDiemRepository.danhSachDiemHK(maSV, nienKhoa, hocKi);
    }
}
