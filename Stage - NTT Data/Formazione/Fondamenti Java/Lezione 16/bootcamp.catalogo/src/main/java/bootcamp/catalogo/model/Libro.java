package bootcamp.catalogo.model;

import java.time.LocalDate;

import bootcamp.catalogo.model.CategoriaLibro;

public class Libro {

	private Long id;
	private String titolo, autore;
	private CategoriaLibro categoria;
	private int pagine;
	private double prezzo;
	private LocalDate dataInserimento;

	public Libro(Long id, String titolo, String autore, CategoriaLibro categoria, int pagine, double prezzo,
			LocalDate dataInserimento) {

		validazioneCampi(titolo, autore, categoria, pagine, prezzo, dataInserimento);

		// Dopo aver svolto le dovute modifiche andrò con l'associazione

		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.categoria = categoria;
		this.pagine = pagine;
		this.prezzo = prezzo;
		this.dataInserimento = LocalDate.now();

	}

	// Partiamo prima dei GETTER e SETTER alla dichiarazione dei metodi

	// Prima dell'associazione delle variabili all'oggetto, svolgo il controllo sui
	// dati

	private void validazioneCampi(String titolo, String autore, CategoriaLibro categoria, int pagine, double prezzo,
			LocalDate dataInserimento) {

		if (titolo == null || titolo.isBlank()) {

			throw new IllegalArgumentException("ATTENZIONE ! Il titolo è obbligatorio");

		}

		if (autore == null || autore.isBlank()) {

			throw new IllegalArgumentException("ATTENZIONE ! l'autore del libro è obbligatorio");

		}

		if (categoria == null) {

			throw new IllegalArgumentException(
					"ATTENZIONE ! la categoria è obbligatoria e deve rispecchiare gli enum disponibili");

		}

		if (pagine <= 0) {

			throw new IllegalArgumentException("ATTENZIONE ! le pagine totali devo essere maggiori di 0");

		}

		if (prezzo < 0) {

			throw new IllegalArgumentException("ATTENZIONE ! Il prezzo NON PUO' essere minore di zero !");

		}

	}

	public void aggiornaDati(String titolo, String autore, CategoriaLibro categoria, int pagine, double prezzo) {

		validazioneCampi(titolo, autore, categoria, pagine, prezzo, dataInserimento);

		this.titolo = titolo;
		this.autore = autore;
		this.categoria = categoria;
		this.pagine = pagine;
		this.prezzo = prezzo;
		this.dataInserimento = LocalDate.now();

	}

	public boolean isCostoso(double soglia) {

		if (this.prezzo > soglia) {

			return true;
		}
		return false;

	}

	public String descrizioneBreve() {

		return "\nLIBRO:" + "\n\nID LIBRO: " + id + "\nTITOLO: " + titolo + "\nAUTORE: " + autore + "\nCATEGORIA: "
				+ categoria + "\nPAGINE: " + pagine +

				// Gestiamo anche il fatto di due cifre decimali con format
				"\nPREZZO: " + String.format("%.2f", prezzo) + "€" +

				"\nDATA INSERIMENTO: " + dataInserimento + "\n";
	}

	// Da qui con GETTER e SETTER

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public CategoriaLibro getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaLibro categoria) {
		this.categoria = categoria;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public LocalDate getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDate dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	// Non procediamo con il toString(), per il fatto che abbiamo già il metodo
	// descrizioneBreve che celo fa

}
