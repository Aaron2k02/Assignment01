package Assignment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author User 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProductDB {

    
    public static Connection getConnection(){
        
          Connection conn = null; 

          try {
              
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/omazon", "root", "PBB.v8*$z7bz#c5");
              return conn;
              
          } catch (SQLException ex) {
              Logger.getLogger(Product_Windows.class.getName()).log(Level.SEVERE, null, ex);
              return null;   
          }
       
    }
    
    public static void insert(String productName,String description, String price,String stock,String productCategory,String image){
        try {
            
            Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO product(product_name,descriptions,price,stock_count,product_image,product_category) VALUES(?,?,?,?,?,?)");
                pst.setString(1, productName);

                pst.setString(2, description);

                pst.setDouble(3,Double.parseDouble(price) );

                pst.setInt(4,Integer.parseInt(stock));
                
                InputStream img = new FileInputStream(new File(image));
                pst.setBlob(5,img);
                
                pst.setString(6, productCategory);
                
                pst.executeUpdate();
               
                JOptionPane.showMessageDialog(null,"Product Added Successfully");
        } catch (FileNotFoundException | NumberFormatException | SQLException ex) {
            
                JOptionPane.showMessageDialog(null,ex.getMessage());
        }

    }
    
    public static void update(String productName,String description, String price,String stock,String productCategory,  String image) {
        
         Connection conn = getConnection();
         if(image == null){
             try {
                 String UpdateQuery = "update product set descriptions=?,price=?,stock_count=?,product_category=? where product_name=?";
                 PreparedStatement stmt = conn.prepareStatement(UpdateQuery);
                 
                 stmt.setString(1, description);
            
                 stmt.setDouble(2,Double.parseDouble(price) );
            
                 stmt.setInt(3,Integer.parseInt(stock));            
            
                 stmt.setString(4, productCategory);
            
                 stmt.setString(5, productName);            
            
                 stmt.executeUpdate();
            
                 JOptionPane.showMessageDialog(null, "Product Successfully updated");
             } catch (SQLException ex) {
                 Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
             }

             
         }else{
        try {
            String UpdateQuery = "update productinformation set descriptions=?,price=?,stock_count=?,product_category=?,product_image=? where product_name=?";
            
            PreparedStatement stmt = conn.prepareStatement(UpdateQuery);
            
            stmt.setString(1, description);
            
            stmt.setDouble(2,Double.parseDouble(price) );
            
            stmt.setInt(3,Integer.parseInt(stock));            
            
            stmt.setString(4, productCategory);
            
            InputStream img = new FileInputStream(new File(image));
            stmt.setBlob(5,img);
            
            stmt.setString(6, productName);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Product Successfully updated");
            
        } catch (FileNotFoundException | NumberFormatException | SQLException ex) {
            
              JOptionPane.showMessageDialog(null, ex.getMessage());
        }
      }
    }
    
    public static void delete(String productName){
        Connection conn = getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM product WHERE product_name=?");
            
            ps.setString(1, productName);
            if(ps.executeUpdate()==0){
               JOptionPane.showMessageDialog(null, "Product does not exist ");
              
            }else{
               JOptionPane.showMessageDialog(null, "Product deleted succesfully"); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // bind with Jtable
    public static ArrayList<ProductList> TableContent(){
        ArrayList<ProductList> list = new ArrayList<>();
        Connection conn = getConnection();
      
       try {
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT product_name, descriptions, price, stock_count, sales_count, product_category, product_image FROM product ");
          
          
           ProductList p;
           while(rs.next()){
                 p = new ProductList(
                 rs.getString("product_name"),
                 rs.getString("descriptions"),
                 rs.getDouble("price"),
                 rs.getInt("stock_count"),
                 rs.getInt("sales_count"),
                 rs.getString("product_category"),
                 rs.getBytes("product_image"));
                 
                list.add(p);
           }

        
       } catch (SQLException ex) {
           System.out.println(ex);
       }
              
      return list;
    }

    public static ArrayList<ProductList> mainPage(){
        ArrayList<ProductList> list = new ArrayList<>();
        Connection conn = getConnection();
      
        try { 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Product_Id,product_name, descriptions, price, stock_count, sales_count, product_image,product_category FROM product ");
     
             ProductList p;
             while(rs.next()){
                 p = new ProductList(
                 rs.getString("product_name"),
                 rs.getString("descriptions"),
                 rs.getDouble("price"),
                 rs.getInt("stock_count"),
                 rs.getInt("sales_count"),
                 rs.getString("product_category"),
                 rs.getBytes("product_image"));
                 
                 list.add(p);
           }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
    }
    
    
    public static ArrayList<ProductList>checkProductStock(){
  
            ArrayList<ProductList> list = new ArrayList<>();
            Connection conn = getConnection();
        try {     
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT product_name, descriptions, price, stock_count, sales_count, product_image,product_category FROM product ");
           
            ProductList p;
            
             while(rs.next()){
                 p = new ProductList(
                 rs.getString("product_name"),
                 rs.getString("descriptions"),
                 0,
                 rs.getInt("stock_count"),
                 rs.getInt("sales_count"),
                 rs.getString("product_category"),
                         null);
                 
                list.add(p);
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static ArrayList<ProductList> BestSelling(){
         ArrayList<ProductList> list = new ArrayList<>();
         
         Connection conn = getConnection();
         
          try { 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Product_Id,product_name, descriptions, price, stock_count, product_image,product_category FROM product ORDER BY sales_count DESC LIMIT 3 ");
     
             ProductList p;
             while(rs.next()){
                 p = new ProductList(
                 rs.getString("product_name"),
                 rs.getString("descriptions"),
                 rs.getDouble("price"),
                 rs.getInt("stock_count"),
                 0,
                 rs.getString("product_category"),
                 rs.getBytes("product_image"));
                 list.add(p);
           }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDB.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
    }
    
    


}