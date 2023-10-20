package GUI;

import BLL.KT_Dang_Nhap;
import BLL.Save_Ma_NV;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
/**
 *
 * @author Hoang
 */
public class Dang_Nhap extends javax.swing.JFrame {
    public static void Icon(String path, JButton menu){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }
    public static void Icon1(String path, JCheckBox menu){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }
    public Dang_Nhap() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        chk_Hien_MK.setOpaque(false);
        
        Icon("D:\\do\\log-in.png", btn_Dang_Nhap);        
        Icon("D:\\do\\exit.png", btn_Thoat);  
        Icon1("D:\\do\\hidden.png", chk_Hien_MK);  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_Dang_Nhap = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        txt_Tai_khoan = new javax.swing.JTextField();
        chk_Hien_MK = new javax.swing.JCheckBox();
        txt_Mat_khau = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Constantia", 3, 56)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Đăng nhập");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 320, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tài khoản");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mật khẩu");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, 50));

        btn_Dang_Nhap.setBackground(new java.awt.Color(0, 255, 204));
        btn_Dang_Nhap.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_Dang_Nhap.setForeground(new java.awt.Color(255, 0, 0));
        btn_Dang_Nhap.setText(" Đăng nhập");
        btn_Dang_Nhap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Dang_Nhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Dang_NhapActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Dang_Nhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 210, 40));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 0, 0));
        btn_Thoat.setText(" Thoát");
        btn_Thoat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 140, 40));

        txt_Tai_khoan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_Tai_khoan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Tai_khoan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_Tai_khoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 350, 50));

        chk_Hien_MK.setBackground(new java.awt.Color(255, 255, 255));
        chk_Hien_MK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        chk_Hien_MK.setForeground(new java.awt.Color(255, 255, 255));
        chk_Hien_MK.setText("Hiển thị mật khẩu");
        chk_Hien_MK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_Hien_MKActionPerformed(evt);
            }
        });
        getContentPane().add(chk_Hien_MK, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        txt_Mat_khau.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_Mat_khau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Mat_khau, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 350, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\pngtree-minimalist-interior-design-idea-pink-doorway-in-blue-surroundings-3d-rendered-image_3621141.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 540));

        setSize(new java.awt.Dimension(785, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chk_Hien_MKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_Hien_MKActionPerformed
        // TODO add your handling code here:
        if (chk_Hien_MK.isSelected()) {
            Icon1("D:\\do\\eye.png", chk_Hien_MK);  
            txt_Mat_khau.setEchoChar((char) 0);
        } else {
            Icon1("D:\\do\\hidden.png", chk_Hien_MK); 
            txt_Mat_khau.setEchoChar('*');
        }
    }//GEN-LAST:event_chk_Hien_MKActionPerformed

    private void btn_Dang_NhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Dang_NhapActionPerformed
        // TODO add your handling code here:
        String tai_Khoan = txt_Tai_khoan.getText();        
        char[] passwordChars = txt_Mat_khau.getPassword();
        String mat_Khau = new String(passwordChars);

        boolean dangNhapThanhCong = KT_Dang_Nhap.kiemTraDangNhap(tai_Khoan, mat_Khau);
        if (tai_Khoan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else if (mat_Khau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (dangNhapThanhCong) {
                Save_Ma_NV.setTK(tai_Khoan);                
                Save_Ma_NV.setMK(mat_Khau);
                JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã đăng nhập thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Menu menu = new Menu();
                menu.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu của bạn đang sai! Vui lòng nhập lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btn_Dang_NhapActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0); 
        }
    }//GEN-LAST:event_btn_ThoatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dang_Nhap().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Dang_Nhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Dang_Nhap;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JCheckBox chk_Hien_MK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_Mat_khau;
    private javax.swing.JTextField txt_Tai_khoan;
    // End of variables declaration//GEN-END:variables
}
