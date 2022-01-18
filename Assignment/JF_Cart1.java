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
public class JF_Cart1 extends javax.swing.JFrame {

    private String username;
    private int index;
    private int quantity;

    JF_Cart1(String username, int index, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Creates new form JF_Cart
     */
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public JF_Cart1() {
        initComponents();
        
                DefaultTableModel model = new DefaultTableModel(new String[]{"Product Name","Description","Price per unit","Quantity","Total"},0);      
        
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
         Statement st = con.createStatement();
//         Statement st1 = con.createStatement();
         ResultSet res = st.executeQuery("select * from cart where cart = 1 ");
//         ResultSet res1 = st1.executeQuery("select  from product where cart = 1 ");
         
         int total = 0;
         
         while(res.next()){
             String a = res.getString("product_name");
             String d = res.getString("descriptions");
             double b= res.getDouble("price");
             int c = res.getInt("quantity");
             double e = b * c;
             
             model.addRow(new Object[]{a,d,b,c,e});
             jTable1.setModel(model);
             jTable1.setVisible(true);
             
             double price = b * c;
              total += price;
         }
             price.setText(String.valueOf(total));
             
            
        }catch (ClassNotFoundException e) {
            System.out.println("Error 1");
            System.out.println(e);
            }
        catch (SQLException e){
            System.out.println("Error 2");
            System.out.println(e);
            }
    }

    JF_Cart1(String username) {
        initComponents();
        this.username = username;
        

        DefaultTableModel model = new DefaultTableModel(new String[]{"Product Name","Description","Price per unit","Quantity","Total"},0);      
        
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
         Statement st = con.createStatement();
//         Statement st1 = con.createStatement();
         ResultSet res = st.executeQuery("select * from cart where cart_name =  ' " +this.username+ " '   ");
//         ResultSet res1 = st1.executeQuery("select  from product where cart = 1 ");
         
         int total = 0;
         
         
         while(res.next()){
             String a = res.getString("product_name");
             String d = res.getString("descriptions");
             double b= res.getDouble("price");
             int c = res.getInt("quantity");
             double e = b * c;
             
             model.addRow(new Object[]{a,d,b,c,e});
             jTable1.setModel(model);
             jTable1.setVisible(true);
             
             double price = b * c;
              total += price;
         }
             price.setText(String.valueOf(total));
             
            
        }catch (ClassNotFoundException e) {
            System.out.println("Error 1");
            System.out.println(e);
            }
        catch (SQLException e){
            System.out.println("Error 2");
            System.out.println(e);
            }
    }

    JF_Cart1(String username, int quantity) {
        initComponents();
        this.username = username;
        this.index = index;
        this.quantity = quantity;
        
        DefaultTableModel model = new DefaultTableModel(new String[]{"Product Name","Description","Price per unit","Quantity","Total"},0);      
        
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
         Statement st = con.createStatement();
//         Statement st1 = con.createStatement();
         ResultSet res = st.executeQuery("select * from cart where cart_name =  ' " +this.username+ " '   ");
//         ResultSet res1 = st1.executeQuery("select  from product where cart = 1 ");
         
         int total = 0;
         
         while(res.next()){
             String a = res.getString("product_name");
             String d = res.getString("descriptions");
             double b= res.getDouble("price");
             int c = res.getInt("quantity");
             double e = b * c;
             
             model.addRow(new Object[]{a,d,b,c,e});
             jTable1.setModel(model);
             jTable1.setVisible(true);
             
             double price = b * c;
              total += price;
         }
             price.setText(String.valueOf(total));
             
            
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
        purchase = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        price = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Shopping Cart");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Description", "Price", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        purchase.setText("Purchase");
        purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Total price: ");

        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        price.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        price.setText("price");

        jButton3.setText("clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(361, 361, 361)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 469, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchase)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(price)))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         dispose();
         JF_mainPage_cus sc = new JF_mainPage_cus(this.username);
         sc.setLocationRelativeTo(null);
         sc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseActionPerformed
        // TODO add your handling code here:
        int payment = Integer.parseInt(price.getText());
        
         try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
         Statement st = con.createStatement();
         Statement st1 = con.createStatement();
         Statement st2 = con.createStatement();
         Statement st3 = con.createStatement();
         ResultSet res = st.executeQuery("select balance from registration where username = ' "+this.username+" ' ");
         ResultSet res1 = st1.executeQuery("select * from cart where cart_name = ' " +this.username+ " ' ");
         ResultSet res2= st2.executeQuery("select * from product ");


         double total = 0;
         
         if(res.next()){
              double balances = res.getDouble("balance");
              total = balances - payment;
              System.out.println(total);
             
              if(total > 0){

                 while(res1.next()){
                     String a = res1.getString("product_name");
                     double b= res1.getDouble("price");
                     int c = res1.getInt("quantity");
                     int stock = res2.getInt("stock_count");
                     int sales = res2.getInt("sales_count");
                     String seller = res2.getString("username");
                  
                  
                     JOptionPane.showMessageDialog(null,"Product has been purchased!");

                     
                     int sales2 = sales + c;
                     int stock2 = stock - c;
                     
                     int executeUpdate1 = st1.executeUpdate("INSERT INTO buyer( product_name, price, quantity, buyer_name, seller_name) VALUES(' "+a+" ',"+b+","+c+",' "+this.username+" ',' " +seller+" ' )");
                     int executeUpdate2 = st2.executeUpdate("UPDATE product SET stock_count = "+stock2+", sales_count = "+sales2+" where product_name = ' " +a+ " ' ");
                     
                        }
                 int executeUpdate = st.executeUpdate("UPDATE product SET balance = "+total+" " );
                 int executeUpdate3 = st3.executeUpdate("DELETE FROM cart where cart_name = ' " +this.username+ " '  " );
                 dispose();
                 JF_Cart1 sc = new JF_Cart1(this.username);
                 sc.setLocationRelativeTo(null);
                 sc.setVisible(true);
                 
              }else{
                 JOptionPane.showMessageDialog(null,"Unsufficient amount of money! ");
                 dispose();
                 JF_Cart1 sc = new JF_Cart1(this.username);
                 sc.setLocationRelativeTo(null);
                 sc.setVisible(true);
              }
             price.setText(String.valueOf(total));

         }
             
            
        }catch (ClassNotFoundException e) {
            System.out.println("Error 1");
            System.out.println(e);
            }
        catch (SQLException e){
            System.out.println("Error 2");
            System.out.println(e);
            }
         
//         PreparedStatement st = con.prepareStatement(username)
//         st.execute();
//         st.close();
//         
//         res = st.executeQuery(username);
//         st.close();
//         res.close();
//         ResultSet res1 = st1.executeQuery();
//         ResultSet res2 = st2.executeQuery("select * from product ");
         
         
        
    }//GEN-LAST:event_purchaseActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
         Statement st = con.createStatement();
         ResultSet res = st.executeQuery("select * from cart where cart_name = ' "+this.username+" ' ");
         
         if(res.next()){
             int executeUpdate = st.executeUpdate("DELETE FROM cart where cart_name = ' " +this.username+ " '  " );
             dispose();
             JF_Cart1 redo = new JF_Cart1(this.username);
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
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Cart1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Cart1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Cart1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Cart1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Cart1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel price;
    private javax.swing.JButton purchase;
    // End of variables declaration//GEN-END:variables
}
