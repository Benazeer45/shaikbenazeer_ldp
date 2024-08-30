// src/pages/index.tsx

import React from 'react';
import TodoTemplate from '../../components/templates/todoTemplate';
import TodoApp from '../../components/organisms/TodoApp';
import { HEADER_CONTENT, FOOTER_CONTENT } from '../../utils';

const Home: React.FC = () => {
  return (
    <div>
      <TodoTemplate
        headerContent={HEADER_CONTENT}
        footerContent={FOOTER_CONTENT}
        todoComponent={<TodoApp />}
      />
    </div>
  );
};

export default Home;
