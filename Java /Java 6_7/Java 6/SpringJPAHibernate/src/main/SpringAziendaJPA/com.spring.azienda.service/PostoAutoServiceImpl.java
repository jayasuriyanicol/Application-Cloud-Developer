package com.spring.azienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.azienda.dto.PostoAutoDTO;
import com.spring.azienda.entity.PostoAuto;
import com.spring.azienda.mapper.MapperAzienda;
import com.spring.azienda.repository.PostoAutoDAO;

import jakarta.transaction.Transactional;

 
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


