package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.about;
import model.aboutImg;
import util.DBconnection;

public class aboutDAO {
    
    public boolean insertText(about ab) {
        try {
            String q1 = "UPDATE images SET description=? WHERE id=3";
            Connection con1 = DBconnection.createconnection();
            PreparedStatement pr1 = con1.prepareStatement(q1);
            pr1.setString(1, ab.gettext());
            
            int row = pr1.executeUpdate();
            return row > 0;
        } catch (SQLException ex) {
            Logger.getLogger(aboutDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean insertImg(aboutImg im, String id) {
        try {
            String q2 = "UPDATE images SET image=? WHERE id=?";
            
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
}
