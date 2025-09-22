/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.leader;
import model.leaderImg;
import util.DBconnection;

/**
 *
 * @author Akila Perera
 */
public class leaderDAO {
    public byte[] img(int i)
    {
        byte[] imageBytes = null;
        try {
            String q1= "SELECT * FROM leader WHERE id=?";
             
            Connection con= DBconnection.createconnection();
            PreparedStatement p1=con.prepareStatement(q1);
            
            p1.setInt(1, i);
            
            
            ResultSet rs1= p1.executeQuery();
            if (rs1.next())
            {
                imageBytes = rs1.getBytes("photo");
            }
            
            
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(mainDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageBytes;
        
    }
    
    public String leader(int i)
    {
        String text = null;
        try {
            String q2="SELECT * FROM leader WHERE id=?";
            
            Connection con=DBconnection.createconnection();
            PreparedStatement p2= con.prepareStatement(q2);
            
            p2.setInt(1, i);
            
            ResultSet rs2= p2.executeQuery();
            
            if(rs2.next())
            {
                text= rs2.getString("message");
            }
            
            con.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(mainDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return text;
        
        
        
    }
    public boolean insertImg(leaderImg im, String id) {
        try {
            String q2 = "UPDATE leader SET photo=? WHERE id=?";
            
            Connection con2 = DBconnection.createconnection();
            PreparedStatement pr2 = con2.prepareStatement(q2);
            pr2.setBinaryStream(1, im.getImg()); 
            pr2.setString(2, id);
            
            int row = pr2.executeUpdate();
            return row > 0;
        } catch (SQLException ex) {
            Logger.getLogger(aboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        public boolean insertText(leader le,String id) {
        try {
            String q1 = "UPDATE leader SET message=? WHERE id=?";
            Connection con1 = DBconnection.createconnection();
            PreparedStatement pr1 = con1.prepareStatement(q1);
            pr1.setString(1, le.gettext());
            pr1.setString(2, id);
            int row = pr1.executeUpdate();
            return row > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(aboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
        public boolean insertName(String name,String title,String id) {
        try {
            String q1 = "UPDATE leader SET title=?,name=? WHERE id=?";
            Connection con3 = DBconnection.createconnection();
            PreparedStatement pr1 = con3.prepareStatement(q1);
            pr1.setString(1, title);
            pr1.setString(2, name);
            
            pr1.setString(3, id);
            int row = pr1.executeUpdate();
            return row > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(aboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        public String name(int i)
    {
        String name = null;
        try {
            String q2="SELECT * FROM leader WHERE id=?";
            
            Connection con=DBconnection.createconnection();
            PreparedStatement p2= con.prepareStatement(q2);
            
            p2.setInt(1, i);
            
            ResultSet rs2= p2.executeQuery();
            
            if(rs2.next())
            {
                name= rs2.getString("name");
            }
            
            con.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(mainDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
        
        
        
    }
        public String title(int i)
    {
        String title = null;
        try {
            String q2="SELECT * FROM leader WHERE id=?";
            
            Connection con=DBconnection.createconnection();
            PreparedStatement p2= con.prepareStatement(q2);
            
            p2.setInt(1, i);
            
            ResultSet rs2= p2.executeQuery();
            
            if(rs2.next())
            {
                title= rs2.getString("title");
            }
            
            con.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(mainDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return title;
        
        
        
    }
}
