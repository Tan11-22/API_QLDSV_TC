package ptithcm.API_QLDSV_TC.DTO;

public class HeDTO {
    private Integer id;
    private String tenHe;
    
    public HeDTO(Integer id, String tenHe) {
        this.id = id;
        this.tenHe = tenHe;
    }
    public HeDTO() {
    }
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
