package com.amit.sample.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.amit.sample.data.Customer;

public interface CustomerSortPageRepo extends PagingAndSortingRepository<Customer, String> {

}
