import React from 'react';
import Button from '../../atoms/Button'; // Correct path from molecules to atoms

interface ITodo {
  id: number;
  text: string;
  isCompleted: boolean;
  isEditing: boolean;
}

interface TodoListProps {
  todos: ITodo[];
  onToggleComplete: (id: number) => void;
  onEdit: (id: number) => void;
  onDelete: (id: number) => void;
  onSave: (id: number, newText: string) => void;
  onKeyPress: (event: React.KeyboardEvent<HTMLInputElement>, id: number) => void;
}

const TodoList: React.FC<TodoListProps> = ({ todos, onToggleComplete, onEdit, onDelete, onSave, onKeyPress }) => {
  return (
    <ul className="todo-list">
      {todos.map(todo => (
        <li key={todo.id} className={`todo-item ${todo.isCompleted ? 'completed' : ''}`}>
          <input
            type="checkbox"
            checked={todo.isCompleted}
            onChange={() => onToggleComplete(todo.id)}
            className="todo-checkbox"
          />
          {todo.isEditing ? (
            <input
              type="text"
              defaultValue={todo.text}
              onKeyPress={(e) => onKeyPress(e, todo.id)} // Save on Enter key
              autoFocus
              className="todo-edit-input"
            />
          ) : (
            <span
              onDoubleClick={() => onEdit(todo.id)}
              className="todo-text"
            >
              {todo.text}
            </span>
          )}
          <Button onClick={() => onDelete(todo.id)}>
            Delete
          </Button>
        </li>
      ))}
    </ul>
  );
};

export default TodoList;
