package JDBC;
import java.util.Scanner;

/* * AppTodo - Console Application Entry Point
    ? A simple CLI class that captures user input for a 'todo' task and delegates the database insertion to the DAO layer.

    ! 1. main(String [] args), manages the user interaction: reads the task from the console, validates it is not blank, calls TodoDAO.inserimentoTask() to save it, and prints the operation status.
*/

public class AppTodo {
	
	public static void main(String [] args) {
		
		Scanner scanner  = new Scanner(System.in);
		
		System.out.println(" ==== INSERISCI il nuovo TASK ====  ");
		String task  = scanner.nextLine();
		
		if(task.isBlank()) {
			
			System.out.println("ATTENZIONE ! Il task risulta vuoto, inserire almeno una parola");
		
		}
		
		boolean TaskOK = TodoDAO.inserimentoTask(task);
		
		
		if(TaskOK) {
			
			System.out.println("SUCCESSO ! Il Task è stato inserito correttamente ");
		}
		
		
		
		
		scanner.close();
	}
	
	
	}