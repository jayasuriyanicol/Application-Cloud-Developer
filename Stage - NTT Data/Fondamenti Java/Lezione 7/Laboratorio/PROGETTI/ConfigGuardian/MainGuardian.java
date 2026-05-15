package Lezione_07;

import java.io.IOException;

public class MainGuardian {
	
	
	// ! Generated AI Test
	public static void main(String[] args) {
		

		        ConfigurazioneReader reader = new ConfigurazioneReader();
		        
		        try {
		          
		            String testoGrezzo = reader.leggiContenuto();
		            
		         
		            String[] dati =  testoGrezzo.replaceAll("\\r?\\n", "").trim().split(",");

		            
		            if (dati.length != 4) {
		                throw new ConfigurazioneNonValidaException("ATTENZIONE ! Il file contiene " + dati.length + " parametri invece di 4.");
		            }
		            
		            ConfigurazioneApp appConfig = new ConfigurazioneApp(
		                dati[0].trim(),
		                dati[1].trim(), 
		                dati[2].trim(),
		                dati[3].trim()  
		            );
		            
		           
		            ConfigurazioneValidator.validazioneContenuto(appConfig);
		            
		  
		            
		            System.out.println("=== CONFIGURAZIONE APPLICATA CON SUCCESSO ===");
		            System.out.println("Applicazione: " + appConfig.nomeApplicazione());
		            System.out.println("Versione:      " + appConfig.versione());
		            System.out.println("Ambiente:      " + appConfig.ambiente());
		            System.out.println("Porta Rete:    " + appConfig.porta());
		            System.out.println("=============================================");
		            
		        } catch (IOException e) {
		          
		            System.err.println("[ERRORE TECNICO D'I/O]: Impossibile accedere fisicamente al file di configurazione.");
		            System.err.println("Dettaglio di sistema: " + e.getMessage());
		            
		        } catch (ConfigurazioneNonValidaException e) {
		      
		            System.err.println("[ERRORE LOGICO DI DOMINIO]: I dati estratti non sono validi.");
		            System.err.println("Dettaglio di business: " + e.getMessaggio());
		        }
		    }
	
		
	}

