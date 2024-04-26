package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.API_QLDSV_TC.Repository.ChuongTrinhDaoTaoRepository;

import java.util.List;
import java.util.Map;
@Service
public class ChuongTrinhDaoTaoService {
    @Autowired
    ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository;

    public List<Map<String,Object>> findCTDT(String maLop, String nienKhoa) {
        return chuongTrinhDaoTaoRepository.findCTDT(maLop,nienKhoa);
    }
}
