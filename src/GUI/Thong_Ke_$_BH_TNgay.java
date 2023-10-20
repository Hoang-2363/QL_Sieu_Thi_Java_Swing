package GUI;

import BLL.Save_Ma_NV;
import DAL.Connect_TKe_$_BH;
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
public class Thong_Ke_$_BH_TNgay extends javax.swing.JFrame {
    
    public void Load() {
        DefaultTableModel tableModel = Connect_TKe_$_BH.TK_Theo_Ngay();
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
    
    public Thong_Ke_$_BH_TNgay() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        txt_Ngay.setText(Save_Ma_NV.getNgay_TK());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txt_Tong_DT = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_Ngay = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống kê tiền bán hàng theo ngày");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel3.setText("Chi tiết hóa đơn bán hàng");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        table_HH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_HH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_HH);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 940, 360));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel6.setText("Tổng tiền hóa đơn");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 240, 40));

        txt_Tong_DT.setEditable(false);
        txt_Tong_DT.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        txt_Tong_DT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Tong_DT, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 480, 450, -1));

        jButton2.setBackground(new java.awt.Color(0, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Xuất File");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Ngày");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 60, 30));

        txt_Ngay.setEditable(false);
        txt_Ngay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ngay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 180, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Thong_Ke_$_BH menu = new Thong_Ke_$_BH();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thong_Ke_$_BH_TNgay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_HH;
    private javax.swing.JTextField txt_Ngay;
    private javax.swing.JTextField txt_Tong_DT;
    // End of variables declaration//GEN-END:variables
}
