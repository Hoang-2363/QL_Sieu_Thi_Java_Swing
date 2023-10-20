package GUI;

import BLL.KT_Thong_Ke;
import DAL.Connect_TKe_$_BH;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class Thong_Ke_HH_So_Luong_Da_N extends javax.swing.JFrame {
    public void Load() {
        DefaultTableModel tableModel = Connect_TKe_$_BH.TK_HH_Nhap();
        table_HH3.setModel(tableModel);
        table_HH3.setRowHeight(30);
        table_HH3.getColumnModel().getColumn(0).setPreferredWidth(200);
        table_HH3.getColumnModel().getColumn(1).setPreferredWidth(80);
        table_HH3.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_HH3.getColumnModel().getColumn(3).setPreferredWidth(100);
        table_HH3.getColumnModel().getColumn(4).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_HH3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_HH3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table_HH3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_HH3.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table_HH3.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }
    public Thong_Ke_HH_So_Luong_Da_N() {
        initComponents();
         this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH3.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        Load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Ten_HH = new javax.swing.JTextField();
        txt_Tim_Theo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_So_Luong = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_HH3 = new javax.swing.JTable();
        txt_Tu_Ngay1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        date_Start = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txt_Den_Ngay = new javax.swing.JTextField();
        date_End = new com.toedter.calendar.JDateChooser();
        btn_Xem = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        btn_Xuat_File = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Số lượng hàng hóa đã nhập");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Danh sách hàng hóa đã nhập");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Thông tin");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 90, 30));

        txt_Ten_HH.setEditable(false);
        txt_Ten_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_HH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 420, -1));

        txt_Tim_Theo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Tim_Theo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên hàng hóa", "Loại hàng hóa", "Nhà cung cấp" }));
        txt_Tim_Theo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Tim_TheoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Tim_Theo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Số lượng");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 80, 30));

        txt_So_Luong.setEditable(false);
        txt_So_Luong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_So_Luong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_So_Luong, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 140, -1));

        table_HH3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_HH3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_HH3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HH3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_HH3);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 870, 280));

        txt_Tu_Ngay1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Tu_Ngay1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Tu_Ngay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Tu_Ngay1MouseClicked(evt);
            }
        });
        getContentPane().add(txt_Tu_Ngay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Từ ngày");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 80, 30));

        date_Start.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_StartPropertyChange(evt);
            }
        });
        getContentPane().add(date_Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 20, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Đến ngày");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 90, 30));

        txt_Den_Ngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Den_Ngay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Den_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 130, -1));

        date_End.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_EndPropertyChange(evt);
            }
        });
        getContentPane().add(date_End, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 20, 30));

        btn_Xem.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xem.setForeground(new java.awt.Color(255, 51, 51));
        btn_Xem.setText("Xem");
        btn_Xem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Xem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 110, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 51));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, -1, -1));

        btn_Xuat_File.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xuat_File.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xuat_File.setForeground(new java.awt.Color(255, 51, 51));
        btn_Xuat_File.setText("Xuất File");
        getContentPane().add(btn_Xuat_File, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Tim_TheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Tim_TheoActionPerformed
        // TODO add your handling code here:
        if (txt_Tim_Theo.getSelectedItem().equals("Tên hàng hóa")) {
            txt_Ten_HH.setText("");
            txt_So_Luong.setText("");
            Load();
        } else if (txt_Tim_Theo.getSelectedItem().equals("Nhà cung cấp")) {
            txt_Ten_HH.setText("");
            txt_So_Luong.setText("");
            Connect_TKe_$_BH.TK_HH_Nhap_Nha_Cung_Cap(table_HH3);
        } else if (txt_Tim_Theo.getSelectedItem().equals("Loại hàng hóa")) {
            txt_Ten_HH.setText("");
            txt_So_Luong.setText("");
            Connect_TKe_$_BH.TK_HH_Nhap_LHH(table_HH3);
        }
    }//GEN-LAST:event_txt_Tim_TheoActionPerformed

    private void table_HH3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HH3MouseClicked
        // TODO add your handling code here:
        int i = table_HH3.getSelectedRow();
        if (i != -1) {
            String tenHH = table_HH3.getValueAt(i, 0).toString();
            String sl = table_HH3.getValueAt(i, 1).toString();
            txt_Ten_HH.setText(tenHH);
            txt_So_Luong.setText(sl);
        }
    }//GEN-LAST:event_table_HH3MouseClicked

    private void txt_Tu_Ngay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Tu_Ngay1MouseClicked
        // TODO add your handling code here:
        Load();
    }//GEN-LAST:event_txt_Tu_Ngay1MouseClicked

    private void date_StartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_StartPropertyChange
        // TODO add your handling code here:
        java.util.Date selectedDate = date_Start.getDate();
        if (selectedDate != null) {
            String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
            txt_Tu_Ngay1.setText(formattedDate);
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
        String s = txt_Tu_Ngay1.getText();
        String e = txt_Den_Ngay.getText();

        boolean kt = KT_Thong_Ke.isValidDate(s, e);

        if (kt) {
            if (txt_Tim_Theo.getSelectedItem().equals("Tên hàng hóa")) {
                Connect_TKe_$_BH.Tim_kiem_Theo_Ngay_Nhap_Ten(table_HH3, s, e);
            } else if (txt_Tim_Theo.getSelectedItem().equals("Nhà cung cấp")) {
                Connect_TKe_$_BH.Tim_kiem_Theo_ngay_Nhap_NCC(table_HH3, s, e);

            } else if (txt_Tim_Theo.getSelectedItem().equals("Loại hàng hóa")) {
                Connect_TKe_$_BH.Tim_kiem_Theo_ngay_Nhap_LHH(table_HH3, s, e);
            }
        } else {
        }
    }//GEN-LAST:event_btn_XemActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thong_Ke_HH_So_Luong_Da_N().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JButton btn_Xem;
    private javax.swing.JButton btn_Xuat_File;
    private com.toedter.calendar.JDateChooser date_End;
    private com.toedter.calendar.JDateChooser date_Start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable table_HH3;
    private javax.swing.JTextField txt_Den_Ngay;
    private javax.swing.JTextField txt_So_Luong;
    private javax.swing.JTextField txt_Ten_HH;
    private javax.swing.JComboBox<String> txt_Tim_Theo;
    private javax.swing.JTextField txt_Tu_Ngay1;
    // End of variables declaration//GEN-END:variables
}
