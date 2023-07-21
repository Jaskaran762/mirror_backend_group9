package com.group9.group09.DTO;

import com.group9.group09.model.User;

public class UserEditRequestDTO extends RequestDTO {
    private User user;
    private String email;
    private String password;
    private String newEmail;
    private String newpassword;
    private String newHomeCountry;
    private String newContactno;
    private String newusername;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getNewHomeCountry() {
        return newHomeCountry;
    }

    public void setNewHomeCountry(String newHomeCountry) {
        this.newHomeCountry = newHomeCountry;
    }

    public String getNewContactno() {
        return newContactno;
    }

    public void setNewContactno(String newContactno) {
        this.newContactno = newContactno;
    }

    public String getNewusername() {
        return newusername;
    }

    public void setNewusername(String newusername) {
        this.newusername = newusername;
    }
}
