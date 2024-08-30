import React from 'react';
import './index.css';

// Define props interfaces
interface TodoTemplateProps {
  headerContent: string;
  footerContent: string;
  todoComponent: React.ReactNode;
}

const TodoTemplate: React.FC<TodoTemplateProps> = ({ headerContent, footerContent, todoComponent }) => {
  return (
    <div className="todo-template">
      <header className="todo-header">
        <h1>{headerContent}</h1>
      </header>
      <section className="todo-list-section">
        {todoComponent}
      </section>
      <footer className="todo-footer">
        <p>{footerContent}</p>
      </footer>
    </div>
  );
};

export default TodoTemplate;

