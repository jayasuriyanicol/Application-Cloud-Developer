package com.spring.dto;


/* * ErroreDTO - Error Response Wrapper
    ? A simple Data Transfer Object designed to standardize error reporting across the API. It encapsulates failure messages into a structured JSON object, ensuring clients receive consistent and parseable feedback when exceptions occur.

    ! 1. Serialization Compliance, includes a no-argument constructor, which is a mandatory requirement for JSON serialization libraries (like Jackson) to instantiate the class via reflection during data binding.
    ! 2. API Contract, by wrapping the `messaggioErrore` string, it avoids returning raw text or stack traces to the client, promoting a clean separation between internal exception handling and external API communication.
*/

//Adding the new ErroreDTO it will be called into the Controller and the Service one
public class ErroreDTO  {
	
	private String messaggioErrore;
	
	public ErroreDTO( String  messaggioErrore) {
		
		this.messaggioErrore = messaggioErrore;

	}
	

    //Adding also the empty constructor because is it a DTO
	public ErroreDTO() {
		
	}

	public String getMessaggioErrore() {
		return messaggioErrore;
	}

	public void setMessaggioErrore(String messaggioErrore) {
		this.messaggioErrore = messaggioErrore;
	}
	
	
	
	

}
