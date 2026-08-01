package com.seller.project.dtos;

import com.seller.project.entity.Seller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SellerRequest {
    
    private Long id;

    @NotBlank(message = "Name can't be null")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    private String name;


    private String gender;

    @NotBlank(message = "Salary can't be null")
    @Positive(message = "Salary must be a positive number")
    private double salary;

    @NotBlank(message = "Bonus percentage can't be null")
    private double bonusPercentage;


    public SellerRequest() {
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

    public Seller toEntity(){
        
        Seller seller = new Seller();
        
        seller.setName(name);
        seller.setGender(gender);
        seller.setSalary(salary);
        seller.setBonusPercentage(bonusPercentage);

        return seller;
    }
    
}
