import React from 'react';
import Button from '../../atoms/Button';
import Text from '../../atoms/Text';

interface DescriptionProps {
  onOpenTodoList: () => void;
}

const Description: React.FC<DescriptionProps> = ({ onOpenTodoList }) => {
  return (
    <div className="description">
      <Text type="heading" content="To-Do List Application" />
      <Text type="paragraph" content="This application allows you to manage your tasks efficiently. Here are the key functionalities:" />
      <ul className="description-list">
        <li>Add new tasks to your to-do list.</li>
        <li>Double-click on a task to edit it.</li>
        <li>Click the checkbox to mark tasks as completed and strike through them.</li>
      </ul>
      <Button onClick={onOpenTodoList}>
        Open To-Do List →
      </Button>
    </div>
  );
};

export default Description;
