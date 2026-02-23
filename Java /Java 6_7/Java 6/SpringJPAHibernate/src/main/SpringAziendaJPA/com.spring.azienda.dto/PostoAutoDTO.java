package com.spring.azienda.dto;

import com.spring.azienda.entity.Dipendente;

public class PostoAutoDTO {
		
		//PK
		private Integer idPostoAuto;
		
		
		//FK
		private Dipendente dipendenteAzienda;
		
		private String posizione;
		
		
		public PostoAutoDTO() {}

		public PostoAutoDTO(Integer idPostoAuto, Dipendente dipendenteAzienda, String posizione) {
			
			this.dipendenteAzienda = dipendenteAzienda;
			this.posizione = posizione;
		}

		public Integer getIdPostoAuto() {
			return idPostoAuto;
		}

		public void setIdPostoAuto(Integer idPostoAuto) {
			this.idPostoAuto = idPostoAuto;
		}

		public Dipendente getDipendenteAzienda() {
			return dipendenteAzienda;
		}

		public void setDipendenteAzienda(Dipendente dipendenteAzienda) {
			this.dipendenteAzienda = dipendenteAzienda;
		}

		public String getPosizione() {
			return posizione;
		}

		public void setPosizione(String posizione) {
			this.posizione = posizione;
		}

		@Override
		public String toString() {
			return "PostoAuto [IdPostoAuto=" + idPostoAuto + ", dipendenteAzienda=" + dipendenteAzienda + ", posizione="
					+ posizione + "]";
		}
		
		
		
		
		
		
		
		
	}


