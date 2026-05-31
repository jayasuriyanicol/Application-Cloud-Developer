package catalogoProdotti;

import java.util.List;

import catalogoProdotti.dto.ProdottoRequestDTO;
import catalogoProdotti.dto.ProdottoResponseDTO;
import catalogoProdotti.repository.ProdottoRepository;
import catalogoProdotti.repository.prodottoRepositoryImpl;
import catalogoProdotti.service.ProdottoService;

public class Main {
    
    public static void main(String[] args) {
        
        
        ProdottoRepository repository = new prodottoRepositoryImpl();
        ProdottoService service = new ProdottoService(repository);
            
      
        service.creaProd(new ProdottoRequestDTO("Webcam", 79.99));
                
        List<ProdottoResponseDTO> prodotti = service.trovaTuttiProd();
            
  
        for (ProdottoResponseDTO prodotto : prodotti) {
            System.out.println(
                prodotto.nome()
                + " - € "
                + prodotto.prezzo()
            );
        }
    }
}
