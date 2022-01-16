/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Assignment;


import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class Product_Windows extends javax.swing.JFrame {

    /**
     * Creates new form Product_Windows
     */
    public Product_Windows() {
        initComponents();
         Display_Product_In_Table();
     }
    
    String ImagePath = null;
    int position = 0;

    // Resize Image 
    public ImageIcon ResizeImage(String imagePath,byte[]  pic){
        
        ImageIcon ProductImage = null;
        
        if(imagePath != null){
            
             ProductImage = new ImageIcon(imagePath);
        }else{
             ProductImage = new ImageIcon(pic);
        }
        
        Image image = ProductImage.getImage();
        Image image2 = image.getScaledInstance(DisplayImagefield.getWidth(), DisplayImagefield.getHeight(), Image.SCALE_SMOOTH );
        ImageIcon img = new ImageIcon(image2);
        return img;
        
    }
    
    //Check field for input
    
    public boolean checkInput(){
        
        if(namefield.getText()==null || descriptionfield.getText()==null||pricefield.getText()==null||stockfield.getText()==null||salesCountfield.getText()==null||salesCountfield.getText()==null ){
            return false;
        }else{
            try{
                Float.parseFloat(pricefield.getText());
                
                return true;
                
            }catch(Exception ex){
                return false;
            }
        }
    }
    // Display Product Information in Table
    // Fill ArrayList with The Data 
       

    // populate table with product information 
    
    
    
    public void Display_Product_In_Table(){
        ArrayList<ProductList> P_List = ProductDB.BestSelling();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //clearing table content;
        model.setRowCount(0);
        Object[] row = new Object[6];
        for(int i=0;i<P_List.size();i++){
            
            row[0] = P_List.get(i).getProductId();
            
            row[1] = P_List.get(i).getProductName();
            
            row[2] = P_List.get(i).getDescription();
            
            row[3] = P_List.get(i).getPrice();
            
            row[4] = P_List.get(i).getStockcount();
            
            row[5] = ResizeImage(null,P_List.get(i).getImage());
       
            model.addRow(row);
            jTable1.setRowHeight(150);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        }
        
    }
    // Execute SQL
   public void DisplayItem(int index){
      
       namefield.setText(ProductDB.BestSelling().get(index).getProductName());
       descriptionfield.setText(ProductDB.BestSelling().get(index).getDescription());
       pricefield.setText(Float.toString((float) ProductDB.BestSelling().get(index).getPrice()));
       stockfield.setText(Integer.toString(ProductDB.BestSelling().get(index).getStockcount()));
       salesCountfield.setText(Integer.toString(ProductDB.BestSelling().get(index).getSalescount()));
       DisplayImagefield.setIcon(ResizeImage(null,ProductDB.BestSelling().get(index).getImage()));
       // Display_image.setIcon(ResizeImage(null,ProductDB.TableGenerator().get(index).getImage());

   }
   // JComboBox Product Category 
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        namefield = new javax.swing.JTextField();
        descriptionfield = new javax.swing.JTextField();
        pricefield = new javax.swing.JTextField();
        stockfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Btn_AddImage = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        AddProduct_Button = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        Previous_Button = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        rolefield = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        DisplayImagefield = new javax.swing.JLabel();
        salesCountfield = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText(" PRODUCT LIST");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Description : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Product Name :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Product Price: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Product Stock :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("        Product Image:");

        namefield.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namefieldActionPerformed(evt);
            }
        });

        descriptionfield.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descriptionfield.setText(" ");
        descriptionfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionfieldActionPerformed(evt);
            }
        });

        pricefield.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pricefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricefieldActionPerformed(evt);
            }
        });

        stockfield.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stockfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockfieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Product Sales Count:");

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "ProductName", "Description", "ProductPrice", "ProductStock", "ProductImage"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Btn_AddImage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Btn_AddImage.setText("Choose Image");
        Btn_AddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AddImageActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Delete Product");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        AddProduct_Button.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        AddProduct_Button.setText("Add Product");
        AddProduct_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProduct_ButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        UpdateButton.setText("Update Product");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        Previous_Button.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Previous_Button.setText("Previous");
        Previous_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Previous_ButtonActionPerformed(evt);
            }
        });

        NextButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Product Category: ");

        rolefield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rolefield.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronic", "Sport&Recreation", "Food&Beverages" }));
        rolefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolefieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setText("MANAGE PRODUCT");
        jLabel8.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel8AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        DisplayImagefield.setBackground(new java.awt.Color(255, 255, 204));
        DisplayImagefield.setOpaque(true);
        DisplayImagefield.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                DisplayImagefieldAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        salesCountfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(UpdateButton)
                .addGap(465, 465, 465))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(115, 115, 115)
                                    .addComponent(jLabel7))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(AddProduct_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stockfield, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pricefield, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn_AddImage, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                    .addComponent(descriptionfield))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(namefield)
                                .addGap(39, 39, 39)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rolefield, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salesCountfield, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addComponent(Previous_Button)
                                .addGap(31, 31, 31)
                                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DisplayImagefield, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(902, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Previous_Button)
                            .addComponent(NextButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namefield, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionfield, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pricefield, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(stockfield, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(salesCountfield, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rolefield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(DisplayImagefield, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(Btn_AddImage)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateButton)
                    .addComponent(jButton2)
                    .addComponent(AddProduct_Button)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(603, Short.MAX_VALUE)))
        );

        UpdateButton.getAccessibleContext().setAccessibleParent(UpdateButton);
        rolefield.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namefieldActionPerformed

    private void descriptionfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionfieldActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_descriptionfieldActionPerformed

    private void pricefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricefieldActionPerformed

    private void stockfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockfieldActionPerformed

    private void Btn_AddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AddImageActionPerformed
        
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result==  JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            DisplayImagefield.setIcon(ResizeImage(path,null));
            ImagePath = path;
            
        }else{
             System.out.println("Please select an Image ");
            
        }
           
        
        
    }//GEN-LAST:event_Btn_AddImageActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        
        if(checkInput() && pricefield.getText() != null){
            

            
            if(ImagePath == null){

                ProductDB.update(namefield.getText(), descriptionfield.getText(), pricefield.getText(), stockfield.getText(),  rolefield.getSelectedItem().toString(), null);
                Display_Product_In_Table();
            }else{

                  ProductDB.update(namefield.getText(), descriptionfield.getText(), pricefield.getText(), stockfield.getText(),  rolefield.getSelectedItem().toString(), ImagePath);
                  Display_Product_In_Table();
                

            }
            
        }else{
                 JOptionPane.showMessageDialog(null,"Please fill in the field correctly! ");
        }
        
        
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void Previous_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Previous_ButtonActionPerformed
        


    
    }//GEN-LAST:event_Previous_ButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        
        position++;
        
        if(position >= ProductDB.TableContent().size()){
            position = ProductDB.TableContent().size()-1;
        }
          DisplayItem(position);
    }//GEN-LAST:event_NextButtonActionPerformed

    private void AddProduct_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProduct_ButtonActionPerformed
        
        if(checkInput()&& ImagePath != null){
             Connection conn=ProductDB.getConnection(); 

                
                ProductDB.insert(namefield.getText(),descriptionfield.getText(),pricefield.getText(),stockfield.getText(), rolefield.getSelectedItem().toString(), ImagePath);
                Display_Product_In_Table();
                
            }else{
             JOptionPane.showMessageDialog(null,"Please Fill the required field");
          }
        
    }//GEN-LAST:event_AddProduct_ButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection conn=ProductDB.getConnection();
        if(!namefield.getText().equals("")){
           //
               

              ProductDB.delete(namefield.getText());
              Display_Product_In_Table();
              //JOptionPane.showMessageDialog(null,"Product Deleted Successfully");
            
        }else{
              JOptionPane.showMessageDialog(null,"Please select a Product");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //display on click item in table 
        
        int index = jTable1.getSelectedRow();
        DisplayItem(index);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void rolefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolefieldActionPerformed
        // will store product based on category selected 

    }//GEN-LAST:event_rolefieldActionPerformed

    private void jTable1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1AncestorAdded

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1AncestorAdded

    private void jLabel8AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel8AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8AncestorAdded

    private void DisplayImagefieldAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_DisplayImagefieldAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayImagefieldAncestorAdded

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
            java.util.logging.Logger.getLogger(Product_Windows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product_Windows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product_Windows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product_Windows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product_Windows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProduct_Button;
    private javax.swing.JButton Btn_AddImage;
    private javax.swing.JLabel DisplayImagefield;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton Previous_Button;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTextField descriptionfield;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namefield;
    private javax.swing.JTextField pricefield;
    private javax.swing.JComboBox<String> rolefield;
    private javax.swing.JLabel salesCountfield;
    private javax.swing.JTextField stockfield;
    // End of variables declaration//GEN-END:variables
}
