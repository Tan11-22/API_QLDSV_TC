package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CT_DONGHOCPHI")
public class CTDongHocPhi {
    @EmbeddedId
    private CTDongHocPhiId id;

    @Column(name = "SOTIENDONG", nullable = false)
    private Integer sotiendong;

    public CTDongHocPhiId getId() {
        return id;
    }

    public void setId(CTDongHocPhiId id) {
        this.id = id;
    }

    public Integer getSotiendong() {
        return sotiendong;
    }

    public void setSotiendong(Integer sotiendong) {
        this.sotiendong = sotiendong;
    }

}