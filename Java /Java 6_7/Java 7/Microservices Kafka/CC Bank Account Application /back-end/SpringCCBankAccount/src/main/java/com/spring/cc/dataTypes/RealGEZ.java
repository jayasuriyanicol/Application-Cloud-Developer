package com.spring.cc.dataTypes;

import jakarta.persistence.Embeddable;

@Embeddable
public final class RealGEZ {
	
	    private final double value;

	    public RealGEZ(double value) {
	    	
	        if (value < 0) {
	        	//Not a simple ERROR/EXCEPTION, but the IllegalArgumentException because is a not simple error.
	            throw new IllegalArgumentException("ATTENZIONE ! Il valore deve essere maggiore o uguale a zero.");
	        }
	        
	        //I will save the data after the correct validation with the if condition
	        this.value = value;
	    }

	    public double getValue() {
	        return value;
	    }
	}


