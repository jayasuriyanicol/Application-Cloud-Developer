package singleton;

/* * Singleton - Creational Design Pattern Implementation
    ? A classic implementation of the Singleton pattern, ensuring that a class has only one instance while providing a global access point to it. This structure is essential for managing shared resources, such as database connections or configuration settings, where multiple instances would cause state conflicts.

    ! 1. Private Constructor Encapsulation, by declaring the constructor private, the class effectively "locks its own front door." This prevents other classes from using the 'new' keyword to create multiple objects, forcing them to use the controlled access method instead.
    ! 2. Lazy Initialization Strategy, the 'getInstance' method implements a "creation on demand" logic. The instance is only instantiated the very first time it is requested; subsequent calls bypass the expensive creation process and return the existing reference, optimizing memory usage.
    ! 3. Static State Management, utilizes a static variable to hold the unique 'instance'. Because static members belong to the class rather than a specific object, the state of 'name' ("Nicol") persists across the entire application lifecycle, acting as a single "Source of Truth."
*/

public class Singleton {

    //Attribute needed to handle assignment within the constructor
    private String name;

    //3. Define a static attribute to hold the unique instance we want to provide
    private static Singleton instance;

    //1. Private constructor to prevent external instantiation
    private Singleton() {
        this.name = "Nicol";
    }

    //2. Define a static (and public) method that returns the Singleton object
    public static Singleton getInstance() {

        if (instance == null) {

            System.out.println("Creating new instance....");
            instance = new Singleton();
            return instance;

        } else {

            System.out.println("Recycling existing instance..");
            return instance;
        }
    }
}