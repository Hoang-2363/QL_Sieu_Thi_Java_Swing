package GUI;

import BLL.KT_Loai_Hang_Hoa;
import DAL.Connect_Loai_HH;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class QL_Loai_HH extends javax.swing.JFrame {
    public void Load(){
        Connect_Loai_HH db = new Connect_Loai_HH();
        DefaultTableModel tableModel = db.getData();
        table_Loai_HH.setModel(tableModel);
        table_Loai_HH.setRowHeight(30);
        table_Loai_HH.getColumnModel().getColumn(0).setPreferredWidth(80);    
        table_Loai_HH.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_Loai_HH.getColumnModel().getColumn(2).setPreferredWidth(90);      
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table_Loai_HH.getColumnCount(); i++) {
            table_Loai_HH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    public QL_Loai_HH() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        TableCellRenderer rendererFromHeader = table_Loai_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
         Load();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Ma_LHH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Ten_LHH = new javax.swing.JTextField();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Ghi_Chu = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Loai_HH = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý loại hàng hóa");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel2.setText("Quản lý loại hàng hóa");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mã loại hàng hóa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        txt_Ma_LHH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_LHH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ma_LHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 260, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Ghi chú");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tên loại hàng hóa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 160, 30));

        txt_Ten_LHH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_LHH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_LHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 260, -1));

        btn_Them.setBackground(new java.awt.Color(0, 255, 204));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 51, 0));
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, -1, -1));

        btn_Sua.setBackground(new java.awt.Color(0, 255, 204));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Sua.setForeground(new java.awt.Color(255, 51, 0));
        btn_Sua.setText("Lưu");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Sua, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, -1, -1));

        btn_Xoa.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xoa.setForeground(new java.awt.Color(255, 51, 0));
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Xoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 0));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, -1, -1));

        txt_Ghi_Chu.setColumns(20);
        txt_Ghi_Chu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ghi_Chu.setLineWrap(true);
        txt_Ghi_Chu.setRows(3);
        jScrollPane1.setViewportView(txt_Ghi_Chu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 220, 100));

        table_Loai_HH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_Loai_HH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_Loai_HH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Loai_HHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Loai_HH);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 820, 260));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 840, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        String ma_LHH = txt_Ma_LHH.getText();        
        String ten_LHH = txt_Ten_LHH.getText();
        String ghi_chu = txt_Ghi_Chu.getText();
        
        KT_Loai_Hang_Hoa db = new KT_Loai_Hang_Hoa();
        boolean kt = db.themLoaiHH(ma_LHH, ten_LHH, ghi_chu);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã thêm loại hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            txt_Ma_LHH.setText("");            
            txt_Ten_LHH.setText("");
            txt_Ghi_Chu.setText("");

        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        String maLHH = txt_Ma_LHH.getText();        
        String tenLHH = txt_Ten_LHH.getText();
        String ghiChu = txt_Ghi_Chu.getText();
        
        KT_Loai_Hang_Hoa db = new KT_Loai_Hang_Hoa();
        boolean kt = db.suaLoaiHH(maLHH, tenLHH, ghiChu);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã sửa loại hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            txt_Ma_LHH.setText("");            
            txt_Ten_LHH.setText("");
            txt_Ghi_Chu.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        KT_Loai_Hang_Hoa db = new KT_Loai_Hang_Hoa();
        boolean kt = db.xoaLoaiHH(txt_Ma_LHH.getText());

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã xóa khách hàng thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            txt_Ma_LHH.setText("");            
            txt_Ten_LHH.setText("");
            txt_Ghi_Chu.setText("");
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

    private void table_Loai_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Loai_HHMouseClicked
        // TODO add your handling code here:
        int i = table_Loai_HH.getSelectedRow();
        if (i != -1) {
            String maLHH = table_Loai_HH.getValueAt(i, 0).toString();
            String tenLHH = table_Loai_HH.getValueAt(i, 1).toString();
            String ghi_Chu = table_Loai_HH.getValueAt(i, 2).toString();      

            txt_Ma_LHH.setText(maLHH);
            txt_Ten_LHH.setText(tenLHH);            
            txt_Ghi_Chu.setText(ghi_Chu);
        }
    }//GEN-LAST:event_table_Loai_HHMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_Loai_HH().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_Loai_HH;
    private javax.swing.JTextArea txt_Ghi_Chu;
    private javax.swing.JTextField txt_Ma_LHH;
    private javax.swing.JTextField txt_Ten_LHH;
    // End of variables declaration//GEN-END:variables
}
