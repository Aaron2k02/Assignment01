/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class TransactionDB {
    
    public static void insertIntoTransaction(String userName,double Price,String Date){
        
        try {
            
            Connection con = ProductDB.getConnection();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO Transaction(user_Name,Transaction_amount,Transaction_date)VALUES(?,?,?)");
            
            ps.setString(1, userName);
            ps.setDouble(2, Price);
            ps.setString(3, Date);
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TransactionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ArrayList<TransactionObject>TransactionInformation(){
        ArrayList<TransactionObject> user = new ArrayList<>();
        
        
        try{
            Connection conn = ProductDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT User_Id,user_Name,Transaction_amount,Transaction_date FROM transaction");
            
             TransactionObject bill;
            
             while(rs.next()){
                bill = new TransactionObject(rs.getInt("User_Id"),rs.getString("user_Name"),
                        rs.getDouble("Transaction_amount"),rs.getString("Transaction_date"));
                user.add(bill);
             }
             
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return user;
    } 
    
    //Delete Transaction list 
    public static void deleteTransactionHistory(){
   
        try {
            Connection conn = ProductDB.getConnection();
            PreparedStatement  ps = conn.prepareStatement("DELETE FROM Transaction");
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "All Transaction History has been deleted successfully");
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex);
        } 
    }
}
