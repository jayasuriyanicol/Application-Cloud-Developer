package Lezione_07;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class EmailUniche {

	private String email;
	
	List<String> listaEmail = new ArrayList<>();

	
	public EmailUniche(String email) {
		
		this.email = email;
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(email, listaEmail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailUniche other = (EmailUniche) obj;
		return Objects.equals(email, other.email) && Objects.equals(listaEmail, other.listaEmail);
	}
	
	
	
	
}
