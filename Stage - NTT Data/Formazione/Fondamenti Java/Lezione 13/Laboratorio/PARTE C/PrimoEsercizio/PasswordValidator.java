
public class PasswordValidator {

	public String verificaPassword(String password) {

		Boolean numero = false;
		Boolean maiuscolo = false;

		if (password != null && password.length() < 8) {

			for (int i = 0; i < password.length(); i++) {

				char c = password.charAt(i);

				if (Character.isDigit(c)) {

					numero = true;
				}

				if (Character.isUpperCase(c)) {

					maiuscolo = true;
				}

				if (numero && maiuscolo) {

					break;

				}

			}

			if (numero && maiuscolo) {

				return "SUCCESSO ! La password inserita è valida";

			} else
				throw new IllegalArgumentException("ATTENZIONE ! La password inserita non è compatibile");

		} else {
			throw new IllegalArgumentException("ATTENZIONE ! La password inserita non è compatibile");
		}
	}

}
