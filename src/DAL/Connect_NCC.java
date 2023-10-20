package DAL;

import Interface.Connect_DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Connect_NCC implements Connect_DataBase {
    public static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
     @Override
    public DefaultTableModel getData() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT * FROM NHA_CUNG_CAP");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã nhà cung cấp</b></html>");
                model.addColumn("<html><b>Tên nhà cung cấp</b></html>");
                model.addColumn("<html><b>Địa chỉ</b></html>");
                model.addColumn("<html><b>SDT</b></html>");                
                model.addColumn("<html><b>Gmail</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NHA_CUNG_CAP"), rs.getString("TEN_NHA_CUNG_CAP"), rs.getString("DIA_CHI"), rs.getString("SDT"), rs.getString("EMAIL")};
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
