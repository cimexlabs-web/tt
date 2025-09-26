package model;

/**
 * Student registration model for Table Tennis registration form.
 * 
 * @author Akila
 */
public class student {
    
    private String name;
    private String batch;
    private String degree;
    private String faculty;
    private String sid;
    private String gender;
    private String phone;
    private String mail;
    private String exp;
    private String yearStarted;
    private String achievements;
    
    
    public student(String name, String batch, String degree, String faculty,
                         String sid, String gender, String phone,String mail, String exp,
                         String yearStarted, String achievements) {
        this.name = name;
        this.batch = batch;
        this.degree = degree;
        this.faculty = faculty;
        this.sid = sid;
        this.gender = gender;
        this.phone = phone;
        this.mail=mail;
        this.exp = exp;
        this.yearStarted = yearStarted;
        this.achievements = achievements;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public String getDegree() {
        return degree;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSid() {
        return sid;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
    public String getMail() {
        return mail;
    }

    public String getExp() {
        return exp;
    }

    public String getYearStarted() {
        return yearStarted;
    }

    public String getAchievements() {
        return achievements;
    }
}
