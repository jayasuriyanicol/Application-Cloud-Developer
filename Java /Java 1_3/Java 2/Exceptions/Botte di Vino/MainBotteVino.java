package corsoBase;

public class  MainBotteVino{

    public static void main (String[] args){


        BotteVino botte = new BotteVino(2,10);
        System.out.println(botte);


        botte.preleva(1);


        /* 
        In this case it will raise Unhandled Excption, in order to prevent from this we can apply:
        
        1. throws Exception in to the public static void main (String[] args), so:

                /* public static void main (String[] args) throw Exception{ 
                
                botte.preleva(1); 


                        ...
                
                } 
                * /
               


        2. Try - Catch, method:

            try{

                botte.preleva(11);
           } 
           catch (Exception e) {


               // e.printStackTrace() -> Show the trace of the error excption.

               e.printStackTrace()
               System.out.println(e.getMessage());

               /* -> botte.toString()
                     java.lang.Exception: message
                                        
                                          TRACE ROUTE 
                     ATTENZIONE ! La quantità " + qnt + " non si può prelevare, il LIVELLO della BOTTE è minore rispetto alla quantità richiesta !
                     botte.toString()
               */

          }

            System.out.println(botte);

        
        
        
        
        */


       }


   }