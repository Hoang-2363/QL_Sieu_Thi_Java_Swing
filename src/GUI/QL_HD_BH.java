package GUI;

import BLL.Save_Ma_NV;
import DAL.Connect_HD_BH;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class QL_HD_BH extends javax.swing.JFrame {
    public void Load() {
        DefaultTableModel tableModel = Connect_HD_BH.getData();
        table_HH.setModel(tableModel);
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

    }
    public QL_HD_BH() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txt_Ma_HD_BH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Gio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_Ngay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý hóa đơn bán hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel3.setText("Quản lý hóa đơn bán hàng");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        table_HH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_HH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_HH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_HH);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 940, 310));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mã HD bán hàng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        txt_Ma_HD_BH.setEditable(false);
        txt_Ma_HD_BH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_HD_BH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ma_HD_BH, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Giờ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, 30));

        txt_Gio.setEditable(false);
        txt_Gio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Gio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Gio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 150, -1));

        jButton1.setBackground(new java.awt.Color(0, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Xem chi tiết");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, -1, -1));

        txt_Ngay.setEditable(false);
        txt_Ngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ngay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 150, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Ngày");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 80, 50, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HHMouseClicked
        int i = table_HH.getSelectedRow();
        if (i != -1) {
            String mhd_bh = table_HH.getValueAt(i, 0).toString();
            String gio = table_HH.getValueAt(i, 3).toString();
            String ngay = table_HH.getValueAt(i, 4).toString();
            
            txt_Ma_HD_BH.setText(mhd_bh);
            txt_Gio.setText(gio);
            txt_Ngay.setText(ngay);
            
            Save_Ma_NV.setMa_HD_BH_1(txt_Ma_HD_BH.getText());
        }
    }//GEN-LAST:event_table_HHMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txt_Ma_HD_BH.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn bất kỳ  !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            CT_HD_BH menu = new CT_HD_BH();
            menu.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_HD_BH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_HH;
    private javax.swing.JTextField txt_Gio;
    private javax.swing.JTextField txt_Ma_HD_BH;
    private javax.swing.JTextField txt_Ngay;
    // End of variables declaration//GEN-END:variables
}
