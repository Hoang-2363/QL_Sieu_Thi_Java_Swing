package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class KT_Thong_Ke {

    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";

    public static boolean TK_Thong_ke(String tu_ngay, String den_ngay) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (tu_ngay.isEmpty() || den_ngay.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin ngày tháng năm !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                
                if (!isValidDate(tu_ngay, den_ngay)) {
                    return false;
                }
                
                PreparedStatement st = connection.prepareStatement("SELECT CASE DATEPART(WEEKDAY, DR.Ngay) WHEN 1 THEN N'Chủ Nhật' WHEN 2 THEN N'Thứ Hai' WHEN 3 THEN N'Thứ Ba' WHEN 4 THEN N'Thứ Tư' WHEN 5 THEN N'Thứ Năm' "
                        + "WHEN 6 THEN N'Thứ Sáu' WHEN 7 THEN N'Thứ Bảy' ELSE N'Không xác định' END AS Thứ, CONVERT(NVARCHAR(10), DR.Ngay, 103) AS Ngày, CAST(COALESCE(CASE WHEN SUM(ISNULL(HH.GIA_BAN * BH_CT.SO_LUONG, 0)) = 0 THEN '' ELSE CAST(SUM(ISNULL(HH.GIA_BAN * BH_CT.SO_LUONG, 0)) AS VARCHAR(10)) END, '0') AS VARCHAR(10)) AS TONG_TIEN_HD "
                        + "FROM ( SELECT DATEADD(DAY, number, ?) AS Ngay FROM master.dbo.spt_values WHERE type = 'P' AND number >= 0 AND number < DATEDIFF(DAY, ?, ?)  ) DR LEFT JOIN HOA_DON_BH HDBH ON CAST(HDBH.NGAY_XUAT_HD AS DATE) = DR.Ngay "
                        + "LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH = BH_CT.MA_HD_BH LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG = HH.MA_HANG GROUP BY CONVERT(NVARCHAR(10), DR.Ngay, 103), DR.Ngay ORDER BY DR.Ngay;");
                st.setString(1, tu_ngay);
                st.setString(2, tu_ngay);               
                st.setString(3, den_ngay);
                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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
    
    
    public static DefaultTableModel TK_TK(JTable table_HH, String tu_ngay, String den_ngay) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT CASE DATEPART(WEEKDAY, DR.Ngay) WHEN 1 THEN N'Chủ Nhật' WHEN 2 THEN N'Thứ Hai' WHEN 3 THEN N'Thứ Ba' WHEN 4 THEN N'Thứ Tư' WHEN 5 THEN N'Thứ Năm' "
                        + "WHEN 6 THEN N'Thứ Sáu' WHEN 7 THEN N'Thứ Bảy' ELSE N'Không xác định' END AS Thứ, CONVERT(NVARCHAR(10), DR.Ngay, 103) AS Ngày, CAST(COALESCE(CASE WHEN SUM(ISNULL(HH.GIA_BAN * BH_CT.SO_LUONG, 0)) = 0 THEN '' ELSE CAST(SUM(ISNULL(HH.GIA_BAN * BH_CT.SO_LUONG, 0)) AS VARCHAR(10)) END, '0') AS VARCHAR(10)) AS TONG_TIEN_HD "
                        + "FROM ( SELECT DATEADD(DAY, number, ?) AS Ngay FROM master.dbo.spt_values WHERE type = 'P' AND number >= 0 AND number < DATEDIFF(DAY, ?, ?)  ) DR LEFT JOIN HOA_DON_BH HDBH ON CAST(HDBH.NGAY_XUAT_HD AS DATE) = DR.Ngay "
                        + "LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH = BH_CT.MA_HD_BH LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG = HH.MA_HANG GROUP BY CONVERT(NVARCHAR(10), DR.Ngay, 103), DR.Ngay ORDER BY DR.Ngay;");
                st.setString(1, tu_ngay);
                st.setString(2, tu_ngay);               
                st.setString(3, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Thứ</b></html>");
                model.addColumn("<html><b>Ngày</b></html>");
                model.addColumn("<html><b>Tổng tiền hóa đơn</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);
                table_HH.getColumnModel().getColumn(0).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(120);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(200);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("Thứ"), rs.getString("Ngày"), rs.getString("TONG_TIEN_HD")};
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
    
    
    public static boolean isValidDate(String s, String e) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            Date date = dateFormat.parse(s);
            Date dateq = dateFormat.parse(e);

            if (date.after(dateq)) {
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải trước ngày kết thúc.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            return true;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Định dạng ngày tháng không hợp lệ. Vui lòng sử dụng định dạng yyyy-MM-dd.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public static DefaultTableModel TK_TK_KH(JTable table_HH, String tu_ngay, String den_ngay, String ten_Kh) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT HDBH.MA_HD_BH, KH.TEN_KH, NV.HO_TEN_NV, FORMAT(HDBH.NGAY_XUAT_HD, 'HH:mm:ss') AS GIO, FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') AS NGAY, TRANG_THAI, CAST(COALESCE(CASE WHEN SUM(HH.GIA_BAN * BH_CT.SO_LUONG) = 0 THEN '' ELSE CAST(SUM(HH.GIA_BAN * BH_CT.SO_LUONG) AS VARCHAR(10)) END, '') AS VARCHAR(10)) AS TONG_TIEN_HD "
                        + "FROM HOA_DON_BH HDBH JOIN KHACH_HANG KH ON HDBH.MA_KH  = KH.MA_KH JOIN NHAN_VIEN NV ON HDBH.MA_NV  = NV.MA_NV LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH  = BH_CT.MA_HD_BH LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG  = HH.MA_HANG  "
                        + "WHERE KH.TEN_KH = ? AND FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') BETWEEN ? AND ? GROUP BY HDBH.MA_HD_BH, HDBH.MA_KH, KH.TEN_KH, HDBH.MA_NV, NV.HO_TEN_NV, HDBH.NGAY_XUAT_HD, TRANG_THAI ORDER BY HDBH.MA_HD_BH;");
                st.setString(1, ten_Kh);
                st.setString(2, tu_ngay);               
                st.setString(3, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã hóa đơn BH</b></html>");
                model.addColumn("<html><b>Tên khách hàng</b></html>");
                model.addColumn("<html><b>Tên nhân viên</b></html>");                
                model.addColumn("<html><b>Thời gian</b></html>");
                model.addColumn("<html><b>Ngày</b></html>");
                model.addColumn("<html><b>Trạng thái</b></html>");
                model.addColumn("<html><b>Tổng tiền hóa đơn</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);
                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(4).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(5).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(6).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HD_BH"), rs.getString("TEN_KH"), rs.getString("HO_TEN_NV"), rs.getString("GIO"), rs.getString("NGAY"), rs.getString("TRANG_THAI"),  rs.getString("TONG_TIEN_HD")};
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
    public static boolean isValidDate1(String s, String e) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            Date date = dateFormat.parse(s);
            Date dateq = dateFormat.parse(e);

            if (date.after(dateq)) {
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải trước ngày kết thúc.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            return true;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Định dạng ngày tháng không hợp lệ. Vui lòng sử dụng định dạng yyyy-MM-dd.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    public static DefaultTableModel TK_TK_NV(JTable table_HH, String tu_ngay, String den_ngay, String ten_Kh) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT HDBH.MA_HD_BH, KH.TEN_KH, NV.HO_TEN_NV, FORMAT(HDBH.NGAY_XUAT_HD, 'HH:mm:ss') AS GIO, FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') AS NGAY, TRANG_THAI, CAST(COALESCE(CASE WHEN SUM(HH.GIA_BAN * BH_CT.SO_LUONG) = 0 THEN '' ELSE CAST(SUM(HH.GIA_BAN * BH_CT.SO_LUONG) AS VARCHAR(10)) END, '') AS VARCHAR(10)) AS TONG_TIEN_HD "
                        + "FROM HOA_DON_BH HDBH JOIN KHACH_HANG KH ON HDBH.MA_KH  = KH.MA_KH JOIN NHAN_VIEN NV ON HDBH.MA_NV  = NV.MA_NV LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH  = BH_CT.MA_HD_BH LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG  = HH.MA_HANG  "
                        + "WHERE NV.HO_TEN_NV = ? AND FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') BETWEEN ? AND ? GROUP BY HDBH.MA_HD_BH, HDBH.MA_KH, KH.TEN_KH, HDBH.MA_NV, NV.HO_TEN_NV, HDBH.NGAY_XUAT_HD, TRANG_THAI ORDER BY HDBH.MA_HD_BH;");
                st.setString(1, ten_Kh);
                st.setString(2, tu_ngay);               
                st.setString(3, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã hóa đơn BH</b></html>");
                model.addColumn("<html><b>Tên khách hàng</b></html>");
                model.addColumn("<html><b>Tên nhân viên</b></html>");                
                model.addColumn("<html><b>Thời gian</b></html>");
                model.addColumn("<html><b>Ngày</b></html>");
                model.addColumn("<html><b>Trạng thái</b></html>");
                model.addColumn("<html><b>Tổng tiền hóa đơn</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);
                table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(4).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(5).setPreferredWidth(100);
                table_HH.getColumnModel().getColumn(6).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HD_BH"), rs.getString("TEN_KH"), rs.getString("HO_TEN_NV"), rs.getString("GIO"), rs.getString("NGAY"), rs.getString("TRANG_THAI"),  rs.getString("TONG_TIEN_HD")};
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
