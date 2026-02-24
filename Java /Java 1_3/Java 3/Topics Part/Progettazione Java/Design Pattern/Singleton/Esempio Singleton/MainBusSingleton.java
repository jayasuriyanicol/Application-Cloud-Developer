package designPattern.singleton;

import singleton.Bus;

/* * MainBusSingleton - Singleton Behavioral Validation
    ? An execution harness designed to verify the "Unique Instance" constraint of the BusSingleton. It acts as a simulation of multiple client requests for the same physical resource, ensuring the JVM maintains a single reference point throughout the application lifecycle.

    ! 1. Memory Address Synchronization, by printing the object references (b1, b2, b3), the code confirms that the hexadecimal hashcodes are identical. This proves that despite three distinct variable declarations, the heap memory contains only one 'Bus' object, preventing memory bloat.
    ! 2. Execution Log Traceability, the console output serves as an audit trail. The "Deploying..." message appears only once, while the "Recycling..." message repeats, providing real-time evidence that the conditional logic within the Singleton successfully blocked additional instantiations.
    ! 3. Resource Access Simulation, demonstrates how different parts of a software system—such as a ticketing service or a route tracker—can safely share a single global asset. By calling 'getInstance()', each service is guaranteed to work with the same 'Shuttle-X100' instance without creating data conflicts.
*/

public class MainBusSingleton {

    public static void main(String[] args) {

        // I want to instantiate the MainBusSingleton class and
        // demonstrate that no more than one bus instance can ever exist

        Bus b1 = Bus.getInstance();
        System.out.println(b1);

        Bus b2 = Bus.getInstance();
        System.out.println(b2);

        Bus b3 = Bus.getInstance();
        System.out.println(b3);
    }
}