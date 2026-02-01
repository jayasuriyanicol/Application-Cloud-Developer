package multithreading;

public class MainRunnable{

    public static void main(String[] args ){


        Countdown cd = new Countdown(100,0);
        Thread t = new Thread(cd, "First Runnable")
        t.start();

        // ! t.stop(); -> Deprecated method, t.stop(), it not usable 
    


       }



   }