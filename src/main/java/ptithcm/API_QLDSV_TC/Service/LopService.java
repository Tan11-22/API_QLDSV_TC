package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.Lop;
import ptithcm.API_QLDSV_TC.Repository.LopRepository;

import java.util.List;

@Service
public class LopService  {

    @Autowired
    private LopRepository lopRepository;

    public List<Lop> getAllLop(){
        return lopRepository.findAll();
    }

}
