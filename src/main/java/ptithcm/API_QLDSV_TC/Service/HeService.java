package ptithcm.API_QLDSV_TC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ptithcm.API_QLDSV_TC.DTO.HeDTO;
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

    public int capNhathe(He he){
        try{
            heRepository.save(he);
            return 1;
        }catch (DataIntegrityViolationException e){
            return 0;
        }
    }

    public int themMoiHe(He he){
        try{
            heRepository.save(he);
            return 1;
        }catch (DataIntegrityViolationException e){
            return 0;
        }
    }

    public int xoaHe(int id){
        He he = heRepository.findByid(id);
        try{
            heRepository.delete(he);
            return 1;
        } catch (DataIntegrityViolationException e){
            return 0;
        }
    }

    public He heTheoTen(String tenHe){
        return heRepository.findBytenHe(tenHe);
    }
}
