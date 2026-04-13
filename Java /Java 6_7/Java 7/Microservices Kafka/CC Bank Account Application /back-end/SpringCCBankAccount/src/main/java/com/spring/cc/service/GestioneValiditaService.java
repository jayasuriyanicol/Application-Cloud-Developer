package com.spring.cc.service;

import com.spring.cc.entity.ContoCorrente;
import com.spring.cc.entity.Movimento.tipoMovimento;
import com.spring.cc.entity.Utente;
import com.spring.cc.repository.ContoCorrenteRepository;
import com.spring.cc.repository.UtenteRepository;
import com.spring.cc.dto.ReportUtenteDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


// * This is an only service dedicated as lecture as validator of the CC Bank
@Service
@Transactional(readOnly = true)
public class GestioneValiditaService {
	
	@Autowired 
	private ContoCorrenteRepository cc;
	
	@Autowired
	private UtenteRepository utente;
    

    public boolean CCValidazione (Integer numeroCC) {
        
    	ContoCorrente conto = cc.findById(numeroCC).orElseThrow();
        
        // ! Sum of movements consistent with the balance
        double sommaMovimenti = conto.getListaMovimenti().stream()
            .mapToDouble(m -> m.getOperazione() ==  tipoMovimento.versamento ? m.getImporto().getValue() : -m.getImporto().getValue())
            .sum();
        if (Math.abs(sommaMovimenti - conto.getSaldo()) > 0.01) return false;

        // ? Check Balance not less than -5000
        if (conto.getSaldo() < -5000) return false;
        
        return true;
    }
    
    
    // * Management of user's
    public Utente getSingoloUtente(Integer idUtente) {
        return utente.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Non è stato possibile trovare l'utente con ID ->  " + idUtente));
    }

    public List<ReportUtenteDTO> generaReportUtenti() {
        
    	// ! Here we retrieve all users from the database
        List<Utente> tuttiGliUtenti = utente.findAll();
        
        return tuttiGliUtenti.stream().map(utente -> {
           
        	// ? Calculate the total balance, we add the balances of all accounts in which the user is the account holder.
            double saldoIntestatario = utente.getListaContiIntestati().stream()
                    .mapToDouble(ContoCorrente::getSaldo)
                    .sum();
            
            // ? We add up the balance of all accounts in which the user is a joint account holder
            double saldoCointestatario = utente.getListaContiCointestati().stream()
                    .mapToDouble(ContoCorrente::getSaldo)
                    .sum();
            
            double saldoTotale = saldoIntestatario + saldoCointestatario;

            // * We create the DTO with the required data including the address
            return new ReportUtenteDTO(
                utente.getIdUtente(),
                utente.getNome(),
                utente.getCognome(),
                utente.getIndirizzo().getCittà(),
                utente.getIndirizzo().getProvincia(),
                saldoTotale
            );
            
        }).collect(Collectors.toList());
    }
    
    
    public Double getPatrimonioBanca() {
        return cc.findAll().stream()
                .mapToDouble(ContoCorrente::getSaldo)
                .sum();
    }

    
  

}
