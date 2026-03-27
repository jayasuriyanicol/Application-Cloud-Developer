


@Service 
public class CatalogService {

    @Autowired 
    private ProdottoRepossitory repository;

    @Autowired 
    private StreamBridge bridge;

   @Transactional 
   public vodi creaProdotto(Prodotto p){

        repository.save(p);

        bridge.send("prodotto-stream-catalog", p);

        System.out.println("SUCCESSO ! Il prodotto è stato creato correttamente ed è stato inviato a KAFKA come coda a messaggio");
   } 


}
