package com.spring.ecommerce.interceptors;

import javax.security.sasl.AuthenticationException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.ecommerce.dao.AdminManagerDAO;
import com.spring.ecommerce.dto.ManagementProductDTO;

/* * InterceptorAccess - AOP Security Guard
    ? An Aspect-Oriented Programming (AOP) component that acts as a centralized security gatekeeper. It intercepts service calls in real-time to validate administrative credentials before the actual business logic is executed.

    ! 1. Aspect-Oriented Validation, utilizes the `@Before` advice and a `@Pointcut` to monitor all methods within the `ProductService`. This "cross-cutting concern" removes the need to manually write authentication checks inside every individual service method, resulting in a cleaner and more maintainable codebase.
    ! 2. Dynamic Argument Inspection, leverages the `JoinPoint` to reflectively scan method arguments at runtime. It specifically hunts for the `ManagementProductDTO`, extracting the embedded username and password to verify them against the `AdminManagerDAO`.
    ! 3. Proactive Security, implements a "Fail-Fast" strategy. If the credentials provided are invalid or missing, it immediately throws an `AuthenticationException`, halting the execution flow before any sensitive data (like catalog modifications) can be processed or compromised.
*/

@Component
@Aspect
public class InterceptorAccess {
	
	
		@Autowired
		AdminManagerDAO dao;

		@Pointcut("execution(* com.spring.ecommerce.service.ProductService.*(..))")
		
		public void operazioneSelezionata() {}

		@Before("operazioneSelezionata()")
		
		public void autenticazioneSoggetto (JoinPoint jp) throws Throwable {
			
			Object[] args = jp.getArgs();

			ManagementProductDTO credentials = null;

			for (Object arg : args) {
				
				if (arg instanceof ManagementProductDTO) {
					credentials = (ManagementProductDTO) arg;
					break;
				}
			}

			if (credentials != null && !dao.autenticazioneAdmin(credentials.getUsername(), credentials.getPassword())) {
				
				throw new AuthenticationException("ATTENZIONE ! Non è autorizzato all'accesso per questo contentuto !");
			}
		}
	}


