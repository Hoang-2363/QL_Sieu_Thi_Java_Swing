
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


public class KT_KT_Ton {
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    
    public static DefaultTableModel KT_Ton(JTable table_HH, String sl) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                st = connection.prepareStatement("SELECT * FROM HANG_HOA WHERE SO_LUONG_TON = ?;");
                st.setString(1, sl);
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã hàng hóa</b></html>");
                model.addColumn("<html><b>Tên hàng hóa</b></html>");                
                model.addColumn("<html><b>Giá nhập</b></html>");
                model.addColumn("<html><b>Giá bán</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");
                model.addColumn("<html><b>Số lượng tồn</b></html>");
                model.addColumn("<html><b>Ghi chú</b></html>");
                model.addColumn("<html><b>Mã loại hàng</b></html>");
                model.addColumn("<html><b>Mã NC cấp</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);
                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(160);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(4).setPreferredWidth(90);
                table_HH.getColumnModel().getColumn(5).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(6).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(7).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(8).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
            
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HANG"), rs.getString("TEN_HANG"), rs.getString("GIA_NHAP"), 
                        rs.getString("GIA_BAN"), rs.getString("DON_VI_TINH"), rs.getString("SO_LUONG_TON"), 
                        rs.getString("GHI_CHU"), rs.getString("MA_NHA_CUNG_CAP"), rs.getString("MA_LOAI_HANG")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu 1: " + e.getMessage());
        } 
        return model;
    }
}
