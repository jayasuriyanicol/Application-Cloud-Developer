package it.demo.catalogo.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Prodotto {

	// ? Commenting the @GeneratedValue and @Version annotation to avoid any potential issue with the synchronization of the message received from Kafka on RD DB Catalogo, in fact we set the version to 0 on the MessageConsumer class, on the other hand if we want to use these annotations we need to set the version to 1 and not 0 because of the @Version annotation, but in this way we can have some issue with the synchronization of the message received from Kafka on RD DB Catalogo.  

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProdotto;
	private Double prezzoUnitario;
	private Integer quantitàProdotto;
	private String categoria;
	
	
	//@Version
	private int versione;
	
	public Prodotto() {}
	


	public Prodotto(Integer idProdotto, Double prezzoUnitario, Integer quantitàProdotto, String categoria, int versione ) {
		
		this.idProdotto = idProdotto;
		this.prezzoUnitario = prezzoUnitario;
		this.quantitàProdotto = quantitàProdotto;
		this.categoria = categoria;
		this.versione = versione;
		
	}

	




	public Integer getIdProdotto() {
		return idProdotto;
	}





	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}





	public Double getPrezzoUnitario() {
		return prezzoUnitario;
	}





	public void setPrezzoUnitario(Double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}





	public Integer getQuantitàProdotto() {
		return quantitàProdotto;
	}





	public void setQuantitàProdotto(Integer quantitàProdotto) {
		this.quantitàProdotto = quantitàProdotto;
	}





	public String getCategoria() {
		return categoria;
	}





	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}





	public int getVersione() {
		return versione;
	}





	public void setVersione(int versione) {
		this.versione = versione;
	}



	@Override
	public String toString() {
		
		return "Prodotto [idProdotto=" + idProdotto + ", prezzoUnitario=" + prezzoUnitario + ", quantitàProdotto="
				+ quantitàProdotto + ", categoria=" + categoria + ", versione=" + versione + "]";
	}
	
	

	
}
