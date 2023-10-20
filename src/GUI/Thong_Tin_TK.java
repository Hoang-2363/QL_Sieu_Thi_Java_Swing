package GUI;

import BLL.KT_Support;
import BLL.Save_Ma_NV;
import DAL.Connect_TT_Nhan_Vien;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class Thong_Tin_TK extends javax.swing.JFrame {
    String tk = Save_Ma_NV.getTK();        
    String mk = Save_Ma_NV.getMK();
    
    public Thong_Tin_TK() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_KH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Connect_TT_Nhan_Vien.load_Ma_NV(txt_Ma_NV, txt_Ten_NV, txt_Luong, txt_DC, txt_Sdt, txt_Gmail, tk, mk);
        Connect_TT_Nhan_Vien.getData1(table_KH, tk, mk);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_KH = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_Ma_NV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_DC = new javax.swing.JTextField();
        txt_Sdt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Ten_NV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Gmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Luong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_Sua = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông tin tài khoản");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Thông tin nhân viên");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        table_KH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_KH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_KHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_KH);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 870, 140));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mã nhân viên");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, 30));

        txt_Ma_NV.setEditable(false);
        txt_Ma_NV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_Ma_NV, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 220, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Số điện thoại");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, 30));

        txt_DC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_DC, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 260, -1));

        txt_Sdt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_Sdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 260, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Địa chỉ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, 30));

        txt_Ten_NV.setEditable(false);
        txt_Ten_NV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_Ten_NV, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 220, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Họ tên nhân viên");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 30));

        txt_Gmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_Gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 260, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Gmail");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, 30));

        txt_Luong.setEditable(false);
        txt_Luong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_Luong, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 220, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Lương");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, 30));

        btn_Sua.setBackground(new java.awt.Color(0, 255, 204));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 51, 0));
        btn_Sua.setText("Lưu");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 0));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        String ma_nv = txt_Ma_NV.getText();
        String dia_Chi = txt_DC.getText();
        String sdt = txt_Sdt.getText();
        String gmail = txt_Gmail.getText();
        boolean kt = KT_Support.sua_TT_NV(ma_nv, dia_Chi, sdt, gmail);
        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã sửa khách hàng thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Connect_TT_Nhan_Vien.getData1(table_KH, tk, mk);
            txt_DC.setText("");
            txt_Sdt.setText("");
            txt_Gmail.setText("");
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

    private void table_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KHMouseClicked
        // TODO add your handling code here:
        int i = table_KH.getSelectedRow();
        if (i != -1) {
            String dc = table_KH.getValueAt(i, 3).toString();
            String sdt = table_KH.getValueAt(i, 4).toString();
            String gm = table_KH.getValueAt(i, 5).toString();

            txt_DC.setText(dc);
            txt_Sdt.setText(sdt);
            txt_Gmail.setText(gm);
        }
    }//GEN-LAST:event_table_KHMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thong_Tin_TK().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_KH;
    private javax.swing.JTextField txt_DC;
    private javax.swing.JTextField txt_Gmail;
    private javax.swing.JTextField txt_Luong;
    private javax.swing.JTextField txt_Ma_NV;
    private javax.swing.JTextField txt_Sdt;
    private javax.swing.JTextField txt_Ten_NV;
    // End of variables declaration//GEN-END:variables

    private void Load() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
