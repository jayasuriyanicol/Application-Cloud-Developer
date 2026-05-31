package multithreading;

public class Counter extends Thread {

    private int max;
    
    public Counter(int max, String name){
        //To indicate the name of the Thread
        super(name);
        this.max = max;
    }

    //Is a protection for develpoers, to do not change the sign of the method. Not to the programm, for humans
    @Override 
    public void run(){

        for(int i=1; i < max;  i++){

            System.out.println( Thread.currentThread().getName () + "-> "+i);

            try{

                //Using the Thread.sleep(), to print in sleeping mode indicating the seconds -> e.g. Thread.sleep(100) - print every second
                Thread.sleep(10000);

            } catch (InterruptedException e){
                e.printStackTrace();
           }


            
           }

       }

   }
