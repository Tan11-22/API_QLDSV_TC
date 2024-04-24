package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.API_QLDSV_TC.DTO.HeDTO;
import ptithcm.API_QLDSV_TC.Model.He;
import ptithcm.API_QLDSV_TC.Repository.HeRepository;

import java.util.List;

@Service

public class HeService {
    @Autowired
    HeRepository heRepository;

    public List<He> danhSachHeDaoTao(){
        return heRepository.findAll();
    }

    public He heTheoId(int id){
        return heRepository.findByid(id);
    }

    // public int themHe(HeDTO heDTO) {
    //     try {
    //         heRepository.themHe(
    //             heDTO.getId(),heDTO.getTenHe()
    //         );
    //     } catch (DataAccessException dataAccessException) {
    //         System.out.println(dataAccessException.getMessage());
    //         return 0;
    //     }
    //     return 1;
    // }

    // public int updateMonHoc(MonHocDTO monHocDTO) {
    //     System.out.println(monHocDTO.toString());
    //     try {
    //         monHocRepository.updateMonHoc(
    //                 monHocDTO.getMamh(),
    //                 monHocDTO.getTenmh(),
    //                 monHocDTO.getSotietLt(),
    //                 monHocDTO.getSotietTh(),
    //                 monHocDTO.getSotinchi()
    //         );
    //     } catch (DataAccessException dataAccessException) {
    //         System.out.println(dataAccessException.getMessage());
    //         return 0;
    //     }
    //     return 1;
    // }
    // public int xoaMonHoc(String mamh) {

    //     try {
    //         monHocRepository.xoaMonHoc(mamh);
    //     } catch (DataAccessException dataAccessException) {
    //         System.out.println(dataAccessException.getMessage());
    //         return 0;
    //     }
    //     return 1;
    // }
}
