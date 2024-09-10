import React from 'react';
import Button from '../../atoms/Button'; // Correct path from molecules to atoms

interface ITodoItemProps {
  text: string;
  isCompleted: boolean;
  onToggleComplete: () => void;
  onEdit: () => void;
  onDelete: () => void;
}

const TodoItem: React.FC<ITodoItemProps> = ({ text, isCompleted, onToggleComplete, onEdit, onDelete }) => {
  return (
    <li>
      <input type="checkbox" checked={isCompleted} onChange={onToggleComplete} />
      <span onDoubleClick={onEdit} style={{ textDecoration: isCompleted ? 'line-through' : 'none' }}>
        {text}
      </span>
      <Button onClick={onDelete}>Delete</Button>
    </li>
  );
};

export default TodoItem;
