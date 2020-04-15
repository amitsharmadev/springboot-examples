package com.amit.sample.repo;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import com.amit.sample.data.Customer;


public interface CustomerRepository extends JpaRepository<Customer, String> {

	
	@Query("SELECT t.name FROM Customer t where t.id = :id") 
    Optional<String> findNameById(@Param("id") String id);
	
	//
	@Async
    @Query("SELECT t.name FROM Customer t where t.id = :id") 
    Future<Optional<String>> findNameUsingId(@Param("id") String id);
	
	@Query(value = "SELECT t.name,t.age,t.address,t.bankName,t.doj,t.id FROM Customer t where t.address = :address AND t.bankName = :bankname"
	    )
	    public List<Customer> findByAddressAndBank(@Param("address")String address, @Param("bankname")String bankName);

	//Example of JPA NamedQuery See Customer POJO for NamedQuery declaration

	 List<Customer> fetchByAddress(@Param("address") String address);
}
