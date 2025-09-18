import { useState } from "react";
import TodoForm from "./TodoForm";
import TodoList from "./TodoList";

const TodoApp = () => {
  const [tasks, setTasks] = useState([]);

  // aggiungi un nuovo task
  function handleAddTask(text) {
    const nuovoTask = { id: Date.now(), text, completed: false };
    setTasks([...tasks, nuovoTask]);
  }

  // elimina un task
  function handleDeleteTask(id) {
    setTasks(tasks.filter((task) => task.id !== id));
  }

  // toggle completato
  function handleToggleTask(id) {
    setTasks(
      tasks.map((task) =>
        task.id === id ? { ...task, completed: !task.completed } : task
      )
    );
  }

  return (
    <div>
      <h1>Todo App</h1>
      <TodoForm handleAddTask={handleAddTask} />
      <TodoList
        tasks={tasks}
        handleDeleteTask={handleDeleteTask}
        handleToggleTask={handleToggleTask}
      />
    </div>
  );
};

export default TodoApp;
