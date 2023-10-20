package Interface;

/**
 *
 * @author Hoang
 */
public interface Insert_DataBase {
    //Quản lý khách hàng
    boolean themKhachHang(String tenKH, String sdt, String diaChi);
    
    //Quản lý hàng hóa
    boolean themHH(String ten_HH, String gia_Nhap, String gia_Ban, String donvt, String so_Luong_Ton, String ghi_Chu, String ma_NCC, String ma_LHH);
    
    //Quản lý nhà cung cấp
    boolean themNCC(String ma_NCC, String ten_NCC, String dia_Chi, String SDT, String gmail);
    
    //Quản lý loại hàng hóa
    boolean themLoaiHH(String ma_LHH, String ten_LHH, String ghi_Chu);
    
}
