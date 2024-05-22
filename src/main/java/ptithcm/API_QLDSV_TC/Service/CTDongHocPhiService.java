package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.API_QLDSV_TC.Model.CTDongHocPhi;
import ptithcm.API_QLDSV_TC.Repository.CTDongHocPhiRepository;

@Service
public class CTDongHocPhiService {
    @Autowired
    private CTDongHocPhiRepository ctDongHocPhiRepository;

    public String dongHocPhi(CTDongHocPhi ctDongHocPhi){
        if (ctDongHocPhi == null){
            System.out.println("Lỗi: Không nhận được dữ liệu");
            return "Lỗi: Không nhận được dữ liệu";
        }
        try{
            if(ctDongHocPhiRepository.existsById(ctDongHocPhi.getId())){
                ctDongHocPhi.setSotiendong(ctDongHocPhi.getSotiendong()+ctDongHocPhiRepository.findByid(ctDongHocPhi.getId()).getSotiendong());
            }
            ctDongHocPhiRepository.save(ctDongHocPhi);
            return "1";
        }
        catch(Exception e){
            System.out.println("Lỗi: "+ e);
            return "Lỗi: "+ e;
        }
    }

}
