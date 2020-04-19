package com.amit.sample;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{

	
	@Autowired 
	DemoRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= Persistence.createEntityManagerFactory("myemf").createEntityManager();
		em.getTransaction().begin();
		DeptEmployee d=new DeptEmployee();
		d.setId(10);
		d.setLocation("Delhi");
		d.setDeptName("Sales");
		d.setEmpid(101);
		d.setSalary(9000);
		d.setName("Prince");
		em.persist(d);
		em.getTransaction().commit();
		em.close();
		
		
	}
	

}
