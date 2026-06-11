import java.util.ArrayList;
import java.util.List;

public class MainOrdine {

    public static void main(String[] args) {

        Ordine o1 = new Ordine("Fiutini Gilberto", "ARW432", 121.00);
        Ordine o2 = new Ordine("Leandro Paziente", "LPD323",  99.99);
        Ordine o3 = new Ordine("Mario Mela", "MAI9324", 999.67);


        List<Ordine> listaOrdini = new ArrayList<>();
        listaOrdini.add(o1);
        listaOrdini.add(o2);
        listaOrdini.add(o3);

        List<Ordine> listaFiltrata = listaOrdini.stream()
                .filter(o -> o.getTotale() > 100)
                .toList();

        System.out.println("\nLISTA FILTRATA:\n " + listaFiltrata.toString());


        double totFilt = listaFiltrata.stream()
                .map(Ordine::getTotale)
                .reduce(0.00, (tot, prezzo) -> tot + prezzo);

        System.out.println("\nTOTALE FILTRATO: " + totFilt);
    }
}
