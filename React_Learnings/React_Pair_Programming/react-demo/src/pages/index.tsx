import React from 'react';
import {  myntraData } from '../utils'; // Adjust the path as needed
import MainSection from '../components/organisms/CardSection';
import CustomTemplate from '../components/templates/MainTemplate';

const IndexPage: React.FC = () => {
  return (
    <div>
      <CustomTemplate>
      {myntraData.map((data, index) => (
        <MainSection key={`myntra-${index}`} data={data} />
      ))}
      </CustomTemplate>
    </div>
  );
};

export default IndexPage;
