import java.util.ArrayList;
import java.util.List;

public class MiniReport {

    public static void main(String[] args) {

        Ordine o1 = new Ordine("Fiutini Gilberto", "ARW432", 121.00);
        Ordine o2 = new Ordine("Leandro Paziente", "LPD323",  99.99);
        Ordine o3 = new Ordine("Mario Mela", "MAI9324", 999.67);


        List<Ordine> listaOrdini = new ArrayList<>();
        listaOrdini.add(o1);
        listaOrdini.add(o2);
        listaOrdini.add(o3);


        long totProdotti = listaOrdini.stream().count();

        List<Ordine> listaProdEco = listaOrdini.stream()

                .filter( o -> o.getTotale() < 100)
                 .toList();

        List<Ordine> listaProdCost = listaOrdini.stream()

                .filter( o -> o.getTotale() > 100)
                 .toList();


          double totSold = listaOrdini.stream().mapToDouble(o -> o.getTotale()).sum();


          List<String> lista50 = listaOrdini.stream()

                  .filter(o -> o.getTotale() > 50)
                  .map(o -> o.getCliente())
                  .toList();

            System.out.println(lista50);


    }
}
