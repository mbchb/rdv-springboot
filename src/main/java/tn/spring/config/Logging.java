package tn.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class Logging {

	@After("execution(* com.esprit.examen.services.*.get*(..))")
	public void apres(JoinPoint thisJoinPoint) {
		log.info("Out of the method (After)" + thisJoinPoint.getSignature().getName());
	}

}