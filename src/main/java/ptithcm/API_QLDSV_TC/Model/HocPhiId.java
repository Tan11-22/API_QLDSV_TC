package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class HocPhiId implements Serializable {
    private static final long serialVersionUID = 417954944571108266L;
    @Nationalized
    @Column(name = "MASV", nullable = false, length = 10)
    private String masv;

    @Nationalized
    @Column(name = "NIENKHOA", nullable = false, length = 9)
    private String nienkhoa;

    @Column(name = "HOCKY", nullable = false)
    private Integer hocky;

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getNienkhoa() {
        return nienkhoa;
    }

    public void setNienkhoa(String nienkhoa) {
        this.nienkhoa = nienkhoa;
    }

    public Integer getHocky() {
        return hocky;
    }

    public void setHocky(Integer hocky) {
        this.hocky = hocky;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HocPhiId entity = (HocPhiId) o;
        return Objects.equals(this.masv, entity.masv) &&
                Objects.equals(this.hocky, entity.hocky) &&
                Objects.equals(this.nienkhoa, entity.nienkhoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masv, hocky, nienkhoa);
    }

}