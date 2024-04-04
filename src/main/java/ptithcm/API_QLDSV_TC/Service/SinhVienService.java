package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.SinhVien;
import ptithcm.API_QLDSV_TC.Repository.SinhVienRepository;

@Service
public class SinhVienService {
    @Autowired
    SinhVienRepository sinhVienRepository;

    public SinhVien sinhVienTheoMa(String maSV){
        return sinhVienRepository.findBymasv(maSV);
    }
}
