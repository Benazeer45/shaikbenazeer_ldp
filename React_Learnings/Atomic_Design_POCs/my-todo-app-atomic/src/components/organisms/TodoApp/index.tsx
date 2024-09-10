import React, { useState } from 'react';
import Input from '../../atoms/Input';
import Button from '../../atoms/Button';
import TodoList from '../../molecules/TodoList';
import Description from '../../organisms/Description';
import './index.css';

interface ITodo {
  id: number;
  text: string;
  isCompleted: boolean;
  isEditing: boolean; // Added property to manage editing state
}

const TodoApp: React.FC = () => {
  const [todos, setTodos] = useState<ITodo[]>([]);
  const [input, setInput] = useState<string>('');
  const [editId, setEditId] = useState<number | null>(null);
  const [showTodoApp, setShowTodoApp] = useState<boolean>(true); // State to toggle between Description and TodoApp

  const addTodo = () => {
    if (input.trim()) {
      if (!todos.some(todo => todo.text.toLowerCase() === input.trim().toLowerCase())) {
        setTodos([...todos, { id: Date.now(), text: input, isCompleted: false, isEditing: false }]);
        setInput('');
      }
    }
  };

  const toggleComplete = (id: number) => {
    setTodos(todos.map(todo =>
      todo.id === id ? { ...todo, isCompleted: !todo.isCompleted } : todo
    ));
  };

  const editTodo = (id: number) => {
    setEditId(id);
  };

  const saveTodo = (id: number, newText: string) => {
    setTodos(todos.map(todo =>
      todo.id === id ? { ...todo, text: newText, isEditing: false } : todo
    ));
  };

  const deleteTodo = (id: number) => {
    setTodos(todos.filter(todo => todo.id !== id));
  };

  const handleDoubleClick = (id: number) => {
    setTodos(todos.map(todo =>
      todo.id === id ? { ...todo, isEditing: true } : todo
    ));
  };

  const handleKeyPress = (event: React.KeyboardEvent<HTMLInputElement>, id: number) => {
    if (event.key === 'Enter') {
      saveTodo(id, event.currentTarget.value);
    }
  };

  return (
    <div>
      {showTodoApp ? (
        <>
          <h1>To-Do List</h1>
          <Input
            value={input}
            onChange={(e) => setInput(e.target.value)}
            placeholder="Add a new task..."
          />
          <Button onClick={addTodo}>Add</Button>
          <TodoList
            todos={todos}
            onToggleComplete={toggleComplete}
            onEdit={handleDoubleClick}
            onDelete={deleteTodo}
            onSave={saveTodo}
            onKeyPress={handleKeyPress}
          />
          <Button onClick={() => setShowTodoApp(false)}>
            ← Back
          </Button>
        </>
      ) : (
        <Description onOpenTodoList={() => setShowTodoApp(true)} />
      )}
    </div>
  );
};

export default TodoApp;
