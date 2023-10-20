package GUI;

import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoang
 */
public class Menu extends javax.swing.JFrame {
    public static void Icon(String path, JMenu menu){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }
    public static void Icon_item(String path, JMenuItem menu){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        menu_QL.setFont(new Font("Arial", Font.BOLD, 18));  
        menu_QL_KH.setFont(new Font("Arial", Font.BOLD, 18));
        menu_QL_HH.setFont(new Font("Arial", Font.BOLD, 18));        
        menu_QL_LHH.setFont(new Font("Arial", Font.BOLD, 18));
        menu_QL_NCC.setFont(new Font("Arial", Font.BOLD, 18));
        menu_QL_HD_BH.setFont(new Font("Arial", Font.BOLD, 18));
        menu_QL_HD_NH.setFont(new Font("Arial", Font.BOLD, 18));  
        
        menu_CN.setFont(new Font("Arial", Font.BOLD, 18));        
        menu_CN_BH.setFont(new Font("Arial", Font.BOLD, 18));
        menu_CN_NH.setFont(new Font("Arial", Font.BOLD, 18));
        menu_CN_KT_T.setFont(new Font("Arial", Font.BOLD, 18));

        menu_TK.setFont(new Font("Arial", Font.BOLD, 18));        
        menu_TK_KH.setFont(new Font("Arial", Font.BOLD, 18));
        menu_TK_HH.setFont(new Font("Arial", Font.BOLD, 18));        
        menu_TK_LHH.setFont(new Font("Arial", Font.BOLD, 18));
        menu_TK_NCC.setFont(new Font("Arial", Font.BOLD, 18));        
        
        menu_TKE.setFont(new Font("Arial", Font.BOLD, 18));
        menu_TKE_KM.setFont(new Font("Arial", Font.BOLD, 18));
        menu_TKE_HHB.setFont(new Font("Arial", Font.BOLD, 18));
        menu_TKE_BH.setFont(new Font("Arial", Font.BOLD, 18));
        menu_TKE_NH.setFont(new Font("Arial", Font.BOLD, 18));
        jMenuItem1.setFont(new Font("Arial", Font.BOLD, 18));
        jMenuItem2.setFont(new Font("Arial", Font.BOLD, 18));

        menu_TG.setFont(new Font("Arial", Font.BOLD, 18));
        menu_TG_TTTK.setFont(new Font("Arial", Font.BOLD, 18));
        menu_TG_DMK.setFont(new Font("Arial", Font.BOLD, 18));
        
        menu_DX.setFont(new Font("Arial", Font.BOLD, 18));      


        Icon("D:\\do\\planning.png", menu_QL);        
        Icon("D:\\\\Download\\\\shopping-cart.png", menu_CN);
        Icon("D:\\\\Download\\\\magnifying-glass.png", menu_TK);
        Icon("D:\\do\\analytics.png", menu_TKE);        
        Icon("D:\\do\\tro_giup.png", menu_TG);
        Icon("D:\\do\\exit.png", menu_DX);
        
        Icon_item("D:\\do\\client.png", menu_QL_KH);
        Icon_item("D:\\do\\groceries.png", menu_QL_HH);        
        Icon_item("D:\\do\\boxes.png", menu_QL_LHH);
        Icon_item("D:\\do\\supplier.png", menu_QL_NCC);
        Icon_item("D:\\do\\bill.png", menu_QL_HD_BH);
        Icon_item("D:\\do\\purchasing.png", menu_QL_HD_NH);

        Icon_item("D:\\do\\bill.png", menu_CN_BH);
        Icon_item("D:\\do\\import.png", menu_CN_NH);        
        Icon_item("D:\\do\\clipboard.png", menu_CN_KT_T);
        
        Icon_item("D:\\do\\segment.png", menu_TK_KH);
        Icon_item("D:\\do\\search.png", menu_TK_HH);        
        Icon_item("D:\\do\\lhh.png", menu_TK_LHH);
        Icon_item("D:\\do\\ncc.png", menu_TK_NCC);
        
        Icon_item("D:\\do\\project.png", menu_TG_TTTK);
        Icon_item("D:\\do\\reset-password.png", menu_TG_DMK);   
        
        Icon_item("D:\\do\\customer.png", menu_TKE_KM);
        Icon_item("D:\\do\\revenue.png", menu_TKE_HHB);        
        Icon_item("D:\\do\\discount.png", menu_TKE_BH);
        Icon_item("D:\\do\\trading.png", menu_TKE_NH);
        Icon_item("D:\\do\\sales.png", jMenuItem1);            
        Icon_item("D:\\do\\hang_nhap.png", jMenuItem2);            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menu_QL = new javax.swing.JMenu();
        menu_QL_KH = new javax.swing.JMenuItem();
        menu_QL_HH = new javax.swing.JMenuItem();
        menu_QL_LHH = new javax.swing.JMenuItem();
        menu_QL_NCC = new javax.swing.JMenuItem();
        menu_QL_HD_BH = new javax.swing.JMenuItem();
        menu_QL_HD_NH = new javax.swing.JMenuItem();
        menu_CN = new javax.swing.JMenu();
        menu_CN_BH = new javax.swing.JMenuItem();
        menu_CN_NH = new javax.swing.JMenuItem();
        menu_CN_KT_T = new javax.swing.JMenuItem();
        menu_TK = new javax.swing.JMenu();
        menu_TK_KH = new javax.swing.JMenuItem();
        menu_TK_HH = new javax.swing.JMenuItem();
        menu_TK_LHH = new javax.swing.JMenuItem();
        menu_TK_NCC = new javax.swing.JMenuItem();
        menu_TKE = new javax.swing.JMenu();
        menu_TKE_KM = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menu_TKE_HHB = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_TKE_BH = new javax.swing.JMenuItem();
        menu_TKE_NH = new javax.swing.JMenuItem();
        menu_TG = new javax.swing.JMenu();
        menu_TG_TTTK = new javax.swing.JMenuItem();
        menu_TG_DMK = new javax.swing.JMenuItem();
        menu_DX = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Download\\supermarket-interior-vector-shop-shelves-refrigerator-cartoon-illustration-background-design-7983833.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 490));

        menu.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        menu_QL.setText("Quản lý");

        menu_QL_KH.setText("Quản lý khách hàng");
        menu_QL_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_QL_KHActionPerformed(evt);
            }
        });
        menu_QL.add(menu_QL_KH);

        menu_QL_HH.setText("Quản lý hàng hóa");
        menu_QL_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_QL_HHActionPerformed(evt);
            }
        });
        menu_QL.add(menu_QL_HH);

        menu_QL_LHH.setText("Quản lý loại hàng hóa");
        menu_QL_LHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_QL_LHHActionPerformed(evt);
            }
        });
        menu_QL.add(menu_QL_LHH);

        menu_QL_NCC.setText("Quản lý nhà cung cấp");
        menu_QL_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_QL_NCCActionPerformed(evt);
            }
        });
        menu_QL.add(menu_QL_NCC);

        menu_QL_HD_BH.setText("Quản lý hoá đơn bán hàng");
        menu_QL_HD_BH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_QL_HD_BHActionPerformed(evt);
            }
        });
        menu_QL.add(menu_QL_HD_BH);

        menu_QL_HD_NH.setText("Quản lý hóa đơn nhập hàng");
        menu_QL_HD_NH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_QL_HD_NHActionPerformed(evt);
            }
        });
        menu_QL.add(menu_QL_HD_NH);

        menu.add(menu_QL);

        menu_CN.setText("Chức năng");

        menu_CN_BH.setText("Bán hàng");
        menu_CN_BH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_CN_BHActionPerformed(evt);
            }
        });
        menu_CN.add(menu_CN_BH);

        menu_CN_NH.setText("Nhập hàng");
        menu_CN_NH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_CN_NHActionPerformed(evt);
            }
        });
        menu_CN.add(menu_CN_NH);

        menu_CN_KT_T.setText("Kiểm tra tồn");
        menu_CN_KT_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_CN_KT_TActionPerformed(evt);
            }
        });
        menu_CN.add(menu_CN_KT_T);

        menu.add(menu_CN);

        menu_TK.setText("Tìm kiếm");

        menu_TK_KH.setText("Tìm kiếm khách hàng");
        menu_TK_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TK_KHActionPerformed(evt);
            }
        });
        menu_TK.add(menu_TK_KH);

        menu_TK_HH.setText("Tìm kiếm hàng hóa");
        menu_TK_HH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TK_HHActionPerformed(evt);
            }
        });
        menu_TK.add(menu_TK_HH);

        menu_TK_LHH.setText("Tìm kiếm loại hàng hóa");
        menu_TK_LHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TK_LHHActionPerformed(evt);
            }
        });
        menu_TK.add(menu_TK_LHH);

        menu_TK_NCC.setText("Tìm kiếm nhà cung cấp");
        menu_TK_NCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TK_NCCActionPerformed(evt);
            }
        });
        menu_TK.add(menu_TK_NCC);

        menu.add(menu_TK);

        menu_TKE.setText("Thống kê");

        menu_TKE_KM.setText("Khách mua");
        menu_TKE_KM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TKE_KMActionPerformed(evt);
            }
        });
        menu_TKE.add(menu_TKE_KM);

        jMenuItem1.setText("Nhân viên");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_TKE.add(jMenuItem1);

        menu_TKE_HHB.setText("Hàng đã bán");
        menu_TKE_HHB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TKE_HHBActionPerformed(evt);
            }
        });
        menu_TKE.add(menu_TKE_HHB);

        jMenuItem2.setText("Hàng hóa đã nhập");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_TKE.add(jMenuItem2);

        menu_TKE_BH.setText("Thống kê bán hàng");
        menu_TKE_BH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TKE_BHActionPerformed(evt);
            }
        });
        menu_TKE.add(menu_TKE_BH);

        menu_TKE_NH.setText("Thống kê nhập hàng");
        menu_TKE_NH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TKE_NHActionPerformed(evt);
            }
        });
        menu_TKE.add(menu_TKE_NH);

        menu.add(menu_TKE);

        menu_TG.setText("Trợ giúp");

        menu_TG_TTTK.setText("Thông tin nhân viên");
        menu_TG_TTTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TG_TTTKActionPerformed(evt);
            }
        });
        menu_TG.add(menu_TG_TTTK);

        menu_TG_DMK.setText("Đổi mật khẩu");
        menu_TG_DMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_TG_DMKActionPerformed(evt);
            }
        });
        menu_TG.add(menu_TG_DMK);

        menu.add(menu_TG);

        menu_DX.setText("Đăng xuất");
        menu_DX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_DXMouseClicked(evt);
            }
        });
        menu.add(menu_DX);

        setJMenuBar(menu);

        setSize(new java.awt.Dimension(817, 491));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_QL_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_QL_KHActionPerformed
        // TODO add your handling code here:
        QL_KH ql_kh = new QL_KH();
        ql_kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_QL_KHActionPerformed

    private void menu_QL_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_QL_HHActionPerformed
        // TODO add your handling code here:
        QL_HH ql_hh = new QL_HH();
        ql_hh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_QL_HHActionPerformed

    private void menu_QL_LHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_QL_LHHActionPerformed
        // TODO add your handling code here:
        QL_Loai_HH ql_lhh = new QL_Loai_HH();
        ql_lhh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_QL_LHHActionPerformed

    private void menu_QL_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_QL_NCCActionPerformed
        // TODO add your handling code here:
        QL_Nha_CC ql_ncc = new QL_Nha_CC();
        ql_ncc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_QL_NCCActionPerformed

    private void menu_CN_BHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_CN_BHActionPerformed
        // TODO add your handling code here:
        CN_BH ql_ncc = new CN_BH();
        ql_ncc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_CN_BHActionPerformed

    private void menu_CN_NHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_CN_NHActionPerformed
        // TODO add your handling code here:
        CN_Nhap_Hang kh = new CN_Nhap_Hang();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_CN_NHActionPerformed

    private void menu_CN_KT_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_CN_KT_TActionPerformed
        // TODO add your handling code here:
        CN_KT_Ton kh = new CN_KT_Ton();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_CN_KT_TActionPerformed

    private void menu_TK_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TK_KHActionPerformed
        // TODO add your handling code here:
        TK_KH kh = new TK_KH();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TK_KHActionPerformed

    private void menu_TK_HHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TK_HHActionPerformed
        // TODO add your handling code here:
        TK_HH kh = new TK_HH();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TK_HHActionPerformed

    private void menu_TK_LHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TK_LHHActionPerformed
        // TODO add your handling code here:
        TK_Loai_HH kh = new TK_Loai_HH();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TK_LHHActionPerformed

    private void menu_TK_NCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TK_NCCActionPerformed
        // TODO add your handling code here:
        TK_NCC kh = new TK_NCC();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TK_NCCActionPerformed

    private void menu_QL_HD_NHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_QL_HD_NHActionPerformed
        // TODO add your handling code here:
        QL_HD_NH kh = new QL_HD_NH();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_QL_HD_NHActionPerformed

    private void menu_QL_HD_BHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_QL_HD_BHActionPerformed
        // TODO add your handling code here:
        QL_HD_BH kh = new QL_HD_BH();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_QL_HD_BHActionPerformed

    private void menu_TG_TTTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TG_TTTKActionPerformed
        // TODO add your handling code here:
        Thong_Tin_TK kh = new Thong_Tin_TK();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TG_TTTKActionPerformed

    private void menu_TG_DMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TG_DMKActionPerformed
        // TODO add your handling code here:
        Doi_MK kh = new Doi_MK();
        kh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TG_DMKActionPerformed

    private void menu_DXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_DXMouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            Dang_Nhap dn;
            try {
                dn = new Dang_Nhap();
                dn.setVisible(true);
                this.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_menu_DXMouseClicked

    private void menu_TKE_NHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TKE_NHActionPerformed
        // TODO add your handling code here:
        Thong_Ke_$_NH hd = new Thong_Ke_$_NH();
        hd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TKE_NHActionPerformed

    private void menu_TKE_BHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TKE_BHActionPerformed
        // TODO add your handling code here:
        Thong_Ke_$_BH hd = new Thong_Ke_$_BH();
        hd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TKE_BHActionPerformed

    private void menu_TKE_HHBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TKE_HHBActionPerformed
        // TODO add your handling code here:
        Thong_Ke_HH_So_Luong_B hd = new Thong_Ke_HH_So_Luong_B();
        hd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TKE_HHBActionPerformed

    private void menu_TKE_KMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_TKE_KMActionPerformed
        // TODO add your handling code here:
        Thong_Ke_KH_Mua hd = new Thong_Ke_KH_Mua();
        hd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menu_TKE_KMActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Thong_Ke_Nhan_Vien hd = new Thong_Ke_Nhan_Vien();
        hd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Thong_Ke_HH_So_Luong_Da_N hd = new Thong_Ke_HH_So_Luong_Da_N();
        hd.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menu_CN;
    private javax.swing.JMenuItem menu_CN_BH;
    private javax.swing.JMenuItem menu_CN_KT_T;
    private javax.swing.JMenuItem menu_CN_NH;
    private javax.swing.JMenu menu_DX;
    private javax.swing.JMenu menu_QL;
    private javax.swing.JMenuItem menu_QL_HD_BH;
    private javax.swing.JMenuItem menu_QL_HD_NH;
    private javax.swing.JMenuItem menu_QL_HH;
    private javax.swing.JMenuItem menu_QL_KH;
    private javax.swing.JMenuItem menu_QL_LHH;
    private javax.swing.JMenuItem menu_QL_NCC;
    private javax.swing.JMenu menu_TG;
    private javax.swing.JMenuItem menu_TG_DMK;
    private javax.swing.JMenuItem menu_TG_TTTK;
    private javax.swing.JMenu menu_TK;
    private javax.swing.JMenu menu_TKE;
    private javax.swing.JMenuItem menu_TKE_BH;
    private javax.swing.JMenuItem menu_TKE_HHB;
    private javax.swing.JMenuItem menu_TKE_KM;
    private javax.swing.JMenuItem menu_TKE_NH;
    private javax.swing.JMenuItem menu_TK_HH;
    private javax.swing.JMenuItem menu_TK_KH;
    private javax.swing.JMenuItem menu_TK_LHH;
    private javax.swing.JMenuItem menu_TK_NCC;
    // End of variables declaration//GEN-END:variables

}
