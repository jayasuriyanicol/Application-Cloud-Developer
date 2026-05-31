package Cartoleria2;

import java.time.LocalDate;
import java.util.ArrayList;


/*  
    * Ordine - Old Class
    ? Adding previous class of Ordine to test it with JUnit & Mock:

    ! Ordine(LocalDate data, Cliente cliente): Constructor that initializes the order with the given date and client, assigns a unique auto-incrementing ID (numero) using a static counter, initializes the empty list of items (merci), and sets the payment status (pagato) to false.

    ! getNumero(): Returns the unique order number.

    ! setNumero(int numero): Updates the order number.

    ! getData(): Returns the order date.

    ! setData(LocalDate data): Updates the order date.

    ! getCliente(): Returns the associated client object.

    ! setCliente(Cliente cliente): Updates the associated client.

    ! getMerci(): Returns the list of articles currently in the order.

    ! setMerci(ArrayList<Articolo> merci): Replaces the current list of articles with a new one.

    ! getContaNumeri(): Returns the current value of the static counter used for generating order IDs.

    ! toString(): Overrides the default string representation to return a formatted string detailing the order number, date, client information, and the list of items.

    ! calcolaTotale(): Iterates through the list of items (merci) and calculates the total sum based on the cost of each article.

    ! chiudi(): Finalizes the order; it checks if the order is unpaid, calculates the total amount, executes the payment via the client's polymorphic paga() method, and marks the order as paid.

    ! isPagato(): Returns the current payment status of the order.

    ! carica(Articolo articolo): Adds a specific article object to the order's list of items (merci).
*/


public class Ordine {

	private int numero;
	private static int contaNumeri = 1;
	private LocalDate data;
	private Cliente cliente;
	private ArrayList<Articolo> merci;
	private boolean pagato;
	
	public Ordine(LocalDate data, Cliente cliente) {
		super();
		this.data = data;
		this.cliente = cliente;
		this.numero = contaNumeri;
		contaNumeri++;
		this.merci = new ArrayList<>();
		this.pagato = false;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Articolo> getMerci() {
		return merci;
	}

	public void setMerci(ArrayList<Articolo> merci) {
		this.merci = merci;
	}

	public static int getContaNumeri() {
		return contaNumeri;
	}

	@Override
	public String toString() {
		return "Ordine [numero=" + numero + ", data=" + data + ", cliente=" + cliente + ", merci=" + merci + "]";
	}
	
	public double calcolaTotale() {
		double totale = 0;
		for (Articolo articolo : merci) {
			totale += articolo.getCosto();
		}
		return totale;
	}
	
	public void chiudi() {
		if(!pagato) {
			double totale = this.calcolaTotale();
			this.cliente.paga(totale);  // chiamata polimorfica
			pagato = true;
		}
	}

	public boolean isPagato() {
		return pagato;
	}
	
	public void carica(Articolo articolo) {
		this.merci.add(articolo);
	}
}
