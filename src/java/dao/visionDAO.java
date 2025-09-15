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
import model.vision;
import model.visionImg;
import util.DBconnection;

/**
 *
 * @author Akila Perera
 */
public class visionDAO {
    public boolean insertText(vision vi)
    {
        try {
            String q1="UPDATE images SET description=? WHERE id=7";
            
            Connection con=DBconnection.createconnection();
            PreparedStatement p1=con.prepareStatement(q1);
            p1.setString(1,vi.gettext());
            int row= p1.executeUpdate();
            return row >0;
            
        } catch (SQLException ex) {
            Logger.getLogger(visionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean insertImg(visionImg img,String id)
    {
        try {
            String q2="UPDATE images SET image=? WHERE id=?";
            Connection con= DBconnection.createconnection();
            PreparedStatement p2=con.prepareStatement(q2);
            p2.setBinaryStream(1,img.getImg());
            p2.setString(2, id);
            
            int row= p2.executeUpdate();
            return row > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(visionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
