/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Assignment;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abrar
 */
public class JF_favourite extends javax.swing.JFrame {

    private String username;
    private int index;

    JF_favourite(String username) {
        initComponents();
        this.username = username;
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"Product Name","Description","Product Price","Product Stock","Sales Count","Product Category"},0);      
        
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
         Statement st = con.createStatement();
//         Statement st1 = con.createStatement();
         ResultSet res = st.executeQuery("select * from product where favourite = 1 ");
//         ResultSet res1 = st1.executeQuery("select  from product where cart = 1 ");
         
         
         while(res.next()){
             String a = res.getString("product_name");
             String d = res.getString("descriptions");
             int b= res.getInt("price");
             int c = res.getInt("stock_count");
             int e = res.getInt("sales_count");
             String f = res.getString("product_category");
             
             model.addRow(new Object[]{a,d,b,c,e,f});
             jTable1.setModel(model);
             jTable1.setVisible(true);
             
         }

             
            
        }catch (ClassNotFoundException e) {
            System.out.println("Error 1");
            System.out.println(e);
            }
        catch (SQLException e){
            System.out.println("Error 2");
            System.out.println(e);
            }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    /**
     * Creates new form JF_favourite
     */
    public JF_favourite() {
        initComponents();
    }

    JF_favourite(String username, int index) {
        initComponents();
        this.username = username;
        this.index = index;
        
                        DefaultTableModel model = new DefaultTableModel(new String[]{"Product Name","Description","Product Price","Product Stock","Sales Count","Product Category"},0);      
        
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
         Statement st = con.createStatement();
//         Statement st1 = con.createStatement();
         ResultSet res = st.executeQuery("select * from product where favourite = 1 ");
//         ResultSet res1 = st1.executeQuery("select  from product where cart = 1 ");
         
         
         while(res.next()){
             String a = res.getString("product_name");
             String d = res.getString("descriptions");
             int b= res.getInt("price");
             int c = res.getInt("stock_count");
             int e = res.getInt("sales_count");
             String f = res.getString("product_category");
             
             model.addRow(new Object[]{a,d,b,c,e,f});
             jTable1.setModel(model);
             jTable1.setVisible(true);
             
         }

             
            
        }catch (ClassNotFoundException e) {
            System.out.println("Error 1");
            System.out.println(e);
            }
        catch (SQLException e){
            System.out.println("Error 2");
            System.out.println(e);
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Favourite");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductName", "Description", "ProductPrice", "ProductStock", "SalesCount", "ProductCategory"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(329, 329, 329)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         dispose();
         JF_mainPage_cus sc = new JF_mainPage_cus(this.username);
         sc.setLocationRelativeTo(null);
         sc.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                 try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
         Statement st = con.createStatement();
         ResultSet res = st.executeQuery("select * from product where Product_Id = "+this.index+"  ");
         
         if(res.next()){
             int executeUpdate = st.executeUpdate("UPDATE product SET favourite = 0  " );
             dispose();
             JF_favourite redo = new JF_favourite(this.username, this.index);
             redo.setLocationRelativeTo(null);
             redo.setVisible(true);
                
         }
    
        }catch (ClassNotFoundException e) {
            System.out.println("Error 1");
            System.out.println(e);
            } 
         catch (SQLException e){
            System.out.println("Error 2");
            System.out.println(e);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JF_favourite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_favourite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_favourite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_favourite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_favourite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
