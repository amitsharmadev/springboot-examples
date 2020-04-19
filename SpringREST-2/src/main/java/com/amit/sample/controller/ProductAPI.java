package com.amit.sample.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amit.sample.domain.Product;
import com.amit.sample.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Api(value = "Product Management System", description = "Operations pertaining to products in Product Management System")
public class ProductAPI {

	private static final Logger log = LogManager.getLogger(ProductAPI.class);
	@Autowired
	private ProductService productService;

	@GetMapping()
	@ApiOperation(value = "View a list of available products", response = List.class)
	
	@ApiResponses(value = { @ApiResponse(code = 200,message = "Successfully retrieved list"),
							@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
							@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
							@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
			})
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(productService.findAll());
	}

	@PostMapping
	public ResponseEntity create(@Valid @RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product> stock = productService.findById(id);
		if (!stock.isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(stock.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
		if (!productService.findById(id).isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(productService.save(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		if (!productService.findById(id).isPresent()) {
			log.error("Id " + id + " is not existed");
			ResponseEntity.badRequest().build();
		}

		productService.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
