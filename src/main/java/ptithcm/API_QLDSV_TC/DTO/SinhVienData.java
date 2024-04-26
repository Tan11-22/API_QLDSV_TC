package ptithcm.API_QLDSV_TC.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.core.io.Resource;
import ptithcm.API_QLDSV_TC.Model.SinhVien;

import java.util.Arrays;
import java.util.Optional;

public class SinhVienData {

    @JsonProperty("masv")
    private String MASV;
    @JsonProperty("ho")
    private String HO;
    @JsonProperty("ten")
    private String TEN;
    @JsonProperty("phai")
    private String PHAI;
    @JsonProperty("diachi")
    private String DIACHI;
    @JsonProperty("ngaysinh")
    private String NGAYSINH;
    @JsonProperty("email")
    private String EMAIL;
    @JsonProperty("sdt")
    private String SDT;
    @JsonProperty("lop")
    private String LOP;
    @JsonProperty("khoa")
    private String KHOA;

    @JsonProperty("imgResource")
    private String imgResource;
    @JsonProperty("hinhanh")
    private String HINHANH;

    public SinhVienData() {
    }

    public SinhVienData(String MASV, String HO, String TEN, String PHAI, String DIACHI, String NGAYSINH, String EMAIL, String SDT, String LOP, String KHOA) {
        this.MASV = MASV;
        this.HO = HO;
        this.TEN = TEN;
        this.PHAI = PHAI;
        this.DIACHI = DIACHI;
        this.NGAYSINH = NGAYSINH;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
        this.LOP = LOP;
        this.KHOA = KHOA;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public String getHO() {
        return HO;
    }

    public void setHO(String HO) {
        this.HO = HO;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getPHAI() {
        return PHAI;
    }

    public void setPHAI(String PHAI) {
        this.PHAI = PHAI;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getLOP() {
        return LOP;
    }

    public void setLOP(String LOP) {
        this.LOP = LOP;
    }

    public String getKHOA() {
        return KHOA;
    }

    public void setKHOA(String KHOA) {
        this.KHOA = KHOA;
    }

    public String getImgResource() {
        return imgResource;
    }

    public void setImgResource(String imgResource) {
        this.imgResource = imgResource;
    }

    public String getHINHANH() {
        return HINHANH;
    }

    public void setHINHANH(String HINHANH) {
        this.HINHANH = HINHANH;
    }

    @Override
    public String toString() {
        return "SinhVienData{" +
                "HO='" + HO + '\'' +
                ", TEN='" + TEN + '\'' +
                ", PHAI='" + PHAI + '\'' +
                ", DIACHI='" + DIACHI + '\'' +
                ", NGAYSINH='" + NGAYSINH + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", SDT='" + SDT + '\'' +
                ", LOP='" + LOP + '\'' +
                ", KHOA='" + KHOA + '\'' +
                ", imgResource=" + imgResource +
                ", HINHANH='" + HINHANH + '\'' +
                ", MASV='" + MASV + '\'' +
                '}';
    }
}
