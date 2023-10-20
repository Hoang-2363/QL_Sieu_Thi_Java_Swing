package DAL;

import Interface.Connect_DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Connect_HH implements Connect_DataBase{
    public static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    @Override
    public DefaultTableModel getData() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT * FROM HANG_HOA");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hàng hóa</b></html>");
                model.addColumn("<html><b>Tên hàng hóa</b></html>");                
                model.addColumn("<html><b>Giá nhập</b></html>");
                model.addColumn("<html><b>Giá bán</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");
                model.addColumn("<html><b>Số lượng tồn</b></html>");
                model.addColumn("<html><b>Ghi chú</b></html>");
                model.addColumn("<html><b>Mã NC cấp</b></html>");
                model.addColumn("<html><b>Mã loại hàng</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HANG"), rs.getString("TEN_HANG"), rs.getString("GIA_NHAP"), 
                        rs.getString("GIA_BAN"), rs.getString("DON_VI_TINH"), rs.getString("SO_LUONG_TON"), 
                        rs.getString("GHI_CHU"), rs.getString("MA_NHA_CUNG_CAP"), rs.getString("MA_LOAI_HANG")};
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
    public static DefaultTableModel getData1() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT MA_HANG, TEN_HANG, GIA_NHAP, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, TEN_LOAI_HANG, TEN_NHA_CUNG_CAP FROM HANG_HOA INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hàng hóa</b></html>");
                model.addColumn("<html><b>Tên hàng hóa</b></html>");                
                model.addColumn("<html><b>Giá nhập</b></html>");
                model.addColumn("<html><b>Giá bán</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");
                model.addColumn("<html><b>Số lượng tồn</b></html>");
                model.addColumn("<html><b>Tên loại hàng</b></html>");
                model.addColumn("<html><b>Tên NC cấp</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HANG"), rs.getString("TEN_HANG"), rs.getString("GIA_NHAP"), 
                        rs.getString("GIA_BAN"), rs.getString("DON_VI_TINH"), rs.getString("SO_LUONG_TON"), rs.getString("TEN_LOAI_HANG"), rs.getString("TEN_NHA_CUNG_CAP")};
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
