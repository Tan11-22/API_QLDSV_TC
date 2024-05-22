package ptithcm.API_QLDSV_TC.Service;

import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.DanhSachHocPhiLop;
import ptithcm.API_QLDSV_TC.Repository.DanhSachHocPhiLopRepository;


import java.util.List;

@Service
public class DanhSachHocPhiLopService {

    @Autowired
    private DanhSachHocPhiLopRepository danhSachHocPhiLopRepository;


    public List<DanhSachHocPhiLop> DsHocPhiTheoLop (String lop, String nienkhoa, Integer hocky){
        return danhSachHocPhiLopRepository.getDanhSachHocPhiLopsByLop(lop,nienkhoa,hocky);
    }

    public List<String> getNienKhoa(){
        return danhSachHocPhiLopRepository.getNienKhoa();
    }
}