package designPattern.singleton;

import singleton.Singleton;

/* * EsempioSingleton - Pattern Validation & Execution
    ? A demonstration class designed to prove the core invariant of the Singleton pattern. It tests the class's ability to strictly control object creation, verifying that regardless of how many times the request is made, the Java Virtual Machine (JVM) maintains only one memory address for the instance.

    ! 1. Instance Reference Verification, by assigning the result of 'getInstance()' to multiple variables (s, s2, s3), the code checks for reference equality. Printing the objects directly displays their memory hashcodes; in a successful Singleton, all printed values will be identical, confirming no new objects were allocated.
    ! 2. Lifecycle Observation, the execution flow triggers the internal "Creating new instance..." logic only on the first call. For every subsequent assignment, the console output "Recycling existing instance.." serves as empirical proof that the class is successfully reusing its internal static state.
    ! 3. Access Protocol Enforcement, this client code demonstrates the transition from traditional instantiation (new Singleton()) to a governed access point. This ensures that any part of the application needing the 'Singleton' data (like the name "Nicol") interacts with the exact same shared object.
*/


public class EsempioSingleton {

    public static void main(String[] args) {


        //I want to instantiate the Singleton class and
        //demonstrate that no more than one instance can ever exist

        Singleton s = Singleton.getInstance();
        System.out.println(s);

        Singleton s2 = Singleton.getInstance();
        System.out.println(s2);

        Singleton s3 = Singleton.getInstance();
        System.out.println(s3);
    }
}