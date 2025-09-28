
package dao;
import model.user;
import util.DBconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userDAO {
    
    public String validateuser(String user,String pws)
    {
        String q1= "SELECT * FROM admin WHERE username=? AND password=?";
        
        try{
        
            Connection con = DBconnection.createconnection();
            PreparedStatement p1=con.prepareStatement(q1);
            
            p1.setString(1, user);
            p1.setString(2, pws);
            
            ResultSet rs1= p1.executeQuery();
            rs1.next();
            return rs1.getString("type");
     
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return "error";
        }
        
    }
    
    public boolean addUser(user user)
    {
        try {
            String q2= "INSERT INTO admin (name,username,mail,password,type) VALUES (?,?,?,?,?)";
            
            Connection con = DBconnection.createconnection();
            PreparedStatement p2=con.prepareStatement(q2);
            
            p2.setString(1, user.getName());
            p2.setString(2, user.getUsername());
            p2.setString(3, user.getMail());
            p2.setString(4, user.getpassword());
            p2.setString(5, user.getType());
            
            int row= p2.executeUpdate();
            
            return row >0;
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        
    }
    
    public ResultSet viewUser(String type)
    {
        String q1= "SELECT * FROM admin WHERE type=?";
        
        try{
        
            Connection con = DBconnection.createconnection();
            PreparedStatement p1=con.prepareStatement(q1);
            
            p1.setString(1, type);
            
            
            ResultSet rs1= p1.executeQuery();
            
            return rs1;
     
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    
    public boolean deleteUser(String id)
    {
        try {
            String q2="DELETE FROM admin WHERE id=?";
            
            Connection con1= DBconnection.createconnection();
            PreparedStatement pr2=con1.prepareStatement(q2);
            
            pr2.setString(1, id);
            
            int row= pr2.executeUpdate();
            
            return row >0;
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}
