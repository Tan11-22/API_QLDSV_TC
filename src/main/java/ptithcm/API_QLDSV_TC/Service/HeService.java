package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
