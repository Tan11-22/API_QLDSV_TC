package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "HOCPHI")
public class HocPhi {
    @EmbeddedId
    private HocPhiId id;

    @Column(name = "HOCPHI", nullable = false)
    private Integer hocphi;

    public HocPhiId getId() {
        return id;
    }

    public void setId(HocPhiId id) {
        this.id = id;
    }

    public Integer getHocphi() {
        return hocphi;
    }

    public void setHocphi(Integer hocphi) {
        this.hocphi = hocphi;
    }

}