package JDBC.ReportAziendale;
import java.sql.SQLException;

/* * testReportAziendale - Application Entry Point & Test Harness
    ? Serves as the execution entry point and a testing ground for the JDBC layer, demonstrating how DAOs manipulate relational data (Employees and Roles) and handle the execution flow.

    ! 1. Error Handling, encapsulates the entire logic within a try-catch block to manage checked `SQLException`s, ensuring connection or query errors are caught and traced.
    ! 2. Integration Testing, the commented-out section ("EXCEPTION CASES") acts as executable documentation, showcasing various insertion scenarios (cascading, direct object, primitives) to test the robustness of the `aggiungiNuovo` methods.
    ! 3. Data Presentation, retrieves the full list via `getAllImpiegati()` and prints details to validate the manual Object-Relational Mapping (ORM) performed by the DAOs.
*/

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("CASO PROVA ID 1 : " + DAOMansione.existsWithId(1));
			/*
              |EXCPETION CASES|
                System.out.println("Creo mansione 1 -> " +  DAOMansione.aggiungiNuova(7, "Docente", 1821, 3100));
                System.out.println("Creo mansione 2 -> " +  DAOMansione.aggiungiNuova(new Mansione(9, "FullSteck Developer", 1342, 4020)));
                System.out.println("Creo impiegato 1 -> " + DAOImpiegato.aggiungiNuovo(1005, "Federico Fiutini", 1900, 123, 12, "Software Engineer", 2032.00, 5200.00));
                System.out.println("Creo impiegato 2 -> " + DAOImpiegato.aggiungiNuovo(1006, "Mario Mela", 2600, 250, 2));
                System.out.println("Creo impiegato 3 -> " + DAOImpiegato.aggiungiNuovo(new Impiegato(1007, "Cristiano Corda", 1300, 100, new Mansione(1, "NoobSteck", 1212.00, 1999.99))));
			*/

            //Giving all the 'Impiegati' on the Database ReportAziendale
            for (Impiegato imp : DAOImpiegato.getAllImpiegati()) {
				System.out.println(imp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}