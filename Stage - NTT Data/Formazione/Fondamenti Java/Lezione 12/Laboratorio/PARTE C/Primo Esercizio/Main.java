import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Studente s1 = new Studente("Er Ninja", 0.00, "Mummificazione");
        Studente s2 = new Studente("Dragoncelli", 30.00, "Business Marketing");
        Studente s3 = new Studente("Bobby Del", 26.67, "AI & Tools");


        List< Studente> listaStudenti = new ArrayList<>();

        listaStudenti.add(s1);
        listaStudenti.add(s2);
        listaStudenti.add(s3);


        List<Studente> listaPromossi = listaStudenti.stream()

                .filter(s -> s.getMedia() >= 18)
                .sorted((n1,n2) -> n1.getNome().compareTo(n2.getNome()))
                .toList();



        long numeroSuperiori27 = listaStudenti.stream()
                .filter( s -> s.getMedia >= 27)
                .count();

        boolean verificaMedia= listaStudenti.stream().anyMatch(s -> s.getMedia() >= 30);


        System.out.println("LISTA STUDENTI PROMOSSI: " + listaPromossi);
        System.out.println("MEDIA superiore a 27: " + numeroSuperiori27);
        System.out.println("STUDENTI MEDIA 30 O SUPERIORE: " + verificaMedia);




    }
}
