/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Akila Perera
 */
public class submit_student {
    
    private String name;
    private String batch;
    private String degree;
    private String faculty;
    private String sid;
    private String gender;
    private String phone;
    private String exp;
    private String date;
    private String achiv;
    
    public submit_student(String name,String batch,String degree,String faculty,String sid,String gender,String phone,String exp,String date,String achiv)
    {
        this.name=name;
        this.batch=batch;
        this.degree=degree;
        this.faculty=faculty;
        this.sid=sid;
        this.gender=gender;
        this.phone=phone;
        this.exp=exp;
        this.date=date;
        this.achiv=achiv;
    }
    
    public String getName()
    {
        return name;
    }
    public String getBatch()
    {
        return batch;
    }
    public String getDegree()
    {
        return degree;
    }
    public String getFaculty()
    {
        return faculty;
    }
    public String getSid()
    {
        return sid;
    }
    public String getGender()
    {
        return gender;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getExp()
    {
        return exp;
    }
    public String getDate()
    {
        return date;
    }
    public String getAchiv()
    {
        return achiv;
    }
    
}
