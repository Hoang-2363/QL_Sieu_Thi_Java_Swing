package GUI;

import BLL.KT_Thong_Ke;
import BLL.Save_Ma_NV;
import DAL.Connect_TKe_$_BH;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class Thong_Ke_Nhan_Vien extends javax.swing.JFrame {
    public void Load() {
        DefaultTableModel tableModel = Connect_TKe_$_BH.TK_Nhan_Vien();
        table_HH2.setModel(tableModel);
        table_HH2.setRowHeight(30);
        table_HH2.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_HH2.getColumnModel().getColumn(1).setPreferredWidth(180);
        table_HH2.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_HH2.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_HH2.getColumnModel().getColumn(4).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_HH2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_HH2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table_HH2.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_HH2.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table_HH2.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }
    public Thong_Ke_Nhan_Vien() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH2.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Ma_KH = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_Ten_KH = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_Dia_Chi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_HH2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txt_Tong_DT = new javax.swing.JTextField();
        btn_Xem_CT = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống kê theo nhân viên");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Thống kê nhân viên bán hàng");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Mã NV");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 70, 30));

        txt_Ma_KH.setEditable(false);
        txt_Ma_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_KH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ma_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 260, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Họ tên NV");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 30));

        txt_Ten_KH.setEditable(false);
        txt_Ten_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_KH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 260, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("SĐT");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 50, 30));

        txt_SDT.setEditable(false);
        txt_SDT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_SDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 250, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Địa chỉ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 70, 30));

        txt_Dia_Chi.setEditable(false);
        txt_Dia_Chi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Dia_Chi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Dia_Chi, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 250, -1));

        table_HH2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_HH2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_HH2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HH2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_HH2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 870, 260));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel6.setText("Tổng tiền");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 130, 40));

        txt_Tong_DT.setEditable(false);
        txt_Tong_DT.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        txt_Tong_DT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Tong_DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 450, -1));

        btn_Xem_CT.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xem_CT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xem_CT.setForeground(new java.awt.Color(255, 51, 51));
        btn_Xem_CT.setText("Xem chi tiết");
        btn_Xem_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Xem_CTActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Xem_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 51));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_HH2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HH2MouseClicked

        int i = table_HH2.getSelectedRow();
        if (i != -1) {
            String maLHH = table_HH2.getValueAt(i, 0).toString();
            String tenLHH = table_HH2.getValueAt(i, 1).toString();
            String sdt = table_HH2.getValueAt(i, 2).toString();
            String diachi = table_HH2.getValueAt(i, 3).toString();
            String ghi_Chu = table_HH2.getValueAt(i, 4).toString();

            txt_Ma_KH.setText(maLHH);
            txt_Ten_KH.setText(tenLHH);
            txt_Dia_Chi.setText(diachi);
            txt_SDT.setText(sdt);
            txt_Tong_DT.setText(ghi_Chu);

            Save_Ma_NV.setTk_ten_KH(txt_Ten_KH.getText());            
            Save_Ma_NV.setMa_KH_hd(txt_Ma_KH.getText());
            Save_Ma_NV.setSdt(txt_SDT.getText());
            Save_Ma_NV.setDia_chi(txt_Dia_Chi.getText());
            
            String text = txt_Tong_DT.getText();
            double number = Double.parseDouble(text);
            DecimalFormat format = new DecimalFormat("#,###");
            txt_Tong_DT.setText(format.format(number));
        }
    }//GEN-LAST:event_table_HH2MouseClicked

    private void btn_Xem_CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Xem_CTActionPerformed
        // TODO add your handling code here:
        if(txt_SDT.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một ngày nào đó !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Thong_Ke_Nhan_Vien_HD menu = new Thong_Ke_Nhan_Vien_HD();
            menu.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btn_Xem_CTActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thong_Ke_Nhan_Vien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JButton btn_Xem_CT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_HH2;
    private javax.swing.JTextField txt_Dia_Chi;
    private javax.swing.JTextField txt_Ma_KH;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_Ten_KH;
    private javax.swing.JTextField txt_Tong_DT;
    // End of variables declaration//GEN-END:variables
}
