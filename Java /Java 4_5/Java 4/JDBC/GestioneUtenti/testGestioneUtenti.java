package GestioneUtenti;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/* * testGestioneUtenti - Console Application Interface
    ? A CLI (Command Line Interface) driver class that orchestrates the user management system, acting as the frontend controller to interact with the database via the DAO layer.

    ! 1. main(String[] args), establishes the database connection and runs a menu-driven loop allowing users to perform CRUD operations (Registration, Login, Update, Delete) and administrative tasks, while handling input validation and exceptions.
*/


public class testGestioneUtenti {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opzione = -1;

        try {
         
            Connection connessioneTest = DB.getConnection();
            
            System.out.println("SUCCESSO! Connessione al database stabilita.");

            do {
            	
                System.out.println("\n=-=-=-=-=-=-= GESTIONE DB UTENTI =-=-=-=-=-=-=");
                System.out.println("0 -> Registra nuovo utente");
                System.out.println("1 -> Login dell'utente");
                System.out.println("2 -> Modifica password utente");
                System.out.println("3 -> Cancella un utente attraverso username");
                System.out.println("4 -> Visualizza tutti gli utenti (Admin)");
                System.out.println("5 -> ESCI DALL'APPLICAZIONE");
                System.out.print("Scegli un'opzione: ");
                
                try {
                	
                    opzione = Integer.parseInt(sc.nextLine());
                    
                } catch (NumberFormatException e) {
                	
                    System.out.println("Errore: Inserisci un numero valido.");
                    continue;
                }

                switch (opzione) {
                
                    case 0:
                    	
                        System.out.println("\n| REGISTRAZIONE |");
                        System.out.print("Nome: "); String nome = sc.nextLine();
                        System.out.print("Cognome: "); String cognome = sc.nextLine();
                        System.out.print("Password: "); String password = sc.nextLine();
                        System.out.print("Anno di nascita: "); int anno = Integer.parseInt(sc.nextLine());
                        
                        boolean duplicato;
                        do {
                            duplicato = false;
                            System.out.print("Scegli lo Username: "); String user = sc.nextLine();
                            try {
                                DAOUtenti.inserimentoTask(new Utente(user, nome, cognome, password, anno));
                                System.out.println("Utente registrato correttamente!");
                            } catch (SameIDException e) {
                                System.err.println("Errore: " + e.getMessage());
                                duplicato = true;
                            }
                        } while (duplicato);
                        break;

                    case 1:
                        System.out.println("\n| LOGIN |");
                        System.out.print("Username: "); String uLog = sc.nextLine();
                        System.out.print("Password: "); String pLog = sc.nextLine();
                        if (DAOUtenti.login(uLog, pLog)) {
                            System.out.println("Login effettuato! Benvenuto " + uLog);
                        } else {
                            System.out.println("Credenziali errate.");
                        }
                        break;

                    case 2:
                        System.out.println("\n| MODIFICA PASSWORD |");
                        System.out.print("Username dell'utente: "); String uMod = sc.nextLine();
                        System.out.print("Nuova password: "); String pMod = sc.nextLine();
                        if (DAOUtenti.modificaPassword(uMod, pMod)) {
                            System.out.println("Password aggiornata con successo.");
                        } else {
                            System.out.println("Utente non trovato.");
                        }
                        break;

                    case 3:
                        System.out.println("\n| ELIMINAZIONE UTENTE |");
                        System.out.print("Username da cancellare: "); String uDel = sc.nextLine();
                        if (DAOUtenti.cancellaUtente(uDel)) {
                            System.out.println("Utente rimosso.");
                        } else {
                            System.out.println("Utente non trovato.");
                        }
                        break;

                    case 4:
                        System.out.print("Inserisci password ADMIN: ");
                        if (sc.nextLine().equals("admin")) {
                            ArrayList<Utente> lista = DAOUtenti.getAllUtenti();
                            System.out.println("\nLISTA UTENTI:");
                            for (Utente u : lista) {
                                System.out.println("-> " + u.getUsername() + " (" + u.getNome() + " " + u.getCognome() + ")");
                            }
                        } else {
                            System.out.println("Accesso negato.");
                        }
                        break;

                    case 5:
                        System.out.println("Chiusura programma...");
                        break;

                    default:
                        System.out.println("Opzione non valida.");
                }

            } while (opzione != 5);

        } catch (Exception e) {
            System.err.println("ERRORE CRITICO: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}