package DAL;

import BLL.Save_Ma_NV;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Connect_TKe_$_BH {
    
    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
    public static DefaultTableModel TH_BH() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT CASE DATEPART(WEEKDAY, HDBH.NGAY_XUAT_HD) WHEN 1 THEN N'Chủ Nhật' WHEN 2 THEN N'Thứ Hai' WHEN 3 THEN N'Thứ Ba' WHEN 4 THEN N'Thứ Tư' "
                        + "WHEN 5 THEN N'Thứ Năm' WHEN 6 THEN N'Thứ Sáu' WHEN 7 THEN N'Thứ Bảy' ELSE N'Không xác định' END AS Thứ, CONVERT(NVARCHAR(10), HDBH.NGAY_XUAT_HD, 103) AS Ngày, SUM(HH.GIA_BAN * BH_CT.SO_LUONG) AS TONG_TIEN_HD "
                        + "FROM HOA_DON_BH HDBH JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH = BH_CT.MA_HD_BH JOIN HANG_HOA HH ON BH_CT.MA_HANG = HH.MA_HANG GROUP BY CONVERT(NVARCHAR(10), HDBH.NGAY_XUAT_HD, 103), DATEPART(WEEKDAY, HDBH.NGAY_XUAT_HD) ORDER BY Ngày;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Thứ</b></html>");
                model.addColumn("<html><b>Ngày</b></html>");
                model.addColumn("<html><b>Tổng tiền hóa đơn</b></html>");

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
    
    public static DefaultTableModel TK_Theo_Ngay() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HDBH.MA_HD_BH, KH.TEN_KH, NV.HO_TEN_NV, FORMAT(HDBH.NGAY_XUAT_HD, 'HH:mm:ss') AS GIO, FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') AS NGAY, TRANG_THAI, CAST(COALESCE(CASE WHEN SUM(HH.GIA_BAN * BH_CT.SO_LUONG) = 0 THEN '' ELSE CAST(SUM(HH.GIA_BAN * BH_CT.SO_LUONG) AS VARCHAR(10)) END, '') AS VARCHAR(10)) AS TONG_TIEN_HD FROM HOA_DON_BH HDBH JOIN KHACH_HANG KH ON HDBH.MA_KH  = KH.MA_KH  JOIN NHAN_VIEN NV ON HDBH.MA_NV  = NV.MA_NV  LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH  = BH_CT.MA_HD_BH  LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG  = HH.MA_HANG WHERE FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') = ? GROUP BY HDBH.MA_HD_BH, HDBH.MA_KH, KH.TEN_KH, HDBH.MA_NV, NV.HO_TEN_NV, HDBH.NGAY_XUAT_HD, TRANG_THAI ORDER BY HDBH.MA_HD_BH;");
                 st.setString(1, Save_Ma_NV.getNgay_TK());
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hóa đơn BH</b></html>");
                model.addColumn("<html><b>Tên khách hàng</b></html>");
                model.addColumn("<html><b>Tên nhân viên</b></html>");                
                model.addColumn("<html><b>Thời gian</b></html>");
                model.addColumn("<html><b>Ngày</b></html>");
                model.addColumn("<html><b>Trạng thái</b></html>");
                model.addColumn("<html><b>Tổng tiền hóa đơn</b></html>");


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
    
    public static DefaultTableModel TK_KH() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT KH.MA_KH, KH.TEN_KH, KH.SDT, KH.DIA_CHI, SUM(COALESCE(HH.GIA_BAN * BH_CT.SO_LUONG, 0)) AS TONG_TIEN_HD  "
                        + "FROM KHACH_HANG KH LEFT JOIN HOA_DON_BH HDBH ON KH.MA_KH = HDBH.MA_KH LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH = BH_CT.MA_HD_BH "
                        + "LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG = HH.MA_HANG GROUP BY KH.TEN_KH, KH.SDT, KH.DIA_CHI, KH.MA_KH ORDER BY TONG_TIEN_HD DESC;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã KH</b></html>");
                model.addColumn("<html><b>Họ tên KH</b></html>");
                model.addColumn("<html><b>SĐT</b></html>");
                model.addColumn("<html><b>Địa chỉ</b></html>");
                model.addColumn("<html><b>Tổng tiền</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_KH"), rs.getString("TEN_KH"), rs.getString("SDT"), rs.getString("DIA_CHI"), rs.getString("TONG_TIEN_HD")};
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
    
    public static DefaultTableModel TK_HD_Theo_KH() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HDBH.MA_HD_BH, KH.TEN_KH, NV.HO_TEN_NV, FORMAT(HDBH.NGAY_XUAT_HD, 'HH:mm:ss') AS GIO, FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') AS NGAY, TRANG_THAI, CAST(COALESCE(CASE WHEN SUM(HH.GIA_BAN * BH_CT.SO_LUONG) = 0 THEN '' ELSE CAST(SUM(HH.GIA_BAN * BH_CT.SO_LUONG) AS VARCHAR(10)) END, '') AS VARCHAR(10)) AS TONG_TIEN_HD FROM HOA_DON_BH HDBH JOIN KHACH_HANG KH ON HDBH.MA_KH  = KH.MA_KH  JOIN NHAN_VIEN NV ON HDBH.MA_NV  = NV.MA_NV  LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH  = BH_CT.MA_HD_BH  LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG  = HH.MA_HANG WHERE KH.TEN_KH = ? GROUP BY HDBH.MA_HD_BH, HDBH.MA_KH, KH.TEN_KH, HDBH.MA_NV, NV.HO_TEN_NV, HDBH.NGAY_XUAT_HD, TRANG_THAI ORDER BY HDBH.MA_HD_BH;");
                st.setString(1, Save_Ma_NV.getTk_ten_KH());
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hóa đơn BH</b></html>");
                model.addColumn("<html><b>Tên khách hàng</b></html>");
                model.addColumn("<html><b>Tên nhân viên</b></html>");                
                model.addColumn("<html><b>Thời gian</b></html>");
                model.addColumn("<html><b>Ngày</b></html>");
                model.addColumn("<html><b>Trạng thái</b></html>");
                model.addColumn("<html><b>Tổng tiền hóa đơn</b></html>");


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
    
    public static DefaultTableModel TK_HH_Ban() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.TEN_HANG, SUM(HD_BH_CT.SO_LUONG) AS SO_LUONG, HANG_HOA.DON_VI_TINH "
                        + "FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG "
                        + "GROUP BY HANG_HOA.TEN_HANG, HANG_HOA.DON_VI_TINH, HANG_HOA.GIA_BAN ORDER BY SO_LUONG DESC;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Tên hàng hóa</b></html>");
                model.addColumn("<html><b>Số lượng đã bán</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");       


                while (rs.next()) {
                    Object objList[] = {rs.getString("TEN_HANG"), rs.getString("SO_LUONG"), rs.getString("DON_VI_TINH")};
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
    
    public static DefaultTableModel TK_HH_Nhap() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.TEN_HANG, SUM(HD_NH_CT.SO_LUONG) AS SO_LUONG, HANG_HOA.DON_VI_TINH, HD_NH_CT.GIA_NHAP_HANG, (HD_NH_CT.GIA_NHAP_HANG*SUM(HD_NH_CT.SO_LUONG)) AS THANH_TIEN "
                        + "FROM HD_NH_CT INNER JOIN HANG_HOA ON HD_NH_CT.MA_HANG = HANG_HOA.MA_HANG "
                        + "GROUP BY HANG_HOA.TEN_HANG, HANG_HOA.DON_VI_TINH, HD_NH_CT.GIA_NHAP_HANG ORDER BY SO_LUONG DESC;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Tên hàng hóa</b></html>");
                model.addColumn("<html><b>Số lượng đã bán</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");   
                model.addColumn("<html><b>Giá nhập</b></html>");
                model.addColumn("<html><b>Thành tiền</b></html>");       

                while (rs.next()) {
                    Object objList[] = {rs.getString("TEN_HANG"), rs.getString("SO_LUONG"), rs.getString("DON_VI_TINH"), rs.getString("GIA_NHAP_HANG"), rs.getString("THANH_TIEN")};
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
    
    
    public static void TK_HH_Ban_Nha_Cung_Cap(JTable table_HH3) {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.MA_NHA_CUNG_CAP, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP, SUM(HD_BH_CT.SO_LUONG) AS SO_LUONG_DA_BAN "
                        + "FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG  INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP "
                        + "GROUP BY HANG_HOA.MA_NHA_CUNG_CAP, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP ORDER BY SO_LUONG_DA_BAN DESC;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã nhà cung cấp</b></html>");
                model.addColumn("<html><b>Tên nhà cung cấp</b></html>");
                model.addColumn("<html><b>Số lượng đã bán</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NHA_CUNG_CAP"), rs.getString("TEN_NHA_CUNG_CAP"), rs.getString("SO_LUONG_DA_BAN")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }
    
    public static void TK_HH_Ban_LHH(JTable table_HH3) {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG, SUM(HD_BH_CT.SO_LUONG) AS SO_LUONG_DA_BAN "
                        + "FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG "
                        + "GROUP BY HANG_HOA.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG ORDER BY SO_LUONG_DA_BAN DESC;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã loại hàng</b></html>");
                model.addColumn("<html><b>Tên loại hàng</b></html>");
                model.addColumn("<html><b>Số lượng đã bán</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_LOAI_HANG"), rs.getString("TEN_LOAI_HANG"), rs.getString("SO_LUONG_DA_BAN")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }
    
    public static void TK_HH_Nhap_Nha_Cung_Cap(JTable table_HH3) {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.MA_NHA_CUNG_CAP, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP, SUM(HD_NH_CT.SO_LUONG) AS SO_LUONG_DA_NHAP "
                        + "FROM HD_NH_CT INNER JOIN HANG_HOA ON HD_NH_CT.MA_HANG = HANG_HOA.MA_HANG  INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP "
                        + "GROUP BY HANG_HOA.MA_NHA_CUNG_CAP, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP ORDER BY SO_LUONG_DA_NHAP DESC;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã nhà cung cấp</b></html>");
                model.addColumn("<html><b>Tên nhà cung cấp</b></html>");
                model.addColumn("<html><b>Số lượng đã nhập</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NHA_CUNG_CAP"), rs.getString("TEN_NHA_CUNG_CAP"), rs.getString("SO_LUONG_DA_NHAP")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }
    
    public static void TK_HH_Nhap_LHH(JTable table_HH3) {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HANG_HOA.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG, SUM(HD_NH_CT.SO_LUONG) AS SO_LUONG_DA_NHAP "
                        + "FROM HD_NH_CT INNER JOIN HANG_HOA ON HD_NH_CT.MA_HANG = HANG_HOA.MA_HANG INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG "
                        + "GROUP BY HANG_HOA.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG ORDER BY SO_LUONG_DA_NHAP DESC;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã loại hàng</b></html>");
                model.addColumn("<html><b>Tên loại hàng</b></html>");
                model.addColumn("<html><b>Số lượng đã nhập</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_LOAI_HANG"), rs.getString("TEN_LOAI_HANG"), rs.getString("SO_LUONG_DA_NHAP")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        }
    }
    
    public static DefaultTableModel TK_Nhan_Vien() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT KH.MA_NV, KH.HO_TEN_NV, KH.SDT, KH.DIA_CHI, SUM(COALESCE(HH.GIA_BAN * BH_CT.SO_LUONG, 0)) AS TONG_TIEN_HD  "
                        + "FROM NHAN_VIEN KH LEFT JOIN HOA_DON_BH HDBH ON KH.MA_NV = HDBH.MA_NV LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH = BH_CT.MA_HD_BH "
                        + "LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG = HH.MA_HANG GROUP BY KH.MA_NV, KH.SDT, KH.DIA_CHI, KH.HO_TEN_NV ORDER BY TONG_TIEN_HD DESC;");
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã NV</b></html>");
                model.addColumn("<html><b>Họ tên NV</b></html>");
                model.addColumn("<html><b>SĐT</b></html>");
                model.addColumn("<html><b>Địa chỉ</b></html>");
                model.addColumn("<html><b>Tổng tiền</b></html>");

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NV"), rs.getString("HO_TEN_NV"), rs.getString("SDT"), rs.getString("DIA_CHI"), rs.getString("TONG_TIEN_HD")};
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
    
    public static DefaultTableModel TK_HD_Theo_NV() {
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel();
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                PreparedStatement st = connection.prepareStatement("SELECT HDBH.MA_HD_BH, KH.TEN_KH, NV.HO_TEN_NV, FORMAT(HDBH.NGAY_XUAT_HD, 'HH:mm:ss') AS GIO, FORMAT(HDBH.NGAY_XUAT_HD, 'dd/MM/yyyy') AS NGAY, TRANG_THAI, CAST(COALESCE(CASE WHEN SUM(HH.GIA_BAN * BH_CT.SO_LUONG) = 0 THEN '' ELSE CAST(SUM(HH.GIA_BAN * BH_CT.SO_LUONG) AS VARCHAR(10)) END, '') AS VARCHAR(10)) AS TONG_TIEN_HD FROM HOA_DON_BH HDBH JOIN KHACH_HANG KH ON HDBH.MA_KH  = KH.MA_KH  JOIN NHAN_VIEN NV ON HDBH.MA_NV  = NV.MA_NV  LEFT JOIN HD_BH_CT BH_CT ON HDBH.MA_HD_BH  = BH_CT.MA_HD_BH  LEFT JOIN HANG_HOA HH ON BH_CT.MA_HANG  = HH.MA_HANG WHERE NV.HO_TEN_NV = ? GROUP BY HDBH.MA_HD_BH, HDBH.MA_KH, KH.TEN_KH, HDBH.MA_NV, NV.HO_TEN_NV, HDBH.NGAY_XUAT_HD, TRANG_THAI ORDER BY HDBH.MA_HD_BH;");
                st.setString(1, Save_Ma_NV.getTk_ten_KH());
                ResultSet rs = st.executeQuery();

                model.addColumn("<html><b>Mã hóa đơn BH</b></html>");
                model.addColumn("<html><b>Tên khách hàng</b></html>");
                model.addColumn("<html><b>Tên nhân viên</b></html>");                
                model.addColumn("<html><b>Thời gian</b></html>");
                model.addColumn("<html><b>Ngày</b></html>");
                model.addColumn("<html><b>Trạng thái</b></html>");
                model.addColumn("<html><b>Tổng tiền hóa đơn</b></html>");


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
    
  
    public static DefaultTableModel Tim_kiem_Theo_ngay_LHH(JTable table_HH3, String tu_ngay, String den_ngay) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT HANG_HOA.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG, SUM(HD_BH_CT.SO_LUONG) AS SO_LUONG_DA_BAN "
                        + "FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG "
                        + "WHERE MA_HD_BH IN ( SELECT MA_HD_BH FROM HOA_DON_BH WHERE NGAY_XUAT_HD >= ? AND NGAY_XUAT_HD < DATEADD(DAY, 1, ?) "
                        + ") GROUP BY HANG_HOA.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG ORDER BY SO_LUONG_DA_BAN DESC;");
                st.setString(1, tu_ngay);               
                st.setString(2, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã loại hàng</b></html>");
                model.addColumn("<html><b>Tên loại hàng</b></html>");
                model.addColumn("<html><b>Số lượng đã bán</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_LOAI_HANG"), rs.getString("TEN_LOAI_HANG"), rs.getString("SO_LUONG_DA_BAN")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } 
        return model;
    }
    
    public static DefaultTableModel Tim_kiem_Theo_Ngay_Ten(JTable table_HH3, String tu_ngay, String den_ngay) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT HANG_HOA.TEN_HANG, SUM(HD_BH_CT.SO_LUONG) AS SO_LUONG, HANG_HOA.DON_VI_TINH "
                        + "FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG "
                        + "WHERE MA_HD_BH IN ( SELECT MA_HD_BH FROM HOA_DON_BH WHERE NGAY_XUAT_HD >= ? AND NGAY_XUAT_HD < DATEADD(DAY, 1, ?) "
                        + ") GROUP BY HANG_HOA.TEN_HANG, HANG_HOA.DON_VI_TINH ORDER BY SO_LUONG DESC;");
                st.setString(1, tu_ngay);               
                st.setString(2, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Tên hàng</b></html>");
                model.addColumn("<html><b>Số lượng</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("TEN_HANG"), rs.getString("SO_LUONG"), rs.getString("DON_VI_TINH")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } 
        return model;
    }
    
    public static DefaultTableModel Tim_kiem_Theo_ngay_NCC(JTable table_HH3, String tu_ngay, String den_ngay) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT HANG_HOA.MA_NHA_CUNG_CAP, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP, SUM(HD_BH_CT.SO_LUONG) AS SO_LUONG_DA_BAN "
                        + "FROM HD_BH_CT INNER JOIN HANG_HOA ON HD_BH_CT.MA_HANG = HANG_HOA.MA_HANG  INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP "
                        + "WHERE MA_HD_BH IN ( SELECT MA_HD_BH FROM HOA_DON_BH WHERE NGAY_XUAT_HD >= ? AND NGAY_XUAT_HD < DATEADD(DAY, 1, ?) "
                        + ") GROUP BY HANG_HOA.MA_NHA_CUNG_CAP, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP ORDER BY SO_LUONG_DA_BAN DESC;");
                st.setString(1, tu_ngay);               
                st.setString(2, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã nhà cung cấp</b></html>");
                model.addColumn("<html><b>Tên nhà cung cấp</b></html>");
                model.addColumn("<html><b>Số lượng đã bán</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NHA_CUNG_CAP"), rs.getString("TEN_NHA_CUNG_CAP"), rs.getString("SO_LUONG_DA_BAN")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } 
        return model;
    }
    
    
    public static DefaultTableModel Tim_kiem_Theo_ngay_Nhap_LHH(JTable table_HH3, String tu_ngay, String den_ngay) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT HANG_HOA.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG, SUM(HD_NH_CT.SO_LUONG) AS SO_LUONG_DA_NHAP "
                        + "FROM HD_NH_CT INNER JOIN HANG_HOA ON HD_NH_CT.MA_HANG = HANG_HOA.MA_HANG INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG "
                        + "WHERE MA_HD_NH IN ( SELECT MA_HD_NH FROM HOA_DON_NH WHERE NGAY_NHAP_HANG >= ? AND NGAY_NHAP_HANG < DATEADD(DAY, 1, ?) "
                        + ") GROUP BY HANG_HOA.MA_LOAI_HANG, LOAI_HH.TEN_LOAI_HANG ORDER BY SO_LUONG_DA_NHAP DESC;");
                st.setString(1, tu_ngay);               
                st.setString(2, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã loại hàng</b></html>");
                model.addColumn("<html><b>Tên loại hàng</b></html>");
                model.addColumn("<html><b>Số lượng đã nhập</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_LOAI_HANG"), rs.getString("TEN_LOAI_HANG"), rs.getString("SO_LUONG_DA_NHAP")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } 
        return model;
    }
    
    public static DefaultTableModel Tim_kiem_Theo_Ngay_Nhap_Ten(JTable table_HH3, String tu_ngay, String den_ngay) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT HANG_HOA.TEN_HANG, SUM(HD_NH_CT.SO_LUONG) AS SO_LUONG, HANG_HOA.DON_VI_TINH, HD_NH_CT.GIA_NHAP_HANG, (HD_NH_CT.GIA_NHAP_HANG*SUM(HD_NH_CT.SO_LUONG)) AS THANH_TIEN "
                        + "FROM HD_NH_CT INNER JOIN HANG_HOA ON HD_NH_CT.MA_HANG = HANG_HOA.MA_HANG "
                        + "WHERE MA_HD_NH IN ( SELECT MA_HD_NH FROM HOA_DON_NH WHERE NGAY_NHAP_HANG >= ? AND NGAY_NHAP_HANG < DATEADD(DAY, 1, ?) "
                        + ") GROUP BY HANG_HOA.TEN_HANG, HANG_HOA.DON_VI_TINH, HD_NH_CT.GIA_NHAP_HANG ORDER BY SO_LUONG DESC;");
                st.setString(1, tu_ngay);               
                st.setString(2, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Tên hàng</b></html>");
                model.addColumn("<html><b>Số lượng</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");   
                model.addColumn("<html><b>Giá nhập</b></html>");
                model.addColumn("<html><b>Thành tiền</b></html>");  
                
                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(100);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);
                table_HH3.getColumnModel().getColumn(3).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(4).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("TEN_HANG"), rs.getString("SO_LUONG"), rs.getString("DON_VI_TINH"), rs.getString("GIA_NHAP_HANG"), rs.getString("THANH_TIEN")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } 
        return model;
    }
    
    public static DefaultTableModel Tim_kiem_Theo_ngay_Nhap_NCC(JTable table_HH3, String tu_ngay, String den_ngay) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);

            if (connection != null) {
                st = connection.prepareStatement("SELECT HANG_HOA.MA_NHA_CUNG_CAP, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP, SUM(HD_NH_CT.SO_LUONG) AS SO_LUONG_DA_NHAP "
                        + "FROM HD_NH_CT INNER JOIN HANG_HOA ON HD_NH_CT.MA_HANG = HANG_HOA.MA_HANG  INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP "
                        + "WHERE MA_HD_NH IN ( SELECT MA_HD_NH FROM HOA_DON_NH WHERE NGAY_NHAP_HANG >= ? AND NGAY_NHAP_HANG < DATEADD(DAY, 1, ?) "
                        + ") GROUP BY HANG_HOA.MA_NHA_CUNG_CAP, NHA_CUNG_CAP.TEN_NHA_CUNG_CAP ORDER BY SO_LUONG_DA_NHAP DESC;");
                st.setString(1, tu_ngay);               
                st.setString(2, den_ngay);
                rs = st.executeQuery();

                model.addColumn("<html><b>Mã nhà cung cấp</b></html>");
                model.addColumn("<html><b>Tên nhà cung cấp</b></html>");
                model.addColumn("<html><b>Số lượng đã nhập</b></html>");       

                table_HH3.setModel(model);
                table_HH3.setRowHeight(30);
                table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
                table_HH3.getColumnModel().getColumn(1).setPreferredWidth(130);
                table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_NHA_CUNG_CAP"), rs.getString("TEN_NHA_CUNG_CAP"), rs.getString("SO_LUONG_DA_NHAP")};
                    model.addRow(objList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối đến cơ sở dữ liệu: " + e.getMessage());
        } 
        return model;
    }
    
}
