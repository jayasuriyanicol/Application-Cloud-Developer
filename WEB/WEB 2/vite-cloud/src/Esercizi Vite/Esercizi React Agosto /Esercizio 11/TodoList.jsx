import TodoItem from "./TodoItem";

const TodoList = ({ tasks, handleDeleteTask, handleToggleTask }) => {
  return (
    <div>
      <h2>Lista Task</h2>
      {tasks.length === 0 && <p>Nessun task disponibile</p>}
      <ul>
        {tasks.map((task) => (
          <TodoItem
            key={task.id}
            task={task}
            handleDeleteTask={handleDeleteTask}
            handleToggleTask={handleToggleTask}
          />
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
