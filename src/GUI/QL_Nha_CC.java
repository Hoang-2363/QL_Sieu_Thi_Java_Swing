package GUI;

import BLL.KT_Nha_CC;
import DAL.Connect_NCC;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class QL_Nha_CC extends javax.swing.JFrame {

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

    public QL_Nha_CC() {
        initComponents();
        this.setLocationRelativeTo(null);

        TableCellRenderer rendererFromHeader = table_NCC.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        Load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Ma_NCC = new javax.swing.JTextField();
        txt_Ten_NCC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Dia_Chi = new javax.swing.JTextField();
        txt_SDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_Gmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_NCC = new javax.swing.JTable();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhà cung cấp");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel2.setText("Quản lý nhà cung cấp");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mã nhà cung cấp");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tên nhà cung cấp");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 160, 30));

        txt_Ma_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_NCC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ma_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 250, -1));

        txt_Ten_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_NCC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 250, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Địa chỉ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("SDT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, 30));

        txt_Dia_Chi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Dia_Chi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Dia_Chi, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 250, -1));

        txt_SDT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_SDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 250, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Gmail");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 50, 30));

        txt_Gmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Gmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 250, -1));

        table_NCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_NCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_NCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_NCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_NCC);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 930, 320));

        btn_Them.setBackground(new java.awt.Color(0, 255, 204));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 51, 0));
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, -1, -1));

        btn_Sua.setBackground(new java.awt.Color(0, 255, 204));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 51, 0));
        btn_Sua.setText("Lưu");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, -1, -1));

        btn_Xoa.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 51, 0));
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 0));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        String ma_NCC = txt_Ma_NCC.getText();
        String ten_NCC = txt_Ten_NCC.getText();
        String dia_Chi = txt_Dia_Chi.getText();
        String sdt = txt_SDT.getText();
        String gmail = txt_Gmail.getText();
        if (!gmail.matches(".*@gmail\\.com") && !gmail.matches(".*@gmail\\.com.vn")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ Gmail không đúng định dạng (@gmail.com) !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            KT_Nha_CC db = new KT_Nha_CC();
            boolean kt = db.themNCC(ma_NCC, ten_NCC, dia_Chi, sdt, gmail);

            if (kt) {
                JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã thêm loại hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Load();
                txt_Ma_NCC.setText("");
                txt_Ten_NCC.setText("");
                txt_Dia_Chi.setText("");
                txt_SDT.setText("");
                txt_Gmail.setText("");

            } else {
                //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        String ma_NCC = txt_Ma_NCC.getText();
        String ten_NCC = txt_Ten_NCC.getText();
        String dia_Chi = txt_Dia_Chi.getText();
        String sdt = txt_SDT.getText();
        String gmail = txt_Gmail.getText();
        
        KT_Nha_CC db = new KT_Nha_CC();
        boolean kt = db.suaNCC(ma_NCC, ten_NCC, dia_Chi, sdt, gmail);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã sửa nhà cung cấp thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            txt_Ma_NCC.setText("");
            txt_Ten_NCC.setText("");
            txt_Dia_Chi.setText("");
            txt_SDT.setText("");
            txt_Gmail.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        KT_Nha_CC db = new KT_Nha_CC();
        boolean kt = db.xoaNCC(txt_Ma_NCC.getText());

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã xóa khách hàng thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            txt_Ma_NCC.setText("");
            txt_Ten_NCC.setText("");
            txt_Dia_Chi.setText("");
            txt_SDT.setText("");
            txt_Gmail.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void table_NCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_NCCMouseClicked
        // TODO add your handling code here:
        int i = table_NCC.getSelectedRow();
        if (i != -1) {
            String maNCC = table_NCC.getValueAt(i, 0).toString();
            String tenNCC = table_NCC.getValueAt(i, 1).toString();
            String diaChi = table_NCC.getValueAt(i, 2).toString();
            String SDT = table_NCC.getValueAt(i, 3).toString();
            String gmail = table_NCC.getValueAt(i, 4).toString();

            txt_Ma_NCC.setText(maNCC);
            txt_Ten_NCC.setText(tenNCC);
            txt_Dia_Chi.setText(diaChi);
            txt_SDT.setText(SDT);
            txt_Gmail.setText(gmail);
        }
    }//GEN-LAST:event_table_NCCMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_Nha_CC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_NCC;
    private javax.swing.JTextField txt_Dia_Chi;
    private javax.swing.JTextField txt_Gmail;
    private javax.swing.JTextField txt_Ma_NCC;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_Ten_NCC;
    // End of variables declaration//GEN-END:variables
}
