// src/pages/index.tsx
import React from 'react';
import CustomTemplate from '../components/templates/MainTemplate';
import MainSection from '../components/organisms/CardSection';

const IndexPage: React.FC = () => {
  return (
    <div>
      <CustomTemplate>
        <MainSection /> 
      </CustomTemplate>
    </div>
  );
};

export default IndexPage;
