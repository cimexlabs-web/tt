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
import model.player;

import util.DBconnection;

/**
 *
 * @author Akila Perera
 */
public class playerDAO {
    
    public boolean addPlayer(player p)
    {
        try {
            String q1= "INSERT INTO player(fname,lname,batch,faculty,sid,gender,phone,school,team,photo) VALUES (?,?,?,?,?,?,?,?,?,?)";
            Connection con=DBconnection.createconnection();
            PreparedStatement p1=con.prepareStatement(q1);
            
            p1.setString(1, p.getFname());
            p1.setString(2, p.getLname());
            p1.setString(3, p.getBatch());
            p1.setString(4, p.getFaculty());
            p1.setString(5, p.getSid());
            p1.setString(6, p.getGender());
            p1.setString(7, p.getPhone());
            p1.setString(8, p.getScl());
            p1.setString(9, p.getTeam());
            p1.setBinaryStream(10, p.getImg());
            
            int row = p1.executeUpdate();
            
            return row >0;
            
        } catch (SQLException ex) {
            Logger.getLogger(playerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public ResultSet getPlayerDetail(String team)
    {
        ResultSet rs = null;
        try {
            String q2="SELECT * FROM player WHERE team=?";
            Connection con1=DBconnection.createconnection();
            PreparedStatement p2=con1.prepareStatement(q2);
            p2.setString(1, team);
            rs= p2.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(playerDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return rs;
    }
    
    public ResultSet getDetails(String sid)
    {
        ResultSet rs = null;
        try {
            String q2="SELECT * FROM player WHERE sid=?";
            Connection con1=DBconnection.createconnection();
            PreparedStatement p2=con1.prepareStatement(q2);
            p2.setString(1, sid);
            rs= p2.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(playerDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return rs;
    }
    
}
