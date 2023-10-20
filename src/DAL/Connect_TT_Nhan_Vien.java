package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Connect_TT_Nhan_Vien {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    public static void load_Ma_NV(JTextField  Ma_NV, JTextField  Ho_Ten_NV, JTextField  Luong, JTextField  Dia_Chi, JTextField  SDT, JTextField Gmail, String tk, String mk) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement stmt = conn.prepareStatement("SELECT NHAN_VIEN.MA_NV, HO_TEN_NV, LUONG, DIA_CHI, SDT, EMAIL FROM NHAN_VIEN INNER JOIN NGUOI_DUNG ON NHAN_VIEN.MA_NV = NGUOI_DUNG.MA_NV  WHERE TAI_KHOAN = ? AND MAT_KHAU = ?;");
            stmt.setString(1, tk);
            stmt.setString(2, mk);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String item1 = rs.getString("MA_NV");                
                String item2 = rs.getString("HO_TEN_NV");
                String item3 = rs.getString("LUONG");
                String item4 = rs.getString("DIA_CHI");
                String item5 = rs.getString("SDT");
                String item6 = rs.getString("EMAIL");
                
                Ma_NV.setText(item1);    
                Ho_Ten_NV.setText(item2);
                Luong.setText(item3);
                Dia_Chi.setText(item4);
                SDT.setText(item5);
                Gmail.setText(item6);
            }
        } catch (SQLException e) {
        }
    }
    public static void load_TK(JTextField  TK, String tk, String mk) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement stmt = conn.prepareStatement("SELECT TAI_KHOAN FROM NGUOI_DUNG WHERE TAI_KHOAN = ? AND MAT_KHAU = ?;");
            stmt.setString(1, tk);
            stmt.setString(2, mk);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String item1 = rs.getString("TAI_KHOAN"); 
                TK.setText(item1);  
            }
        } catch (SQLException e) {
        }
    }
    public static DefaultTableModel getData1(JTable table_HH, String tk, String mk) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                st = connection.prepareStatement("SELECT NHAN_VIEN.MA_NV, HO_TEN_NV, LUONG, DIA_CHI, SDT, EMAIL FROM NHAN_VIEN INNER JOIN NGUOI_DUNG ON NHAN_VIEN.MA_NV = NGUOI_DUNG.MA_NV  WHERE TAI_KHOAN = ? AND MAT_KHAU = ?;");
                st.setString(1, tk);                
                st.setString(2, mk);
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã NV</b></html>");
                model.addColumn("<html><b>Họ tên NV</b></html>");
                model.addColumn("<html><b>Lương</b></html>");
                model.addColumn("<html><b>Địa chỉ</b></html>");
                model.addColumn("<html><b>Số điện thoại</b></html>");                
                model.addColumn("<html><b>Gmail</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);

                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(60);
                table_HH.getColumnModel().getColumn(3).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(4).setPreferredWidth(80);                
                table_HH.getColumnModel().getColumn(5).setPreferredWidth(130);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);

                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);                
                table_HH.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);                
                table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NV"), rs.getString("HO_TEN_NV"), rs.getString("LUONG"), rs.getString("DIA_CHI"), rs.getString("SDT"), rs.getString("EMAIL")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu 1: " + e.getMessage());
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
