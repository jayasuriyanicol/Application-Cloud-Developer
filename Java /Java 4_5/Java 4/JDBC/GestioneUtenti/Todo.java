package GestioneUtenti;


/* * Todo - Task Entity Model
    ? A simple POJO (Plain Old Java Object) representing a task, linking a description ('task') and a completion status ('done') to a specific user owner ('username').

    ! 1. Encapsulation, maintains private access to task details, exposing them only via public getter and setter methods for data manipulation.
*/

public class Todo {
	
	
	private String username;
	private String task;
	private boolean done;
	
	
	public Todo(String username, String task, boolean done) {
		this.username = username;
		this.task = task;
		this.done = done;
	}

	
	public void setUsername(String username) {
		
		this.username = username;
	}
	
	public String getUsername() {
		return username;
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
