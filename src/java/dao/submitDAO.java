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
import model.submit_student;
import util.DBconnection;

/**
 *
 * @author Akila Perera
 */
public class submitDAO {

    
    public boolean addStudent(submit_student s)
    {
        try {
            String q1= "INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?,?) ";
            
            Connection con=DBconnection.createconnection();
            PreparedStatement p1= con.prepareStatement(q1);
            
            p1.setString(1, s.getName());
            p1.setString(2, s.getBatch());
            p1.setString(3, s.getDegree());
            p1.setString(4, s.getFaculty());
            p1.setString(5, s.getSid());
            p1.setString(6, s.getGender());
            p1.setString(7, s.getPhone());
            p1.setString(8, s.getExp());
            p1.setString(9, s.getDate());
            p1.setString(10, s.getAchiv());
            
            int row= p1.executeUpdate();
            
            return row > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(submitDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    
}
