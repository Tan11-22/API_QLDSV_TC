package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Entity
@Table(name = "SINHVIEN")
public class SinhVien {
    @Id
    @Nationalized
    @Column(name = "MASV", nullable = false, length = 10)
    private String masv;

    @Nationalized
    @Column(name = "HO", nullable = false, length = 50)
    private String ho;

    @Nationalized
    @Column(name = "TEN", nullable = false, length = 10)
    private String ten;

    @Column(name = "PHAI", nullable = false)
    private Boolean phai = false;

    @Nationalized
    @Column(name = "DIACHI", length = 100)
    private String diachi;

    @Column(name = "NGAYSINH")
    private LocalDate ngaysinh;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "MALOP", nullable = false)
    private Lop malop;

    @Column(name = "DANGHIHOC", nullable = false)
    private Boolean danghihoc = false;

    @Nationalized
    @Column(name = "PASSWORD", length = 40)
    private String password;

    @Column(name = "HINHANH")
    private String hinhanh;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MASV")
    @MapsId
    private TaiKhoan taiKhoan;

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
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

    public Boolean getPhai() {
        return phai;
    }

    public void setPhai(Boolean phai) {
        this.phai = phai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Lop getMalop() {
        return malop;
    }

    public void setMalop(Lop malop) {
        this.malop = malop;
    }

    public Boolean getDanghihoc() {
        return danghihoc;
    }

    public void setDanghihoc(Boolean danghihoc) {
        this.danghihoc = danghihoc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

}