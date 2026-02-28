package PatternObserver;

/* * Observer - The Notification Contract
    ? The core abstraction of the Observer Design Pattern. This interface defines the "Subscriber" protocol, ensuring that any object—whether it is an 'Allievo', a logging system, or a UI component—can be notified of state changes in a 'Subject' (like a 'Docente') without being tightly coupled to its implementation.

    ! 1. Decoupled Communication Architecture, establishes a standardized 'update()' method that serves as the universal callback. This allows the 'Subject' to maintain a list of 'Observer' references and trigger them blindly, adhering to the "Open/Closed Principle" by allowing new types of observers to be added without modifying the existing subject code.
    ! 2. Push-Model Synchronization, defines the mechanism for state propagation. When the subject's state changes (e.g., a lesson ends), it iterates through its collection of observers and invokes this method, forcing them to synchronize their internal state or stop their execution threads, as seen in your 'Allievo' implementation.
    ! 3. Foundation for Reactive Systems, provides the essential structure for event-driven programming. By implementing this single-method interface, objects transform from passive data containers into active listeners that can respond dynamically to runtime events, which is critical for handling concurrent tasks in multithreaded Java applications.
*/

//Comune interface the CLASS COMPONENT 'Observer'
public interface Observer {
	
	public void update();
	

}
