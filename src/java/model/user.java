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
public class user {
    private String name;
    private String username;
    private String mail;
    private String pws;
    private String type;
    
    public user (String name,String username,  String pws,String mail, String type)
    {
        this.name=name;
        this.username=username;
        this.mail=mail;
        this.pws=pws;
        this.type=type;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getpassword()
    {
        return pws;
    }
    public String getUsername()
    {
        return username;
    }
    public String getMail()
    {
        return mail;
    }
    public String getType()
    {
        return type;
    }
}
