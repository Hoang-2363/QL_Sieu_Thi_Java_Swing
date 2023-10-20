package BLL;

import Interface.Delete_Database;
import Interface.Insert_DataBase;
import Interface.Update_Database;
import static com.microsoft.sqlserver.jdbc.StringUtils.isInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KT_Hang_Hoa implements Insert_DataBase, Update_Database, Delete_Database {

    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";

    @Override
    public boolean themHH(String ten_HH, String gia_Nhap, String gia_Ban, String donvt, String so_Luong_Ton, String ghi_Chu, String ma_NCC, String ma_LHH) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (ten_HH.isEmpty()|| gia_Nhap.isEmpty()|| gia_Ban.isEmpty()|| donvt.isEmpty() ||
                        so_Luong_Ton.isEmpty() || ma_NCC.isEmpty()|| ma_LHH.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin nhà cung cấp !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement kt = connection.prepareStatement("SELECT COUNT(*) FROM HANG_HOA WHERE TEN_HANG = ?");
                kt.setString(1, ten_HH);  
                ResultSet resultSet = kt.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount > 0) {
                        String message = "Tên hàng hóa " + ten_HH + " đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                PreparedStatement st = connection.prepareStatement("INSERT INTO HANG_HOA (MA_HANG, TEN_HANG, GIA_NHAP, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, GHI_CHU, MA_NHA_CUNG_CAP, MA_LOAI_HANG) "
                        + "VALUES ('HH_' + RIGHT('00' + CAST(NEXT VALUE FOR Hanghoa_Seq AS NVARCHAR(3)), 2), ?, ?, ?, ?, ?, ?, ?, ?)");
                st.setString(1, ten_HH);
                st.setString(2, gia_Nhap);
                st.setString(3, gia_Ban);
                st.setString(4, donvt);
                st.setString(5, so_Luong_Ton);
                st.setString(6, ghi_Chu);
                st.setString(7, ma_NCC);
                st.setString(8, ma_LHH);

                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                connection.close(); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc thêm hàng hóa: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean xoaHH(String maKH) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maKH.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng hóa cần xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement st = connection.prepareStatement("DELETE FROM HANG_HOA WHERE MA_HANG = ?");              
                st.setString(1, maKH);

                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Không còn hàng hóa nào để xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                     return false;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc thêm khách hàng: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean suaHH(String ma_HH, String ten_HH, String gia_Nhap, String gia_Ban, String donvt, String so_Luong_Ton, String ghi_Chu, String ma_NCC, String ma_LHH) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (ma_HH.isEmpty() || ten_HH.isEmpty()|| gia_Nhap.isEmpty()|| gia_Ban.isEmpty()|| donvt.isEmpty() || so_Luong_Ton.isEmpty() || ma_NCC.isEmpty()|| ma_LHH.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin hàng hóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement kt = connection.prepareStatement("SELECT COUNT(*) FROM NHA_CUNG_CAP WHERE MA_NHA_CUNG_CAP = ?");
                kt.setString(1, ma_NCC);  
                ResultSet resultSet = kt.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount == 0) {
                        String message = "Mã nhà cung cấp " + ten_HH + " không tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                PreparedStatement kt1 = connection.prepareStatement("SELECT COUNT(*) FROM LOAI_HH WHERE MA_LOAI_HANG = ?");
                kt1.setString(1, ma_LHH);  
                ResultSet resultSet1 = kt1.executeQuery();
                if (resultSet1.next()) {
                    int rowCount = resultSet1.getInt(1);
                    if (rowCount == 0) {
                        String message = "Mã loại hàng hóa " + ten_HH + " không tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
//                PreparedStatement kt2 = connection.prepareStatement("SELECT COUNT(*) FROM HANG_HOA WHERE TEN_HANG = ?");
//                kt2.setString(1, ten_HH);  
//                ResultSet resultSet2 = kt2.executeQuery();
//                if (resultSet2.next()) {
//                    int rowCount = resultSet2.getInt(1);
//                    if (rowCount > 0) {
//                        String message = "Tên hàng hóa " + ten_HH + " đã tồn tại !!!";
//                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
//                        return false;
//                    }
//                }
                
                if (!isInteger(gia_Nhap)) {
                    JOptionPane.showMessageDialog(null, "Giá nhập phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else if (!isInteger(gia_Ban)) {
                    JOptionPane.showMessageDialog(null, "Giá bán phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else if (!isInteger(so_Luong_Ton)) {
                    JOptionPane.showMessageDialog(null, "Số lượng tồn phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    PreparedStatement st = connection.prepareStatement("UPDATE HANG_HOA SET TEN_HANG = ?, GIA_NHAP = ?, GIA_BAN = ?, DON_VI_TINH = ?, SO_LUONG_TON = ?, GHI_CHU = ?, MA_NHA_CUNG_CAP = ?, MA_LOAI_HANG = ? WHERE MA_HANG = ?");
                    st.setString(1, ten_HH);
                    st.setString(2, gia_Nhap);
                    st.setString(3, gia_Ban);
                    st.setString(4, donvt);
                    st.setString(5, so_Luong_Ton);
                    st.setString(6, ghi_Chu);
                    st.setString(7, ma_NCC);
                    st.setString(8, ma_LHH);                    
                    st.setString(9, ma_HH);

                    int rowsInserted = st.executeUpdate();
                    if (rowsInserted > 0) {
                        return true;
                    }
                    connection.close();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc sửa nhà cung cấp: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        return false;
    }

    @Override
    public boolean themKhachHang(String tenKH, String sdt, String diaChi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean suaKH(String maKH, String tenKH, String sdt, String diaChi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean xoaKH(String maKH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean themNCC(String ma_NCC, String ten_NCC, String dia_Chi, String SDT, String gmail) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean themLoaiHH(String ma_LHH, String ten_LHH, String ghi_Chu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean suaNCC(String ma_NCC, String ten_NCC, String dia_Chi, String SDT, String gmail) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean suaLoaiHH(String maLHH, String tenLHH, String ghiChu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean xoaNCC(String maLHH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean xoaLoaiHH(String maLHH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
