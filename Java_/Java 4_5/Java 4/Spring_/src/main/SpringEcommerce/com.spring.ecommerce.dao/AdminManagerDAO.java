package com.spring.ecommerce.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

/* * AdminManagerDAO - Credential Persistence & Validation
    ? A security-focused Data Access Object that manages administrative credentials. It acts as a lightweight authentication provider, storing authorized personnel data in an internal map to control access to restricted system operations.

    ! 1. Seeded Security Context, the constructor populates an internal `HashMap` with specific administrative roles ranging from 'admin' and 'logistics' to 'support' and 'audit'. This provides a pre-defined set of secure access points for the application's management layer without an external identity provider.
    ! 2. Safe Authentication Protocol, implements the `autenticazioneAdmin` method using a defensive "check-then-get" approach. By verifying the existence of the username before comparing the password, it avoids potential null-pointer risks and provides a boolean result for clean integration with security filters.
    ! 3. Role-Based Naming Convention, utilizes structured usernames (e.g., `_admin`, `_mgr`, `_staff`) which allows the system to potentially extend the logic beyond simple authentication into authorization, where different users could be granted different permission levels.
*/


@Repository
public class AdminManagerDAO implements AdminManagerInterfaceDAO {

		private Map<String, String> mappa = new HashMap<>();

		public AdminManagerDAO() {

			mappa.put("m.rossi_admin", "Kr9!pT0_v4ult#26");
			mappa.put("l.bianchi_mgr", "S3cur3_P4ss_Logist!x");
			mappa.put("g.verdi_staff", "V3rdi_Catalog_2026$");
			mappa.put("sys_root_admin", "R00t_Acc3ss_Cl0ud!");
			mappa.put("a.nieri_support", "Supp0rt_T3ch_99@");
			mappa.put("audit_service", "Audit_V3rif_77*");

		}

		@Override
		public boolean autenticazioneAdmin(String username, String password) {
			return mappa.containsKey(username) && mappa.get(username).equals(password);
		}
	}

