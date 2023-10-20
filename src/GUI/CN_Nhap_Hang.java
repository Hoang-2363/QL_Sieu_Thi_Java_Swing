package GUI;

import BLL.KT_CTiet_HD_BH;
import BLL.KT_CTiet_HD_Nhap_H;
import BLL.Save_Ma_NV;
import DAL.Connect_CTiet_HD_NhapH;
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
public class CN_Nhap_Hang extends javax.swing.JFrame {
    public void Load() {
        DefaultTableModel tableModel = Connect_CTiet_HD_NhapH.table_Nhap_hang();
        table_Nhap_HH.setModel(tableModel);
        table_Nhap_HH.setRowHeight(30);

        table_Nhap_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_Nhap_HH.getColumnModel().getColumn(1).setPreferredWidth(230);
        table_Nhap_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_Nhap_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
        table_Nhap_HH.getColumnModel().getColumn(4).setPreferredWidth(80);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_Nhap_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_Nhap_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_Nhap_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table_Nhap_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }
    public CN_Nhap_Hang() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        TableCellRenderer rendererFromHeader1 = table_NCC.getTableHeader().getDefaultRenderer();
        JLabel headerLabel1 = (JLabel) rendererFromHeader1;
        headerLabel1.setHorizontalAlignment(JLabel.CENTER);

        TableCellRenderer rendererFromHeader2 = table_Nhap_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel2 = (JLabel) rendererFromHeader2;
        headerLabel2.setHorizontalAlignment(JLabel.CENTER);
        
        Connect_CTiet_HD_NhapH.table_HH(table_HH);
        Connect_CTiet_HD_NhapH.table_NCC(table_NCC);
        
        String tk = Save_Ma_NV.getTK();        
        String mk = Save_Ma_NV.getMK();
        Connect_CTiet_HD_NhapH.load_Ma_NV(txt_Ma_NV, tk, mk);
        Connect_CTiet_HD_NhapH.load_Ma_HH(txt_Ma_HH);
        Connect_CTiet_HD_NhapH.load_Ten_HH(txt_Ten_HH);
        
        Load();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        txt_CBo_Hang_Hoa = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_HT_HH = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_Ma_HH = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_Ten_HH = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_So_Luong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Gia_Nhap = new javax.swing.JTextField();
        btn_Them_HH = new javax.swing.JButton();
        btnSua_HH = new javax.swing.JButton();
        btnXoa_HH = new javax.swing.JButton();
        btn_Thong_Tin_HH = new javax.swing.JButton();
        btnThem_HH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Nhap_HH = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txt_CBo_NCC = new javax.swing.JComboBox<>();
        txt_Thong_Tin_NCC = new javax.swing.JTextField();
        btn_Thong_Tin_NCC = new javax.swing.JButton();
        btnThem_NCC = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_NCC = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_Ma_NV = new javax.swing.JComboBox<>();
        btn_Thanh_Toan = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nhập hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Palatino Linotype", 3, 22)); // NOI18N
        jLabel9.setText("Bảng hàng hóa");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 1, -1, 40));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 340));

        txt_CBo_Hang_Hoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_CBo_Hang_Hoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên hàng", "Mã NC Cấp", "Loại hàng hóa", "Nhà cung cấp" }));
        txt_CBo_Hang_Hoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CBo_Hang_HoaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_CBo_Hang_Hoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 170, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Tìm theo");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 80, 30));

        txt_HT_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_HT_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 340, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Mã hàng hóa");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 120, 30));

        txt_Ma_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ma_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 260, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Tên hàng hóa");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 120, 30));

        txt_Ten_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ten_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ten_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 260, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Số lượng");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 80, 30));

        txt_So_Luong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_So_Luong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_So_Luong, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 540, 260, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Giá nhập hàng");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 130, 30));

        txt_Gia_Nhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Gia_Nhap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_Gia_Nhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 260, -1));

        btn_Them_HH.setBackground(new java.awt.Color(0, 255, 204));
        btn_Them_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Them_HH.setForeground(new java.awt.Color(255, 0, 0));
        btn_Them_HH.setText("Thêm");
        btn_Them_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Them_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Them_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, 90, -1));

        btnSua_HH.setBackground(new java.awt.Color(0, 255, 204));
        btnSua_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua_HH.setForeground(new java.awt.Color(255, 0, 0));
        btnSua_HH.setText("Lưu");
        btnSua_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, 80, -1));

        btnXoa_HH.setBackground(new java.awt.Color(0, 255, 204));
        btnXoa_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa_HH.setForeground(new java.awt.Color(255, 0, 0));
        btnXoa_HH.setText("Xóa");
        btnXoa_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 640, 80, -1));

        btn_Thong_Tin_HH.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thong_Tin_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thong_Tin_HH.setForeground(new java.awt.Color(255, 0, 0));
        btn_Thong_Tin_HH.setText("Tìm kiếm");
        btn_Thong_Tin_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Thong_Tin_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thong_Tin_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, -1, -1));

        btnThem_HH.setBackground(new java.awt.Color(0, 255, 204));
        btnThem_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem_HH.setForeground(new java.awt.Color(255, 0, 0));
        btnThem_HH.setText("+");
        btnThem_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, -1));

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 3, 24)); // NOI18N
        jLabel4.setText("Bảng nhập hàng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, -1, 50));

        table_Nhap_HH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_Nhap_HH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_Nhap_HH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Nhap_HHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Nhap_HH);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 720, 220));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Tìm theo");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 80, 30));

        txt_CBo_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_CBo_NCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên nhà cung cấp", "Số điện thoại" }));
        txt_CBo_NCC.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_CBo_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CBo_NCCActionPerformed(evt);
            }
        });
        getContentPane().add(txt_CBo_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 200, -1));

        txt_Thong_Tin_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Thong_Tin_NCC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Thong_Tin_NCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Thong_Tin_NCCMouseClicked(evt);
            }
        });
        getContentPane().add(txt_Thong_Tin_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, 210, 30));

        btn_Thong_Tin_NCC.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thong_Tin_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thong_Tin_NCC.setForeground(new java.awt.Color(255, 0, 0));
        btn_Thong_Tin_NCC.setText("Tìm kiếm nhà cung cấp");
        btn_Thong_Tin_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Thong_Tin_NCCActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thong_Tin_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 240, -1));

        btnThem_NCC.setBackground(new java.awt.Color(0, 255, 204));
        btnThem_NCC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem_NCC.setForeground(new java.awt.Color(255, 0, 0));
        btnThem_NCC.setText("+");
        btnThem_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_NCCActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem_NCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 3, 22)); // NOI18N
        jLabel3.setText("Bảng nhà cung cấp");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, -1, 40));

        table_NCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_NCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_NCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_NCCMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_NCC);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 510, 250));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Mã nhân viên");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, -1, 30));

        txt_Ma_NV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_Ma_NV, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, 100, -1));

        btn_Thanh_Toan.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thanh_Toan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thanh_Toan.setForeground(new java.awt.Color(255, 0, 0));
        btn_Thanh_Toan.setText("Nhập hàng");
        btn_Thanh_Toan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Thanh_ToanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thanh_Toan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 520, 140, -1));

        btnThoat.setBackground(new java.awt.Color(0, 255, 204));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 0, 0));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 590, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HHMouseClicked
        int i = table_HH.getSelectedRow();
        if (i != -1) {
            String maHH = table_HH.getValueAt(i, 0).toString();
            String tenHH = table_HH.getValueAt(i, 1).toString();             
            String gia = table_HH.getValueAt(i, 4).toString();           
            txt_Ma_HH.setSelectedItem(maHH);
            txt_Ten_HH.setSelectedItem(tenHH);
            txt_So_Luong.setText("");            
            txt_Gia_Nhap.setText(gia);
            
        }
    }//GEN-LAST:event_table_HHMouseClicked

    private void txt_CBo_Hang_HoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CBo_Hang_HoaActionPerformed
        KT_CTiet_HD_Nhap_H.load_TK_HH(txt_HT_HH, txt_CBo_Hang_Hoa);
        Connect_CTiet_HD_NhapH.table_HH(table_HH);
    }//GEN-LAST:event_txt_CBo_Hang_HoaActionPerformed

    private void txt_Ma_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma_HHActionPerformed
        KT_CTiet_HD_BH.load_ten_HH(txt_Ma_HH, txt_Ten_HH);
    }//GEN-LAST:event_txt_Ma_HHActionPerformed

    private void txt_Ten_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ten_HHActionPerformed
        KT_CTiet_HD_BH.load_ma_HH(txt_Ten_HH, txt_Ma_HH);
    }//GEN-LAST:event_txt_Ten_HHActionPerformed

    private void btn_Them_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Them_HHActionPerformed
        String maHH = (String) txt_Ma_HH.getSelectedItem();
        String soLuong = txt_So_Luong.getText();
        String gia_Nhap = txt_Gia_Nhap.getText();

        boolean kt = KT_CTiet_HD_Nhap_H.them_CTiet_HD_NH(maHH, soLuong, gia_Nhap);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã nhập hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            txt_Ma_HH.setSelectedIndex(0);
            txt_Ten_HH.setSelectedIndex(0);
            txt_So_Luong.setText("");
            txt_Gia_Nhap.setText("");
            Load();
            Connect_CTiet_HD_NhapH.table_HH(table_HH);
            
        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_Them_HHActionPerformed

    private void btnSua_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_HHActionPerformed
        String ma_HH = (String) txt_Ma_HH.getSelectedItem();
        String soLuong = txt_So_Luong.getText();
        String soLuong_da_mua = Save_Ma_NV.getSo_Luong_Da_Mua_1();
        boolean kt = KT_CTiet_HD_Nhap_H.sua_CTiet_HD(ma_HH, soLuong, soLuong_da_mua);
        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã sửa hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load();
            Connect_CTiet_HD_NhapH.table_HH(table_HH);
            txt_Ma_HH.setSelectedIndex(0);
            txt_Ten_HH.setSelectedIndex(0);
            txt_So_Luong.setText("");
            txt_Gia_Nhap.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSua_HHActionPerformed

    private void btnXoa_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_HHActionPerformed
        String ma_HH = (String) txt_Ma_HH.getSelectedItem();
        boolean kt = KT_CTiet_HD_Nhap_H.xoa_CTiet_HD(ma_HH, txt_So_Luong.getText());
        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã xóa hàng hóa nhập thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            txt_Ma_HH.setSelectedIndex(0);
            txt_Ten_HH.setSelectedIndex(0);
            txt_So_Luong.setText("");
            txt_Gia_Nhap.setText("");
            Load();
            Connect_CTiet_HD_NhapH.table_HH(table_HH);
        } else {
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoa_HHActionPerformed

    private void btn_Thong_Tin_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Thong_Tin_HHActionPerformed
        if (txt_CBo_Hang_Hoa.getSelectedItem().equals("Tên hàng")) {
            KT_CTiet_HD_Nhap_H.TK_HH_Ten_HH(txt_HT_HH, table_HH);
        } else if (txt_CBo_Hang_Hoa.getSelectedItem().equals("Nhà cung cấp")) {
            KT_CTiet_HD_Nhap_H.TK_HH_NCC(txt_HT_HH, table_HH);
        } else if (txt_CBo_Hang_Hoa.getSelectedItem().equals("Loại hàng hóa")) {
            KT_CTiet_HD_Nhap_H.TK_HH_LHH(txt_HT_HH, table_HH);
        }else if (txt_CBo_Hang_Hoa.getSelectedItem().equals("Mã NC Cấp")) {
            KT_CTiet_HD_Nhap_H.TK_HH_Ma_NCC(txt_HT_HH, table_HH);
        }
    }//GEN-LAST:event_btn_Thong_Tin_HHActionPerformed

    private void btnThem_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_HHActionPerformed
        Chi_T_HD_NH_Them_HH themKH = new Chi_T_HD_NH_Them_HH();
        themKH.setVisible(true);
    }//GEN-LAST:event_btnThem_HHActionPerformed

    private void table_Nhap_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Nhap_HHMouseClicked
        int i = table_Nhap_HH.getSelectedRow();
        if (i != -1) {
            String maHH = table_Nhap_HH.getValueAt(i, 0).toString();
            String tenHH = table_Nhap_HH.getValueAt(i, 1).toString();
            String soluong = table_Nhap_HH.getValueAt(i, 2).toString();
            String gia = table_Nhap_HH.getValueAt(i, 3).toString();

            Save_Ma_NV.setSo_Luong_Da_Mua_1(soluong);

            txt_Ma_HH.setSelectedItem(maHH);
            txt_Ten_HH.setSelectedItem(tenHH);
            txt_So_Luong.setText(soluong);
            txt_Gia_Nhap.setText(gia);
            
        }
    }//GEN-LAST:event_table_Nhap_HHMouseClicked

    private void txt_CBo_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CBo_NCCActionPerformed
        txt_Thong_Tin_NCC.setText("");
        Connect_CTiet_HD_NhapH.table_NCC(table_NCC);
    }//GEN-LAST:event_txt_CBo_NCCActionPerformed

    private void txt_Thong_Tin_NCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Thong_Tin_NCCMouseClicked
        Connect_CTiet_HD_NhapH.table_NCC(table_NCC);
    }//GEN-LAST:event_txt_Thong_Tin_NCCMouseClicked

    private void btn_Thong_Tin_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Thong_Tin_NCCActionPerformed
        if (txt_CBo_NCC.getSelectedItem().equals("Tên nhà cung cấp")) {
            KT_CTiet_HD_Nhap_H.TK_NCC_Ten_NCC(txt_Thong_Tin_NCC, table_NCC);
        } else if (txt_CBo_NCC.getSelectedItem().equals("Số điện thoại")) {
            KT_CTiet_HD_Nhap_H.TK_NCC_SDT(txt_Thong_Tin_NCC, table_NCC);
        }
    }//GEN-LAST:event_btn_Thong_Tin_NCCActionPerformed

    private void btnThem_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_NCCActionPerformed
        Chi_T_HD_NH_Them_NCC themKH = new Chi_T_HD_NH_Them_NCC();
        themKH.setVisible(true);
    }//GEN-LAST:event_btnThem_NCCActionPerformed

    private void table_NCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_NCCMouseClicked
        int i = table_NCC.getSelectedRow();
        if (i != -1) {
            String maKH = table_NCC.getValueAt(i, 0).toString();
            Save_Ma_NV.setMa_KH(maKH);
            txt_Thong_Tin_NCC.setText(maKH);
        }
    }//GEN-LAST:event_table_NCCMouseClicked

    private void btn_Thanh_ToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Thanh_ToanActionPerformed
        if(txt_Thong_Tin_NCC.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp để thanh toán !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String mancc = txt_Thong_Tin_NCC.getText();          
            String maNV = (String) txt_Ma_NV.getSelectedItem();   
            
            boolean kt = KT_CTiet_HD_Nhap_H.them_HD_NH(maNV, mancc);
            if (kt) {
                JOptionPane.showMessageDialog(this, "Chúc mừng bạn tạo hóa đơn thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Hoa_Don_NH_CT menu = new Hoa_Don_NH_CT();
                menu.setVisible(true);
                this.setVisible(false);
            } else {
                //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_Thanh_ToanActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        boolean kt = KT_CTiet_HD_Nhap_H.events_Close();
        if (kt) {
            String message = "Bạn đã nhập hàng rồi! Không thoát ra được !!!";
            JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            Menu menu = new Menu();
            menu.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CN_Nhap_Hang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua_HH;
    private javax.swing.JButton btnThem_HH;
    private javax.swing.JButton btnThem_NCC;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa_HH;
    private javax.swing.JButton btn_Thanh_Toan;
    private javax.swing.JButton btn_Them_HH;
    private javax.swing.JButton btn_Thong_Tin_HH;
    private javax.swing.JButton btn_Thong_Tin_NCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_HH;
    private javax.swing.JTable table_NCC;
    private javax.swing.JTable table_Nhap_HH;
    private javax.swing.JComboBox<String> txt_CBo_Hang_Hoa;
    private javax.swing.JComboBox<String> txt_CBo_NCC;
    private javax.swing.JTextField txt_Gia_Nhap;
    private javax.swing.JComboBox<String> txt_HT_HH;
    private javax.swing.JComboBox<String> txt_Ma_HH;
    private javax.swing.JComboBox<String> txt_Ma_NV;
    private javax.swing.JTextField txt_So_Luong;
    private javax.swing.JComboBox<String> txt_Ten_HH;
    private javax.swing.JTextField txt_Thong_Tin_NCC;
    // End of variables declaration//GEN-END:variables
}
