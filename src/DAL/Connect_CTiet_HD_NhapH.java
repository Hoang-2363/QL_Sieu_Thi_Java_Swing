
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


public class Connect_CTiet_HD_NhapH {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    public static DefaultTableModel table_HH(JTable table_HH) {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT MA_HANG, TEN_HANG, DON_VI_TINH, SO_LUONG_TON, GIA_NHAP, GIA_BAN FROM HANG_HOA");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hàng hóa</b></html>");
                model.addColumn("<html><b>Tên hàng hóa</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");
                model.addColumn("<html><b>Số lượng tồn</b></html>");
                model.addColumn("<html><b>Giá nhập</b></html>");
                model.addColumn("<html><b>Giá bán</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);
                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(260);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(4).setPreferredWidth(90);                
                table_HH.getColumnModel().getColumn(5).setPreferredWidth(90);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);                
                table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HANG"), rs.getString("TEN_HANG"), rs.getString("DON_VI_TINH"), rs.getString("SO_LUONG_TON"), rs.getString("GIA_NHAP"), rs.getString("GIA_BAN")};
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

    public static DefaultTableModel table_Nhap_hang() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HD_NH_CT.MA_HANG, HANG_HOA.TEN_HANG, SO_LUONG, GIA_NHAP_HANG, SO_LUONG*GIA_NHAP_HANG AS THANH_TIEN  "
                        + "FROM HD_NH_CT INNER JOIN HANG_HOA ON HD_NH_CT.MA_HANG = HANG_HOA.MA_HANG "
                        + "WHERE HD_NH_CT.MA_HD_NH is null;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hàng hóa</b></html>");
                model.addColumn("<html><b>Tên hàng hóa</b></html>");
                model.addColumn("<html><b>Số lượng nhập</b></html>");
                model.addColumn("<html><b>Giá nhập</b></html>");
                model.addColumn("<html><b>Thành tiền</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HANG"), rs.getString("TEN_HANG"), rs.getString("SO_LUONG"), rs.getString("GIA_NHAP_HANG"), rs.getString("THANH_TIEN")};
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

    public static DefaultTableModel table_NCC(JTable table_HH) {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT MA_NHA_CUNG_CAP, TEN_NHA_CUNG_CAP, SDT FROM NHA_CUNG_CAP;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã NCC</b></html>");
                model.addColumn("<html><b>Tên NCC</b></html>");
                model.addColumn("<html><b>Số điện thoại</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);
                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(260);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(80);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NHA_CUNG_CAP"), rs.getString("TEN_NHA_CUNG_CAP"), rs.getString("SDT")};
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
    
    public static void load_Ma_HH(JComboBox<String> comboBox) {
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = conn.prepareStatement("SELECT MA_HANG FROM HANG_HOA"); ResultSet rs = stmt.executeQuery()) {

            comboBox.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("MA_HANG");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
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
        }
    }

    public static void load_Ma_NV(JComboBox<String> comboBox2, String tk, String mk) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement stmt = conn.prepareStatement("SELECT MA_NV FROM NGUOI_DUNG WHERE TAI_KHOAN = ? AND MAT_KHAU = ?;");
            stmt.setString(1, tk);
            stmt.setString(2, mk);
            ResultSet rs = stmt.executeQuery();
            comboBox2.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("MA_NV");
                comboBox2.addItem(item);
            }
        } catch (SQLException e) {
        }
    }
}
