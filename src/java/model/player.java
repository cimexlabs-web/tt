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
    private String fname,lname,batch,faculty,sid,gender,phone,school,team;
    
    
    public player(InputStream img,String fname,String lname,String batch,String faculty,String sid,String gender,String phone,String school,String team)
    {
        this.img=img;
        this.batch=batch;
        this.faculty=faculty;
        this.fname=fname;
        this.gender=gender;
        
        this.lname=lname;
        this.phone=phone;
        this.school=school;
        this.sid=sid;
        this.team=team;
    }
    
    public InputStream getImg()
    {
        return img;
    }
    
    public String getBatch()
    {
        return batch;
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
    public String getLname()
    {
        return lname;
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
}
