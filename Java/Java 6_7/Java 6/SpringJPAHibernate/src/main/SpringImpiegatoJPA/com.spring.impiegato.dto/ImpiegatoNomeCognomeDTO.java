package com.spring.impiegati.dto;

/* * ImpiegatoNomeCognomeDTO - Targeted Identity Projection
    ? A specialized "Identity Projection" DTO designed to deliver a minimal subset of employee data. It is specifically tailored for the 'eliminaMatricolaNomCogn' service operation, providing a clean confirmation of the individual's identity (first and last name) without exposing financial or internal ID data.

    ! 1. Principle of Least Privilege, implements a data-hiding strategy by excluding the 'salarioMensile' and 'matricola'. This ensures that when an employee is removed or identified in a log, only the necessary biographical details are transmitted, reducing the risk of accidental data leakage.
    ! 2. Optimized Payload Delivery, reduces the JSON footprint significantly compared to the full 'ImpiegatoDTO'. By stripping away temporal and numerical fields, it creates a lightweight response that is ideal for quick confirmation messages or UI notifications in the HR management dashboard.
    ! 3. Semantic Clarity, serves as a clear indicator of the method's intent. By returning this specific DTO, the service explicitly communicates to the caller that the operation was successful and confirms exactly which person was affected, maintaining a user-friendly and professional API contract.
*/


//Creating the DTO to manage the SERVICE method 'eliminaMatricolaNomCogn' -> return name and surname of Impiegato

	public class ImpiegatoNomeCognomeDTO {
			
			
			private String nome,cognome;
			
			public ImpiegatoNomeCognomeDTO() {}
		
			public ImpiegatoNomeCognomeDTO(String nome, String cognome) {
			
				this.nome = nome;
				this.cognome = cognome;
		
			}



			public String getNome() {
				return nome;
			}



			public void setNome(String nome) {
				this.nome = nome;
			}



			public String getCognome() {
				return cognome;
			}



			public void setCognome(String cognome) {
				this.cognome = cognome;
			}
			
	
			
			
			

		}



