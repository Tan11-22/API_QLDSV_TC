package ptithcm.API_QLDSV_TC.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ptithcm.API_QLDSV_TC.Model.DDKLTC;
import ptithcm.API_QLDSV_TC.Model.DKLTCLopSV;
import ptithcm.API_QLDSV_TC.Model.DangKy;
import ptithcm.API_QLDSV_TC.Model.LopTinChi;
import ptithcm.API_QLDSV_TC.Service.DangKyService;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ptithcm.API_QLDSV_TC.DTO.DiemDTO;
import ptithcm.API_QLDSV_TC.Service.LopTinChiService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lop-tin-chi")
public class LopTinChiController {
    @Autowired
    DangKyService dangKyService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    LopTinChiService lopTinChiService;

    private SimpleJdbcCall simpleJdbcCallFunction;
    
    public class DKLTCLOPRowMapper implements RowMapper<DKLTCLopSV>{
        public DKLTCLopSV mapRow(ResultSet rs, int rowNum) throws SQLException{
            DKLTCLopSV row = new DKLTCLopSV();
            row.setMaMH(rs.getString("MAMH"));
            row.setNhom(rs.getInt("NHOM"));
            row.setTenMH(rs.getString("TENMH"));
            row.setSoSVToiThieu(rs.getInt("SOSVTOITHIEU"));
            row.setSoTinChi(rs.getInt("SOTINCHI"));
            row.setMaLTC(rs.getInt("MALTC"));
            row.setMaLop(rs.getString("MALOP"));
            return row;
        }
    }
    public List<DKLTCLopSV> getDKLTCLop(String maLop, String nienKhoa, int hocKy) {
        // init();
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DS_DKLTC_LOP").returningResultSet("result", new DKLTCLOPRowMapper());

        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("MALOP", maLop);//"D15CQCP01 "
        inParamMap.put("NIENKHOA", nienKhoa);//"2023-2024"
        inParamMap.put("HOCKY", hocKy);//1
        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
        System.out.println(simpleJdbcCallResult);
        @SuppressWarnings("unchecked")
        List<DKLTCLopSV> dKLTCLopList=(List<DKLTCLopSV>)simpleJdbcCallResult.get("result");
        return dKLTCLopList;
    }
    @RequestMapping(value = "lopsv-dang-ky", method=RequestMethod.GET)
    public ResponseEntity<List<DKLTCLopSV>> loadDSLopSVDK(
        @RequestParam("maLop")String maLop,
        @RequestParam("nienKhoa")String nienKhoa,
        @RequestParam("hocKy")int hocKy
    ){
        List<DKLTCLopSV> lopSVDKDS = getDKLTCLop(maLop,nienKhoa,hocKy);
        if(lopSVDKDS == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT); // trả về mã lỗi 204
        }
        return new ResponseEntity<>(lopSVDKDS, HttpStatus.OK);
    }

    public List<DKLTCLopSV> getDKLTC(String nienKhoa, int hocKy) {
        // init();
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DS_DKLTC_ALL").returningResultSet("result", new DKLTCLOPRowMapper());

        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("NIENKHOA", nienKhoa);//"2023-2024"
        inParamMap.put("HOCKY", hocKy);//1
        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
        System.out.println(simpleJdbcCallResult);
        @SuppressWarnings("unchecked")
        List<DKLTCLopSV> dKLTCLopList=(List<DKLTCLopSV>)simpleJdbcCallResult.get("result");
        return dKLTCLopList;
    }
    @RequestMapping(value = "ds-dang-ky", method=RequestMethod.GET)
    public ResponseEntity<List<DKLTCLopSV>> loadDSDK(
        @RequestParam("nienKhoa")String nienKhoa,
        @RequestParam("hocKy")int hocKy
    ){
        List<DKLTCLopSV> lopSVDKDS = getDKLTC(nienKhoa,hocKy);
        if(lopSVDKDS == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT); // trả về mã lỗi 204
        }
        return new ResponseEntity<>(lopSVDKDS, HttpStatus.OK);
    }
    
    public class DDKLTCRowMapper implements RowMapper<DDKLTC>{
        public DDKLTC mapRow(ResultSet rs, int rowNum) throws SQLException{
            DDKLTC row = new DDKLTC();
            row.setMaMH(rs.getString("MAMH"));
            row.setNhom(rs.getInt("NHOM"));
            row.setTenMH(rs.getString("TENMH"));
            row.setSoTinChi(rs.getInt("SOTINCHI"));
            row.setMaLTC(rs.getInt("MALTC"));
            return row;
        }
    }
    public List<DDKLTC> getDDKLTC(String maSV, String nienKhoa, int hocKy) {
        // init();
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DS_DDKLTC_LOP").returningResultSet("result", new DDKLTCRowMapper());

        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("MASV", maSV);//"N15DCCN001"
        inParamMap.put("NIENKHOA", nienKhoa);//"2023-2024"
        inParamMap.put("HOCKY", hocKy);//1
        SqlParameterSource in = new MapSqlParameterSource(inParamMap);
        Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
        System.out.println(simpleJdbcCallResult);
        @SuppressWarnings("unchecked")
        List<DDKLTC> dDKLTCList=(List<DDKLTC>)simpleJdbcCallResult.get("result");
        return dDKLTCList;
    }
    @RequestMapping(value = "da-dang-ky", method=RequestMethod.GET)
    public ResponseEntity<List<DDKLTC>> loadDSDDKLTC(
        @RequestParam("maSV")String maSV,
        @RequestParam("nienKhoa")String nienKhoa,
        @RequestParam("hocKy")int hocKy
    ){
        List<DDKLTC> dsDDKLTC = getDDKLTC(maSV,nienKhoa,hocKy);
        if(dsDDKLTC == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT); // trả về mã lỗi 204
        }
        return new ResponseEntity<>(dsDDKLTC, HttpStatus.OK);
    }


    @RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
    public ResponseEntity<Map<String,String>> dangKy(
        @RequestParam("maSV") String maSV,
        @RequestParam("maLTC") Integer maLTC
    ){
        Map<String,String> response = new HashMap<>();
        
        String ketQua = dangKyService.dangKy(maSV, maLTC);
        if (ketQua.equals("1")){
            response.put("status","1");
            response.put("message","sucessful");
        }
        else{
            response.put("status","0");
            response.put("message", ketQua);
        }
        
        return ResponseEntity.ok(response);
    }
    @RequestMapping(value = "/bo-dang-ky", method = RequestMethod.GET)
    public ResponseEntity<Map<String,String>> boDangKy(
        @RequestParam("maSV") String maSV,
        @RequestParam("maLTC") Integer maLTC
    ){
        Map<String,String> response = new HashMap<>();
        
        String ketQua = dangKyService.boDangKy(maSV, maLTC);
        if (ketQua.equals("1")){
            response.put("status","1");
            response.put("message","sucessful");
        }
        else{
            response.put("status","0");
            response.put("message", ketQua);
        }
        
        return ResponseEntity.ok(response);
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, ?>>> danhSachLTCTheoMaGV(@RequestParam("ma-gv") String maGV){
        List<Map<String, ?>> danhSachLTC = lopTinChiService.danhSachLTCTheoMaGV(maGV);
        return new ResponseEntity<>(danhSachLTC, HttpStatus.OK);
    }

    @RequestMapping(value = "/danh-sach-sinh-vien", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, ?>>> danhSachSinhVienLTC(@RequestParam("ma-ltc") int maLTC){
        List<Map<String, ?>> danhSachSinhVien = lopTinChiService.danhSachSinhVienLTC(maLTC);
        return new ResponseEntity<>(danhSachSinhVien, HttpStatus.OK);
    }
    @RequestMapping(value = "/xem-diem", method = RequestMethod.GET)
    public ResponseEntity<Map<String, ?>> diemSinhVienLTC(@RequestParam("ma-ltc") int maLTC, @RequestParam("ma-sv") String maSV){
        Map<String, ?> diem = lopTinChiService.diemSinhVienLTC(maSV, maLTC);
        return new ResponseEntity<>(diem, HttpStatus.OK);
    }
    @RequestMapping(value = "/nhap-diem", method = RequestMethod.POST)
    public ResponseEntity<?> capNhatDiemSV(@Validated @RequestBody DiemDTO diemDTO){
        int x = lopTinChiService.capNhatDiemSvLTC(diemDTO.getMALTC(), diemDTO.getMASV(), diemDTO.getDIEM_CC(), diemDTO.getDIEM_GK(), diemDTO.getDIEM_CK());
        System.out.println(diemDTO.toString() + " " + x);
        if(x == 1)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
