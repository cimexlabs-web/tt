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
import util.DBconnection;

/**
 *
 * @author Akila Perera
 */
public class searchDAO {
    public byte[] img(String i)
    {
        byte[] imageBytes = null;
        try {
            String q1= "SELECT * FROM player WHERE sid=?";
             
            Connection con= DBconnection.createconnection();
            PreparedStatement p1=con.prepareStatement(q1);
            
            p1.setString(1, i);
            
            
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
}
