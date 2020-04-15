package com.amit.sample.aop;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class CustomerAspect {

	@Before(value = "execution(* com.amit.sample.data.Customer.*(..)) and args(name, id, address, age, bankName, doj)")  
	public void beforeAdvice(JoinPoint joinPoint, String id, String name, String address,int age,String bankName,LocalDate doj) {  
		System.out.println("Before method:" + joinPoint.getSignature());  
		System.out.println("Creating Customer with Name  - " + name + ", address - " + address + " and id - " + id);  
	}  
//	
//	@Before(value = "execution(* com.amit.sample.data.Product.set*(..))")  
//	public void beforeNewAdvice(JoinPoint joinPoint) {  
//		System.out.println("Before method:" + joinPoint.getSignature());  
//		System.out.println("Setting Product  - ");  
//	}  
//	
//	private static final Logger LOGGER = LogManager.getLogger(CustomerAspect.class);
//    
//	
//	@Around("execution(* com.amit.sample.data..*(..)))")
//    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
//    {
//        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
//          
//        //Get intercepted method details
//        String className = methodSignature.getDeclaringType().getSimpleName();
//        String methodName = methodSignature.getName();
//          
//        final StopWatch stopWatch = new StopWatch();
//          
//        //Measure method execution time
//        stopWatch.start();
//        Object result = proceedingJoinPoint.proceed();
//        stopWatch.stop();
//  
//        //Log method execution time
//        LOGGER.info("Execution time of " + className + "." + methodName + " "
//                            + ":: " + stopWatch.getTotalTimeMillis() + " ms");
//  
//        return result;
//    }
	

	
	@AfterReturning(
		    pointcut="execution(* com.amit.sample.data.Customer.get*(..))", 
		    returning="returnValue")
		    public void runAfter(JoinPoint joinPoint, String returnValue) throws Throwable {
		         
		        System.out.println("Inside RunAfterExecution.afterReturning() method...");
		        System.out.println("inserted after : " + joinPoint.getSignature().getName());
		        System.out.println("Method returned value is : " + returnValue);
		    }
	
	
	@After("execution(* com.amit.sample.data.Customer.set*(..))")
    public void logAfterAllMethods(JoinPoint joinPoint) { 
		System.out.println("Inside RunAfterExecution.after() method...");
        System.out.println("inserted after : " + joinPoint.getSignature().getName());
    }
		
//	@AfterThrowing("execution(* com.amit.sample.data.Cusomter.doSomething(..))")
//	public void doSomethingAdvice() {
//		
//	}
	
 
	
}
