package ptithcm.API_QLDSV_TC.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.API_QLDSV_TC.Model.Nganh;
import ptithcm.API_QLDSV_TC.Repository.NganhRepository;
@Service
public class NganhService {
    
    @Autowired
    NganhRepository nganhRepository;

    public List<Nganh> danhSachNganh(){
        return nganhRepository.findAll();
    }

    public Nganh nganhTheoId(int id){
        return nganhRepository.findByid(id);
    }
}
