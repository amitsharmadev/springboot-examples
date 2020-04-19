package com.amit.sample.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.sample.domain.EmployeeVO;

public interface EmployeeRepository extends JpaRepository<EmployeeVO,Integer> {

}
