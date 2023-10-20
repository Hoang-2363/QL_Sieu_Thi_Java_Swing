package GUI;

import BLL.KT_Nha_CC;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang
 */
public class Chi_T_HD_NH_Them_NCC extends javax.swing.JFrame {
    public Chi_T_HD_NH_Them_NCC() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        txt_Dia_Chi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_Gmail = new javax.swing.JTextField();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm nhà cung cấp");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel2.setText("Thêm nhà cung cấp");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mã NCC");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tên NCC");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, 30));

        txt_Ma_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_NCC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ma_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 250, -1));

        txt_Ten_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_NCC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 250, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Địa chỉ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, 30));

        txt_Dia_Chi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Dia_Chi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Dia_Chi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 250, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("SDT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, 30));

        txt_SDT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_SDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 250, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Gmail");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 50, 30));

        txt_Gmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Gmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 250, -1));

        btn_Them.setBackground(new java.awt.Color(0, 255, 204));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 51, 0));
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        btn_Sua.setBackground(new java.awt.Color(0, 255, 204));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 51, 0));
        btn_Sua.setText("Lưu");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        String ma_NCC = txt_Ma_NCC.getText();
        String ten_NCC = txt_Ten_NCC.getText();
        String dia_Chi = txt_Dia_Chi.getText();
        String sdt = txt_SDT.getText();
        String gmail = txt_Gmail.getText();
        
        KT_Nha_CC db = new KT_Nha_CC();
        boolean kt = db.themNCC(ma_NCC, ten_NCC, dia_Chi, sdt, gmail);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã thêm loại hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            txt_Ma_NCC.setText("");
            txt_Ten_NCC.setText("");
            txt_Dia_Chi.setText("");
            txt_SDT.setText("");
            txt_Gmail.setText("");

        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
            txt_Ma_NCC.setText("");
            txt_Ten_NCC.setText("");
            txt_Dia_Chi.setText("");
            txt_SDT.setText("");
            txt_Gmail.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chi_T_HD_NH_Them_NCC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_Dia_Chi;
    private javax.swing.JTextField txt_Gmail;
    private javax.swing.JTextField txt_Ma_NCC;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_Ten_NCC;
    // End of variables declaration//GEN-END:variables
}
