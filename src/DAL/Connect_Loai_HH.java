package DAL;

import Interface.Connect_DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Connect_Loai_HH implements Connect_DataBase {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    @Override
    public DefaultTableModel getData() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT * FROM LOAI_HH");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã loại hàng hóa</b></html>");
                model.addColumn("<html><b>Tên loại hàng hóa</b></html>");
                model.addColumn("<html><b>Ghi chú</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_LOAI_HANG"), rs.getString("TEN_LOAI_HANG"), rs.getString("GHI_CHU")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
                }
            }
        }
        return model;
    }

}
