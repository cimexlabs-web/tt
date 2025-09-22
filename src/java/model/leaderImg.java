/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;

/**
 *
 * @author Akila Perera
 */
public class leaderImg {
    private InputStream img;
    private String id;

    // Constructor
    public leaderImg(InputStream img, String id) {
        this.img = img;
        this.id = id;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
