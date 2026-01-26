import React from 'react'

const TodoItem = ({ task, onDeleteTask, onToggleTask }) => {
  return (
    <li className='list-group-item d-flex justify-content-between'>

      <input type='checkbox'
        className='form-check-input me-2'
        checked={task.completed}
        onChange={() => { onToggleTask(task.id, task.completed) }} />


      <span style={{ textDecoration: task.completed ? "line-through" : "none" }}>
        {task.text}
      </span>

      <button className='btn btn-danger' onClick={() => onDeleteTask(task.id)}>Delete</button>
    </li>
  );
};

export default TodoItem;