package com.seller.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.seller.project.dtos.SellerRequest;
import com.seller.project.dtos.SellerResponse;
import com.seller.project.service.SellerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/sellers")
public class SellerController {
    
    @Autowired
    private SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerResponse> save(@Validated @RequestBody SellerRequest sellerRequest) {
        SellerResponse sellerResponse = sellerService.create(sellerRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sellerResponse.getId())
                .toUri();
 
        return ResponseEntity.created(location).body(sellerResponse);
    }


    @GetMapping("{id}")
    public ResponseEntity<SellerResponse> getProduct(@PathVariable long id) {
        SellerResponse seller = sellerService.getById(id);
        return ResponseEntity.ok(seller);
    }

    @GetMapping  
    public ResponseEntity<List<SellerResponse>> getProducts() { 
        return ResponseEntity.ok(sellerService.getAll());
    }

    @DeleteMapping("{id}")    
    public ResponseEntity<Void> removeProduct(@PathVariable long id) {
        sellerService.deleteById(id);                
        return ResponseEntity.noContent().build(); 
    }
   
    @PutMapping("{id}")    
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @Valid @RequestBody SellerRequest sellerRequest) {
        sellerService.update(id, sellerRequest);
        return ResponseEntity.ok().build(); 
    }
    

}
