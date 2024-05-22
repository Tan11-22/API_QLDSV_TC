package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.DTO.MonHocDTO;
import ptithcm.API_QLDSV_TC.Model.MonHoc;
import ptithcm.API_QLDSV_TC.Repository.MonHocRepository;

import java.util.List;
import java.util.Map;

@Service
public class MonHocService {
    @Autowired
    private MonHocRepository monHocRepository;

    public List<MonHoc> danhSachTatCaMonHoc() {
        return monHocRepository.findAll();
    }

    public int themMonHoc(MonHoc monHoc) {
        if (monHocRepository.findById(monHoc.getMamh()).isPresent()) {
            return 0; // mon hoc da ton tai trong db
        } else {
            monHocRepository.save(monHoc);
            return 1;
        }
    }

    public MonHoc monHocTheoMa(String maMh) {
        return monHocRepository.findBymamh(maMh);
    }

    public Map<String, ?> soTCMonHoc(String tenMH) {
        return monHocRepository.soTCMonHoc(tenMH);
    }

    public int themMonHocMoi(MonHoc monHocDTO) {
        System.out.println(monHocDTO.toString());
        try {
            monHocRepository.themMonHoc(
                    monHocDTO.getMamh(),
                    monHocDTO.getTenmh(),
                    monHocDTO.getSotietLt(),
                    monHocDTO.getSotietTh(),
                    monHocDTO.getSotinchi());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }

    public int updateMonHoc(MonHoc monHocDTO) {
        System.out.println(monHocDTO.toString());
        try {
            monHocRepository.updateMonHoc(
                    monHocDTO.getMamh(),
                    monHocDTO.getTenmh(),
                    monHocDTO.getSotietLt(),
                    monHocDTO.getSotietTh(),
                    monHocDTO.getSotinchi());
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }

    public int xoaMonHoc(String mamh) {

        try {
            monHocRepository.xoaMonHoc(mamh);
        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException.getMessage());
            return 0;
        }
        return 1;
    }
}
