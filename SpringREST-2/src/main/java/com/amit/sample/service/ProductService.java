package com.amit.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.sample.data.ProductRepository;
import com.amit.sample.domain.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	private  ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product stock) {
        return productRepository.save(stock);
    }

    public void deleteById(Long id) {
    	productRepository.deleteById(id);
    }
}