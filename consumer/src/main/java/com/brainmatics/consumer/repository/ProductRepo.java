package com.brainmatics.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brainmatics.consumer.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
