package GUI;

import BLL.KT_Support;
import BLL.Save_Ma_NV;
import DAL.Connect_TT_Nhan_Vien;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang
 */
public class Doi_MK extends javax.swing.JFrame {
    String tk = Save_Ma_NV.getTK();        
    String mk = Save_Ma_NV.getMK();
    
    public static void Icon1(String path, JCheckBox menu){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }
    
    public Doi_MK() {
        initComponents();
        this.setLocationRelativeTo(null);
        chk_Hien_MK.setOpaque(false);
        
        Connect_TT_Nhan_Vien.load_TK(txt_Tk, tk, mk);
        Icon1("D:\\do\\hidden.png", chk_Hien_MK);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Tk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_Sua = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        chk_Hien_MK = new javax.swing.JCheckBox();
        txt_Mat_khau_Cu = new javax.swing.JPasswordField();
        txt_Mat_khau_Moi = new javax.swing.JPasswordField();
        txt_MK_Moi_NL = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đổi mật khẩu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Đổi mật khẩu");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tài khoản");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 30));

        txt_Tk.setEditable(false);
        txt_Tk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Tk.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Tk, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 310, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Mật khẩu cũ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Mật khẩu mới");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 30));

        btn_Sua.setBackground(new java.awt.Color(0, 255, 204));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 51, 0));
        btn_Sua.setText("Lưu mật khẩu");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 170, 30));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 0));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 90, 30));

        chk_Hien_MK.setBackground(new java.awt.Color(255, 255, 255));
        chk_Hien_MK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        chk_Hien_MK.setForeground(new java.awt.Color(255, 255, 255));
        chk_Hien_MK.setText("Hiển thị mật khẩu");
        chk_Hien_MK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_Hien_MKActionPerformed(evt);
            }
        });
        getContentPane().add(chk_Hien_MK, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 220, 30));

        txt_Mat_khau_Cu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Mat_khau_Cu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Mat_khau_Cu.setToolTipText("");
        getContentPane().add(txt_Mat_khau_Cu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 310, 30));

        txt_Mat_khau_Moi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Mat_khau_Moi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Mat_khau_Moi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 310, 30));

        txt_MK_Moi_NL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_MK_Moi_NL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_MK_Moi_NL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 310, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("khẩu mới");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Nhập lại mật");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        char[] passwordChars = txt_Mat_khau_Cu.getPassword();
        String mk_c = new String(passwordChars);
        
        char[] passwordChars1 = txt_Mat_khau_Moi.getPassword();
        String mk_m = new String(passwordChars1);
        
        char[] passwordChars2 = txt_MK_Moi_NL.getPassword();
        String mk_m_nl = new String(passwordChars2);
        
        boolean kt = KT_Support.doi_MK(tk, mk_c, mk_m, mk_m_nl);
        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã đổi mật khẩu thành công thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Connect_TT_Nhan_Vien.load_TK(txt_Tk, tk, mk);
            txt_Mat_khau_Cu.setText("");
            txt_Mat_khau_Moi.setText("");
            txt_MK_Moi_NL.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void chk_Hien_MKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_Hien_MKActionPerformed
        // TODO add your handling code here:
        if (chk_Hien_MK.isSelected()) {
            Icon1("D:\\do\\eye.png", chk_Hien_MK);
            txt_Mat_khau_Moi.setEchoChar((char) 0);            
            txt_Mat_khau_Cu.setEchoChar((char) 0);            
            txt_MK_Moi_NL.setEchoChar((char) 0);
        } else {
            Icon1("D:\\do\\hidden.png", chk_Hien_MK);
            txt_Mat_khau_Moi.setEchoChar('*');            
            txt_Mat_khau_Cu.setEchoChar('*');            
            txt_MK_Moi_NL.setEchoChar('*');
        }
    }//GEN-LAST:event_chk_Hien_MKActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doi_MK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JCheckBox chk_Hien_MK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txt_MK_Moi_NL;
    private javax.swing.JPasswordField txt_Mat_khau_Cu;
    private javax.swing.JPasswordField txt_Mat_khau_Moi;
    private javax.swing.JTextField txt_Tk;
    // End of variables declaration//GEN-END:variables
}
