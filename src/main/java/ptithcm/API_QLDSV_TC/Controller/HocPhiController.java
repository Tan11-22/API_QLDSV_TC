package ptithcm.API_QLDSV_TC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ptithcm.API_QLDSV_TC.Model.HocPhi;
import ptithcm.API_QLDSV_TC.Model.HocPhiHocKy;
import ptithcm.API_QLDSV_TC.Model.HocPhiKeToan;
import ptithcm.API_QLDSV_TC.Model.HocPhiSinhVien;
import ptithcm.API_QLDSV_TC.Model.MonHoc;
import ptithcm.API_QLDSV_TC.Service.MonHocService;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/hoc-phi")
public class HocPhiController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCallFunction;
    
    //Row Mapper để đổ dữ liệu vào đối tượng khi load SP

    public class HocPhiRowMapper implements RowMapper<HocPhiHocKy>{
        public HocPhiHocKy mapRow(ResultSet rs, int rowNum) throws SQLException{
            HocPhiHocKy row = new HocPhiHocKy();
            row.setMaMH(rs.getString("MAMH"));
            row.setTenMH(rs.getString("TENMH"));
            row.setSoTC(rs.getInt("SOTINCHI"));
            row.setHocLai(rs.getInt("HOCLAI"));
            row.setTien(rs.getInt("TIEN"));
            return row;
        }
    }

    public class HocPhiSinhVienRowMapper implements RowMapper<HocPhiSinhVien>{
        public HocPhiSinhVien mapRow(ResultSet rs, int rowNum) throws SQLException{
            HocPhiSinhVien row = new HocPhiSinhVien();
            row.setNienKhoa(rs.getString("NIENKHOA"));
            row.setHocKy(rs.getInt("HOCKY"));
            row.setHocPhi(rs.getInt("HOCPHI"));
            row.setDaDong(rs.getInt("DADONG"));
            row.setNo(rs.getInt("NO"));
            return row;
        }
    }

    public class HocPhiKeToanRowMapper implements RowMapper<HocPhiKeToan>{
        public HocPhiKeToan mapRow(ResultSet rs, int rowNum) throws SQLException{
            HocPhiKeToan row = new HocPhiKeToan();
            row.setMaLop(rs.getString("MALOP"));
            row.setMaSV(rs.getString("MASV"));
            row.setHoTen(rs.getString("HOTEN"));
            row.setNienKhoa(rs.getString("NIENKHOA"));
            row.setHocKy(rs.getInt("HOCKY"));
            row.setHocPhi(rs.getInt("HOCPHI"));
            row.setNgayDong(rs.getDate("NGAYDONG").toLocalDate());
            row.setSoTienDong(rs.getInt("SOTIENDONG"));
            return row;
        }
    }

    // public void init(){
    //     jdbcTemplate.setResultsMapCaseInsensitive(true);
    // }
    public List<HocPhiHocKy> getHocPhiHocKy(String maSV, String nienKhoa, int hocKy) {
        // init();
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_HOC_PHI_HOC_KY").returningResultSet("result", new HocPhiRowMapper());

        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("MASV", maSV);//"N15DCCN001"
        inParamMap.put("NIENKHOA", nienKhoa);//"2023-2024"
        inParamMap.put("HOCKY", hocKy);//1
        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
        System.out.println(simpleJdbcCallResult);
        @SuppressWarnings("unchecked")
        List<HocPhiHocKy> hocPhiList=(List<HocPhiHocKy>)simpleJdbcCallResult.get("result");
        for (HocPhiHocKy item: hocPhiList){
            System.out.println(item.getTenMH());
        }
        return hocPhiList;
    }

    public List<HocPhiSinhVien> getHocPhiSinhVien(String maSV) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_HOC_PHI_SV").returningResultSet("result", new HocPhiSinhVienRowMapper());

        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("MASV", maSV);//"N15DCCN001"
        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
        System.out.println(simpleJdbcCallResult);
        @SuppressWarnings("unchecked")
        List<HocPhiSinhVien> hocPhiList=(List<HocPhiSinhVien>)simpleJdbcCallResult.get("result");
        return hocPhiList;
    }

    public List<HocPhiKeToan> getHocPhiKeToan() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_HOC_PHI_KE_TOAN").returningResultSet("result", new HocPhiKeToanRowMapper());

        Map<String, Object> inParamMap = new HashMap<String, Object>();
        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
        System.out.println(simpleJdbcCallResult);
        @SuppressWarnings("unchecked")
        List<HocPhiKeToan> hocPhiList=(List<HocPhiKeToan>)simpleJdbcCallResult.get("result");
        return hocPhiList;
    }
    
    @RequestMapping(value = "hoc-ky", method = RequestMethod.GET)
    public ResponseEntity<List<HocPhiHocKy>> loadHocPhiHocKySV(
        @RequestParam("maSV")String maSV,
        @RequestParam("nienKhoa")String nienKhoa,
        @RequestParam("hocKy")int hocKy){
        List<HocPhiHocKy> hocPhiHocKy = getHocPhiHocKy(maSV,nienKhoa,hocKy);
        if(hocPhiHocKy == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT); // trả về mã lỗi 204
        }
        return new ResponseEntity<>(hocPhiHocKy, HttpStatus.OK);
    }
    @RequestMapping(value = "sinh-vien", method=RequestMethod.GET)
    public ResponseEntity<List<HocPhiSinhVien>> loadHocPhiSV(
        @RequestParam("maSV")String maSV){
        List<HocPhiSinhVien> hocPhiSinhVien = getHocPhiSinhVien(maSV);
        if(hocPhiSinhVien == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT); // trả về mã lỗi 204
        }
        return new ResponseEntity<>(hocPhiSinhVien, HttpStatus.OK);
    }
    @RequestMapping(value = "ke-toan", method=RequestMethod.GET)
    public ResponseEntity<List<HocPhiKeToan>> loadHocPhiKT(){
        List<HocPhiKeToan> hocPhiKeToan = getHocPhiKeToan();
        if(hocPhiKeToan == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT); // trả về mã lỗi 204
        }
        return new ResponseEntity<>(hocPhiKeToan, HttpStatus.OK);
    }
    
}
