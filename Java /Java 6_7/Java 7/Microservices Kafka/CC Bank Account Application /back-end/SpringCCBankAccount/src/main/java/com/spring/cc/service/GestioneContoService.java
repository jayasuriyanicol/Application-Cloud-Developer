package com.spring.cc.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cc.entity.ContoCorrente;
import com.spring.cc.entity.Utente;
import com.spring.cc.repository.ContoCorrenteRepository;
import com.spring.cc.repository.UtenteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GestioneContoService {
	
	@Autowired
	private UtenteRepository utente;
	
	@Autowired 
	private ContoCorrenteRepository cc;
	
	
	
	public Utente registraUtente(Utente u) {
		
		if (u.getIdUtente() != null && utente.existsById(u.getIdUtente())) {
	        throw new RuntimeException("ATTENZIONE ! L'ID utente risulta già esistente !");
	    }

	   
	    if (u.getMail() != null && utente.existsByMail(u.getMail())) {
	        throw new RuntimeException("ATTENZIONE ! Questa email è già associata a un altro utente !");
	    }
	    
		
		if(u.getIndirizzo() == null ) {
			
			throw new RuntimeException("ATTENZIONE ! Errore deve essere associato un indirizzo all'utenza !");
			

		}
		
		
		return utente.save(u);
	
	}
	


    public Utente modificaDatiUtente(Integer idUtente, Utente nuoviDati) {
    	
        
        Utente utenteEsistente = utente.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Impossibile modificare l'utente dato che non è stato trovato"));

        // ?  Check if the new email is already used by ANOTHER user to avoid duplicates
        if (!utenteEsistente.getMail().equals(nuoviDati.getMail()) && 
            utente.existsByMail(nuoviDati.getMail())) {
            throw new RuntimeException("ERRORE ! La nuova mail inserita è già associata a un altro account.");
        }

        // * After the all process I can proceed updating allowed fields
        utenteEsistente.setNome(nuoviDati.getNome());
        utenteEsistente.setCognome(nuoviDati.getCognome());
        utenteEsistente.setMail(nuoviDati.getMail());
        utenteEsistente.setTelefono(nuoviDati.getTelefono());

        
        return utente.save(utenteEsistente);

        // TODO (Note) : The address and ID remain unchanged as per security practices. If we wanted to update the address, we would need dedicated logic or a proper cascade.
    }
	
	
	
	
	public void cancellaUtente(Integer idUtente) {
		
		Utente ut = utente.findById(idUtente)
				.orElseThrow(() -> new RuntimeException("ATTENZIONE ! NON è possibile eleminare l'utente dato che non è presente !"));
		
		boolean utCC = !ut.getListaContiIntestati().isEmpty() || !ut.getListaContiCointestati().isEmpty();
		
		if (utCC) {
            throw new RuntimeException("L'utente non può essere cancellato perché possiede dei conti.");
        }
		
		// ! In this case we avoid deleting only the ID, since this involves completely removing the USER.
        utente.delete(ut);
		
		}
	
    
	
	
	public ContoCorrente registraNuovoConto(Double saldoIniziale, Integer IdIntestatario, Integer IdCointestatario) {
		
		if(saldoIniziale < 0) {
			
			throw new RuntimeException("ATTENZIONE ! Il saldo iniziale non può risultare negativo non appena si apre il CC");
			
		}
		
		Utente intestatario = utente.findById(IdIntestatario)
				.orElseThrow(() -> new RuntimeException("ERRORE ! Non risulta essere presente nessun intestatario con ID -> " + idIntestatario));
		
		
		// ! Only after this verification do we proceed with the opening of the actual CC
		
		ContoCorrente nuovoCC  = new ContoCorrente();
		nuovoCC.setDataApertura(LocalDateTime.now());
		nuovoCC.setSaldo(0.0);
	    nuovoCC.setIntestatario(intestatario);
	    
		// * OPTIONAL verification to verify whether there is actually a joint owner
		
		if (IdCointestatario != null) {
            Utente cointestatario = utente.findById(IdCointestatario)
                    .orElseThrow(() -> new RuntimeException("ERRORE ! Non risulta essere presente nessun Cointestatario."));
            nuovoCC.setCointestatario(cointestatario);
        }
        
        // ? Primaly I save it to prevent any types of errors, and after i returning it
        nuovoCC = cc.save(nuovoCC);

        //  ? Once the ACCOUNT has been generated, we can give "permission" to make changes to the balance.
        if (initial balance > 0) {
            nuovoCC.modificaSaldoCC(saldoIniziale, intestatario);
            return cc.save(nuovoCC);
        }

        return nuovoCC;
		
	}
	

    public ContoCorrente aggiornaSaldo(Integer numeroCC, Double nuovoSaldo, Integer idOperatore) {
    	
        ContoCorrente conto = cc.findById(numeroCC)
                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Il conto fornito non è associat con noi  o non valido"));
        
        Utente operatore = utente.findById(idOperatore)
                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Non è stato possibile individuare l'ID dell'operatore da voi fornito."));

        // * I need to verify that the operator is one of the owners of the CC
        
        boolean propetarioCC = operatore.equals(conto.getIntestatario()) || 
                                 operatore.equals(conto.getCointestatario());
        if (!propetarioCC) {
            throw new RuntimeException("ATTENZIONE ! l'operatore NON è autorizzato, dato che NON è proprietario del CC.");
        }

        // * Any CC changes are applied
        conto.modificaSaldoCC(nuovoSaldo, operatore);
        
        return cc.save(conto);
    }
    

    // ! Returning all the CC account avaible on the system 
    public Iterable<ContoCorrente> getTuttiConti() {
    	
    	return cc.findAll();
    }
    
    
    // ! Returning the CC account avaible on the system by the id -> numeroConto
    public ContoCorrente getConto(Integer numeroConto) {
    	
    	return cc.findById(numeroConto)
    		  .orElseThrow(() -> new RuntimeException("ATTENZIONE !\nIl conto inserito non risulta essere valido o presente nel sistema"));
    }
    

    public ContoCorrente sganciaCointestatario(Integer numeroCC, Integer idCointestatario) {
    	
        ContoCorrente conto = cc.findById(numeroCC)
                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Non è stato possibile individuare il CC."));

        if (conto.getCointestatario() == null || !conto.getCointestatario().getIdUtente().equals(idCointestatario)) {
            throw new RuntimeException("ATTENZIONE ! l'utente indicato non è il cointestatario di questo CC");
        }

        // ? Check whether the joint account holder has made any movements in the account
        boolean operazioniEffettuate = conto.getListaMovimenti().stream()
                .anyMatch(m -> m.getOperatoreBanca().getIdUtente().equals(idCointestatario));
        
        if (operazioniEffettuate) {
            throw new RuntimeException("ATTENZIONE ! IMPOSSIBILE sganciare dal CC: il cointestatario ha effettuato delle operazioni.");
        }

        // ! In this case we are going to set it as null and not delete it
        conto.setCointestatario(null); 
        return cc.save(conto);
    }

    public void eliminaCC(Integer numeroCC) {
    	
        ContoCorrente conto = cc.findById(numeroCC)
                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Non risulta esserci nessun CC con numero -> " + numeroCC));

        // ? Business Logic to security, in fact the balance must be zero to close the account.
        if (conto.getSaldo() != 0) {
            throw new RuntimeException("ERRORE ! È Impossibile cancellare il conto, il saldo deve essere esattamente 0.00 euro.\nMentre il SALDO attuale corrisponde ad: " + conto.getSaldo() + " EURO");
        }

        // * If the balance is zero, we proceed with the removal, thanks to CascadeType.ALL on the entities, the associated transactions (orphanRemoval) will be automatically deleted.
        cc.delete(conto);
    }
}

		
		
		
		
		
		
		
		
		
		
		
	