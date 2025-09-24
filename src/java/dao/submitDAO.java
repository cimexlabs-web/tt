package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.student;
import util.DBconnection;

/**
 * DAO class for handling Student submissions.
 * 
 * @author Akila
 */
public class submitDAO {

    private static final Logger LOGGER = Logger.getLogger(submitDAO.class.getName());

    
    public boolean addStudent(student student) {
        try {
            Connection con=DBconnection.createconnection();
            String q2="SELECT * FROM student WHERE sid=?";
            PreparedStatement ps2=con.prepareStatement(q2);
            
            ps2.setString(1, student.getSid());
            
            ResultSet rs=ps2.executeQuery();
            
            if(rs.next())
            {
                return false;
            }
            
            
            
            String query = "INSERT INTO student (name, batch, degree, faculty, sid, gender, phone, experience, start_date, achievement) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setString(2, student.getBatch());
            ps.setString(3, student.getDegree());
            ps.setString(4, student.getFaculty());
            ps.setString(5, student.getSid());
            ps.setString(6, student.getGender());
            ps.setString(7, student.getPhone());
            ps.setString(8, student.getExp());
            ps.setString(9, student.getYearStarted());
            ps.setString(10, student.getAchievements());
            
            int row= ps.executeUpdate();
            
            return row > 0;
        } catch (SQLException ex) {
            Logger.getLogger(submitDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        
    }
}
