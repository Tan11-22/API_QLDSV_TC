package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.API_QLDSV_TC.Repository.HocPhiRepository;

@Service
public class HocPhiService {
    @Autowired
    HocPhiRepository hocPhiRepository;
    public String apHocPhi(String maSV, String nienKhoa, int hocKy){
        try{
            hocPhiRepository.SP_AP_HOC_PHI(maSV, nienKhoa, hocKy);
            return "1";
        }
        catch(Exception e){
            System.out.println(e.getMessage().toString());
            return e.getMessage().toString();
        }
    }
}
