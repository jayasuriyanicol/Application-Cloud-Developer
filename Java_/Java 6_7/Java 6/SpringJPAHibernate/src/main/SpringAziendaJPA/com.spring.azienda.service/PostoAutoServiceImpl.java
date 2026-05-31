package com.spring.azienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.azienda.dto.PostoAutoDTO;
import com.spring.azienda.entity.PostoAuto;
import com.spring.azienda.mapper.MapperAzienda;
import com.spring.azienda.repository.PostoAutoDAO;

import jakarta.transaction.Transactional;

 /* * PostoAutoServiceImpl - Physical Asset Governance
    ? This class manages the operational lifecycle of the company's parking infrastructure. It acts as a safety controller, ensuring that physical assets are created, queried, and retired without disrupting the relational links to the employees who utilize them.

    ! 1. Protected Resource Deletion, implements a critical "Guard Clause" in 'cancellaPostoAutoSeDipendenteExist'. By checking the 'dipendenteAzienda' reference before proceeding with a delete, the service prevents the accidental removal of a parking spot that is currently in use, thereby upholding the business rule that resources must be vacated before they are decommissioned.
    ! 2. Unified State Management, utilizes the '@Transactional' annotation to ensure that all asset operations are atomic. This is particularly vital for the consistency of the 'PostoAuto' table, ensuring that any failed operation during a batch update or deletion results in a complete rollback, keeping the physical inventory records accurate.
    ! 3. Standardized Error Propagation, employs the '.orElseThrow()' pattern for all ID-based lookups. This approach standardizes how the system handles missing assets, providing clear, descriptive feedback through 'RuntimeExceptions' that can be easily captured by a global exception handler to inform the end user.
*/

@Service
@Transactional
public class PostoAutoServiceImpl implements PostoAutoService {
	
	@Autowired
	PostoAutoDAO postoAutoDao;


	    @Override
	    public void inserisciPosto(PostoAutoDTO postoAuto) {
	        PostoAuto entity = MapperAzienda.PostoAutoDTOToEntity(postoAuto);
	        postoAutoDao.save(entity);
	    }

	    @Override
	    public List<PostoAutoDTO> visualizzaPostiAuto() {
	        List<PostoAuto> lista = postoAutoDao.findAll(); 
	        return (List<PostoAutoDTO>) MapperAzienda.CollectionPostoAutoToDTO(lista);
	    }

	    @Override
	    public PostoAutoDTO visualizzaPostoAuto(Integer idPostoAuto) {
	        PostoAuto entity = postoAutoDao.findById(idPostoAuto)
	                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Posto auto non trovato"));
	        return MapperAzienda.PostoAutoToDTO(entity);
	    }

	    @Override
	    public PostoAutoDTO cancellaPostoAutoSeDipendenteExist(Integer idPostoAuto) {
	        PostoAuto entity = postoAutoDao.findById(idPostoAuto) 
	                .orElseThrow(() -> new RuntimeException("ATTENZIONE ! Posto auto non trovato"));

	        if (entity.getDipendenteAzienda() != null) { 
	            throw new RuntimeException("ATTENZIONE ! Non è possibile cancellare il Dipendente dall'azienda: il posto auto è assegnato"); 
	        
	        }
	        PostoAutoDTO dto = MapperAzienda.PostoAutoToDTO(entity); 
	        postoAutoDao.delete(entity); 
	        return dto;
	    }
	
	    }


