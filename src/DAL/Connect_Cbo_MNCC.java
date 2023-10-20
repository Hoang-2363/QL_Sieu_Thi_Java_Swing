
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class Connect_Cbo_MNCC {

    public static void load(JComboBox<String> comboBox) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = conn.prepareStatement("SELECT MA_NHA_CUNG_CAP FROM NHA_CUNG_CAP"); 
                ResultSet rs = stmt.executeQuery()) {

            comboBox.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("MA_NHA_CUNG_CAP");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void load1(JComboBox<String> comboBox) {
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = conn.prepareStatement("SELECT TEN_NHA_CUNG_CAP FROM NHA_CUNG_CAP");
             ResultSet rs = stmt.executeQuery()) {

            comboBox.removeAllItems();
            while (rs.next()) {
                String item = rs.getString("TEN_NHA_CUNG_CAP");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
