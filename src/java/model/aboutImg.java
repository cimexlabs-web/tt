package model;

import java.io.InputStream;

public class aboutImg {
    private InputStream img;
    private String id;

    // Constructor
    public aboutImg(InputStream img, String id) {
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
