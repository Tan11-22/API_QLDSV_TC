package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "LOP")
public class Lop {
    @Id
    @Nationalized
    @Column(name = "MALOP", nullable = false, length = 10)
    private String malop;

    @Nationalized
    @Column(name = "TENLOP", nullable = false, length = 50)
    private String tenlop;

    @Nationalized
    @Column(name = "KHOAHOC", nullable = false, length = 9)
    private String khoahoc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAKHOA", nullable = false)
    private Khoa makhoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HE")
    private He idHe;

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(String khoahoc) {
        this.khoahoc = khoahoc;
    }

    public Khoa getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(Khoa makhoa) {
        this.makhoa = makhoa;
    }

    public He getIdHe() {
        return idHe;
    }

    public void setIdHe(He idHe) {
        this.idHe = idHe;
    }

}