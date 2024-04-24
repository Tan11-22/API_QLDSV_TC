package ptithcm.API_QLDSV_TC.DTO;

public class MonHocDTO {
    private String mamh;
    private String tenmh;
    private Integer sotietLt;
    private Integer sotietTh;
    private Integer sotinchi;
    public MonHocDTO()
    {

    }

    public MonHocDTO(String mamh, String tenmh, Integer sotietLt, Integer sotietTh, Integer sotinchi) {
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.sotietLt = sotietLt;
        this.sotietTh = sotietTh;
        this.sotinchi = sotinchi;
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public Integer getSotietLt() {
        return sotietLt;
    }

    public void setSotietLt(Integer sotietLt) {
        this.sotietLt = sotietLt;
    }

    public Integer getSotietTh() {
        return sotietTh;
    }

    public void setSotietTh(Integer sotietTh) {
        this.sotietTh = sotietTh;
    }

    public Integer getSotinchi() {
        return sotinchi;
    }

    public void setSotinchi(Integer sotinchi) {
        this.sotinchi = sotinchi;
    }
}
