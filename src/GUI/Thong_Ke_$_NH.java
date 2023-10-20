package GUI;

import BLL.Save_Ma_NV;
import DAL.Connect_Tke_$_NH;
import static GUI.Thong_Ke_$_BH.Tong_HD;
import java.text.DecimalFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class Thong_Ke_$_NH extends javax.swing.JFrame {
    public void Load() {
        DefaultTableModel tableModel = Connect_Tke_$_NH.TH_BH();
        table_HH.setModel(tableModel);
        table_HH.setRowHeight(30);
        table_HH.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_HH.getColumnModel().getColumn(1).setPreferredWidth(120);
        table_HH.getColumnModel().getColumn(2).setPreferredWidth(200);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
    }
    public Thong_Ke_$_NH() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        Load();
        Tong_HD(table_HH, txt_Tong_DT);
        
        String text = txt_Tong_DT.getText();
        double number = Double.parseDouble(text);
        DecimalFormat format = new DecimalFormat("#,###");
        txt_Tong_DT.setText(format.format(number));
        
        txt_Tu_Ngay.setText("");        
        txt_Den_Ngay.setText("");
        date_Start.setLocale(new Locale("vi", "VN"));
        date_End.setLocale(new Locale("vi", "VN"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Thu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_Ngay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_Tong_tien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_Tu_Ngay = new javax.swing.JTextField();
        date_Start = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txt_Den_Ngay = new javax.swing.JTextField();
        date_End = new com.toedter.calendar.JDateChooser();
        btn_Xem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_Tong_DT = new javax.swing.JTextField();
        btn_Xem_CT = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống kê tiền nhập hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Thống kê tiền nhập hàng");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Thứ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 40, 30));

        txt_Thu.setEditable(false);
        txt_Thu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Thu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Thu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 170, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Ngày");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 60, 30));

        txt_Ngay.setEditable(false);
        txt_Ngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ngay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 160, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Tổng tiền");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 90, 30));

        txt_Tong_tien.setEditable(false);
        txt_Tong_tien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Tong_tien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Tong_tien, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 160, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 870, 260));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Từ ngày");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 80, 30));

        txt_Tu_Ngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Tu_Ngay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Tu_Ngay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Tu_NgayMouseClicked(evt);
            }
        });
        getContentPane().add(txt_Tu_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 140, -1));

        date_Start.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_StartPropertyChange(evt);
            }
        });
        getContentPane().add(date_Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 20, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Đến ngày");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 90, 30));

        txt_Den_Ngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Den_Ngay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Den_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 130, -1));

        date_End.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_EndPropertyChange(evt);
            }
        });
        getContentPane().add(date_End, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 20, 30));

        btn_Xem.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xem.setForeground(new java.awt.Color(255, 51, 51));
        btn_Xem.setText("Xem");
        btn_Xem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Xem, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 110, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel6.setText("Tổng doanh thu");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 210, 40));

        txt_Tong_DT.setEditable(false);
        txt_Tong_DT.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        txt_Tong_DT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Tong_DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 450, -1));

        btn_Xem_CT.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xem_CT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xem_CT.setForeground(new java.awt.Color(255, 51, 51));
        btn_Xem_CT.setText("Xem chi tiết");
        btn_Xem_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Xem_CTActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Xem_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 51));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HHMouseClicked

        int i = table_HH.getSelectedRow();
        if (i != -1) {
            String maLHH = table_HH.getValueAt(i, 0).toString();
            String tenLHH = table_HH.getValueAt(i, 1).toString();
            String ghi_Chu = table_HH.getValueAt(i, 2).toString();

            txt_Thu.setText(maLHH);
            txt_Ngay.setText(tenLHH);
            txt_Tong_tien.setText(ghi_Chu);

            String text = txt_Tong_tien.getText();
            double number = Double.parseDouble(text);
            DecimalFormat format = new DecimalFormat("#,###");
            txt_Tong_tien.setText(format.format(number));
        
            Save_Ma_NV.setNgay_TK(txt_Ngay.getText());
        }
    }//GEN-LAST:event_table_HHMouseClicked

    private void txt_Tu_NgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Tu_NgayMouseClicked
        // TODO add your handling code here:
        Load();
        Tong_HD(table_HH, txt_Tong_DT);
    }//GEN-LAST:event_txt_Tu_NgayMouseClicked

    private void date_StartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_StartPropertyChange
        // TODO add your handling code here:
        java.util.Date selectedDate = date_Start.getDate();
        if (selectedDate != null) {
            String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
            txt_Tu_Ngay.setText(formattedDate);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một ngày trước khi lưu.");
        }
    }//GEN-LAST:event_date_StartPropertyChange

    private void date_EndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_EndPropertyChange
        // TODO add your handling code here:
        java.util.Date selectedDate = date_End.getDate();
        if (selectedDate != null) {
            String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
            txt_Den_Ngay.setText(formattedDate);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một ngày trước khi lưu.");
        }
    }//GEN-LAST:event_date_EndPropertyChange

    private void btn_XemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XemActionPerformed
        // TODO add your handling code here:
        String s = txt_Tu_Ngay.getText();
        String e = txt_Den_Ngay.getText();

        boolean kt = Connect_Tke_$_NH.isValidDate(s, e);

        if (kt) {
            Connect_Tke_$_NH.TK_TK(table_HH, s, e);
            Tong_HD(table_HH, txt_Tong_DT);
        } else {
        }
    }//GEN-LAST:event_btn_XemActionPerformed

    private void btn_Xem_CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Xem_CTActionPerformed
        // TODO add your handling code here:
        if(txt_Ngay.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một ngày nào đó !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Thong_Ke_$_NH_TNgay menu = new Thong_Ke_$_NH_TNgay();
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
                new Thong_Ke_$_NH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JButton btn_Xem;
    private javax.swing.JButton btn_Xem_CT;
    private com.toedter.calendar.JDateChooser date_End;
    private com.toedter.calendar.JDateChooser date_Start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_HH;
    private javax.swing.JTextField txt_Den_Ngay;
    private javax.swing.JTextField txt_Ngay;
    private javax.swing.JTextField txt_Thu;
    private javax.swing.JTextField txt_Tong_DT;
    private javax.swing.JTextField txt_Tong_tien;
    private javax.swing.JTextField txt_Tu_Ngay;
    // End of variables declaration//GEN-END:variables
}
