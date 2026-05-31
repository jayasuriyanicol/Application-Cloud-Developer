package JDBC;

/* * Todo - Entity Class
    ? A Plain Old Java Object (POJO) representing a single task, containing a unique ID, the task description, and a completion status (boolean).

    ! 1. Todo(int id, String task, boolean done), constructor that fully initializes the object state.
    ! 2. Getters (getId, getTask, isDone), standard accessor methods to retrieve the object's properties.
    ! 3. Setters (setTask, setDone), standard mutator methods to update the task description or completion status.
*/

public class Todo {
	
	
	private int id;
	private String task;
	private boolean done;
	
	
	public Todo(int id, String task, boolean done) {
		this.id = id;
		this.task = task;
		this.done = done;
	}


	public int getId() {
		return id;
	}


	public boolean isDone() {
		return done;
	}
	
	

	public void setDone(boolean done) {
		this.done = done;
	}

	
	public void setTask(String task) {
		this.task = task;
	}


	public String getTask() {
		return task;
	}

	
}
