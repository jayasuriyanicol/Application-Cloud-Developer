package com.spring.ecommerce.dao;


/* * AdminManagerInterfaceDAO - Security Abstraction Contract
    ? A strategic interface that defines the contract for administrative identity verification. It establishes the mandatory behavior for any authentication provider within the system, ensuring a consistent approach to credential validation.

    ! 1. Security Decoupling, by defining the authentication logic as an interface, the application remains flexible. The system can transition from the current In-Memory `HashMap` implementation to a more robust solution like Spring Security with LDAP or an encrypted SQL table without altering the business logic layers.
    ! 2. Functional Simplicity, provides a focused, single-purpose method `autenticazioneAdmin` that adheres to the Single Responsibility Principle. This ensures that the calling services only need to provide credentials and receive a binary (True/False) result, keeping the security handshake clean and efficient.
    ! 3. Integration Readiness, serves as the formal signature for the DAO layer, making it easy to mock during unit testing. This allows developers to simulate successful and failed login attempts independently of the actual user database.
*/

public interface AdminManagerInterfaceDAO {
	
	public boolean autenticazioneAdmin (String username, String password);
}