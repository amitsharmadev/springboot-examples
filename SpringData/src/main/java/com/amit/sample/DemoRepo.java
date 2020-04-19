package com.amit.sample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepo extends JpaRepository<DeptEmployee, Integer> {

}
