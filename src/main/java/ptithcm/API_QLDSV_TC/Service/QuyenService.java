package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Model.Quyen;
import ptithcm.API_QLDSV_TC.Repository.QuyenRepository;

import java.util.List;
import java.util.Map;

@Service
public class QuyenService {
    @Autowired
    QuyenRepository quyenRepository;

    public Quyen getQuyenById(Integer id) {
        return quyenRepository.findById(id).get();
    }

    public List<Map<String,Object>> getAllQuyen(){
        return quyenRepository.getDanhSachQuyen();
    }
}
