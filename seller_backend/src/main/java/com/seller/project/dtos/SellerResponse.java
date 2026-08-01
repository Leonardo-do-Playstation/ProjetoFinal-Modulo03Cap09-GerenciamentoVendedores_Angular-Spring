package com.seller.project.dtos;

public abstract class SellerResponse {
    
    private Long id;

    private String name;

    private String gender;
    private double salary;

    private double bonusPercentage;

    public SellerResponse() {
    }

    public SellerResponse(Long id, String name, String gender, double salary, double bonusPercentage) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.bonusPercentage = bonusPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }
}
