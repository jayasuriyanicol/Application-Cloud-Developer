package Lezione_07;

import java.io.IOException;

public class MainGuardian {
	
	public static void main(String[] args) {
		
                // ? Logica di gestione imitanto un reader 
		        ConfigurazioneReader reader = new ConfigurazioneReader();
		        
		        try {
		          
		            String testoGrezzo = reader.leggiContenuto();
		            
		            // ! I dati vengono estratti senza spazi, divisi da virgole
		            String[] dati =  testoGrezzo.replaceAll("\\r?\\n", "").trim().split(",");

		            // ? I parametri devono essere esattemente 4 sennò scatta l'eccezione ConfigurazioneNonValidaException
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
		            
		  
		            
		            System.out.println("\n|CONFIGURAZIONE APPLICATA CON SUCCESSO|");
		            System.out.println("\nAPPLICAZIONE -> " + appConfig.nomeApplicazione());
		            System.out.println("\nVERSIONE -> " + appConfig.versione());
		            System.out.println("\nAMBIENTE -> " + appConfig.ambiente());
		            System.out.println("\nNUMERO PORTA -> " + appConfig.porta());
		        
		            
		        } catch (IOException e) {
		          
		            System.err.println("[ERRORE TECNICO D'I/O]: ATTENZIONE, impossibile accedere fisicamente al file di configurazione.");
		            System.err.println("\nINFORMAZIONE AGGIUNTIVA -> " + e.getMessage());
		            
		        } catch (ConfigurazioneNonValidaException e) {
		      
		            System.err.println("[ERRORE LOGICO DI DOMINIO]: ATTENZIONE ! I dati estratti non sono validi.");
		            System.err.println("ERORRE COMPRESSO -> " + e.getMessaggio());
		        }
		    }
	
		
	}

