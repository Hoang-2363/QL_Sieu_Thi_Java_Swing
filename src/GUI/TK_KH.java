package GUI;

import BLL.KT_CTiet_HD_BH;
import DAL.Connect_Khach_Hang;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hoang
 */
public class TK_KH extends javax.swing.JFrame {
    public static void Icon(String path, JButton menu) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image imgsvg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon sc = new ImageIcon(imgsvg);
        menu.setIcon(sc);
    }
    public void Load(){
        Connect_Khach_Hang db = new Connect_Khach_Hang();
        DefaultTableModel tableModel = db.getData();
        table_KH.setModel(tableModel);
        table_KH.setRowHeight(30);
        table_KH.getColumnModel().getColumn(0).setPreferredWidth(50);    
        table_KH.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_KH.getColumnModel().getColumn(2).setPreferredWidth(90);        
        table_KH.getColumnModel().getColumn(3).setPreferredWidth(110);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table_KH.getColumnCount(); i++) {
            table_KH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    public TK_KH() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        TableCellRenderer rendererFromHeader = table_KH.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        Icon("D:\\do\\loupe.png", btn_TK_KH);
        Load();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_KH = new javax.swing.JTable();
        btn_TT_CT = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Thong_Tin = new javax.swing.JTextField();
        btn_TK_KH = new javax.swing.JButton();
        txt_TT = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tim kiếm khách hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_KH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        table_KH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_KH);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 850, 300));

        btn_TT_CT.setBackground(new java.awt.Color(0, 255, 204));
        btn_TT_CT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TT_CT.setForeground(new java.awt.Color(255, 0, 51));
        btn_TT_CT.setText("Thông tin chi tiết");
        btn_TT_CT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TT_CTActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TT_CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        btn_Thoat.setBackground(new java.awt.Color(0, 255, 204));
        btn_Thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 0, 51));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Thoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 500, -1, -1));

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 3, 36)); // NOI18N
        jLabel1.setText("Tìm kiếm khách hàng");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tìm theo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, 30));

        txt_Thong_Tin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_Thong_Tin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Thong_Tin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_Thong_TinMouseClicked(evt);
            }
        });
        getContentPane().add(txt_Thong_Tin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 340, 30));

        btn_TK_KH.setBackground(new java.awt.Color(0, 255, 204));
        btn_TK_KH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_TK_KH.setForeground(new java.awt.Color(255, 0, 0));
        btn_TK_KH.setText("Tìm kiếm");
        btn_TK_KH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_TK_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TK_KHActionPerformed(evt);
            }
        });
        getContentPane().add(btn_TK_KH, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 140, 30));

        txt_TT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_TT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên khách hàng", "Số điện thoại" }));
        txt_TT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_TT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TTActionPerformed(evt);
            }
        });
        getContentPane().add(txt_TT, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 290, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Nhập thông tin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Download\\2560x1600-light-blue-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TT_CTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TT_CTActionPerformed
        // TODO add your handling code here:
        QL_KH ql_hh = new QL_KH();
        ql_hh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_TT_CTActionPerformed

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        // TODO add your handling code here:
        Menu ql_hh = new Menu();
        ql_hh.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ThoatActionPerformed

    private void btn_TK_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TK_KHActionPerformed
        // TODO add your handling code here:
        if ("".equals(txt_Thong_Tin.getText())) {
           JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else if (txt_TT.getSelectedItem().equals("Tên khách hàng")) {
            KT_CTiet_HD_BH.TK_HH_Ten_KH(txt_Thong_Tin, table_KH);
        } else if (txt_TT.getSelectedItem().equals("Số điện thoại")) {
            KT_CTiet_HD_BH.TK_HH_SDT(txt_Thong_Tin, table_KH);
        } 
    }//GEN-LAST:event_btn_TK_KHActionPerformed

    private void txt_Thong_TinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_Thong_TinMouseClicked
        // TODO add your handling code here:
        Load();
    }//GEN-LAST:event_txt_Thong_TinMouseClicked

    private void txt_TTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TTActionPerformed
        // TODO add your handling code here:
        Load();
    }//GEN-LAST:event_txt_TTActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TK_KH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TK_KH;
    private javax.swing.JButton btn_TT_CT;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_KH;
    private javax.swing.JComboBox<String> txt_TT;
    private javax.swing.JTextField txt_Thong_Tin;
    // End of variables declaration//GEN-END:variables
}
