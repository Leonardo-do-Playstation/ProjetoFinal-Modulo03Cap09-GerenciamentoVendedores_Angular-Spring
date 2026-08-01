package com.seller.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seller.project.dtos.SellerRequest;
import com.seller.project.dtos.SellerResponse;
import com.seller.project.entity.Seller;
import com.seller.project.repository.SellerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SellerService {
    
    @Autowired
    private SellerRepository sellerRepository;


    public List<SellerResponse> getAll(){
        return sellerRepository.findAll().stream().map(Seller :: toDto).collect(java.util.stream.Collectors.toList());
    }

    public SellerResponse getById(long id){
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seller not found with id: " + id));

                return seller.toDto();
    }

    public SellerResponse create(SellerRequest sellerRequest){
        Seller seller = sellerRequest.toEntity();
        sellerRepository.save(seller);
        return seller.toDto();
    }

    public void deleteById(long id){
       sellerRepository.deleteById(id); 
    }

    public void update(long id, SellerRequest sellerRequest){

        Seller seller = sellerRepository.getReferenceById(id);
        seller.setId(sellerRequest.getId());
        seller.setName(sellerRequest.getName());
        seller.setGender(sellerRequest.getGender());
        seller.setSalary(sellerRequest.getSalary());
        seller.setBonusPercentage(sellerRequest.getBonusPercentage());
        sellerRepository.save(seller);
    }
}
