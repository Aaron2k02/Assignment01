/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Assignment;

// getter and setter for product 

import javax.swing.ImageIcon;


public class ProductList {
     private int ProductId;
     private String ProductName;
     private String Description;
     private double price;
     private int Stockcount;
     private String Reviews;
     private int Salescount;
     private byte[] image;
     private String ProductCategory;
     private int quantity;
     
    ProductList(int aInt, String PName, String Pdes, float Pprice, int Stock, int Sales, byte[]  Pimg) {
       
         this.ProductId = aInt;
         this.ProductName = PName;
         this.Description =  Pdes;
         this.price =  Pprice;
         this.Stockcount = Stock;
         this.Reviews = Reviews;
         this.Salescount = Sales;
         this.image =  Pimg;
    }

    public ProductList(String ProductName, String Description, double price, int Stockcount,int salesCount, String ProductCategory, byte[]  image) {
      
        this.ProductName = ProductName;
        this.Description = Description;
        this.price = price;
        this.Stockcount = Stockcount;
        this.Salescount = salesCount;
        this.ProductCategory = ProductCategory;
        this.image = image;
    }

    
    public int getProductId() {
        return ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getDescription() {
        return Description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockcount() {
        return Stockcount;
    }

    public String getReviews() {
        return Reviews;
    }

    public int getSalescount() {
        return Salescount;
    }
    
    
   public ImageIcon GETImage() {
     return new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH));
   }

    public byte[]  getImage() {
        return image;
   }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String ProductCategory) {
        this.ProductCategory = ProductCategory;
    }

    
}
    