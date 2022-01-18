/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class JF_Product_Review extends javax.swing.JFrame {

    /**
     * Creates new form JF_Product_Review
     */
    public JF_Product_Review() {
        initComponents();
         DisplayComment();
    }
    
    public void DisplayComment(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "");
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from product_review");
            DefaultTableModel model =  (DefaultTableModel) Review_Comment.getModel();
            model.setRowCount(0);
            
            Object[] row = new Object[4];
            while(rs.next()){
                row[0] = rs.getString("userName");
                row[1] = rs.getString("Comment");
                row[2] = rs.getInt("Rating");
                row[3] = rs.getString("SellerComment");
                model.addRow(row);
            }            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JF_ProductInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Review_Comment = new javax.swing.JTable();
        Back_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("My Product Review");

        Review_Comment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Customer Name", "Comment ", "Rating ", "Your Comment"
            }
        ));
        Review_Comment.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Review_CommentAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Review_Comment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Review_CommentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Review_Comment);

        Back_Button.setText("Back");
        Back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Back_Button)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Review_CommentAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Review_CommentAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_Review_CommentAncestorAdded
   JF_SellerComment comment = new JF_SellerComment();
    private void Review_CommentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Review_CommentMouseClicked
    dispose();
    comment.setVisible(true);
    comment.pack();
    
    
     int selectedRow = Review_Comment.getSelectedRow();
    
     TableModel tm = Review_Comment.getModel();
     
     String customerComment = tm.getValueAt(selectedRow, 1).toString();
     
     String SellerComment = tm.getValueAt(selectedRow, 3).toString(); 

     comment.customerComment.setText(customerComment);    
     
     comment.SellerComment.setText(SellerComment);
    
    }//GEN-LAST:event_Review_CommentMouseClicked

    private void Back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_ButtonActionPerformed
        dispose();
        JF_mainPage_seller sc = new  JF_mainPage_seller();
        sc.setLocationRelativeTo(null);
        sc.setVisible(true);
    }//GEN-LAST:event_Back_ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Product_Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Product_Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Product_Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Product_Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Product_Review().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back_Button;
    private javax.swing.JTable Review_Comment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}