package com.javabase.javaEight.lambdaAndStream.demo.validation.two;

import java.util.Optional;

public  final class Invalid implements ValidationResult {
	 private final String reason;

	    Invalid(String reason){
	        this.reason = reason;
	    }

	    public boolean isValid(){
	        return false;
	    }

	    public Optional<String> getReason(){
	        return Optional.of(reason);
	    }
}
