/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @author Akila Perera
 */
public class player {
    
    private InputStream img;
    private String fname,batch,faculty,sid,gender,phone,mail,school,team,achiev;
    
    
    public player(InputStream img,String fname,String batch,String faculty,String sid,String gender,String phone,String mail,String school,String team,String achiev)
    {
        this.img=img;
        this.batch=batch;
        this.faculty=faculty;
        this.fname=fname;
        this.gender=gender;
        
        this.mail=mail;
        this.phone=phone;
        this.school=school;
        this.sid=sid;
        this.team=team;
        this.achiev=achiev;
    }
    
    
    public player(String fname,String batch,String faculty,String sid,String gender,String phone,String mail,String school,String team,String achiev)
    {
        
        this.batch=batch;
        this.faculty=faculty;
        this.fname=fname;
        this.gender=gender;
        
        this.mail=mail;
        this.phone=phone;
        this.school=school;
        this.sid=sid;
        this.team=team;
        this.achiev=achiev;
    }
    
    
    public InputStream getImg()
    {
        return img;
    }
    
    public String getBatch()
    {
        return batch;
    }
    public String getMail()
    {
        return mail;
    }
    public String getFaculty()
    {
        return faculty;
    }
    public String getFname()
    {
        return fname;
    }
    public String getGender()
    {
        return gender;
    }
    public String getSid()
    {
        return sid;
    }
    
    public String getPhone()
    {
        return phone;
    }
    public String getScl()
    {
        return school;
    }
    public String getTeam()
    {
        return team;
    }
    public String getAchiev()
    {
        return achiev;
    }
}
