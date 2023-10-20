package GUI;

import BLL.KT_HH_Click_Cbo;
import BLL.KT_Hang_Hoa;
import DAL.Connect_Cbo_MLHH;
import DAL.Connect_Cbo_MNCC;
import DAL.Connect_HH;
import static com.microsoft.sqlserver.jdbc.StringUtils.isInteger;
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
public class QL_HH extends javax.swing.JFrame {
    public void Load() {
        Connect_HH db = new Connect_HH();
        DefaultTableModel tableModel = db.getData();
        table_HH.setModel(tableModel);
        table_HH.setRowHeight(30);
        table_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(1).setPreferredWidth(160);
        table_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
        table_HH.getColumnModel().getColumn(4).setPreferredWidth(90);
        table_HH.getColumnModel().getColumn(5).setPreferredWidth(100);
        table_HH.getColumnModel().getColumn(6).setPreferredWidth(100);
        table_HH.getColumnModel().getColumn(7).setPreferredWidth(100);
        table_HH.getColumnModel().getColumn(8).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        table_HH.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);

    }

    public QL_HH() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        Connect_Cbo_MLHH.load(txt_Ma_LHH);
        Connect_Cbo_MNCC.load(txt_Ma_NCC);        
        Connect_Cbo_MLHH.load1(txt_Ten_LHH);         
        Connect_Cbo_MNCC.load1(txt_Ten_NCC);
        
        Load();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Ten_HH = new javax.swing.JTextField();
        txt_Ma_HH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Don_vitinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_SL_ton = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Gia_Ban = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_Gia_Nhap = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Ghichu = new javax.swing.JTextArea();
        txt_Ma_LHH = new javax.swing.JComboBox<>();
        txt_Ma_NCC = new javax.swing.JComboBox<>();
        txt_Ten_LHH = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_Ten_NCC = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bán hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel3.setText("Quản lý hàng hóa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mã hàng hóa");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tên hàng hóa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 30));

        txt_Ten_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_HH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Ten_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 290, -1));

        txt_Ma_HH.setEditable(false);
        txt_Ma_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_HH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Ma_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ma_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 290, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Đơn vị tính");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 100, 30));

        txt_Don_vitinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Don_vitinh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Don_vitinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 290, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Số lượng tồn");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 120, 30));

        txt_SL_ton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_SL_ton.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_SL_ton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 290, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Ghi chú");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 70, 30));

        txt_Gia_Ban.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Gia_Ban.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Gia_Ban, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 290, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Giá bán");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 70, 30));

        txt_Gia_Nhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Gia_Nhap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Gia_Nhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 290, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Giá nhập");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Mã loại hàng");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 120, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Mã NC Cấp");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 100, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 940, 280));

        txt_Ghichu.setColumns(20);
        txt_Ghichu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ghichu.setRows(2);
        txt_Ghichu.setTabSize(6);
        jScrollPane2.setViewportView(txt_Ghichu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 280, 90));

        txt_Ma_LHH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_LHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma_LHHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ma_LHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 280, -1));

        txt_Ma_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma_NCCActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ma_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 280, -1));

        txt_Ten_LHH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_LHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ten_LHHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ten_LHH, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 280, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Tên loại hàng");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 120, 30));

        txt_Ten_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ten_NCCActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ten_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 280, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Tên NC Cấp");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 100, 30));

        btnThem.setBackground(new java.awt.Color(0, 255, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 0, 0));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, -1, -1));

        btnSua.setBackground(new java.awt.Color(0, 255, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 0, 0));
        btnSua.setText("Lưu");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, -1, -1));

        btnXoa.setBackground(new java.awt.Color(0, 255, 204));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 0, 0));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 630, -1, -1));

        btnThoat.setBackground(new java.awt.Color(0, 255, 204));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 0, 0));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 630, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Ma_LHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma_LHHActionPerformed
        // TODO add your handling code here:
        KT_HH_Click_Cbo.load2(txt_Ma_LHH, txt_Ten_LHH);
    }//GEN-LAST:event_txt_Ma_LHHActionPerformed

    private void txt_Ten_LHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ten_LHHActionPerformed
        // TODO add your handling code here:
        KT_HH_Click_Cbo.load1(txt_Ten_LHH, txt_Ma_LHH);
    }//GEN-LAST:event_txt_Ten_LHHActionPerformed

    private void txt_Ten_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ten_NCCActionPerformed
        // TODO add your handling code here:
        KT_HH_Click_Cbo.load3(txt_Ten_NCC, txt_Ma_NCC);
    }//GEN-LAST:event_txt_Ten_NCCActionPerformed

    private void txt_Ma_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma_NCCActionPerformed
        // TODO add your handling code here:
        KT_HH_Click_Cbo.load4(txt_Ma_NCC, txt_Ten_NCC);
    }//GEN-LAST:event_txt_Ma_NCCActionPerformed

    private void table_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HHMouseClicked
        int i = table_HH.getSelectedRow();
        if (i != -1) {
            String maHH = table_HH.getValueAt(i, 0).toString();
            String tenHH = table_HH.getValueAt(i, 1).toString();
            String giaN = table_HH.getValueAt(i, 2).toString();
            String giaB = table_HH.getValueAt(i, 3).toString();
            String dvt = table_HH.getValueAt(i, 4).toString();
            String slt = table_HH.getValueAt(i, 5).toString();
            String ghichu = table_HH.getValueAt(i, 6).toString();
            String maNCC = table_HH.getValueAt(i, 7).toString();
            String maLHH = table_HH.getValueAt(i, 8).toString();

            txt_Ma_HH.setText(maHH);
            txt_Ten_HH.setText(tenHH);
            txt_Gia_Nhap.setText(giaN);
            txt_Gia_Ban.setText(giaB);
            txt_Don_vitinh.setText(dvt);
            txt_SL_ton.setText(slt);
            txt_Ghichu.setText(ghichu);
            txt_Ma_NCC.setSelectedItem(maNCC);
            txt_Ma_LHH.setSelectedItem(maLHH);
            
        }
    }//GEN-LAST:event_table_HHMouseClicked

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
            Load();
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
            Load();
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:        
        KT_Hang_Hoa db = new KT_Hang_Hoa();
        boolean kt = db.xoaHH(txt_Ma_HH.getText());

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã xóa hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
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
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txt_Ma_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma_HHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Ma_HHActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_HH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_HH;
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
