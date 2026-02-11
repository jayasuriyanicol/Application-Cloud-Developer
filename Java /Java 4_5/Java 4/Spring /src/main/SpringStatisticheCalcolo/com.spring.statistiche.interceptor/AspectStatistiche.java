package com.spring.statistiche.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.statistiche.dao.StatisticheDAO;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;



/* * AspectStatistiche - Centralized Logging & Statistics Interceptor
    ? An AOP Aspect designed to decouple cross-cutting concerns (logging and statistics tracking) from the business logic. It intercepts every method call in the 'calcolatriceService' to record usage and trace execution details.

    ! 1. Runtime Introspection, utilizes the `ProceedingJoinPoint` to extract method arguments (operands) and the signature name (operation type) dynamically. This allows the aspect to identify the math symbol (+, -, *, /) and increment the specific counter in `StatisticheDAO`.
    ! 2. Flow Control & Error Handling, wraps the core execution (`jp.proceed()`) in a try-catch block. It manages the operation's lifecycle by logging successful results or catching `ArithmeticException` to provide a safe fallback (returning 0) without crashing the application.
*/




@Component
@Aspect
public class AspectStatistiche {


    @Autowired
    private StatisticheDAO statDAO;
    
    @Pointcut("execution(* com.spring.statistiche.service.calcolatriceService.*(..))")
    public void tipoOperazione() {}
    
    @Around("tipoOperazione()")
    public Object logSystem(ProceedingJoinPoint jp) throws Throwable {
    	
    	Object[] args = jp.getArgs();
        Double num1 = (Double) args[0]; 
        Double num2 = (Double) args[1];
        
        String simbolo = switch(jp.getSignature().getName()) {
        case "somma" -> "+";
        case "sottrazione" -> "-";
        case "moltiplicazione" -> "*";
        case "divisione" -> "/";
        default -> "ERRORE NESSUN SIMBOLO RICONOSCIUTO";
    };
    	
    	try {
    		
    		statDAO.incrementoOccorrenze(jp.getSignature().getName());
    		Object risultatoOperazione = jp.proceed();
    		
    		System.out.println("SUCCESSO ! risulato dell'operazione -> ' " + jp.getSignature().getName() + " '\nRISULTATO -> " + num1 + " " + simbolo + " " + num2 + " = " + risultatoOperazione);
    		return risultatoOperazione;
    		
    	} catch(ArithmeticException e) {
    		
    		System.out.println("ERRORE ! Risulato dell'operazione -> ' " + jp.getSignature().getName() + " '\nERRORE:\n" + e);
    		return 0;
    	}
    }
    
}
   

