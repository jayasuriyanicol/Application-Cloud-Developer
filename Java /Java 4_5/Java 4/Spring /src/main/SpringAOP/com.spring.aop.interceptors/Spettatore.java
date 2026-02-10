package com.spring.aop.interceptors;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/* * SpettatoreAdvice - AOP Around Advice
    ? Implements a Cross-Cutting Concern using the `@Around` annotation to intercept the `Artista.perform` execution. It simulates the audience's behavior (spectators) wrapping the core performance.

    ! 1. @Around("execution..."), the most powerful advice type. It surrounds the target method entirely, allowing logic to run both *before* (taking seats) and *after* (applause) the actual execution.
    ! 2. ProceedingJoinPoint.proceed(), the critical command that triggers the actual business logic (`Artista.perform`). Without this call, the target method would be blocked and never run.
    ! 3. Flow Control & Exception Handling, explicitly manages the execution flow by calculating the duration (start/end time) and catching any exceptions thrown by the target to provide a custom fallback message ("spettacolo INTERROTTO").
*/

@Component
@Aspect
public class SpettatoreAdvice {

	
	@Around("execution ( * com.spring.aop.entity.Artista.perform(..))")
	public void filtro(ProceedingJoinPoint jp) {
		
		//Pre-Processing
		System.out.println("Gli spettatori prendono posto");
		System.out.println("Gli spettatori spengono i cellulari");
		long start = System.currentTimeMillis();
		
		try {
			
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			// Call the method TARGET
			jp.proceed();
			
			// POST - PROCESSING
			
			//Show ended with success 
			System.out.println("CLAP CLAP CLAP !");
			long end = System.currentTimeMillis();
			System.out.println("Lo SHOW è durato " + (end - start));
		} catch (Throwable e) {
			
			//Post - Processing with error
			System.out.println("ATTENZIONE ! Vi è stato un problema spettacolo INTERROTTO");
			e.printStackTrace();
		}		
	}

}
