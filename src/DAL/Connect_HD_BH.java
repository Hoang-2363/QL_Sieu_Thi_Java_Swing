package DAL;

import BLL.Save_Ma_NV;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Connect_HD_BH {

    public static DefaultTableModel getData() {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HDBH.MA_HD_BH, KH.TEN_KH, NV.HO_TEN_NV, FORMAT(HDBH.NGAY_XUAT_HD, 'HH:mm:ss') AS GIO, FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') AS NGAY, TRANG_THAI, CAST(COALESCE(CASE WHEN SUM(HH.GIA_BAN * BH_CT.SO_LUONG) = 0 THEN '' ELSE CAST(SUM(HH.GIA_BAN * BH_CT.SO_LUONG) AS VARCHAR(10)) END, '') AS VARCHAR(10)) AS TONG_TIEN_HD FROM HOA_DON_BH HDBH JOIN KHACH_HANG KH ON HDBH.MA_KH  = KH.MA_KH  JOIN NHAN_VIEN NV ON HDBH.MA_NV  = NV.MA_NV  LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH  = BH_CT.MA_HD_BH  LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG  = HH.MA_HANG  GROUP BY HDBH.MA_HD_BH, HDBH.MA_KH, KH.TEN_KH, HDBH.MA_NV, NV.HO_TEN_NV, HDBH.NGAY_XUAT_HD, TRANG_THAI ORDER BY HDBH.MA_HD_BH;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hóa đơn BH</b></html>");
                model.addColumn("<html><b>Tên khách hàng</b></html>");
                model.addColumn("<html><b>Tên nhân viên</b></html>");
                model.addColumn("<html><b>Thời gian</b></html>");
                model.addColumn("<html><b>Ngày</b></html>");
                model.addColumn("<html><b>Trạng thái</b></html>");
                model.addColumn("<html><b>Tổng tiền hóa đơn</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HD_BH"), rs.getString("TEN_KH"), rs.getString("HO_TEN_NV"), rs.getString("GIO"), rs.getString("NGAY"), rs.getString("TRANG_THAI"), rs.getString("TONG_TIEN_HD")};
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
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.TEN_HANG, SO_LUONG, DON_VI_TINH, GIA_BAN, SO_LUONG*GIA_BAN AS THANH_TIEN  FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG WHERE MA_HD_BH = ?;");
                st.setString(1, Save_Ma_NV.getMa_HD_BH_1());
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Tên hàng hóa</b></html>");
                model.addColumn("<html><b>Số lượng</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");
                model.addColumn("<html><b>Giá bán</b></html>");
                model.addColumn("<html><b>Thành tiền</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("TEN_HANG"), rs.getString("SO_LUONG"), rs.getString("DON_VI_TINH"), rs.getString("GIA_BAN"), rs.getString("THANH_TIEN")};
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

    public static DefaultTableModel getData3() {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                PreparedStatement st2 = connection.prepareStatement("SELECT TOP 1 MA_HD_BH FROM HOA_DON_BH ORDER BY MA_HD_BH DESC;");
                ResultSet rs = st2.executeQuery();
                if (rs.next()) {
                    String item = rs.getString("MA_HD_BH");
                    Save_Ma_NV.setMa_HD_BH_2(item);

                    PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.TEN_HANG, SO_LUONG, DON_VI_TINH, GIA_BAN, SO_LUONG*GIA_BAN AS THANH_TIEN  FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG WHERE MA_HD_BH = ?;");
                    st.setString(1, Save_Ma_NV.getMa_HD_BH_2());
                    ResultSet rs1 = st.executeQuery();
                    if (rs1.next()) {
                        model.addColumn("<html><b>Tên hàng hóa</b></html>");
                        model.addColumn("<html><b>Số lượng</b></html>");
                        model.addColumn("<html><b>Đơn vị tính</b></html>");
                        model.addColumn("<html><b>Giá bán</b></html>");
                        model.addColumn("<html><b>Thành tiền</b></html>");

                        do {
                            Object objList[] = {rs1.getString("TEN_HANG"), rs1.getString("SO_LUONG"), rs1.getString("DON_VI_TINH"), rs1.getString("GIA_BAN"), rs1.getString("THANH_TIEN")};
                            model.addRow(objList);
                        } while (rs1.next());
                    }
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

    public static void Load_TT(JTextField ma_HD_BH, JTextField thoi_Gian, JTextField ten_Nv, JTextField Ten_KH, JTextField SDT, JTextField Dia_chi) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                PreparedStatement st2 = connection.prepareStatement("SELECT TOP 1 MA_HD_BH FROM HOA_DON_BH ORDER BY MA_HD_BH DESC;");
                ResultSet rs = st2.executeQuery();
                if (rs.next()) {
                    String item = rs.getString("MA_HD_BH");
                    Save_Ma_NV.setMa_HD_BH_2(item);
                    ma_HD_BH.setText(item);

                    PreparedStatement st = connection.prepareStatement("SELECT MA_HD_BH, FORMAT(NGAY_XUAT_HD, 'HH:mm:ss dd/MM/yyyy') AS NGAY_XUAT_HD, NHAN_VIEN.HO_TEN_NV, KHACH_HANG.TEN_KH, KHACH_HANG.SDT, KHACH_HANG.DIA_CHI "
                            + "FROM HOA_DON_BH INNER JOIN KHACH_HANG ON HOA_DON_BH.MA_KH = KHACH_HANG.MA_KH INNER JOIN NHAN_VIEN ON HOA_DON_BH.MA_NV = NHAN_VIEN.MA_NV "
                            + " WHERE MA_HD_BH = ?;");
                    st.setString(1, Save_Ma_NV.getMa_HD_BH_2());
                    ResultSet rs1 = st.executeQuery();
                    if (rs1.next()) {
                        thoi_Gian.setText(rs1.getString("NGAY_XUAT_HD"));
                        ten_Nv.setText(rs1.getString("HO_TEN_NV"));
                        Ten_KH.setText(rs1.getString("TEN_KH"));
                        SDT.setText(rs1.getString("SDT"));
                        Dia_chi.setText(rs1.getString("DIA_CHI"));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }

}
