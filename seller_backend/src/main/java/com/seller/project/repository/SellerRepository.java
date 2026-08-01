package com.seller.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seller.project.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    
}
