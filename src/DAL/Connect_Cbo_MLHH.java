package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class Connect_Cbo_MLHH {
    private final JComboBox<String> comboBox;

    public Connect_Cbo_MLHH(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }
    public static void load(JComboBox<String> comboBox) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = conn.prepareStatement("SELECT MA_LOAI_HANG FROM LOAI_HH");
             ResultSet rs = stmt.executeQuery()) {

            comboBox.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("MA_LOAI_HANG");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void load1(JComboBox<String> comboBox) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = conn.prepareStatement("SELECT TEN_LOAI_HANG FROM LOAI_HH");
             ResultSet rs = stmt.executeQuery()) {

            comboBox.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("TEN_LOAI_HANG");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
