package GUI;

import BLL.KT_TK_Thong_tin;
import DAL.Connect_NCC;
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
public class TK_NCC extends javax.swing.JFrame {
    public static void Icon(String path, JButton menu) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }
    public void Load() {
        Connect_NCC db = new Connect_NCC();
        DefaultTableModel tableModel = db.getData();
        table_NCC.setModel(tableModel);
        table_NCC.setRowHeight(30);
        table_NCC.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_NCC.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_NCC.getColumnModel().getColumn(2).setPreferredWidth(200);
        table_NCC.getColumnModel().getColumn(3).setPreferredWidth(90);
        table_NCC.getColumnModel().getColumn(4).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_NCC.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_NCC.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }
    public TK_NCC() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        TableCellRenderer rendererFromHeader = table_NCC.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Icon("D:\\do\\loupe.png", btn_TK_KH);
        Load();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_TT = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Thong_Tin = new javax.swing.JTextField();
        btn_TK_KH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_NCC = new javax.swing.JTable();
        btn_TT_CT = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tìm kiếm nhà cung cấp");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_TT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_TT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ" }));
        txt_TT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_TT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TTActionPerformed(evt);
            }
        });
        getContentPane().add(txt_TT, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 290, -1));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Tìm kiếm nhà cung cấp");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tìm theo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Nhập thông tin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 40));

        txt_Thong_Tin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Thong_Tin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Thong_Tin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Thong_TinMouseClicked(evt);
            }
        });
        getContentPane().add(txt_Thong_Tin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 340, 40));

        btn_TK_KH.setBackground(new java.awt.Color(0, 255, 204));
        btn_TK_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TK_KH.setForeground(new java.awt.Color(255, 0, 0));
        btn_TK_KH.setText("Tìm kiếm");
        btn_TK_KH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_TK_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TK_KHActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TK_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 140, 40));

        table_NCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_NCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_NCC);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 850, 300));

        btn_TT_CT.setBackground(new java.awt.Color(0, 255, 204));
        btn_TT_CT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TT_CT.setForeground(new java.awt.Color(255, 0, 51));
        btn_TT_CT.setText("Thông tin chi tiết");
        btn_TT_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TT_CTActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TT_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 0, 51));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_TTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TTActionPerformed
        // TODO add your handling code here:
        Load();
    }//GEN-LAST:event_txt_TTActionPerformed

    private void txt_Thong_TinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Thong_TinMouseClicked
        // TODO add your handling code here:
        Load();
    }//GEN-LAST:event_txt_Thong_TinMouseClicked

    private void btn_TK_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TK_KHActionPerformed
        // TODO add your handling code here:
        if ("".equals(txt_Thong_Tin.getText())) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else if (txt_TT.getSelectedItem().equals("Tên nhà cung cấp")) {
            KT_TK_Thong_tin.TK_NCC_Ten(txt_Thong_Tin.getText(), table_NCC);
        } else if (txt_TT.getSelectedItem().equals("Số điện thoại")) {
            KT_TK_Thong_tin.TK_HH_SDT(txt_Thong_Tin.getText(), table_NCC);
        } else if (txt_TT.getSelectedItem().equals("Địa chỉ")) {
            KT_TK_Thong_tin.TK_HH_Dia_chi(txt_Thong_Tin.getText(), table_NCC);
        }
    }//GEN-LAST:event_btn_TK_KHActionPerformed

    private void btn_TT_CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TT_CTActionPerformed
        // TODO add your handling code here:
        QL_Nha_CC ql_hh = new QL_Nha_CC();
        ql_hh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_TT_CTActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        Menu ql_hh = new Menu();
        ql_hh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TK_NCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TK_NCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TK_NCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TK_NCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TK_NCC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TK_KH;
    private javax.swing.JButton btn_TT_CT;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_NCC;
    private javax.swing.JComboBox<String> txt_TT;
    private javax.swing.JTextField txt_Thong_Tin;
    // End of variables declaration//GEN-END:variables
}
