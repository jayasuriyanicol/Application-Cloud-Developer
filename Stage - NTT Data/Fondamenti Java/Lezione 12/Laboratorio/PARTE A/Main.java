import java.util.ArrayList;
import java.util.List;

public class Main {
     public static void main(String[] args) {

          Prodotto p1 = new Prodotto("Albero di Natale", "ADDOBBI", 54.35);
          Prodotto p2 = new Prodotto("Cesto Pasquale", "GASTRONOMIA", 30.99);
          Prodotto p3 = new Prodotto("Uovo Cioccolato", "DOLCI", 9.99);
          Prodotto p4 = new Prodotto("Coccodrillo Gonfiabile", "PISCINA", 7.89);
          Prodotto p5 = new Prodotto("Piscina 100x100", "PISCINA", 121.99);
          Prodotto p6 = new Prodotto("Pane Bauletto Bianco", "PANE", 1.45);

          List<Prodotto> supermercato = new ArrayList<>();
          supermercato.add(p1);
          supermercato.add(p2);
          supermercato.add(p3);
          supermercato.add(p4);
          supermercato.add(p5);
          supermercato.add(p6);

          //Here we have a PREDICATE for the use of a filter
          List<Prodotto> listaProdottiFiltrati = supermercato.stream()
                  .filter(p -> p.getPrezzo() > 50)
                  .sorted((prod1, prod2) -> prod1.getNome().compareTo(prod2.getNome()))
                  .toList();

          //Here we using a CONSUMER, because we have the recall of functions
          // CORRETTO: la variabile p.getPrezzo() viene passata DOPO la virgola
          listaProdottiFiltrati.forEach(p -> System.out.printf("NOME PRODOTTO: %s\nCATEGORIA: %s\nPREZZO: %.2f\n\n",
                  p.getNome(), p.getCategoria(), p.getPrezzo()));


          //Here we have a FUNCTION because we go a to have CAST conversion
          double prezzoFinale = supermercato.stream()
                  .map(Prodotto::getPrezzo)
                  .reduce(0.00, (tot, prezzo) -> tot + prezzo);

          System.out.printf("PREZZO TOT PRODOTTI  %.2f \n", prezzoFinale);

          //Here we have a PREDICATE for the use of a filter
          int prodottiEconomici = (int) supermercato.stream()

                  .filter(p -> (p.getPrezzo() <30))
                  .count();

          System.out.println("PRODOTTI ECONOMICI: " + prodottiEconomici);

          //Here we use a Predicate function, in fact we have a BOOLEAN return
          boolean risultato = supermercato.stream().anyMatch(p -> p.getPrezzo() > 200.00);
          System.out.println("PRODOTTI sopra 200 euro: " + risultato);

     }
}
