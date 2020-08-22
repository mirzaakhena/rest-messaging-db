package com.mirzaakhena.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirzaakhena.consumer.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
