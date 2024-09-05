import React, { useState } from 'react';
import './App.css'; // Import the CSS file

interface Todo {
  id: number;
  text: string;
  isEditing: boolean;
  isCompleted: boolean;  // New property to track if a to-do is completed
}

const App: React.FC = () => {
  // State for the list of todos, the current input, and visibility of the todo list
  const [todos, setTodos] = useState<Todo[]>([]);
  const [input, setInput] = useState<string>('');
  const [showTodoList, setShowTodoList] = useState<boolean>(false); // Control visibility of the to-do list
  const [error, setError] = useState<string | null>(null); // State to handle error messages

  // Function to handle adding a new todo
  const addTodo = () => {
    if (input.trim()) {
      // Check for duplicates (case-insensitive)
      if (todos.some(todo => todo.text.toLowerCase() === input.trim().toLowerCase())) {
        setError('This task already exists.'); // Show an error message
        return;
      }
      setTodos([...todos, { id: Date.now(), text: input, isEditing: false, isCompleted: false }]);
      setInput(''); // Clear the input field
      setError(null); // Clear error message
    }
  };

  // Function to toggle the completed status of a todo
  const toggleComplete = (id: number) => {
    setTodos(todos.map(todo =>
      todo.id === id ? { ...todo, isCompleted: !todo.isCompleted } : todo
    ));
  };

  // Function to handle setting a todo to edit mode
  const editTodo = (id: number) => {
    setTodos(todos.map(todo =>
      todo.id === id ? { ...todo, isEditing: true } : todo
    ));
  };

  // Function to handle saving an edited todo when Enter is pressed
  const saveTodo = (id: number, newText: string) => {
    setTodos(todos.map(todo =>
      todo.id === id ? { ...todo, text: newText, isEditing: false } : todo
    ));
  };

  // Function to handle key press events
  const handleKeyPress = (event: React.KeyboardEvent<HTMLInputElement>, id: number) => {
    if (event.key === 'Enter') {
      saveTodo(id, event.currentTarget.value);
    }
  };

  return (
    <div className={`app-container ${showTodoList ? 'show-todo-list' : ''}`}>
      {!showTodoList ? (
        <div className="description">
          <h2>To-Do List Application</h2>
          <p>This application allows you to manage your tasks efficiently. Here are the key functionalities:</p>
          <ul>
            <li>Add new tasks to your to-do list.</li>
            <li>Double-click on a task to edit it.</li>
            <li>Click the checkbox to mark tasks as completed and strike through them.</li>
          </ul>
          <button onClick={() => setShowTodoList(true)} className="open-todo-list-button">
            Open To-Do List →
          </button>
        </div>
      ) : (
        <div className="todo-app">
          <h1 className="todo-title">To-Do List</h1>
          <input
            type="text"
            value={input}
            onChange={(e) => setInput(e.target.value)}
            placeholder="Add a new task..."
            className="todo-input"
          />
          <button onClick={addTodo} className="todo-add-button">
            Add
          </button>
          {error && <div className="error-message">{error}</div>}
          <ul className="todo-list">
            {todos.map((todo) => (
              <li
                key={todo.id}
                className={`todo-item ${todo.isCompleted ? 'completed' : ''}`}
              >
                <input
                  type="checkbox"
                  checked={todo.isCompleted}
                  onChange={() => toggleComplete(todo.id)}
                  className="todo-checkbox"
                />
                {todo.isEditing ? (
                  <input
                    type="text"
                    defaultValue={todo.text}
                    onKeyPress={(e) => handleKeyPress(e, todo.id)} // Save only when Enter is pressed
                    autoFocus
                    className="todo-edit-input"
                  />
                ) : (
                  <span
                    onDoubleClick={() => editTodo(todo.id)}  // Changed to double-click
                    title="Double-click to edit"
                    className="todo-text"
                  >
                    {todo.text}
                  </span>
                )}
              </li>
            ))}
          </ul>
          <button onClick={() => setShowTodoList(false)} className="back-button">
            ← Back
          </button>
        </div>
      )}
    </div>
  );
};

export default App;
