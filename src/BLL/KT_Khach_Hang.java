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

public class KT_Khach_Hang implements Insert_DataBase, Update_Database, Delete_Database {

    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";

    @Override
    public boolean suaKH(String maKH, String tenKH, String sdt, String diaChi) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maKH.isEmpty() || tenKH.isEmpty() || sdt.isEmpty() || diaChi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin khách hàng !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement st = connection.prepareStatement("UPDATE KHACH_HANG SET TEN_KH = ?, SDT = ?, DIA_CHI = ? WHERE MA_KH = ?");
                st.setString(1, tenKH);
                st.setString(2, sdt);
                st.setString(3, diaChi);                
                st.setString(4, maKH);

                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                connection.close();
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
    public boolean themKhachHang(String tenKH, String sdt, String diaChi) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (tenKH.isEmpty() || sdt.isEmpty() || diaChi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin khách hàng !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement checkSDTStatement = connection.prepareStatement("SELECT COUNT(*) FROM KHACH_HANG WHERE SDT = ?");
                checkSDTStatement.setString(1, sdt);
                ResultSet resultSet = checkSDTStatement.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount > 0) {
                        String message = "Số điện thoại " + sdt + " đã tồn tại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                PreparedStatement st = connection.prepareStatement("INSERT INTO KHACH_HANG (MA_KH, TEN_KH, SDT, DIA_CHI) VALUES ('KH' + RIGHT('00' + CAST(NEXT VALUE FOR KhachHang_Seq AS NVARCHAR(3)), 2), ?, ?, ?)");
                st.setString(1, tenKH);
                st.setString(2, sdt);
                st.setString(3, diaChi);
                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                connection.close();
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
    public boolean xoaKH(String maKH) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maKH.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } 
                PreparedStatement st = connection.prepareStatement("DELETE FROM KHACH_HANG WHERE MA_KH = ?");              
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
