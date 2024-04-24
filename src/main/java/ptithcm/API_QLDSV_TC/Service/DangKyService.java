package ptithcm.API_QLDSV_TC.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.API_QLDSV_TC.Model.DangKy;
import ptithcm.API_QLDSV_TC.Model.DangKyId;
import ptithcm.API_QLDSV_TC.Repository.DangKyRepository;

@Service
public class DangKyService {
    @Autowired
    DangKyRepository dangKyRepository;
    public String dangKy(String maSV, Integer maLTC){
        DangKyId dangKyId=new DangKyId();
        DangKy dangKy =new DangKy();
        dangKyId.setMaltc(maLTC);
        dangKyId.setMasv(maSV);
        dangKy.setId(dangKyId);
        try{
            dangKyRepository.save(dangKy);
            return "1";
        }
        catch(Exception e){
            System.out.println("Lỗi: "+ e);
            return "Lỗi: "+ e;
        }
    }
    public String boDangKy(String maSV, Integer maLTC){
        try{
            DangKyId dangKyId=new DangKyId();
            dangKyId.setMaltc(maLTC);
            dangKyId.setMasv(maSV);
            DangKy dangKy = new DangKy();
            dangKy.setId(dangKyId);
            dangKyRepository.delete(dangKy);
            return "1";
        }
        catch(Exception e){
            System.out.println("Lỗi: "+ e);
            return "Lỗi: "+ e;
        }
    }
    // public List<DangKy> getDS(){
    //     return dangKyRepository.findAll();
    // }
    // public List<DangKy> getDS2(String maSV){
    //     return dangKyRepository.findById_Masv(maSV);
    // }
}
