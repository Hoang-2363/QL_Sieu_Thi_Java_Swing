package Interface;

/**
 *
 * @author Hoang
 */
public interface Delete_Database {
    //Quản lý khách hàng
    boolean xoaKH(String maKH);
    
    //Quản lý hàng hóa
    boolean xoaHH(String maKH);
    
    //Quản lý nhà cung cấp
    boolean xoaNCC(String maLHH);
    
    //Quản lý loại hàng hóa
    boolean xoaLoaiHH(String maLHH);
}
