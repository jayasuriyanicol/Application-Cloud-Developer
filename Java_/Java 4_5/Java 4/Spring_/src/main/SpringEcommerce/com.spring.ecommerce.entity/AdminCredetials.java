package com.spring.ecommerce.entity;
import java.util.Objects;


/* * AdminCredentials - Security Entity Model
    ? A domain entity designed to encapsulate administrative access data. It serves as the primary object for representing an identity within the system's internal security context during the authentication handshake.

    ! 1. Structural Encapsulation, provides a clean, dedicated container for credential pairs. By separating these from the business logic or DTO layers, it ensures that security-related data is handled as a distinct architectural concern.
    ! 2. Composite Identity Logic, overrides `equals` and `hashCode` based on both the username and the password. This strict equality check is essential for precise credential matching within collections, ensuring that access is only granted when the entire security pair matches exactly.
    ! 3. Plaintext Handling Notice, while this class facilitates easy debugging through its `toString()` method, it acts as a direct representation of raw credentials. In a production environment, this entity would typically be used in conjunction with a hashing service to ensure that passwords are never stored or compared in their original, readable form.
*/

public class AdminCredetials {

		private String username;
		private String password;

		public AdminCredetials() {}

		public AdminCredetials(String username, String password) {
			
			this.username = username;
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public int hashCode() {
			return Objects.hash(password, username);
		}

		@Override
		public boolean equals(Object obj) {
			
			if (this == obj)
				return true;
			
			if (obj == null)
				return false;
			
			if (getClass() != obj.getClass())
				return false;
			
			AdminCredetials other = (AdminCredetials) obj;
			
			return Objects.equals(password, other.password) && Objects.equals(username, other.username);
		}
		
		@Override
		public String toString() {
		    return "|ADMIN CREDENTIALS|\n  USERNAME -> " + username + "\n  PASSWORD -> " + password;
		}
		
	}


