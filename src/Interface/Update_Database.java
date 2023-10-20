package Interface;

/**
 *
 * @author Hoang
 */
public interface Update_Database {
    //Quản lý khách hàng
    boolean suaKH(String maKH, String tenKH, String sdt, String diaChi);
    
    //Quản lý hàng hóa
    boolean suaHH(String ma_HH, String ten_HH, String gia_Nhap, String gia_Ban, String donvt, String so_Luong_Ton, String ghi_Chu, String ma_NCC, String ma_LHH);
    
    //Quản lý nhà cung cấp
    boolean suaNCC(String ma_NCC, String ten_NCC, String dia_Chi, String SDT, String gmail);
    
    //Quản lý loại hàng hóa
    boolean suaLoaiHH(String maLHH, String tenLHH, String ghiChu);
}
