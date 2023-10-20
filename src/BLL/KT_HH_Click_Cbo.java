package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class KT_HH_Click_Cbo {

    public static void load1(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        String ten_LHH = (String) comboBox1.getSelectedItem();
        try {
            if (comboBox1.getSelectedItem().equals(ten_LHH)) {
                Connection conn = DriverManager.getConnection(connectionUrl);
                PreparedStatement stmt = conn.prepareStatement("SELECT MA_LOAI_HANG FROM LOAI_HH WHERE TEN_LOAI_HANG = ?");
                stmt.setString(1, ten_LHH);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String item = rs.getString("MA_LOAI_HANG");
                    comboBox2.setSelectedItem(item);
                }
            }
        } catch (SQLException e) {
        }
    }

    public static void load2(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        String ma_LHH = (String) comboBox1.getSelectedItem();
        try {
            if (comboBox1.getSelectedItem().equals(ma_LHH)) {
                Connection conn = DriverManager.getConnection(connectionUrl);
                PreparedStatement stmt = conn.prepareStatement("SELECT TEN_LOAI_HANG FROM LOAI_HH WHERE MA_LOAI_HANG = ?");
                stmt.setString(1, ma_LHH);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String item = rs.getString("TEN_LOAI_HANG");
                    comboBox2.setSelectedItem(item);
                }
            }
        } catch (SQLException e) {
        }
    }

    public static void load3(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        String ten_NCC = (String) comboBox1.getSelectedItem();
        try {
            if (comboBox1.getSelectedItem().equals(ten_NCC)) {
                Connection conn = DriverManager.getConnection(connectionUrl);
                PreparedStatement stmt = conn.prepareStatement("SELECT MA_NHA_CUNG_CAP FROM NHA_CUNG_CAP WHERE TEN_NHA_CUNG_CAP = ?");
                stmt.setString(1, ten_NCC);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String item = rs.getString("MA_NHA_CUNG_CAP");
                    comboBox2.setSelectedItem(item);
                }
            }
        } catch (SQLException e) {
        }
    }

    public static void load4(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        String ma_NCC = (String) comboBox1.getSelectedItem();
        try {
            if (comboBox1.getSelectedItem().equals(ma_NCC)) {
                Connection conn = DriverManager.getConnection(connectionUrl);
                PreparedStatement stmt = conn.prepareStatement("SELECT TEN_NHA_CUNG_CAP FROM NHA_CUNG_CAP WHERE MA_NHA_CUNG_CAP = ?");
                stmt.setString(1, ma_NCC);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String item = rs.getString("TEN_NHA_CUNG_CAP");
                    comboBox2.setSelectedItem(item);
                }
            }
        } catch (SQLException e) {
        }
    }

}
