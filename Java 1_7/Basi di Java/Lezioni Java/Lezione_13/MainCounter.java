package multithreading;

public class MainCounter{

    public static void main(String[] args){
        
        //Here start the THREAD MAIN, every thread have a number o priority (MIN,MIDUM,MAX)
        System.out.println(Thread.currentThread());

        '''
        The output, will be:

            Thread.currentThread()).getName() ->[MainCounter, MainCounter=5] 
            Thread.currentThread()).getName() -> MainCounter
            Thread.currentThread()).getPriority -> 5 

        '''

        //First counter, to operate with the Thread. Associate the max number and the name
        Counter c1  = new Counter(50, "Ludovico Cagnolini");
        //In this case, we do not use the run(), because it will automatically do it in the Counter class
        c1.start()
       
        //Second counter, to operate with the Thread. Associate the max number and the name
        Counter c2 = new Counter(30, "Giacomo Coccodrillini");
        
        c2.start()
       
        
        

       '''
        c1.setPriority(n[0-10]) -> to set the priority
        If we use the -> "c1.run()" it will print the MainCounter after all the processo 

        ->
            5
            MainCounter - n
            MainCounter
        
        Or if we do not declare it, we will have:
        
        ->  
            5 
            MainCounter 
            MainCounter - n
       '''

}

}