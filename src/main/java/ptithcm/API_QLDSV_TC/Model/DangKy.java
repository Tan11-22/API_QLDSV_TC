package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DANGKY")
public class DangKy {
    @EmbeddedId
    private DangKyId id;

    @Column(name = "DIEM_CC")
    private Integer diemCc;

    @Column(name = "DIEM_GK")
    private Double diemGk;

    @Column(name = "DIEM_CK")
    private Double diemCk;

    @Column(name = "HUYDANGKY")
    private Boolean huydangky;

    public DangKyId getId() {
        return id;
    }

    public void setId(DangKyId id) {
        this.id = id;
    }

    public Integer getDiemCc() {
        return diemCc;
    }

    public void setDiemCc(Integer diemCc) {
        this.diemCc = diemCc;
    }

    public Double getDiemGk() {
        return diemGk;
    }

    public void setDiemGk(Double diemGk) {
        this.diemGk = diemGk;
    }

    public Double getDiemCk() {
        return diemCk;
    }

    public void setDiemCk(Double diemCk) {
        this.diemCk = diemCk;
    }

    public Boolean getHuydangky() {
        return huydangky;
    }

    public void setHuydangky(Boolean huydangky) {
        this.huydangky = huydangky;
    }

}