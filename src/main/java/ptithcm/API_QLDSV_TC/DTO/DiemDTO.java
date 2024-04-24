package ptithcm.API_QLDSV_TC.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiemDTO {
    @JsonProperty("MALTC")
    private int MALTC;
    @JsonProperty("MASV")
    private String MASV;
    @JsonProperty("DIEM_CC")
    private int DIEM_CC;
    @JsonProperty("DIEM_GK")
    private float DIEM_GK;
    @JsonProperty("DIEM_CK")
    private float DIEM_CK;

    public DiemDTO() {
    }

    public DiemDTO(int MALTC, String MASV, int DIEM_CC, float DIEM_GK, float DIEM_CK) {
        this.MALTC = MALTC;
        this.MASV = MASV;
        this.DIEM_CC = DIEM_CC;
        this.DIEM_GK = DIEM_GK;
        this.DIEM_CK = DIEM_CK;
    }

    public int getMALTC() {
        return MALTC;
    }

    public void setMALTC(int MALTC) {
        this.MALTC = MALTC;
    }

    public String getMASV() {
        return MASV;
    }

    public void setMASV(String MASV) {
        this.MASV = MASV;
    }

    public int getDIEM_CC() {
        return DIEM_CC;
    }

    public void setDIEM_CC(int DIEM_CC) {
        this.DIEM_CC = DIEM_CC;
    }

    public float getDIEM_GK() {
        return DIEM_GK;
    }

    public void setDIEM_GK(float DIEM_GK) {
        this.DIEM_GK = DIEM_GK;
    }

    public float getDIEM_CK() {
        return DIEM_CK;
    }

    public void setDIEM_CK(float DIEM_CK) {
        this.DIEM_CK = DIEM_CK;
    }

    @Override
    public String toString() {
        return "DiemDTO{" +
                "MALTC=" + MALTC +
                ", MASV='" + MASV + '\'' +
                ", DIEM_CC=" + DIEM_CC +
                ", DIEM_GK=" + DIEM_GK +
                ", DIEM_CK=" + DIEM_CK +
                '}';
    }
}
