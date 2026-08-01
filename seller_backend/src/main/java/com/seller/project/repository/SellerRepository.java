package com.seller.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seller.project.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    
}
