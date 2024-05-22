package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.Nganh;
import ptithcm.API_QLDSV_TC.Repository.NganhRepository;

import java.util.List;
import java.util.Map;

@Service
public class NganhService {
    @Autowired
    NganhRepository nganhRepository;

    public List<Nganh> danhSachNganh(){
        return nganhRepository.findAll();
    };

    public int capNhatNganh(Nganh nganh){
        try{
            nganhRepository.save(nganh);
            return 1;
        } catch (DataIntegrityViolationException e){
            return 0;
        }
    }

    public int themNganh(Nganh nganh){
        try{
            nganhRepository.save(nganh);
            return 1;
        } catch (DataIntegrityViolationException e){
            return 0;
        }
    }

    public int xoaNganh(int id){
        try{
            Nganh nganh = nganhRepository.findByid(id);
            nganhRepository.delete(nganh);
            return 1;
        } catch (DataIntegrityViolationException e){
            return 0;
        }
    }

    public Nganh nganhTheoTen(String ten){
        return nganhRepository.findByten(ten);
    }
    public List<Map<String, Object>> findDanhSachNganh() {
        return nganhRepository.findDanhSachNganh();
    }

    
        public Nganh nganhTheoId(int id){
            return nganhRepository.findByid(id);}

}
