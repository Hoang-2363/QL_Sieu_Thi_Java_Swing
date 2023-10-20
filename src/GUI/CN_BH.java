package GUI;

import BLL.KT_CTiet_HD_BH;
import BLL.Save_Ma_NV;
import DAL.Connect_CTiet_HD_BH;
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
public final class CN_BH extends javax.swing.JFrame {

    public void Load1() {
        Connect_CTiet_HD_BH.getData1(table_HH);
    }

    public void Load2() {
        DefaultTableModel tableModel = Connect_CTiet_HD_BH.getData2();
        table_DAT_HH.setModel(tableModel);
        table_DAT_HH.setRowHeight(30);

        table_DAT_HH.getColumnModel().getColumn(0).setPreferredWidth(80);
        table_DAT_HH.getColumnModel().getColumn(1).setPreferredWidth(230);
        table_DAT_HH.getColumnModel().getColumn(2).setPreferredWidth(80);
        table_DAT_HH.getColumnModel().getColumn(3).setPreferredWidth(80);
        table_DAT_HH.getColumnModel().getColumn(4).setPreferredWidth(80);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table_DAT_HH.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table_DAT_HH.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table_DAT_HH.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        table_DAT_HH.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

    }

    public void Load3() {
        Connect_Khach_Hang db = new Connect_Khach_Hang();
        DefaultTableModel tableModel = db.getData();
        table_KH.setModel(tableModel);
        table_KH.setRowHeight(30);
        table_KH.getColumnModel().getColumn(0).setPreferredWidth(50);
        table_KH.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_KH.getColumnModel().getColumn(2).setPreferredWidth(100);
        table_KH.getColumnModel().getColumn(3).setPreferredWidth(110);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table_KH.getColumnCount(); i++) {
            table_KH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    public CN_BH() {
        initComponents();
        this.setLocationRelativeTo(null);
        TableCellRenderer rendererFromHeader = table_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        TableCellRenderer rendererFromHeader1 = table_DAT_HH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel1 = (JLabel) rendererFromHeader1;
        headerLabel1.setHorizontalAlignment(JLabel.CENTER);

        TableCellRenderer rendererFromHeader2 = table_KH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel2 = (JLabel) rendererFromHeader2;
        headerLabel2.setHorizontalAlignment(JLabel.CENTER);

        Connect_CTiet_HD_BH.load_Ma_HH(txt_Ma_HH);
        Connect_CTiet_HD_BH.load_Ten_HH(txt_Ten_HH);
        
        String tk = Save_Ma_NV.getTK();        
        String mk = Save_Ma_NV.getMK();
        KT_CTiet_HD_BH.load_Ma_NV(txt_Ma_NV, tk, mk);

        Load1();
        Load2();
        Load3();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_TT_HH = new javax.swing.JComboBox<>();
        txt_HT_HH = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btn_TK_HH = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HH = new javax.swing.JTable();
        btn_TK_KH = new javax.swing.JButton();
        txt_TT_KH = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_So_Luong = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_DAT_HH = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btn_Them_HH = new javax.swing.JButton();
        btnSua_HH = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_Thanh_Toan = new javax.swing.JButton();
        txt_Ten_HH = new javax.swing.JComboBox<>();
        txt_Ma_HH = new javax.swing.JComboBox<>();
        btnXoa_HH = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_KH = new javax.swing.JTable();
        btnThem_KH = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_Ma_NV = new javax.swing.JComboBox<>();
        txt_HH_KH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chức năng bán hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_TT_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_TT_HH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên hàng", "Loại hàng hóa", "Nhà cung cấp" }));
        txt_TT_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TT_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_TT_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 180, -1));

        txt_HT_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_HT_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HT_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_HT_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 380, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Tìm theo");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 80, 30));

        btn_TK_HH.setBackground(new java.awt.Color(0, 255, 204));
        btn_TK_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TK_HH.setForeground(new java.awt.Color(255, 0, 0));
        btn_TK_HH.setText("Tìm kiếm");
        btn_TK_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TK_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TK_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Tên hàng hóa");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 130, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 810, 340));

        btn_TK_KH.setBackground(new java.awt.Color(0, 255, 204));
        btn_TK_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TK_KH.setForeground(new java.awt.Color(255, 0, 0));
        btn_TK_KH.setText("Tìm kiếm khách hàng");
        btn_TK_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TK_KHActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TK_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 100, 220, -1));

        txt_TT_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_TT_KH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên khách hàng", "Số điện thoại" }));
        txt_TT_KH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_TT_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TT_KHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_TT_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 230, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Tìm theo");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 80, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Bảng hàng hóa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Mã hàng hóa");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 130, 30));

        txt_So_Luong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_So_Luong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_So_Luong, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 290, -1));

        table_DAT_HH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_DAT_HH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_DAT_HH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_DAT_HHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_DAT_HH);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 650, 220));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Số lượng");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 90, 30));

        btn_Them_HH.setBackground(new java.awt.Color(0, 255, 204));
        btn_Them_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Them_HH.setForeground(new java.awt.Color(255, 0, 0));
        btn_Them_HH.setText("Thêm");
        btn_Them_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Them_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Them_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 630, 90, -1));

        btnSua_HH.setBackground(new java.awt.Color(0, 255, 204));
        btnSua_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua_HH.setForeground(new java.awt.Color(255, 0, 0));
        btnSua_HH.setText("Lưu");
        btnSua_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 90, -1));

        btnThoat.setBackground(new java.awt.Color(0, 255, 204));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 0, 0));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 610, 140, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Bảng đặt hàng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, -1, -1));

        btn_Thanh_Toan.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thanh_Toan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thanh_Toan.setForeground(new java.awt.Color(255, 0, 0));
        btn_Thanh_Toan.setText("Thanh toán");
        btn_Thanh_Toan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Thanh_ToanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thanh_Toan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 530, 140, -1));

        txt_Ten_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ten_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ten_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ten_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 290, -1));

        txt_Ma_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Ma_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma_HHActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Ma_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 290, -1));

        btnXoa_HH.setBackground(new java.awt.Color(0, 255, 204));
        btnXoa_HH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa_HH.setForeground(new java.awt.Color(255, 0, 0));
        btnXoa_HH.setText("Xóa");
        btnXoa_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_HHActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa_HH, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 630, 90, -1));

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
        jScrollPane3.setViewportView(table_KH);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 140, -1, 230));

        btnThem_KH.setBackground(new java.awt.Color(0, 255, 204));
        btnThem_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem_KH.setForeground(new java.awt.Color(255, 0, 0));
        btnThem_KH.setText("+");
        btnThem_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_KHActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Mã nhân viên");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, -1, 30));

        txt_Ma_NV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txt_Ma_NV, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 380, 210, -1));

        txt_HH_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_HH_KH.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_HH_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_HH_KHMouseClicked(evt);
            }
        });
        getContentPane().add(txt_HH_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 380, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_TT_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TT_HHActionPerformed
        // TODO add your handling code here:
        KT_CTiet_HD_BH.load_TK_HH(txt_HT_HH, txt_TT_HH);
    }//GEN-LAST:event_txt_TT_HHActionPerformed

    private void txt_HT_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HT_HHActionPerformed
        // TODO add your handling code here:
        Load1();       
    }//GEN-LAST:event_txt_HT_HHActionPerformed

    private void btn_TK_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TK_HHActionPerformed
        // TODO add your handling code here:
        if (txt_TT_HH.getSelectedItem().equals("Tên hàng")) {
            KT_CTiet_HD_BH.TK_HH_Ten_HH(txt_HT_HH, table_HH);
        } else if (txt_TT_HH.getSelectedItem().equals("Nhà cung cấp")) {
            KT_CTiet_HD_BH.TK_HH_NCC(txt_HT_HH, table_HH);
        } else if (txt_TT_HH.getSelectedItem().equals("Loại hàng hóa")) {
            KT_CTiet_HD_BH.TK_HH_LHH(txt_HT_HH, table_HH);
        }
    }//GEN-LAST:event_btn_TK_HHActionPerformed

    private void btn_TK_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TK_KHActionPerformed
        // TODO add your handling code here:
        if (txt_TT_KH.getSelectedItem().equals("Tên khách hàng")) {
            KT_CTiet_HD_BH.TK_HH_Ten_KH(txt_HH_KH, table_KH);
        } else if (txt_TT_KH.getSelectedItem().equals("Số điện thoại")) {
            KT_CTiet_HD_BH.TK_HH_SDT(txt_HH_KH, table_KH);
        } 
    }//GEN-LAST:event_btn_TK_KHActionPerformed

    private void txt_TT_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TT_KHActionPerformed
        // TODO add your handling code here:
        Load3();
    }//GEN-LAST:event_txt_TT_KHActionPerformed

    private void btn_Them_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Them_HHActionPerformed
        // TODO add your handling code here:
        String maHH = (String) txt_Ma_HH.getSelectedItem();
        String soLuong = txt_So_Luong.getText();

        boolean kt = KT_CTiet_HD_BH.them_CTiet_HD_BH(maHH, soLuong);

        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã đặt hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load2();
            Load1();
            txt_Ma_HH.setSelectedIndex(0);
            txt_Ten_HH.setSelectedIndex(0);
            txt_So_Luong.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_Them_HHActionPerformed

    private void btnSua_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_HHActionPerformed
        // TODO add your handling code here:
        String ma_HH = (String) txt_Ma_HH.getSelectedItem();
        String soLuong = txt_So_Luong.getText();        
        String soLuong_da_mua = Save_Ma_NV.getSo_Luong_Da_Mua();
        boolean kt = KT_CTiet_HD_BH.sua_CTiet_HD(ma_HH, soLuong, soLuong_da_mua);
        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã sửa hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load2();
            Load1();
            txt_Ma_HH.setSelectedIndex(0);
            txt_Ten_HH.setSelectedIndex(0);
            txt_So_Luong.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnSua_HHActionPerformed

    private void btnXoa_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_HHActionPerformed
        // TODO add your handling code here:
        String ma_HH = (String) txt_Ma_HH.getSelectedItem();
        boolean kt = KT_CTiet_HD_BH.xoa_CTiet_HD(ma_HH, txt_So_Luong.getText());
        if (kt) {
            JOptionPane.showMessageDialog(this, "Chúc mừng bạn đã xóa hàng hóa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            Load2();
            Load1();
            txt_Ma_HH.setSelectedIndex(0);
            txt_Ten_HH.setSelectedIndex(0);
            txt_So_Luong.setText("");
        } else {
            //JOptionPane.showMessageDialog(this, "Sửa khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoa_HHActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        boolean kt = KT_CTiet_HD_BH.events_Close();
        if (kt) {
            String message = "Bạn đã mua hàng rồi! Không thoát ra được !!!";
            JOptionPane.showMessageDialog(null, message, "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            Menu menu = new Menu();
            menu.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btn_Thanh_ToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Thanh_ToanActionPerformed
        // TODO add your handling code here
        if(txt_HH_KH.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để thanh toán !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String maKH = txt_HH_KH.getText();          
            String maNV = (String) txt_Ma_NV.getSelectedItem();
            boolean kt = KT_CTiet_HD_BH.them_HD_BH(maKH, maNV);
            if (kt) {
                JOptionPane.showMessageDialog(this, "Chúc mừng bạn tạo hóa đơn thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                Hoa_Don_BH_CT menu = new Hoa_Don_BH_CT();
                menu.setVisible(true);
                this.setVisible(false);
            } else {
                //JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại. Vui lòng thử lại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_Thanh_ToanActionPerformed

    private void txt_Ten_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ten_HHActionPerformed
        // TODO add your handling code here:
        KT_CTiet_HD_BH.load_ma_HH(txt_Ten_HH, txt_Ma_HH);
    }//GEN-LAST:event_txt_Ten_HHActionPerformed

    private void txt_Ma_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma_HHActionPerformed
        // TODO add your handling code here:
        KT_CTiet_HD_BH.load_ten_HH(txt_Ma_HH, txt_Ten_HH);
    }//GEN-LAST:event_txt_Ma_HHActionPerformed

    private void table_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HHMouseClicked
        // TODO add your handling code here:
        int i = table_HH.getSelectedRow();
        if (i != -1) {
            String maHH = table_HH.getValueAt(i, 0).toString();
            String tenHH = table_HH.getValueAt(i, 1).toString();

            txt_Ma_HH.setSelectedItem(maHH);
            txt_Ten_HH.setSelectedItem(tenHH);
            txt_So_Luong.setText("");
        }
    }//GEN-LAST:event_table_HHMouseClicked

    private void table_DAT_HHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DAT_HHMouseClicked
        // TODO add your handling code here:
        int i = table_DAT_HH.getSelectedRow();
        if (i != -1) {
            String maHH = table_DAT_HH.getValueAt(i, 0).toString();
            String tenHH = table_DAT_HH.getValueAt(i, 1).toString();
            String soluong = table_DAT_HH.getValueAt(i, 2).toString();
            
            Save_Ma_NV.setSo_Luong_Da_Mua(soluong);
            
            txt_Ma_HH.setSelectedItem(maHH);
            txt_Ten_HH.setSelectedItem(tenHH);
            txt_So_Luong.setText(soluong);
        }
    }//GEN-LAST:event_table_DAT_HHMouseClicked

    private void btnThem_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_KHActionPerformed
        // TODO add your handling code here:
        Chi_Tiet_HD_BH_Them_KH themKH = new Chi_Tiet_HD_BH_Them_KH();
        themKH.setVisible(true);
    }//GEN-LAST:event_btnThem_KHActionPerformed

    private void table_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KHMouseClicked
        // TODO add your handling code here:
        int i = table_KH.getSelectedRow();
        if (i != -1) {
            String maKH = table_KH.getValueAt(i, 0).toString();
            Save_Ma_NV.setMa_KH(maKH);
            txt_HH_KH.setText(maKH);
        }
    }//GEN-LAST:event_table_KHMouseClicked

    private void txt_HH_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_HH_KHMouseClicked
        // TODO add your handling code here:
        Load3();
    }//GEN-LAST:event_txt_HH_KHMouseClicked
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CN_BH().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua_HH;
    private javax.swing.JButton btnThem_KH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa_HH;
    private javax.swing.JButton btn_TK_HH;
    private javax.swing.JButton btn_TK_KH;
    private javax.swing.JButton btn_Thanh_Toan;
    private javax.swing.JButton btn_Them_HH;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table_DAT_HH;
    private javax.swing.JTable table_HH;
    private javax.swing.JTable table_KH;
    private javax.swing.JTextField txt_HH_KH;
    private javax.swing.JComboBox<String> txt_HT_HH;
    private javax.swing.JComboBox<String> txt_Ma_HH;
    private javax.swing.JComboBox<String> txt_Ma_NV;
    private javax.swing.JTextField txt_So_Luong;
    private javax.swing.JComboBox<String> txt_TT_HH;
    private javax.swing.JComboBox<String> txt_TT_KH;
    private javax.swing.JComboBox<String> txt_Ten_HH;
    // End of variables declaration//GEN-END:variables

}
