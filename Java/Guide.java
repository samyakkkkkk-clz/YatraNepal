package com.touristattraction;

public class Guide {
    private String fullName;
    private String email;
    private String nationality;
    private int age;

    public Guide(String fullName, String email, String nationality, int age) {
        this.fullName = fullName;
        this.email = email;
        this.nationality = nationality;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return fullName + " (" + nationality + ", " + age + ")";
    }
}