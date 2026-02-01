package multithreading;

public class Countdown implements Runnable{
    
    private int inizio;
    private int fine;


    public Countdown (int inizio, int fine){

        this.inizio = inizio;
        this.fine = fine;
    }


    @Override
    public void run(){

        for (int i = inizio; i>= fine; i--){

            System.out.println(Thread.currentThread().getName()+ "-> "+i);

            // ? We want to create an error, a NullPointException to block the Thread
            if(i==50){
                
                String s = null;
                s.charAt(0);

                '''

                In this case, we go to "kill" the Thread and the process. 
                ...

                First Runnable -> 50
                Excpetion in thread "First Runnable" java.lang ...
                '''
            }


   } 

}
}