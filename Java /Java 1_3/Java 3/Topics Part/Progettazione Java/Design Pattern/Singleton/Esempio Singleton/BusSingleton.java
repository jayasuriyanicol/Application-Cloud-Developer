package singleton;

/* * BusSingleton - Resource Allocation Control
    ? A domain-specific implementation of the Singleton pattern that models a limited resource—in this case, a single shuttle bus. This ensures that the application cannot "accidentally" spawn a fleet of buses when only one physical unit is available for deployment.

    ! 1. Resource Integrity, by making the constructor private, the system guarantees that the 'Shuttle-X100' model is unique. This is critical in simulation or logistics software where creating multiple instances of a unique physical asset would lead to data inconsistency and logical errors.
    ! 2. Just-In-Time Deployment, utilizes the "Lazy Loading" approach. The bus is not "parked" in memory until the exact moment 'getInstance()' is called, ensuring that system resources are only consumed when the shuttle is actually needed for service.
    ! 3. Global State Consistency, the static 'instance' attribute ensures that every part of the application—from the booking module to the GPS tracker—interacts with the same bus object. Any change to the bus state (like its current location) is immediately visible to all callers.
*/

public class BusSingleton {

    // Attribute needed for assignment within the constructor
    private String model;

    // 3. Define a static attribute to hold the unique instance to provide
    private static BusSingleton instance;

    // 1. Private constructor to prevent external instantiation
    private BusSingleton() {
        this.model = "Shuttle-X100";
    }

    // 2. Define a static (and public) method that returns the Singleton object
    public static BusSingleton getInstance() {
        if (instance == null) {
            System.out.println("Deploying the only bus available....");
            instance = new BusSingleton();
            return instance;
        } else {
            System.out.println("The bus is already out there, recycling it..");
            return instance;
        }
    }
}