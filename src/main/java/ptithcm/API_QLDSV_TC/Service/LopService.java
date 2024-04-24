package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.API_QLDSV_TC.Model.Lop;
import ptithcm.API_QLDSV_TC.Repository.LopRepository;

@Service
public class LopService {
    @Autowired
    LopRepository lopRepository;
    public Lop lopTheoMaLop(String maLop){
        if(maLop==null){
            return null;
        }
        return lopRepository.findBymalop(maLop);
    }
}
