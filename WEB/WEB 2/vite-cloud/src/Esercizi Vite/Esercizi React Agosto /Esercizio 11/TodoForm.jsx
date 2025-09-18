import { useState } from "react";

const TodoForm = ({ handleAddTask }) => {
  const [text, setText] = useState("");

  function handleSubmit(e) {
    e.preventDefault();
    if (!text.trim()) return;
    handleAddTask(text);
    setText(""); // reset input
  }

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Aggiungi un nuovo task..."
        value={text}
        onChange={(e) => setText(e.target.value)}
      />
      <button type="submit">Aggiungi</button>
    </form>
  );
};

export default TodoForm;
