package com.amit.sample.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.sample.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}