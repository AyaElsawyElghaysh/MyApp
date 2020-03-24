package com.example.myapp.Register;

public class DoctorModel {
    private String name,phone,email,specialization;

    public DoctorModel(String name, String phone, String email, String specialization) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.specialization = specialization;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
