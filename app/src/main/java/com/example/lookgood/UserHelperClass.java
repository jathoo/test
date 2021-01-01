package com.example.lookgood;

public class UserHelperClass {
    String uid , email, password, name, phone;

    public UserHelperClass() {

    }

    public UserHelperClass(String uid, String email, String password, String name, String phone) {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;

    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
