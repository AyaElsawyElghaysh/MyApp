package com.example.myapp.Register;

public class RegisterModelForStudent {
    private String name,phone,email,ssd;

    public RegisterModelForStudent(String name, String phone, String email, String ssd) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.ssd = ssd;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }
}
