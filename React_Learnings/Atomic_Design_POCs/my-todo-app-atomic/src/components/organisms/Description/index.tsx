import React from 'react';
import Button from '../../atoms/Button';
import Text from '../../atoms/Text';
import { HEADER_CONTENT, PARAGRAPH_CONTENT, TASK_1, TASK_2, TASK_3, BUTTON_TEXT } from '../../utils/constants';

interface DescriptionProps {
  onOpenTodoList: () => void;
}

const Description: React.FC<DescriptionProps> = ({ onOpenTodoList }) => {
  return (
    <div className="description">
      <Text type="heading" content={HEADER_CONTENT} />
      <Text type="paragraph" content={PARAGRAPH_CONTENT} />
      <ul className="description-list">
        <li>{TASK_1}</li>
        <li>{TASK_2}</li>
        <li>{TASK_3}</li>
      </ul>
      <Button onClick={onOpenTodoList}>
        {BUTTON_TEXT}
      </Button>
    </div>
  );
};

export default Description;
