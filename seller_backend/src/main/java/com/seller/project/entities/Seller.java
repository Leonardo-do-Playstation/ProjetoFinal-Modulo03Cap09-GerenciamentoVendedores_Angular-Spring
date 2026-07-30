package com.seller.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_SELLER")
public class Seller {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        // minimo 5 caracteres
        private String name;

        @Column(nullable = false)
        // masculino e feminino
        private String gender;

        @Column(nullable = false)
        // salario maior que zero
        private double salary;

        @Column(nullable = false)
        private double bonusPercentage;

        public Seller() {
        }

        public Seller(Long id, String name, String gender, double salary, double bonusPercentage) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.salary = salary;
            this.bonusPercentage = bonusPercentage;
        }

        public Long getId() {
            return id;
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

        public Double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public Double getBonusPercentage() {
            return bonusPercentage;
        }

        public void setBonusPercentage(double bonusPercentage) {
            this.bonusPercentage = bonusPercentage;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Seller other = (Seller) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "Seller [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary
                    + ", bonusPercentage=" + bonusPercentage + "]";
        }

        
}
