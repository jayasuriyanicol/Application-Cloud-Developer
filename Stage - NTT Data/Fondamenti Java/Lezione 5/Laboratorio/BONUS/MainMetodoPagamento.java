package Lezione_05;

public class MainMetodoPagamento {

	public static void main(String[] args) {
		
		PagamentoCarta pc = new PagamentoCarta();
		PagamentoPayPal pyp = new PagamentoPayPal();
		
		
		pc.paga(12.00);
		pc.inviaNotifica("PAGAMENTO RICEVUTO in data 11/05/2026 ore 15:53");
		
		
		pyp.paga(131.78);
		pyp.inviaNotifica("ATTENZIONE ! Errore riprovare, pagamento NON RIUSCITO");
		
		
	}

}
