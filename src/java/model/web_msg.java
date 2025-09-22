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
public class web_msg {
    
    private String name;
    private String mail;
    private String msg;
    
    public web_msg(String name,String mail, String msg)
    {
        this.name=name;
        this.mail=mail;
        this.msg=msg;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getMail()
    {
        return mail;
    }
    
    public String getMsg()
    {
        return msg;
    }
}
