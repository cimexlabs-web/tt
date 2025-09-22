/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.web_msg;
import util.DBconnection;

/**
 *
 * @author Akila Perera
 */
public class webDAO {
    
    public boolean insertMsg(web_msg wb)
    {
        try {
            String q1= "INSERT INTO message (name,email,message) VALUES (?,?,?)";
            Connection con= DBconnection.createconnection();
            PreparedStatement p1=con.prepareStatement(q1);
            
            p1.setString(1, wb.getName());
            p1.setString(2, wb.getMail());
            p1.setString(3, wb.getMsg());
            
            int row= p1.executeUpdate();
            
            return row >0;
            
        } catch (SQLException ex) {
            Logger.getLogger(webDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
