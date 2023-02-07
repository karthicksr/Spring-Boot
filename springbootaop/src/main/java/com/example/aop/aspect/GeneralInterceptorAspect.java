package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.example.aop.model.Department;
import com.example.aop.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class GeneralInterceptorAspect {

	// @Pointcut("execution(* com.example.aop.controller.*.*(..))")
	// @Pointcut("within(com.example.aop..*)")
	// @Pointcut("this(com.example.aop.service.DepartmentService)")
	@Pointcut("@annotation(com.example.aop.annotation.CustomAnnotation)")
	public void loggingPointCut() {
	}

	// @Before("loggingPointCut()")
	public void before(JoinPoint joinPoint) {
		log.info("Before method invoked :" + joinPoint.getSignature());

	}

	// @After("loggingPointCut()")
	public void after(JoinPoint joinPoint) {
		log.info("After method invoked :" + joinPoint.getSignature() + "--->" + joinPoint.getArgs()[0]);
	}

	// @AfterReturning(value = "execution(* com.example.aop.controller.*.*(..))",
	// returning = "employee")
	public void afterReturning(JoinPoint joinPoint) {
		log.info("After method invoked..." + joinPoint.getArgs()[0]);
	}

	// @AfterThrowing(value = "loggingPointCut()", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		log.error("The method throws Exception :" + joinPoint.getSignature().getName()
				+ " and the exception message is :" + e.getMessage());
	}

	@Around("loggingPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Before method invoked..." + joinPoint.getSignature() + " and the args :" + joinPoint.getArgs()[0]);
		Object object = joinPoint.proceed();

		if (object instanceof Employee) {
			log.info("After method invoked..." + joinPoint.getSignature() + " and the args :" + joinPoint.getArgs()[0]);
		} else if (object instanceof Department) {
			log.info("After method invoked..." + joinPoint.getSignature() + " and the args :" + joinPoint.getArgs()[0]);
		}
		return object;
	}
}
