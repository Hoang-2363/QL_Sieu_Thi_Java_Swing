package GUI;

import BLL.KT_CTiet_HD_BH;
import DAL.Connect_HH;
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
public class TK_HH extends javax.swing.JFrame {
    public static void Icon(String path, JButton menu) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }
    public void Load() {
        DefaultTableModel tableModel = Connect_HH.getData1();
        table_HH.setModel(tableModel);
        table_HH.setRowHeight(30);
        table_HH.getColumnModel().getColumn(0).setPreferredWidth(60);
        table_HH.getColumnModel().getColumn(1).setPreferredWidth(160);
        table_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(4).setPreferredWidth(70);
        table_HH.getColumnModel().getColumn(5).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(6).setPreferredWidth(100);
        table_HH.getColumnModel().getColumn(7).setPreferredWidth(150);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

    }
    public TK_HH() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Icon("D:\\do\\loupe.png", btn_TK_KH);
        Load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Thong_Tin = new javax.swing.JTextField();
        btn_TK_KH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        btn_TT_CT = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txt_TT_HH = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tìm kiếm hàng hóa");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Tìm kiếm hàng hóa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Nhập thông tin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, 30));

        txt_Thong_Tin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Thong_Tin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Thong_Tin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Thong_TinMouseClicked(evt);
            }
        });
        txt_Thong_Tin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Thong_TinActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Thong_Tin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 340, 30));

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
        getContentPane().add(btn_TK_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 140, 30));

        table_HH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_HH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_HH);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1060, 300));

        btn_TT_CT.setBackground(new java.awt.Color(0, 255, 204));
        btn_TT_CT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TT_CT.setForeground(new java.awt.Color(255, 0, 51));
        btn_TT_CT.setText("Thông tin chi tiết");
        btn_TT_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TT_CTActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TT_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 0, 51));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Tìm theo");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 160, 30));

        txt_TT_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_TT_HH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên hàng", "Loại hàng hóa", "Nhà cung cấp" }));
        txt_TT_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TT_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_TT_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 260, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Thong_TinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Thong_TinMouseClicked
        // TODO add your handling code here:
        Load();
    }//GEN-LAST:event_txt_Thong_TinMouseClicked

    private void btn_TK_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TK_KHActionPerformed
        // TODO add your handling code here:
        if ("".equals(txt_Thong_Tin.getText())) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else if (txt_TT_HH.getSelectedItem().equals("Tên hàng")) {
            KT_CTiet_HD_BH.TK_HH_Ten_HH_1(txt_Thong_Tin.getText(), table_HH);
        } else if (txt_TT_HH.getSelectedItem().equals("Nhà cung cấp")) {
            KT_CTiet_HD_BH.TK_HH_NCC_1(txt_Thong_Tin.getText(), table_HH);
        } else if (txt_TT_HH.getSelectedItem().equals("Loại hàng hóa")) {
            KT_CTiet_HD_BH.TK_HH_LHH_1(txt_Thong_Tin.getText(), table_HH);
        }
    }//GEN-LAST:event_btn_TK_KHActionPerformed

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
        txt_Thong_Tin.setText("");
    }//GEN-LAST:event_txt_TT_HHActionPerformed

    private void txt_Thong_TinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Thong_TinActionPerformed
        // TODO add your handling code here:
        Load();
    }//GEN-LAST:event_txt_Thong_TinActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TK_HH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TK_KH;
    private javax.swing.JButton btn_TT_CT;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_HH;
    private javax.swing.JComboBox<String> txt_TT_HH;
    private javax.swing.JTextField txt_Thong_Tin;
    // End of variables declaration//GEN-END:variables
}
