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
public class KT_Loai_Hang_Hoa implements Insert_DataBase, Update_Database, Delete_Database {

    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";

    @Override
    public boolean themLoaiHH(String ma_LHH, String ten_LHH, String ghi_Chu) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (ma_LHH.isEmpty() || ten_LHH.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin loại hàng hóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement kt = connection.prepareStatement("SELECT COUNT(*) FROM LOAI_HH WHERE MA_LOAI_HANG = ?");
                kt.setString(1, ma_LHH);  
                ResultSet resultSet = kt.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount > 0) {
                        String message = "Mã loại hàng hóa " + ma_LHH + " đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                
                PreparedStatement kt1 = connection.prepareStatement("SELECT COUNT(*) FROM LOAI_HH WHERE TEN_LOAI_HANG = ?");
                kt1.setString(1, ten_LHH);  
                ResultSet resultSet1 = kt1.executeQuery();
                if (resultSet1.next()) {
                    int rowCount = resultSet1.getInt(1);
                    if (rowCount > 0) {
                        String message = "Tên hàng hóa " + ten_LHH +" đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                
                PreparedStatement st = connection.prepareStatement("INSERT INTO LOAI_HH (MA_LOAI_HANG, TEN_LOAI_HANG, GHI_CHU) VALUES (?, ?, ?)");
                st.setString(1, ma_LHH);
                st.setString(2, ten_LHH);
                st.setString(3, ghi_Chu);
                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc thêm loại hàng hóa: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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
    public boolean xoaLoaiHH(String maLHH) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maLHH.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn loại hàng hóa cần xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement kt = connection.prepareStatement("SELECT COUNT(*) FROM HANG_HOA WHERE MA_LOAI_HANG = ?");
                kt.setString(1, maLHH);  
                ResultSet resultSet = kt.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount > 0) {
                        String message = "Mã loại hàng hóa " + maLHH + " đã tồn tại ở bảng hàng hóa rồi !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                PreparedStatement st = connection.prepareStatement("DELETE FROM LOAI_HH WHERE MA_LOAI_HANG = ?");              
                st.setString(1, maLHH);

                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "Không còn loại hàng hóa nào để xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
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
    public boolean suaLoaiHH(String maLHH, String tenLHH, String ghiChu) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maLHH.isEmpty() || tenLHH.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin loại hàng hóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                
                PreparedStatement kt1 = connection.prepareStatement("SELECT COUNT(*) FROM LOAI_HH WHERE TEN_LOAI_HANG = ?");
                kt1.setString(1, tenLHH);  
                ResultSet resultSet1 = kt1.executeQuery();
                if (resultSet1.next()) {
                    int rowCount = resultSet1.getInt(1);
                    if (rowCount > 0) {
                        String message = "Tên hàng hóa " + tenLHH +" đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                
                PreparedStatement st = connection.prepareStatement("UPDATE LOAI_HH SET TEN_LOAI_HANG = ?, GHI_CHU = ? WHERE MA_LOAI_HANG = ?");
                st.setString(1, tenLHH);
                st.setString(2, ghiChu);
                st.setString(3, maLHH); 

                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc sửa loại hàng hóa: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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
    public boolean themNCC(String ma_NCC, String ten_NCC, String dia_Chi, String SDT, String gmail) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean suaNCC(String ma_NCC, String ten_NCC, String dia_Chi, String SDT, String gmail) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean xoaNCC(String maLHH) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
