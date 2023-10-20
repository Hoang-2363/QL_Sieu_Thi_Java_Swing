package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KT_Dang_Nhap {
    public static boolean kiemTraDangNhap(String taiKhoan, String matKhau) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);
            String query = "SELECT TAI_KHOAN, MAT_KHAU FROM NGUOI_DUNG WHERE TAI_KHOAN = ? AND MAT_KHAU = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, taiKhoan);
            preparedStatement.setString(2, matKhau);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối hoặc truy vấn cơ sở dữ liệu: " + e.getMessage());
        }
        return false;
    }
}
