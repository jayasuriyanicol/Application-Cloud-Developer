package JDBC.ReportAziendale;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/* * DAOMansione - Role Data Access Object
    ? Manages the lifecycle and persistence of 'Mansione' (Job Role) entities within the relational database, isolating SQL logic from the business layer.

    ! 1. Method Overloading (aggiungiNuova), offers flexible insertion paths: one accepting raw primitive data (returning the created object) and another accepting a fully formed Entity (returning a boolean success flag).
    ! 2. existsWithId(int), a validation utility that performs a lightweight query to verify the existence of a primary key, essential for maintaining referential integrity before linking employees.
*/

public class DAOMansione {

	public static Mansione aggiungiNuova(int id, String nome, double stipendio_min, double stipendio_max) throws SQLException {

		PreparedStatement ps = Database.getConnection().prepareStatement(

				"INSERT INTO mansioni (id, nome, stipendio_min, stipendio_max) VALUES (?, ?, ?, ?);");

		ps.setInt(1, id);
		ps.setString(2, nome);
		ps.setDouble(3, stipendio_min);
		ps.setDouble(4, stipendio_max);

		if (ps.executeUpdate() == 1)

			return new Mansione(id, nome, stipendio_min, stipendio_max);

		return null;
	}

	public static boolean aggiungiNuova(Mansione mansione) throws SQLException {

		PreparedStatement ps = Database.getConnection().prepareStatement(

				"INSERT INTO mansioni (id, nome, stipendio_min, stipendio_max) VALUES (?, ?, ?, ?);");

		ps.setInt(1, mansione.getId());
		ps.setString(2, mansione.getNome());
		ps.setDouble(3, mansione.getStipendioMinimo());
		ps.setDouble(4, mansione.getStipendioMassimo());

		return ps.executeUpdate() == 1;
	}

	public static boolean existsWithId(int Id) throws SQLException {

		PreparedStatement ps = Database.getConnection().prepareStatement("SELECT * FROM mansioni WHERE id = ?");

		ps.setInt(1, Id);

		return ps.executeQuery().next();
	}
}