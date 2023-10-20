package BLL;

import static com.microsoft.sqlserver.jdbc.StringUtils.isInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KT_Support {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    public static boolean sua_TT_NV(String ma_NV, String dia_Chi, String sdt, String gmail) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (ma_NV.isEmpty() || dia_Chi.isEmpty() || sdt.isEmpty() || gmail.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin hàng hóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                PreparedStatement kt = connection.prepareStatement("SELECT COUNT(*) FROM NHAN_VIEN WHERE MA_NV = ? AND DIA_CHI = ? AND SDT = ? AND EMAIL = ?");
                kt.setString(1, ma_NV);                
                kt.setString(2, dia_Chi);
                kt.setString(3, sdt);
                kt.setString(4, gmail);

                ResultSet resultSet = kt.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount == 1) {
                        String message = "Bạn chưa thay đổi gì cả !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                PreparedStatement st = connection.prepareStatement("UPDATE NHAN_VIEN SET DIA_CHI = ?, SDT = ?, EMAIL = ? WHERE MA_NV = ?");
                st.setString(1, dia_Chi);
                st.setString(2, sdt);
                st.setString(3, gmail);
                st.setString(4, ma_NV);
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
    
    public static boolean doi_MK(String tk, String mkc, String mkm, String mkm_nl) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (mkc.isEmpty() || mkm.isEmpty() || mkm_nl.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin để đổi mật khẩu !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                PreparedStatement kt1 = connection.prepareStatement("SELECT COUNT(*) FROM NGUOI_DUNG WHERE TAI_KHOAN = ? AND MAT_KHAU = ?");
                kt1.setString(1, tk);                  
                kt1.setString(2, mkc);  
                ResultSet rs = kt1.executeQuery();
                if (rs.next()) {
                    int rowCount = rs.getInt(1);
                    if (rowCount == 0) {
                        String message = "Mật khẩu cũ bạn đã sai. Vui lòng nhập lại !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                if(mkm.equals(mkc)){
                    JOptionPane.showMessageDialog(null, "Mật khẩu cũ và mật khẩu mới giống nhau. Vui lòng nhập lại !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                if(mkm_nl.equals(mkm)){
                    PreparedStatement st = connection.prepareStatement("UPDATE NGUOI_DUNG SET MAT_KHAU = ? WHERE TAI_KHOAN = ? AND MAT_KHAU = ?");
                    st.setString(1, mkm);
                    st.setString(2, tk);
                    st.setString(3, mkc);
                    int rowsInserted = st.executeUpdate();
                    if (rowsInserted > 0) {
                        return true;
                    }
                    connection.close();
                } else{
                    JOptionPane.showMessageDialog(null, "Đã nhập sai mật khẩu mới. Hãy nhập giống mật khẩu mới !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
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
}
