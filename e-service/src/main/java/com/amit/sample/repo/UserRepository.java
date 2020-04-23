package com.amit.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.sample.domain.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	

}
