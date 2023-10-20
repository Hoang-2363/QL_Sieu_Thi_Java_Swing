package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class KT_TK_Thong_tin {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    public static DefaultTableModel TK_NCC_Ten(String text, JTable table) {
        String cmd = "SELECT * FROM NHA_CUNG_CAP WHERE TEN_NHA_CUNG_CAP LIKE ?;";
        return getData2(table, cmd, text);
    }

    public static DefaultTableModel TK_HH_SDT(String text, JTable table) {
        String cmd = "SELECT * FROM NHA_CUNG_CAP WHERE SDT LIKE ?;";
        return getData2(table, cmd, text);
    }
    public static DefaultTableModel TK_HH_Dia_chi(String text, JTable table) {
        String cmd = "SELECT * FROM NHA_CUNG_CAP WHERE DIA_CHI LIKE ?;";
        return getData2(table, cmd, text);
    }

    public static DefaultTableModel getData2(JTable table_HH, String cmd, String selectedValue) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                st = connection.prepareStatement(cmd);
                st.setString(1, "%" + selectedValue + "%");
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã nhà cung cấp</b></html>");
                model.addColumn("<html><b>Tên nhà cung cấp</b></html>");
                model.addColumn("<html><b>Địa chỉ</b></html>");
                model.addColumn("<html><b>SDT</b></html>");                
                model.addColumn("<html><b>Gmail</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);

                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(200);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(200);
                table_HH.getColumnModel().getColumn(3).setPreferredWidth(90);
                table_HH.getColumnModel().getColumn(4).setPreferredWidth(90);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NHA_CUNG_CAP"), rs.getString("TEN_NHA_CUNG_CAP"), rs.getString("DIA_CHI"), rs.getString("SDT"), rs.getString("EMAIL")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Lỗi khi đóng ResultSet: " + e.getMessage());
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Lỗi khi đóng PreparedStatement: " + e.getMessage());
                }
            }
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
    
    
    public static DefaultTableModel TK_LHH_Ten(String text, JTable table) {
        String cmd = "SELECT * FROM LOAI_HH WHERE TEN_LOAI_HANG LIKE ?;";
        return getDataLHH(table, cmd, text);
    }

    public static DefaultTableModel TK_LHH_Ma_LHH(String text, JTable table) {
        String cmd = "SELECT * FROM LOAI_HH WHERE MA_LOAI_HANG LIKE ?;";
        return getDataLHH(table, cmd, text);
    }
    public static DefaultTableModel getDataLHH(JTable table_HH, String cmd, String selectedValue) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                st = connection.prepareStatement(cmd);
                st.setString(1, "%" + selectedValue + "%");
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã loại hàng hóa</b></html>");
                model.addColumn("<html><b>Tên loại hàng hóa</b></html>");
                model.addColumn("<html><b>Ghi chú</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);

                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);    
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(200);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(90);      

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                for (int i = 0; i < table_HH.getColumnCount(); i++) {
                    table_HH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_LOAI_HANG"), rs.getString("TEN_LOAI_HANG"), rs.getString("GHI_CHU")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Lỗi khi đóng ResultSet: " + e.getMessage());
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.err.println("Lỗi khi đóng PreparedStatement: " + e.getMessage());
                }
            }
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
