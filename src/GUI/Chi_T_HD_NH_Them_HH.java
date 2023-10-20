package GUI;

import BLL.KT_HH_Click_Cbo;
import BLL.KT_Hang_Hoa;
import DAL.Connect_Cbo_MLHH;
import DAL.Connect_Cbo_MNCC;
import static com.microsoft.sqlserver.jdbc.StringUtils.isInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang
 */
public class Chi_T_HD_NH_Them_HH extends javax.swing.JFrame {
    public Chi_T_HD_NH_Them_HH() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        Connect_Cbo_MLHH.load(txt_Ma_LHH);
        Connect_Cbo_MNCC.load(txt_Ma_NCC);        
        Connect_Cbo_MLHH.load1(txt_Ten_LHH);         
        Connect_Cbo_MNCC.load1(txt_Ten_NCC);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Ma_HH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Ten_HH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_Gia_Nhap = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Gia_Ban = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Don_vitinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_SL_ton = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Ghichu = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txt_Ten_LHH = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_Ma_LHH = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txt_Ten_NCC = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_Ma_NCC = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm hàng hóa");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel3.setText("Thêm hàng hóa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mã hàng hóa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        txt_Ma_HH.setEditable(false);
        txt_Ma_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_HH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Ma_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ma_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 290, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tên hàng hóa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 30));

        txt_Ten_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_HH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 290, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Giá nhập");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 30));

        txt_Gia_Nhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Gia_Nhap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Gia_Nhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 290, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Giá bán");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 70, 30));

        txt_Gia_Ban.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Gia_Ban.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Gia_Ban, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 290, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Đơn vị tính");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 100, 30));

        txt_Don_vitinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Don_vitinh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Don_vitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 290, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Số lượng tồn");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        txt_SL_ton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_SL_ton.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_SL_ton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 290, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Ghi chú");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 70, 30));

        txt_Ghichu.setColumns(20);
        txt_Ghichu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ghichu.setRows(2);
        txt_Ghichu.setTabSize(6);
        jScrollPane2.setViewportView(txt_Ghichu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 280, 90));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Tên loại hàng");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        txt_Ten_LHH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_LHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ten_LHHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ten_LHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 280, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Mã loại hàng");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 120, 50));

        txt_Ma_LHH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_LHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma_LHHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ma_LHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 280, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Tên NC Cấp");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 100, 30));

        txt_Ten_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ten_NCCActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ten_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 280, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Mã NC Cấp");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 100, 30));

        txt_Ma_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma_NCCActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ma_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 280, -1));

        btnThem.setBackground(new java.awt.Color(0, 255, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 0, 0));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        btnSua.setBackground(new java.awt.Color(0, 255, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 0, 0));
        btnSua.setText("Lưu");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Ma_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma_HHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Ma_HHActionPerformed

    private void txt_Ten_LHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ten_LHHActionPerformed
        // TODO add your handling code here:
        KT_HH_Click_Cbo.load1(txt_Ten_LHH, txt_Ma_LHH);
    }//GEN-LAST:event_txt_Ten_LHHActionPerformed

    private void txt_Ma_LHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma_LHHActionPerformed
        // TODO add your handling code here:
        KT_HH_Click_Cbo.load2(txt_Ma_LHH, txt_Ten_LHH);
    }//GEN-LAST:event_txt_Ma_LHHActionPerformed

    private void txt_Ten_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ten_NCCActionPerformed
        // TODO add your handling code here:
        KT_HH_Click_Cbo.load3(txt_Ten_NCC, txt_Ma_NCC);
    }//GEN-LAST:event_txt_Ten_NCCActionPerformed

    private void txt_Ma_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma_NCCActionPerformed
        // TODO add your handling code here:
        KT_HH_Click_Cbo.load4(txt_Ma_NCC, txt_Ten_NCC);
    }//GEN-LAST:event_txt_Ma_NCCActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String ten_HH = txt_Ten_HH.getText();
        String gia_Nhap = txt_Gia_Nhap.getText();
        String gia_Ban = txt_Gia_Ban.getText();
        String dvt = txt_Don_vitinh.getText();
        String solt = txt_SL_ton.getText();
        String ghi_Chu = txt_Ghichu.getText();
        String maNCC = (String) txt_Ma_NCC.getSelectedItem();
        String maLHH = (String) txt_Ma_LHH.getSelectedItem();

        KT_Hang_Hoa db = new KT_Hang_Hoa();
        boolean kt = db.themHH(ten_HH, gia_Nhap, gia_Ban, dvt, solt, ghi_Chu, maNCC, maLHH);

        if (!isInteger(gia_Nhap)) {
            JOptionPane.showMessageDialog(null, "Giá nhập phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (!isInteger(gia_Ban)) {
            JOptionPane.showMessageDialog(null, "Giá bán phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (!isInteger(solt)) {
            JOptionPane.showMessageDialog(null, "Số lượng tồn phải là số nguyên !!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã thêm hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            txt_Ma_HH.setText("");
            txt_Ten_HH.setText("");
            txt_Gia_Nhap.setText("");
            txt_Gia_Ban.setText("");
            txt_Don_vitinh.setText("");
            txt_SL_ton.setText("");
            txt_Ghichu.setText("");
            txt_Ma_NCC.setSelectedItem("");
            txt_Ma_LHH.setSelectedItem("");

        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String ma_HH = txt_Ma_HH.getText();
        String ten_HH = txt_Ten_HH.getText();
        String gia_Nhap = txt_Gia_Nhap.getText();
        String gia_Ban = txt_Gia_Ban.getText();
        String dvt = txt_Don_vitinh.getText();
        String solt = txt_SL_ton.getText();
        String ghi_Chu = txt_Ghichu.getText();
        String maNCC = (String) txt_Ma_NCC.getSelectedItem();
        String maLHH = (String) txt_Ma_LHH.getSelectedItem();
        
        KT_Hang_Hoa db = new KT_Hang_Hoa();
        boolean kt = db.suaHH(ma_HH, ten_HH, gia_Nhap, gia_Ban, dvt, solt, ghi_Chu, maNCC, maLHH);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã sửa hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            txt_Ma_HH.setText("");
            txt_Ten_HH.setText("");
            txt_Gia_Nhap.setText("");
            txt_Gia_Ban.setText("");
            txt_Don_vitinh.setText("");
            txt_SL_ton.setText("");
            txt_Ghichu.setText("");
            txt_Ma_NCC.setSelectedItem("");
            txt_Ma_LHH.setSelectedItem("");

        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chi_T_HD_NH_Them_HH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_Don_vitinh;
    private javax.swing.JTextArea txt_Ghichu;
    private javax.swing.JTextField txt_Gia_Ban;
    private javax.swing.JTextField txt_Gia_Nhap;
    private javax.swing.JTextField txt_Ma_HH;
    private javax.swing.JComboBox<String> txt_Ma_LHH;
    private javax.swing.JComboBox<String> txt_Ma_NCC;
    private javax.swing.JTextField txt_SL_ton;
    private javax.swing.JTextField txt_Ten_HH;
    private javax.swing.JComboBox<String> txt_Ten_LHH;
    private javax.swing.JComboBox<String> txt_Ten_NCC;
    // End of variables declaration//GEN-END:variables
}
