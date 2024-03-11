package ptithcm.API_QLDSV_TC.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "HE")
public class He {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HE", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "TEN_HE", nullable = false, length = 80)
    private String tenHe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenHe() {
        return tenHe;
    }

    public void setTenHe(String tenHe) {
        this.tenHe = tenHe;
    }

}