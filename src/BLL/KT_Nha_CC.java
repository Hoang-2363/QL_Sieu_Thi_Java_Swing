package BLL;

import Interface.Delete_Database;
import Interface.Insert_DataBase;
import Interface.Update_Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KT_Nha_CC implements Insert_DataBase, Update_Database, Delete_Database {

    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";

    @Override
    public boolean xoaNCC(String maLHH) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maLHH.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement kt = connection.prepareStatement("SELECT COUNT(*) FROM HANG_HOA WHERE MA_NHA_CUNG_CAP = ?");
                kt.setString(1, maLHH);  
                ResultSet resultSet = kt.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount > 0) {
                        String message = "Mã nhà cung cấp " + maLHH + " đã tồn tại ở bảng hàng hóa rồi !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                PreparedStatement st = connection.prepareStatement("DELETE FROM NHA_CUNG_CAP WHERE MA_NHA_CUNG_CAP = ?");              
                st.setString(1, maLHH);

                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Không còn nhà cung cấp nào để xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                     return false;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc xóa nahf cung cấp: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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
    public boolean themNCC(String ma_NCC, String ten_NCC, String dia_Chi, String SDT, String gmail) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (ma_NCC.isEmpty() || ten_NCC.isEmpty()|| dia_Chi.isEmpty()|| SDT.isEmpty()|| gmail.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin nhà cung cấp !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } else if (!gmail.matches(".*@gmail\\.com") && !gmail.matches(".*@gmail\\.com.vn")) {
                    JOptionPane.showMessageDialog(null, "Địa chỉ Gmail không đúng định dạng (@gmail.com) !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                } 
                PreparedStatement kt = connection.prepareStatement("SELECT COUNT(*) FROM NHA_CUNG_CAP WHERE MA_NHA_CUNG_CAP = ?");
                kt.setString(1, ma_NCC);  
                ResultSet resultSet = kt.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount > 0) {
                        String message = "Mã nhà cung cấp " + ma_NCC + " đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                
                PreparedStatement kt1 = connection.prepareStatement("SELECT COUNT(*) FROM NHA_CUNG_CAP WHERE TEN_NHA_CUNG_CAP = ?");
                kt1.setString(1, ten_NCC);  
                ResultSet resultSet1 = kt1.executeQuery();
                if (resultSet1.next()) {
                    int rowCount = resultSet1.getInt(1);
                    if (rowCount > 0) {
                        String message = "Tên nhà cung cấp " + ten_NCC +" đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                
                PreparedStatement kt2 = connection.prepareStatement("SELECT COUNT(*) FROM NHA_CUNG_CAP WHERE SDT = ?");
                kt2.setString(1, SDT);  
                ResultSet resultSet2 = kt2.executeQuery();
                if (resultSet2.next()) {
                    int rowCount = resultSet2.getInt(1);
                    if (rowCount > 0) {
                        String message = "Số điện thoại " + SDT +" đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                
                PreparedStatement kt3 = connection.prepareStatement("SELECT COUNT(*) FROM NHA_CUNG_CAP WHERE EMAIL = ?");
                kt3.setString(1, gmail);  
                ResultSet resultSet3 = kt3.executeQuery();
                if (resultSet3.next()) {
                    int rowCount = resultSet3.getInt(1);
                    if (rowCount > 0) {
                        String message = "Gmail nhà cung cấp " + gmail +" đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                
                PreparedStatement st = connection.prepareStatement("INSERT INTO NHA_CUNG_CAP (MA_NHA_CUNG_CAP, TEN_NHA_CUNG_CAP, DIA_CHI, SDT, EMAIL) VALUES (?, ?, ?, ?, ?)");
                st.setString(1, ma_NCC);
                st.setString(2, ten_NCC);
                st.setString(3, dia_Chi);                
                st.setString(4, SDT);
                st.setString(5, gmail);

                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc thêm nhà cung cấp: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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
    public boolean suaNCC(String ma_NCC, String ten_NCC, String dia_Chi, String SDT, String gmail) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (ma_NCC.isEmpty() || ten_NCC.isEmpty()|| dia_Chi.isEmpty()|| SDT.isEmpty()|| gmail.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin nhà cung cấp !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                
//                PreparedStatement kt1 = connection.prepareStatement("SELECT COUNT(*) FROM NHA_CUNG_CAP WHERE TEN_NHA_CUNG_CAP = ?");
//                kt1.setString(1, ten_NCC);  
//                ResultSet resultSet1 = kt1.executeQuery();
//                if (resultSet1.next()) {
//                    int rowCount = resultSet1.getInt(1);
//                    if (rowCount > 0) {
//                        String message = "Tên nhà cung cấp " + ten_NCC +" đã tồn tại !!!";
//                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
//                        return false;
//                    }
//                }
//                
//                PreparedStatement kt2 = connection.prepareStatement("SELECT COUNT(*) FROM NHA_CUNG_CAP WHERE SDT = ?");
//                kt2.setString(1, SDT);  
//                ResultSet resultSet2 = kt2.executeQuery();
//                if (resultSet2.next()) {
//                    int rowCount = resultSet2.getInt(1);
//                    if (rowCount > 0) {
//                        String message = "Số điện thoại " + SDT +" đã tồn tại !!!";
//                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
//                        return false;
//                    }
//                }
//                
//                PreparedStatement kt3 = connection.prepareStatement("SELECT COUNT(*) FROM NHA_CUNG_CAP WHERE EMAIL = ?");
//                kt3.setString(1, gmail);  
//                ResultSet resultSet3 = kt3.executeQuery();
//                if (resultSet3.next()) {
//                    int rowCount = resultSet3.getInt(1);
//                    if (rowCount > 0) {
//                        String message = "Gmail nhà cung cấp " + gmail +" đã tồn tại !!!";
//                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
//                        return false;
//                    }
//                }
                
                PreparedStatement st = connection.prepareStatement("UPDATE NHA_CUNG_CAP SET MA_NHA_CUNG_CAP = ?, TEN_NHA_CUNG_CAP = ?, DIA_CHI = ?, SDT = ?, EMAIL = ? WHERE MA_NHA_CUNG_CAP = ?");
                st.setString(1, ma_NCC);
                st.setString(2, ten_NCC);
                st.setString(3, dia_Chi);
                st.setString(4, SDT); 
                st.setString(5, gmail);
                st.setString(6, ma_NCC);

                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                connection.close();
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
    public boolean themHH(String ten_HH, String gia_Nhap, String gia_Ban, String donvt, String so_Luong_Ton, String ghi_Chu, String ma_NCC, String ma_LHH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean suaHH(String ma_HH, String ten_HH, String gia_Nhap, String gia_Ban, String donvt, String so_Luong_Ton, String ghi_Chu, String ma_NCC, String ma_LHH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean xoaHH(String maKH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean themLoaiHH(String ma_LHH, String ten_LHH, String ghi_Chu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean suaLoaiHH(String maLHH, String tenLHH, String ghiChu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean xoaLoaiHH(String maLHH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
