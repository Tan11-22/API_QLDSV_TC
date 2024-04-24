package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
//@NamedStoredProcedureQuery(name = "DS_HOCPHI_THEOLOP",procedureName = "DS_HOCPHI_THEOLOP",parameters = {
//        @StoredProcedureParameter(mode=ParameterMode.IN,name = "LOP",type = String.class),
//        @StoredProcedureParameter(mode=ParameterMode.IN,name = "NIENKHOA",type = String.class),
//        @StoredProcedureParameter(mode=ParameterMode.IN,name = "HOCKY",type = Integer.class)
//})
public class DanhSachHocPhiLop {
    @Id
//    @Column(name = "MASV",nullable = false,length = 10)
    private String masv;
//    @Column(name = "NIENKHOA", nullable = false, length = 9)
    private String nienkhoa;
//    @Column(name = "HOCKY", nullable = false)
    private Integer hocky;
//    @Column(name="HO",nullable = false,length = 50)
    private String ho;
//    @Column(name="TEN",nullable = false,length = 10)
    private String ten;
//    @Column(name="HOCPHI",nullable = true,length = 10)
    private Integer hocphi;
//    @Column(name="NGAYDONG",nullable = true,length = 10)
    private Date ngaydong;
//    @Column(name="SOTIENDONG",nullable = true,length = 10)
    private Integer sotiendong;

    public DanhSachHocPhiLop(String masv, String nienkhoa, Integer hocky, String ho, String ten, Integer hocphi, Date ngaydong, Integer sotiendong) {
        this.masv = masv;
        this.nienkhoa = nienkhoa;
        this.hocky = hocky;
        this.ho = ho;
        this.ten = ten;
        this.hocphi = hocphi;
        this.ngaydong = ngaydong;
        this.sotiendong = sotiendong;
    }

    public DanhSachHocPhiLop() {

    }

    public String getMasv() {
        return masv;
    }

    public String getNienkhoa() {
        return nienkhoa;
    }

    public Integer getHocky() {
        return hocky;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public Integer getHocphi() {
        return hocphi;
    }

    public Date getNgaydong() {
        return ngaydong;
    }

    public Integer getSotiendong() {
        return sotiendong;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setNienkhoa(String nienkhoa) {
        this.nienkhoa = nienkhoa;
    }

    public void setHocky(Integer hocky) {
        this.hocky = hocky;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setHocphi(Integer hocphi) {
        this.hocphi = hocphi;
    }

    public void setNgaydong(Date ngaydong) {
        this.ngaydong = ngaydong;
    }

    public void setSotiendong(Integer sotiendong) {
        this.sotiendong = sotiendong;
    }

    @Override
    public String toString() {
        return "DanhSachHocPhiLopRepository{" +
                "masv='" + masv + '\'' +
                ", nienkhoa='" + nienkhoa + '\'' +
                ", hocky=" + hocky +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", hocphi=" + hocphi +
                ", ngaydong=" + ngaydong +
                ", sotiendong=" + sotiendong +
                '}';
    }
}
