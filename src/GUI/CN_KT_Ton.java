package GUI;

import BLL.KT_CTiet_HD_BH;
import BLL.KT_KT_Ton;
import DAL.Connect_HH;
import static com.microsoft.sqlserver.jdbc.StringUtils.isInteger;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class CN_KT_Ton extends javax.swing.JFrame {

    public static void Icon(String path, JButton menu) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }

    public void Load() {
        Connect_HH db = new Connect_HH();
        DefaultTableModel tableModel = db.getData();
        table_HH.setModel(tableModel);
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

    }

    public CN_KT_Ton() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        Icon("D:\\do\\loupe.png", btn_TK_HH);
        Load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_SL_T = new javax.swing.JTextField();
        btn_TK_HH = new javax.swing.JButton();
        btn_TT_CT = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        txt_TT_HH = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kiểm tra tồn");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Kiểm tra hàng hóa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        table_HH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_HH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_HH);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 158, 950, 390));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nhập thông tin");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 160, 30));

        txt_SL_T.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_SL_T.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_SL_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SL_TActionPerformed(evt);
            }
        });
        getContentPane().add(txt_SL_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 340, 30));

        btn_TK_HH.setBackground(new java.awt.Color(0, 255, 204));
        btn_TK_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TK_HH.setForeground(new java.awt.Color(255, 0, 0));
        btn_TK_HH.setText("Tìm kiếm");
        btn_TK_HH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_TK_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TK_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TK_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 140, 30));

        btn_TT_CT.setBackground(new java.awt.Color(0, 255, 204));
        btn_TT_CT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TT_CT.setForeground(new java.awt.Color(255, 0, 51));
        btn_TT_CT.setText("Thông tin chi tiết");
        btn_TT_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TT_CTActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TT_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 570, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 0, 51));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 570, -1, -1));

        txt_TT_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_TT_HH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên hàng", "Tên loại hàng", "Tên nhà cung cấp", "Số lượng" }));
        txt_TT_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TT_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_TT_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 260, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Tìm theo");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 160, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TK_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TK_HHActionPerformed
        // TODO add your handling code here:
        String so_Luong = txt_SL_T.getText();
        
        if ("".equals(txt_SL_T.getText())) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin hàng hóa cần tìm !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (txt_TT_HH.getSelectedItem().equals("Tên hàng")) {
            KT_CTiet_HD_BH.TK_HH_Ten_HH_1(txt_SL_T.getText(), table_HH);
        } else if (txt_TT_HH.getSelectedItem().equals("Tên nhà cung cấp")) {
            KT_CTiet_HD_BH.TK_HH_NCC_1(txt_SL_T.getText(), table_HH);
        } else if (txt_TT_HH.getSelectedItem().equals("Tên loại hàng")) {
            KT_CTiet_HD_BH.TK_HH_LHH_1(txt_SL_T.getText(), table_HH);
        }else if(txt_TT_HH.getSelectedItem().equals("Số lượng")){
            if (!isInteger(so_Luong)) {
            JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else {
                KT_KT_Ton.KT_Ton(table_HH, so_Luong);
            }
        }
    }//GEN-LAST:event_btn_TK_HHActionPerformed

    private void txt_SL_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SL_TActionPerformed
        // TODO add your handling code here:
        String so_Luong_str = txt_SL_T.getText();
        String connectionUrl = "jdbc:sqlserver://DESKTOP-R6CHIHR:1433;databaseName=QL_BH_SIEU_THI;user=sa;password=sa;encrypt=false";

        if (so_Luong_str.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng hàng tồn cần tìm !!!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (!isInteger(so_Luong_str)) {
            JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            
        }

    }//GEN-LAST:event_txt_SL_TActionPerformed

    private void btn_TT_CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TT_CTActionPerformed
        // TODO add your handling code here:
        QL_HH ql_hh = new QL_HH();
        ql_hh.setVisible(true);        
        this.setVisible(false);
    }//GEN-LAST:event_btn_TT_CTActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        Menu ql_hh = new Menu();
        ql_hh.setVisible(true);        
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void txt_TT_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TT_HHActionPerformed
        // TODO add your handling code here:
        Load();
        txt_SL_T.setText("");
    }//GEN-LAST:event_txt_TT_HHActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CN_KT_Ton().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TK_HH;
    private javax.swing.JButton btn_TT_CT;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_HH;
    private javax.swing.JTextField txt_SL_T;
    private javax.swing.JComboBox<String> txt_TT_HH;
    // End of variables declaration//GEN-END:variables
}
