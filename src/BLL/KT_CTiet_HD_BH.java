package BLL;

import static com.microsoft.sqlserver.jdbc.StringUtils.isInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class KT_CTiet_HD_BH {

    private static final String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";

    public static void load_ma_HH(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        String ten_HH = (String) comboBox1.getSelectedItem();
        try {
            if (comboBox1.getSelectedItem().equals(ten_HH)) {
                Connection conn = DriverManager.getConnection(connectionUrl);
                PreparedStatement stmt = conn.prepareStatement("SELECT MA_HANG FROM HANG_HOA WHERE TEN_HANG = ?");
                stmt.setString(1, ten_HH);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String item = rs.getString("MA_HANG");
                    comboBox2.setSelectedItem(item);
                }
            }
        } catch (SQLException e) {
        }
    }

    public static void load_ten_HH(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        String ma_HH = (String) comboBox1.getSelectedItem();
        try {
            if (comboBox1.getSelectedItem().equals(ma_HH)) {
                Connection conn = DriverManager.getConnection(connectionUrl);
                PreparedStatement stmt = conn.prepareStatement("SELECT TEN_HANG FROM HANG_HOA WHERE MA_HANG = ?");
                stmt.setString(1, ma_HH);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String item = rs.getString("TEN_HANG");
                    comboBox2.setSelectedItem(item);
                }
            }
        } catch (SQLException e) {
        }
    }

    public static boolean them_CTiet_HD_BH(String maHH, String soluong_ban) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maHH.isEmpty() || soluong_ban.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin hàng hóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } else if (!isInteger(soluong_ban)) {
                    JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    PreparedStatement kt1 = connection.prepareStatement("SELECT COUNT(*) FROM HD_BH_CT WHERE MA_HANG = ? AND MA_HD_BH IS NULL");
                    kt1.setString(1, maHH);
                    ResultSet resultSet1 = kt1.executeQuery();
                    if (resultSet1.next()) {
                        int rowCount = resultSet1.getInt(1);
                        if (rowCount > 0) {
                            String message = "Mã hàng hóa " + maHH + " đã có rồi, bạn hãy chọn và sửa lại !!!";
                            JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                            return false;
                        }
                    }
                }

                PreparedStatement kt2 = connection.prepareStatement("SELECT SO_LUONG_TON FROM HANG_HOA WHERE MA_HANG = ?");
                kt2.setString(1, maHH);
                ResultSet resultSet2 = kt2.executeQuery();
                if (resultSet2.next()) {
                    int soLuongTon = resultSet2.getInt("SO_LUONG_TON");
                    int soLuongBan = Integer.parseInt(soluong_ban);
                    if (soLuongBan <= 0) {
                        JOptionPane.showMessageDialog(null, "Số lượng không thể nhỏ hơn 0 !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else if (soLuongTon < soLuongBan) {
                        JOptionPane.showMessageDialog(null, "Số lượng tồn chỉ có " + soLuongTon + " không đủ để bán !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else {
                        PreparedStatement st = connection.prepareStatement("INSERT INTO HD_BH_CT (MA_HD_BH, MA_HANG, SO_LUONG) VALUES (NULL, ?, ?)");
                        st.setString(1, maHH);
                        st.setString(2, soluong_ban);
                        int rowsInserted = st.executeUpdate();

                        PreparedStatement st1 = connection.prepareStatement("UPDATE HANG_HOA SET SO_LUONG_TON = (SO_LUONG_TON - ?) WHERE MA_HANG = ?;");
                        st1.setString(1, soluong_ban);
                        st1.setString(2, maHH);
                        int rowsInserted1 = st1.executeUpdate();

                        if (rowsInserted > 0 && rowsInserted1 > 0) {
                            return true;
                        }
                    }
                    return false;
                }
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc đặt hàng hóa: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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

    public static boolean sua_CTiet_HD(String maHH, String soluong_mua, String soluong_ton) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maHH.isEmpty() || soluong_mua.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin hàng hóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                } else if (!isInteger(soluong_mua)) {
                    JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }

                PreparedStatement kt2 = connection.prepareStatement("SELECT SO_LUONG_TON FROM HANG_HOA WHERE MA_HANG = ?");
                kt2.setString(1, maHH);
                ResultSet resultSet2 = kt2.executeQuery();
                if (resultSet2.next()) {
                    int soLuongTon_TT = resultSet2.getInt("SO_LUONG_TON");
                    int soLuongDaMua = Integer.parseInt(soluong_ton);
                    int soLuongBan = Integer.parseInt(soluong_mua);
                    if (soLuongBan <= 0) {
                        JOptionPane.showMessageDialog(null, "Số lượng không thể nhỏ hơn 0 !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else if ((soLuongTon_TT + soLuongDaMua) < soLuongBan) {
                        JOptionPane.showMessageDialog(null, "Số lượng tồn chỉ có " + soLuongTon_TT + " không đủ để bán thêm !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else {
                        PreparedStatement st = connection.prepareStatement("UPDATE HD_BH_CT SET SO_LUONG = ? WHERE MA_HANG = ? AND MA_HD_BH IS NULL;");
                        st.setString(1, soluong_mua);
                        st.setString(2, maHH);
                        int rowsInserted = st.executeUpdate();

                        PreparedStatement st1 = connection.prepareStatement("UPDATE HANG_HOA SET SO_LUONG_TON = (SO_LUONG_TON + ? - ?) WHERE MA_HANG = ?;");
                        st1.setString(1, soluong_ton);
                        st1.setString(2, soluong_mua);
                        st1.setString(3, maHH);
                        int rowsInserted1 = st1.executeUpdate();

                        if (rowsInserted > 0 && rowsInserted1 > 0) {
                            return true;
                        }
                    }
                    return false;
                }

                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc sửa hàng hóa: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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

    public static boolean xoa_CTiet_HD(String maHH, String soluong) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maHH.isEmpty() || soluong.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng hóa cần xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                PreparedStatement st = connection.prepareStatement("DELETE FROM HD_BH_CT WHERE MA_HANG = ? AND MA_HD_BH IS NULL");
                st.setString(1, maHH);

                PreparedStatement st1 = connection.prepareStatement("UPDATE HANG_HOA SET SO_LUONG_TON = (SO_LUONG_TON + ?) WHERE MA_HANG = ?;");
                st1.setString(1, soluong);
                st1.setString(2, maHH);

                int rowsInserted1 = st1.executeUpdate();
                int rowsInserted = st.executeUpdate();
                if (rowsInserted > 0 && rowsInserted1 > 0) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Không còn hàng hóa nào để xóa !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc thêm khách hàng: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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

    public static void load_TK_HH(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        comboBox1.removeAllItems();
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            String query = "";
            if (comboBox2.getSelectedItem().equals("Tên hàng")) {
                query = "SELECT TEN_HANG FROM HANG_HOA";
            } else if (comboBox2.getSelectedItem().equals("Loại hàng hóa")) {
                query = "SELECT TEN_LOAI_HANG FROM LOAI_HH";
            } else if (comboBox2.getSelectedItem().equals("Nhà cung cấp")) {
                query = "SELECT TEN_NHA_CUNG_CAP FROM NHA_CUNG_CAP";
            }
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String item = rs.getString(1);
                comboBox1.addItem(item);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
        }
    }

    public static DefaultTableModel TK_HH_Ten_HH(JComboBox<String> comboBox1, JTable table) {
        String selectedValue = (String) comboBox1.getSelectedItem();
        String cmd = "SELECT MA_HANG, TEN_HANG, DON_VI_TINH, SO_LUONG_TON, GIA_BAN FROM HANG_HOA WHERE TEN_HANG = ?";
        return getData1(table, cmd, selectedValue);
    }

    public static DefaultTableModel TK_HH_NCC(JComboBox<String> comboBox1, JTable table) {
        String selectedValue = (String) comboBox1.getSelectedItem();
        String cmd = "SELECT MA_HANG, TEN_HANG, DON_VI_TINH, SO_LUONG_TON, GIA_BAN FROM HANG_HOA INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP WHERE TEN_NHA_CUNG_CAP = ?;";
        return getData1(table, cmd, selectedValue);
    }

    public static DefaultTableModel TK_HH_LHH(JComboBox<String> comboBox1, JTable table) {
        String selectedValue = (String) comboBox1.getSelectedItem();
        String cmd = "SELECT MA_HANG, TEN_HANG, DON_VI_TINH, SO_LUONG_TON, GIA_BAN FROM HANG_HOA INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG WHERE TEN_LOAI_HANG = ?;";
        return getData1(table, cmd, selectedValue);
    }

    public static DefaultTableModel getData1(JTable table_HH, String cmd, String selectedValue) {
        DefaultTableModel model = new DefaultTableModel();

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                st = connection.prepareStatement(cmd);
                st.setString(1, selectedValue);
                rs = st.executeQuery();

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

    public static DefaultTableModel TK_HH_Ten_KH(JTextField text, JTable table) {
        String selectedValue = text.getText();
        String cmd = "SELECT * FROM KHACH_HANG WHERE TEN_KH LIKE ?;";
        return getData2(table, cmd, selectedValue);
    }

    public static DefaultTableModel TK_HH_SDT(JTextField text, JTable table) {
        String selectedValue = text.getText();
        String cmd = "SELECT * FROM KHACH_HANG WHERE SDT LIKE ?;";
        return getData2(table, cmd, selectedValue);
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

                model.addColumn("<html><b>Mã KH</b></html>");
                model.addColumn("<html><b>Họ tên KH</b></html>");
                model.addColumn("<html><b>Số điện thoại</b></html>");
                model.addColumn("<html><b>Địa chỉ</b></html>");

                table_HH.setModel(model);
                table_HH.setRowHeight(30);

                table_HH.getColumnModel().getColumn(0).setPreferredWidth(50);
                table_HH.getColumnModel().getColumn(1).setPreferredWidth(150);
                table_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
                table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);

                for (int i = 0; i < table_HH.getColumnCount(); i++) {
                    table_HH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                while (rs.next()) {
                    Object objList[] = {rs.getString("MA_KH"), rs.getString("TEN_KH"), rs.getString("SDT"), rs.getString("DIA_CHI")};
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

    public static boolean events_Close() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                PreparedStatement kt1 = connection.prepareStatement("SELECT COUNT(MA_HANG) FROM HD_BH_CT WHERE MA_HD_BH IS NULL;");
                ResultSet resultSet1 = kt1.executeQuery();
                if (resultSet1.next()) {
                    int rowCount = resultSet1.getInt(1);
                    if (rowCount > 0) {
                        return true;
                    }
                }
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc thoát hóa đơn: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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
    public static boolean them_HD_BH(String maKH, String maNV) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl);
            if (connection != null) {
                if (maKH.isEmpty() || maNV.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin khách hàng !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

                PreparedStatement checkSDTStatement = connection.prepareStatement("SELECT COUNT(MA_HANG) FROM HD_BH_CT WHERE MA_HD_BH IS NULL;");
                ResultSet resultSet = checkSDTStatement.executeQuery();
                if (resultSet.next()) {
                    int rowCount = resultSet.getInt(1);
                    if (rowCount == 0) {
                        String message = "Hãy mua 1 hàng hóa !!!";
                        JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }

                PreparedStatement st = connection.prepareStatement("INSERT INTO HOA_DON_BH (MA_HD_BH, NGAY_XUAT_HD, MA_KH, MA_NV, TRANG_THAI) VALUES ('HD_BH_' + RIGHT('00' + CAST(NEXT VALUE FOR HoaDonBH_Seq AS NVARCHAR(3)), 2), GETDATE(), ?, ?, N'Đã thanh toán')");
                st.setString(1, maKH);
                st.setString(2, maNV);
                int rowsInserted = st.executeUpdate();

                if (rowsInserted > 0) {
                    PreparedStatement st2 = connection.prepareStatement("SELECT TOP 1 MA_HD_BH FROM HOA_DON_BH ORDER BY MA_HD_BH DESC;");
                    ResultSet rs = st2.executeQuery();
                    if (rs.next()) {
                        String item = rs.getString("MA_HD_BH");
                        Save_Ma_NV.setMa_HD_BH(item);

                        PreparedStatement st1 = connection.prepareStatement("UPDATE HD_BH_CT SET MA_HD_BH = ? WHERE MA_HD_BH IS NULL;");
                        st1.setString(1, Save_Ma_NV.getMa_HD_BH());
                        int rowsInserted1 = st1.executeUpdate();

                        if (rowsInserted1 > 0) {
                            return true;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối đến cơ sở dữ liệu hoặc thêm khách hàng: " + e.getMessage(), "Thông báo", JOptionPane.WARNING_MESSAGE);
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
    
    
    public static DefaultTableModel TK_HH_Ten_HH_1(String comboBox1, JTable table) {
        String cmd = "SELECT MA_HANG, TEN_HANG, GIA_NHAP, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, TEN_LOAI_HANG, TEN_NHA_CUNG_CAP FROM HANG_HOA INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG WHERE TEN_HANG LIKE ?;";
        return getData1_1(table, cmd, comboBox1);
    }

    public static DefaultTableModel TK_HH_NCC_1(String comboBox1, JTable table) {
        String cmd = "SELECT MA_HANG, TEN_HANG, GIA_NHAP, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, TEN_LOAI_HANG, TEN_NHA_CUNG_CAP FROM HANG_HOA INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG WHERE TEN_LOAI_HANG LIKE ?;";
        return getData1_1(table, cmd, comboBox1);
    }

    public static DefaultTableModel TK_HH_LHH_1(String comboBox1, JTable table) {
        String cmd = "SELECT MA_HANG, TEN_HANG, GIA_NHAP, GIA_BAN, DON_VI_TINH, SO_LUONG_TON, TEN_LOAI_HANG, TEN_NHA_CUNG_CAP FROM HANG_HOA INNER JOIN NHA_CUNG_CAP ON HANG_HOA.MA_NHA_CUNG_CAP = NHA_CUNG_CAP.MA_NHA_CUNG_CAP INNER JOIN LOAI_HH ON HANG_HOA.MA_LOAI_HANG = LOAI_HH.MA_LOAI_HANG WHERE TEN_LOAI_HANG LIKE ?;";
        return getData1_1(table, cmd, comboBox1);
    }

    public static DefaultTableModel getData1_1(JTable table_HH, String cmd, String selectedValue) {
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

                model.addColumn("<html><b>Mã hàng hóa</b></html>");
                model.addColumn("<html><b>Tên hàng hóa</b></html>");                
                model.addColumn("<html><b>Giá nhập</b></html>");
                model.addColumn("<html><b>Giá bán</b></html>");
                model.addColumn("<html><b>Đơn vị tính</b></html>");
                model.addColumn("<html><b>Số lượng tồn</b></html>");
                model.addColumn("<html><b>Tên loại hàng</b></html>");
                model.addColumn("<html><b>Tên NC cấp</b></html>");

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

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
                table_HH.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

                 while (rs.next()) {
                    Object objList[] = {rs.getString("MA_HANG"), rs.getString("TEN_HANG"), rs.getString("GIA_NHAP"), 
                        rs.getString("GIA_BAN"), rs.getString("DON_VI_TINH"), rs.getString("SO_LUONG_TON"), rs.getString("TEN_LOAI_HANG"), rs.getString("TEN_NHA_CUNG_CAP")};
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
