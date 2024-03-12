package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.MonHoc;
import ptithcm.API_QLDSV_TC.Repository.MonHocRepository;

import java.util.List;
@Service
public class MonHocService {
    @Autowired
    private MonHocRepository monHocRepository;

    public List<MonHoc> danhSachTatCaMonHoc(){
        return monHocRepository.findAll();
    }

    public int themMonHoc(MonHoc monHoc){
        if(monHocRepository.findById(monHoc.getMamh()).isPresent()){
            return 0; // mon hoc da ton tai trong db
        } else {
            monHocRepository.save(monHoc);
            return 1;
        }
    }

    public MonHoc monHocTheoMa(String maMh){
        return monHocRepository.findBymamh(maMh);
    }
}
