package Lezione_02;
import java.util.Scanner;

public class RegistrazioneUtente {
	
	
	// ! Prima fase REGISTRAZIONE dell'utente all'interno 
    public static void main(String[] args) {
    	
    	
        Scanner scanner = new Scanner(System.in);

        
        String nome = "", cognome = "", email = "", password = "";
        int eta = 0;

        
        while (true) {
        	
            boolean formCorretto = true;

          
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            
            System.out.print("Cognome: ");
            cognome = scanner.nextLine();
            
            System.out.print("Email: ");
            email = scanner.nextLine();
            
            System.out.print("Password: ");
            password = scanner.nextLine();
            
            System.out.print("Età: ");
            eta = scanner.nextInt();
            scanner.nextLine(); 

            
            if (nome == null || nome.length() < 5) {
                System.out.println("ERRORE ! Il nome deve essere lungo almeno 5 caratteri.");
                formCorretto = false;
            }
            if (cognome == null || cognome.length() < 5) {
                System.out.println("ERRORE ! Il cognome deve essere lungo almeno 5 caratteri.");
                formCorretto = false;
            }
            if (password == null || password.length() < 5) {
                System.out.println("ERRORE ! La password deve essere lunga almeno 5 caratteri.");
                formCorretto = false;
            }
            if (email == null || email.length() < 5 || !email.contains("@")) {
                System.out.println("ERRORE ! Email non valida (minimo 5 caratteri e deve contenere '@').");
                formCorretto = false;
            }
            if (eta <= 0) {
                System.out.println("ERRORE ! L'età deve essere maggiore di 0.");
                formCorretto = false;
            }

            if (formCorretto) {
                System.out.println("SUCCESSO ! Utente inserito con successo.");
                break; 
            }
        }

        //Seconda fase inserimento per l'accesso alla piattaforma 
        boolean accessoCorretto = false;
       

        for (int i = 0; i <= 2; i++) {
            System.out.println("Tentativo " + i);
            
            System.out.print("Inserisci Email: ");
            String loginEmail = scanner.nextLine();
            
            System.out.print("Inserisci Password: ");
            String loginPassword = scanner.nextLine();

            if (loginEmail.equals(email) && loginPassword.equals(password)) {
                accessoCorretto = true;
                break;
            } else {
                System.out.println("ATTENZIONE ! Le credenziali risultano errate.");
            }
        }

       
        if (accessoCorretto) {
            System.out.println("\nSUCCESSO ! Accesso effettuato! Ecco i tuoi dati:");
            System.out.println("Nome: " + nome);
            System.out.println("Cognome: " + cognome);
            System.out.println("Email: " + email);
            System.out.println("Età: " + eta);
        }
        else {
            System.out.println("\nATTENZIONE ! Non è stato possibile eseguire l'accesso.\nACCOUNT BLOCCATO !");
        }
        
        // ? Alla fine di tutto andiamo a chiudere lo scanner liberando la cache 
        scanner.close();
    }
}

