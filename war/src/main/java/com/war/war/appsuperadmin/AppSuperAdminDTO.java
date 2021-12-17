package com.war.war.appsuperadmin;

public class AppSuperAdminDTO {
    private String name;

    private String userName;

    private String lastName;

    private int age;

    private int year;

    private String password;

    private String email;

    private String appUserRole;

    public String getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(String appUserRole) {
        this.appUserRole = appUserRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
