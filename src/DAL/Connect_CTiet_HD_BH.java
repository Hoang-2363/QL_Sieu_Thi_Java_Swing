package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Connect_CTiet_HD_BH {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    public static DefaultTableModel getData1(JTable table_HH) {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT MA_HANG, TEN_HANG, DON_VI_TINH, SO_LUONG_TON, GIA_BAN FROM HANG_HOA");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hàng hóa</b></html>");
                model.addColumn("<html><b>Tên hàng hóa</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");
                model.addColumn("<html><b>Số lượng tồn</b></html>");
                model.addColumn("<html><b>Giá bán</b></html>");
                
                table_HH.setModel(model);
                table_HH.setRowHeight(30);
                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(260);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(4).setPreferredWidth(90);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HANG"), rs.getString("TEN_HANG"), rs.getString("DON_VI_TINH"), rs.getString("SO_LUONG_TON"), rs.getString("GIA_BAN")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu 1: " + e.getMessage());
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

    public static DefaultTableModel getData2() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.MA_HANG, TEN_HANG, SO_LUONG, GIA_BAN, GIA_BAN*SO_LUONG AS THANH_TIEN  FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG WHERE HD_BH_CT.MA_HD_BH is null;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hàng hóa</b></html>");
                model.addColumn("<html><b>Tên hàng hóa</b></html>");
                model.addColumn("<html><b>Số lượng</b></html>");
                model.addColumn("<html><b>Giá tiền</b></html>");
                model.addColumn("<html><b>Thành tiền</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HANG"), rs.getString("TEN_HANG"), rs.getString("SO_LUONG"), rs.getString("GIA_BAN"), rs.getString("THANH_TIEN")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu 2: " + e.getMessage());
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

    public static void load_Ma_HH(JComboBox<String> comboBox) {
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = conn.prepareStatement("SELECT MA_HANG FROM HANG_HOA"); ResultSet rs = stmt.executeQuery()) {

            comboBox.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("MA_HANG");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_Ten_HH(JComboBox<String> comboBox) {
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = conn.prepareStatement("SELECT TEN_HANG FROM HANG_HOA"); ResultSet rs = stmt.executeQuery()) {

            comboBox.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("TEN_HANG");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_Ma_KK(JComboBox<String> comboBox) {
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = conn.prepareStatement("SELECT MA_HANG FROM HANG_HOA"); ResultSet rs = stmt.executeQuery()) {

            comboBox.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("MA_HANG");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
