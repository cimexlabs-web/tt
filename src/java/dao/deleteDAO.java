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
import model.delete_student;
import util.DBconnection;

/**
 *
 * @author Akila Perera
 */
public class deleteDAO {
 
    public boolean deleteStudent(delete_student st)
    {
        try {
            String q="DELETE FROM student WHERE id=?";
            Connection con= DBconnection.createconnection();;
            PreparedStatement p1=con.prepareStatement(q);
            
            p1.setString(1, st.getId());
            
            int row= p1.executeUpdate();
            
            return row >0;
            
        } catch (SQLException ex) {
            Logger.getLogger(deleteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
