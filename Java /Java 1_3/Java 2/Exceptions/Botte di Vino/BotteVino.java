package corsoBase;


public class BotteVino{

    private int livello;
    private final int capacita;



    //Method of 'Botte Piena'
    public BotteVino (int livello, int capacita){

        super();
        this.livello = livello;
        this.capacita = capacita;

    }


    

    public int getLivello(){

        return livello;

    }


    public int getCapacita(){

        return capacita;

    }

    public void preleva(int qnt){


        if(qnt <= livello){


            livello -= qnt;
        }
        else{

            throw new Exception("ATTENZIONE ! La quantità " + qnt + " non si può prelevare, il LIVELLO della BOTTE è minore rispetto alla quantità richiesta !")
        }


    public void versa(int qnt){


            if(qnt + livello <= livello){

                livello += qnt;

            }

            else{

                throw new Exception("ATTENZIONE ! La quantità " + qnt + " non si può versare, il LIVELLO della BOTTE è minore rispetto alla quantità richiesta !")

           }
    

    }

   @Override
   public String(){

    return "BOTTE DI VINO\n: \nLIVELLO BOTTE: " + livello + "\nCAPACITÀ BOTTE: " + capacita;
   }


  }