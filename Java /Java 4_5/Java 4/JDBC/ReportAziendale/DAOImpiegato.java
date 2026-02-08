package JDBC.ReportAziendale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/* * DAOImpiegato - Employee Data Access Object
    ? Handles JDBC persistence for 'Impiegato' entities, managing the relational link between Employees and their Roles (Mansione) through direct SQL execution.

    ! 1. Method Overloading (aggiungiNuovo), provides flexible insertion strategies: strictly by existing foreign key, by cascading creation of a new Role (via DAOMansione), or by passing a fully hydrated object.
    ! 2. getAllImpiegati(), executes an inner JOIN between 'impiegati' and 'mansioni' to reconstruct complex objects (Employee containing a Role object) in a single database round-trip.
*/


public class DAOImpiegato {

    //Adding a new 'Impiegato' on the Database with the FK idMansione REFERENCES to Mansione table
	public static Impiegato aggiungiNuovo(int matricola, String nome, double salarioMensile, double bonusAnnuale,
			int idMansione) throws SQLException {

		PreparedStatement ps = Database.getConnection().prepareStatement(

				"INSERT INTO impiegati (matricola, nome, salarioMensile, bonusAnnuale, idMansione) VALUES (?, ?, ?, ?, ?)");

		ps.setInt(1, matricola);
		ps.setString(2, nome);
		ps.setDouble(3, salarioMensile);
		ps.setDouble(4, bonusAnnuale);
		ps.setInt(5, idMansione);

		//Logic of the search the 'Masnione' on Database
		Mansione mansioneImpiegato = null;
		PreparedStatement cercaMansione = Database.getConnection()

				.prepareStatement("SELECT * FROM mansioni WHERE id = ?");

		cercaMansione.setInt(1, idMansione);
		ResultSet mansioneTrovata = cercaMansione.executeQuery();

		if (mansioneTrovata.next())
			mansioneImpiegato = new Mansione(mansioneTrovata.getInt("id"), mansioneTrovata.getString("nome"),
					mansioneTrovata.getDouble("stipendio_min"), mansioneTrovata.getDouble("stipendio_max"));

		if (ps.executeUpdate() == 1)

			return new Impiegato(matricola, nome, salarioMensile, bonusAnnuale, mansioneImpiegato);

		return null;
	}

     //Adding a new 'Impiegato' on the Database with the FK idMansione REFERENCES to Mansione table
	public static Impiegato aggiungiNuovo(int matricola, String nome, double salarioMensile, double bonusAnnuale,
			int idMansione, String nomeMansione, double stipendio_min_mansione, double stipendio_max_mansione) throws SQLException {

		Mansione nuovaMansione = DAOMansione.aggiungiNuova(idMansione, nomeMansione, stipendio_min_mansione, stipendio_max_mansione);

		PreparedStatement ps = Database.getConnection().prepareStatement(

				"INSERT INTO impiegati (matricola, nome, salarioMensile, bonusAnnuale, idMansione) VALUES (?, ?, ?, ?, ?)");

		ps.setInt(1, matricola);
		ps.setString(2, nome);
		ps.setDouble(3, salarioMensile);
		ps.setDouble(4, bonusAnnuale);
		ps.setInt(5, idMansione);

		if (ps.executeUpdate() == 1)

			return new Impiegato(matricola, nome, salarioMensile, bonusAnnuale, nuovaMansione);
		return null;
	}


	public static boolean aggiungiNuovo(Impiegato impiegato) throws SQLException {
		PreparedStatement ps = Database.getConnection().prepareStatement(
				"INSERT INTO impiegati (matricola, nome, salarioMensile, bonusAnnuale, idMansione) VALUES (?, ?, ?, ?, ?)");
		ps.setInt(1, impiegato.getMatricola());
		ps.setString(2, impiegato.getNome());
		ps.setDouble(3, impiegato.getsalarioMensile());
		ps.setDouble(4, impiegato.getbonusAnnuale());
		ps.setInt(5, impiegato.getMansione().getId());

		return ps.executeUpdate() == 1;
	}


	public static boolean existsWithMatricola(int matricola) throws SQLException {
		PreparedStatement ps = Database.getConnection().prepareStatement("SELECT * FROM impiegati WHERE matricola = ?");
		ps.setInt(1, matricola);

		return ps.executeQuery().next();
	}


	public static List<Impiegato> getAllImpiegati() throws SQLException {

		ArrayList<Impiegato> res = new ArrayList<>();

		ResultSet allImpiegati = Database.getConnection().prepareStatement("SELECT matricola, imp.nome AS nomeImpiegato, salarioMensile, bonusAnnuale, idMansione, m.nome AS nomeMansione, stipendioMinimo, stipendioMassimo FROM impiegati AS imp JOIN mansioni AS m ON imp.idMansione = m.id").executeQuery();

		while (allImpiegati.next()) {
			Mansione mansioneImpiegato = new Mansione(allImpiegati.getInt("idMansione"), allImpiegati.getString("nomeMansione"), allImpiegati.getDouble("stipendioMinimo"), allImpiegati.getDouble("stipendioMinimo"));
			Impiegato impiegatoToReturn = new Impiegato(allImpiegati.getInt("matricola"), allImpiegati.getString("nomeImpiegato"), allImpiegati.getDouble("salarioMensile"), allImpiegati.getDouble("bonusAnnuale"), mansioneImpiegato);
			res.add(impiegatoToReturn);
		}

		return res;
	}
}