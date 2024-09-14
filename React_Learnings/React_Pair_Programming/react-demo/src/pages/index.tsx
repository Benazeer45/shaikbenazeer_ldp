import React from 'react';
import { myntraData } from '../utils'; // Adjust the path as needed
import MainSection from '../components/organisms/CardSection';
import CustomTemplate from '../components/templates/MainTemplate';

const IndexPage: React.FC = () => {
  const logoSrc = '/assets/icons/Logo.svg'; // Define the logo source

  return (
    <div>
      <CustomTemplate>
        {myntraData.map((data, index) => (
          <MainSection
            key={`myntra-${index}`}
            data={data}
            logoSrc={logoSrc} // Pass the logoSrc prop
          />
        ))}
      </CustomTemplate>
    </div>
  );
};

export default IndexPage;
