package ptithcm.API_QLDSV_TC.DTO;

import org.hibernate.annotations.Nationalized;

public class LopDTO {
    private String maLop;
    private String tenLop;
    private boolean trangThai;
    private String khoaHoc;
    private String maKhoa;
    private int idHe;

    public LopDTO() {
    }

    public LopDTO(String maLop, String tenLop, boolean trangThai, String khoaHoc, String maKhoa, int idHe) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.trangThai = trangThai;
        this.khoaHoc = khoaHoc;
        this.maKhoa = maKhoa;
        this.idHe = idHe;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public int getIdHe() {
        return idHe;
    }

    public void setIdHe(int idHe) {
        this.idHe = idHe;
    }
}
