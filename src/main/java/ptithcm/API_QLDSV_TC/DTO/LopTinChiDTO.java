package ptithcm.API_QLDSV_TC.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LopTinChiDTO {
    @JsonProperty("MALTC")
    private int maLTC;
    @JsonProperty("MAKHOA")
    private String maKhoa;
    @JsonProperty("NIENKHOA")
    private String nienKhoa;
    @JsonProperty("HOCKY")
    private int hocKi;
    @JsonProperty("MAMH")
    private String maMH;
    @JsonProperty("TENMH")
    private String tenMH;
    @JsonProperty("NHOM")
    private int nhom;
    @JsonProperty("MAGV")
    private String maGV;
    @JsonProperty("TENGV")
    private String tenGV;
    @JsonProperty("SOSVTOITHIEU")
    private int soSV;
    @JsonProperty("HUYLOP")
    private boolean huyLop;

    @JsonProperty("MALOP")
    private String maLop;
    @JsonProperty("TENLOP")
    private String tenLop;

    public LopTinChiDTO() {
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public int getMaLTC() {
        return maLTC;
    }

    public void setMaLTC(int maLTC) {
        this.maLTC = maLTC;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public int getHocKi() {
        return hocKi;
    }

    public void setHocKi(int hocKi) {
        this.hocKi = hocKi;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    public boolean isHuyLop() {
        return huyLop;
    }

    public void setHuyLop(boolean huyLop) {
        this.huyLop = huyLop;
    }


    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
}
