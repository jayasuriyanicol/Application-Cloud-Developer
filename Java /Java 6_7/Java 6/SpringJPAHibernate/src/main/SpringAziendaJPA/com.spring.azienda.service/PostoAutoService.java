package com.spring.azienda.service;

import java.util.List;

import com.spring.azienda.dto.PostoAutoDTO;


public interface PostoAutoService  {
	
	public void inserisciPosto(PostoAutoDTO postoAuto);
	public List<PostoAutoDTO> visualizzaPostiAuto();
	public PostoAutoDTO visualizzaPostoAuto(Integer IdPostoAuto);
	public PostoAutoDTO cancellaPostoAutoSeDipendenteExist(Integer IdPostoAuto);
	
	

}