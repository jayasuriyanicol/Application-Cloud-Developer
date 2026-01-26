import { useEffect, useState } from "react";
import TodoForm from "./TodoForm";
import TodoList from "./TodoList";

const API_URL = "http://localhost:3123/task";

const TodoApp = () => {

  const [tasks, setTasks] = useState([]); 
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchTasks = async () => {

    try {
      const response = await fetch(API_URL);
      if (!response.ok) throw new Error("Errore nella fetch");

      const data = await response.json();
      setTasks(data);

    } catch (err) {

      setError(err);
    } finally {

      setLoading(false);
    }
  };

  const deleteTask = async (id) => {

     await fetch(API_URL + "/" + id,
            { method: "DELETE" }
        )
        fetchTasks();

  };

  const toggleTask = async (id, completed) => {
    
    await fetch(API_URL + "/" + id,
        {
            method: "PATCH",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ completed: !completed })
        }
        )
    fetchTasks();
};


  useEffect(() => {
    fetchTasks();
  }, []);

  if (loading) return <p>Caricamento...</p>;
  if (error) return <p>Errore: {error.message}</p>;

  return (
    <div>
      <TodoForm />
      <TodoList
        tasks={tasks}
        onDeleteTask={deleteTask}
        onToggleTask={toggleTask}
      />
    </div>
  );
};

export default TodoApp;
