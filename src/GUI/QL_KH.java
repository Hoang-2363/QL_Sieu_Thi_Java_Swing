package GUI;

import BLL.KT_Khach_Hang;
import DAL.Connect_Khach_Hang;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class QL_KH extends javax.swing.JFrame {
    public void Load(){
        Connect_Khach_Hang db = new Connect_Khach_Hang();
        DefaultTableModel tableModel = db.getData();
        table_KH.setModel(tableModel);
        table_KH.setRowHeight(30);
        table_KH.getColumnModel().getColumn(0).setPreferredWidth(50);    
        table_KH.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_KH.getColumnModel().getColumn(2).setPreferredWidth(90);        
        table_KH.getColumnModel().getColumn(3).setPreferredWidth(110);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table_KH.getColumnCount(); i++) {
            table_KH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    public QL_KH() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        TableCellRenderer rendererFromHeader = table_KH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Load();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Ma_KH = new javax.swing.JTextField();
        txt_Ten_KH = new javax.swing.JTextField();
        txt_Dia_Chi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_KH = new javax.swing.JTable();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý khách hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Quản lý khách hàng");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mã khách hàng");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tên khách hàng");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Địa chỉ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, 30));

        txt_Ma_KH.setEditable(false);
        txt_Ma_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_KH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ma_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 210, -1));

        txt_Ten_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_KH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 210, -1));

        txt_Dia_Chi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Dia_Chi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Dia_Chi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 230, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Số điện thoại");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 30));

        txt_SDT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_SDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 230, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 850, 260));

        btn_Them.setBackground(new java.awt.Color(0, 255, 204));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 51, 0));
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        btn_Sua.setBackground(new java.awt.Color(0, 255, 204));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 51, 0));
        btn_Sua.setText("Lưu");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        btn_Xoa.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 51, 0));
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 0));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        String hoTen = txt_Ten_KH.getText();        
        String sdt = txt_SDT.getText();
        String diaChi = txt_Dia_Chi.getText();
        
        KT_Khach_Hang db = new KT_Khach_Hang();
        boolean kt = db.themKhachHang(hoTen, sdt, diaChi);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã thêm khách hàng thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            txt_Ma_KH.setText("");            
            txt_Ten_KH.setText("");
            txt_SDT.setText("");
            txt_Dia_Chi.setText("");

        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void table_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KHMouseClicked
        // TODO add your handling code here:
        int i = table_KH.getSelectedRow();
        if (i != -1) {
            String maKH = table_KH.getValueAt(i, 0).toString();
            String hoTen = table_KH.getValueAt(i, 1).toString();
            String sdt = table_KH.getValueAt(i, 2).toString();            
            String diaChi = table_KH.getValueAt(i, 3).toString();

            txt_Ma_KH.setText(maKH);
            txt_Ten_KH.setText(hoTen);            
            txt_SDT.setText(sdt);
            txt_Dia_Chi.setText(diaChi);
        }
    }//GEN-LAST:event_table_KHMouseClicked

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        String hoTen = txt_Ten_KH.getText();        
        String sdt = txt_SDT.getText();
        String diaChi = txt_Dia_Chi.getText();
        
        KT_Khach_Hang db = new KT_Khach_Hang();
        boolean kt = db.suaKH(txt_Ma_KH.getText(), hoTen, sdt, diaChi);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã sửa khách hàng thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            txt_Ma_KH.setText("");            
            txt_Ten_KH.setText("");
            txt_SDT.setText("");
            txt_Dia_Chi.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        KT_Khach_Hang db = new KT_Khach_Hang();
        boolean kt = db.xoaKH(txt_Ma_KH.getText());

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã xóa khách hàng thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            txt_Ma_KH.setText("");            
            txt_Ten_KH.setText("");
            txt_SDT.setText("");
            txt_Dia_Chi.setText("");
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_KH().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_KH;
    private javax.swing.JTextField txt_Dia_Chi;
    private javax.swing.JTextField txt_Ma_KH;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_Ten_KH;
    // End of variables declaration//GEN-END:variables
}
