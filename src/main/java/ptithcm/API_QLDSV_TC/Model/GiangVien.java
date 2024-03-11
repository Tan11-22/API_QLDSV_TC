package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "GIANGVIEN")
public class GiangVien {
    @Id
    @Nationalized
    @Column(name = "MAGV", nullable = false, length = 10)
    private String magv;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAKHOA", nullable = false)
    private Khoa makhoa;

    @Nationalized
    @Column(name = "HO", nullable = false, length = 50)
    private String ho;

    @Nationalized
    @Column(name = "TEN", nullable = false, length = 10)
    private String ten;

    @Nationalized
    @Column(name = "HOCVI", length = 20)
    private String hocvi;

    @Nationalized
    @Column(name = "HOCHAM", length = 20)
    private String hocham;

    @Nationalized
    @Column(name = "CHUYENMON", length = 50)
    private String chuyenmon;

    @Column(name = "HINHANH")
    private String hinhanh;

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public Khoa getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(Khoa makhoa) {
        this.makhoa = makhoa;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHocvi() {
        return hocvi;
    }

    public void setHocvi(String hocvi) {
        this.hocvi = hocvi;
    }

    public String getHocham() {
        return hocham;
    }

    public void setHocham(String hocham) {
        this.hocham = hocham;
    }

    public String getChuyenmon() {
        return chuyenmon;
    }

    public void setChuyenmon(String chuyenmon) {
        this.chuyenmon = chuyenmon;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

}