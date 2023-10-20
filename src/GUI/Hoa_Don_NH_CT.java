package GUI;

import DAL.Connect_HD_Nhap_H;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class Hoa_Don_NH_CT extends javax.swing.JFrame {
    public void Load() {
        DefaultTableModel tableModel = Connect_HD_Nhap_H.getData2();
        table_HH.setModel(tableModel);
        table_HH.setRowHeight(30);
        table_HH.getColumnModel().getColumn(0).setPreferredWidth(300);
        table_HH.getColumnModel().getColumn(1).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(4).setPreferredWidth(80);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

    }
    public static void Tong_HD(JTable table, JTextField tong) {
        int columnIndex = 4;
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
    
    public Hoa_Don_NH_CT() {
        initComponents();
         this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Connect_HD_Nhap_H.Load_TT(txt_Ma_HD_BH, txt_Thoi_Gian_TT, txt_Ten_Nv, txt_Ten_KH, txt_SDT, txt_Dia_Chi);
        Load();
        Tong_HD(table_HH, txt_Tong_DT);
        
         String text = txt_Tong_DT.getText();
        double number = Double.parseDouble(text);
        DecimalFormat format = new DecimalFormat("#,###");
        txt_Tong_DT.setText(format.format(number));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Ma_HD_BH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_Thoi_Gian_TT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Ten_Nv = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Ten_KH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_Dia_Chi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txt_Tong_DT = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hóa đơn nhập hàng chi tiết");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel3.setText("Hóa đơn nhập hàng chi tiết");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Mã HD nhập hàng");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

        txt_Ma_HD_BH.setEditable(false);
        txt_Ma_HD_BH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_HD_BH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ma_HD_BH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 240, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Thời gian lập hóa đơn");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 30));

        txt_Thoi_Gian_TT.setEditable(false);
        txt_Thoi_Gian_TT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Thoi_Gian_TT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Thoi_Gian_TT, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 240, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Tên nhân viên");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, 30));

        txt_Ten_Nv.setEditable(false);
        txt_Ten_Nv.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_Nv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_Nv, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 240, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Tên NC Cấp");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, 30));

        txt_Ten_KH.setEditable(false);
        txt_Ten_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_KH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 340, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("SĐT");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, 30));

        txt_SDT.setEditable(false);
        txt_SDT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_SDT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 340, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Địa chỉ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, -1, 30));

        txt_Dia_Chi.setEditable(false);
        txt_Dia_Chi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Dia_Chi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Dia_Chi, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 340, -1));

        table_HH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_HH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table_HH);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 1010, 250));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel6.setText("Tổng tiền hóa đơn");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 240, 40));

        jButton6.setBackground(new java.awt.Color(0, 255, 204));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 0, 0));
        jButton6.setText("Xuất File");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, -1, -1));

        txt_Tong_DT.setEditable(false);
        txt_Tong_DT.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        txt_Tong_DT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Tong_DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 450, -1));

        jButton3.setBackground(new java.awt.Color(0, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoa_Don_NH_CT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_HH;
    private javax.swing.JTextField txt_Dia_Chi;
    private javax.swing.JTextField txt_Ma_HD_BH;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_Ten_KH;
    private javax.swing.JTextField txt_Ten_Nv;
    private javax.swing.JTextField txt_Thoi_Gian_TT;
    private javax.swing.JTextField txt_Tong_DT;
    // End of variables declaration//GEN-END:variables
}
