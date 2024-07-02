package com.lyx.model;

import org.springframework.stereotype.Component;

/**
 * --- Be Humble and Hungry ---
 *
 * @author McMeloxD
 * @date 2024/6/22
 * @desc
 */
@Component
public class User {
    private int uid;
    private String uname;
    private String password;

    public User(){}

    public User(int uid,String uname,  String password) {
        this.password = password;
        this.uid = uid;
        this.uname = uname;
    }

    public User(String uname, String password) {
        this.uname = uname;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int id) {
        this.uid = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username=" +  uname+
                ", password='" +  password+ '\'' +
                '}';
    }
}
