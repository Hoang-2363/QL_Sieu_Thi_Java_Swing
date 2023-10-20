package GUI;

import BLL.KT_Thong_Ke;
import BLL.Save_Ma_NV;
import DAL.Connect_TKe_$_BH;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class Thong_Ke_Nhan_Vien_HD extends javax.swing.JFrame {
    public void Load() {
        DefaultTableModel tableModel = Connect_TKe_$_BH.TK_HD_Theo_NV();
        table_HH.setModel(tableModel);
        table_HH.setRowHeight(30);
        table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(1).setPreferredWidth(130);
        table_HH.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(4).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(5).setPreferredWidth(100);
        table_HH.getColumnModel().getColumn(6).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
    }
    public static void Tong_HD(JTable table, JTextField tong) {
        int columnIndex = 6;
        int rowCount = table.getRowCount();
        int sum = 0;

        for (int i = 0; i < rowCount; i++) {
            String cellValue = (String) table.getValueAt(i, columnIndex);
            try {
                int value = Integer.parseInt(cellValue);
                sum += value;
            } catch (NumberFormatException ex) {
            }
        }
        tong.setText(String.valueOf(sum));
    }
    public Thong_Ke_Nhan_Vien_HD() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        Load();
        Tong_HD(table_HH, txt_Tong_DT);
        txt_Ma_KH.setText(Save_Ma_NV.getMa_KH_hd());        
        txt_Ten_KH.setText(Save_Ma_NV.getTk_ten_KH());
        txt_SDT.setText(Save_Ma_NV.getSdt());
        txt_Dia_Chi.setText(Save_Ma_NV.getDia_chi());
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
        jLabel5 = new javax.swing.JLabel();
        txt_Tu_Ngay = new javax.swing.JTextField();
        date_Start = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txt_Den_Ngay = new javax.swing.JTextField();
        date_End = new com.toedter.calendar.JDateChooser();
        btn_Xem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_Tong_DT = new javax.swing.JTextField();
        btn_Xuat_File = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách hóa đơn theo nhân viên");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Danh sách hóa đơn KH đã mua");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Mã KH");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 70, 30));

        txt_Ma_KH.setEditable(false);
        txt_Ma_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_KH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ma_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 260, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Họ tên KH");
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Từ ngày");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 80, 30));

        txt_Tu_Ngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Tu_Ngay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Tu_Ngay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Tu_NgayMouseClicked(evt);
            }
        });
        getContentPane().add(txt_Tu_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 140, -1));

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel6.setText("Tổng doanh thu");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 210, 40));

        txt_Tong_DT.setEditable(false);
        txt_Tong_DT.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        txt_Tong_DT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Tong_DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 450, -1));

        btn_Xuat_File.setBackground(new java.awt.Color(0, 255, 204));
        btn_Xuat_File.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Xuat_File.setForeground(new java.awt.Color(255, 51, 51));
        btn_Xuat_File.setText("Xuất File");
        getContentPane().add(btn_Xuat_File, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 51, 51));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 580, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 870, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Tu_NgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Tu_NgayMouseClicked
        // TODO add your handling code here:
        Load();
        //Tong_HD(table_HH, txt_Tong_DT);
    }//GEN-LAST:event_txt_Tu_NgayMouseClicked

    private void date_StartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_StartPropertyChange
        // TODO add your handling code here:
        java.util.Date selectedDate = date_Start.getDate();
        if (selectedDate != null) {
            String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(selectedDate);
            txt_Tu_Ngay.setText(formattedDate);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một ngày trước khi lưu.");
        }
    }//GEN-LAST:event_date_StartPropertyChange

    private void date_EndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_EndPropertyChange
        // TODO add your handling code here:
        java.util.Date selectedDate = date_End.getDate();
        if (selectedDate != null) {
            String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(selectedDate);
            txt_Den_Ngay.setText(formattedDate);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một ngày trước khi lưu.");
        }
    }//GEN-LAST:event_date_EndPropertyChange

    private void btn_XemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XemActionPerformed
        // TODO add your handling code here:
        String s = txt_Tu_Ngay.getText();
        String e = txt_Den_Ngay.getText();
        String t = txt_Ten_KH.getText();

        boolean kt = KT_Thong_Ke.isValidDate1(s, e);

        if (kt) {
            KT_Thong_Ke.TK_TK_NV(table_HH, s, e, t);
            Tong_HD(table_HH, txt_Tong_DT);
        } else {
        }
    }//GEN-LAST:event_btn_XemActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        Thong_Ke_Nhan_Vien menu = new Thong_Ke_Nhan_Vien();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void table_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HHMouseClicked
        // TODO add your handling code here:
        int i = table_HH.getSelectedRow();
        if (i != -1) {
            String maLHH = table_HH.getValueAt(i, 6).toString();
            txt_Tong_DT.setText(maLHH);

            String text = txt_Tong_DT.getText();
            double number = Double.parseDouble(text);
            DecimalFormat format = new DecimalFormat("#,###");
            txt_Tong_DT.setText(format.format(number));
        }
    }//GEN-LAST:event_table_HHMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thong_Ke_Nhan_Vien_HD().setVisible(true);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_HH;
    private javax.swing.JTextField txt_Den_Ngay;
    private javax.swing.JTextField txt_Dia_Chi;
    private javax.swing.JTextField txt_Ma_KH;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_Ten_KH;
    private javax.swing.JTextField txt_Tong_DT;
    private javax.swing.JTextField txt_Tu_Ngay;
    // End of variables declaration//GEN-END:variables
}
