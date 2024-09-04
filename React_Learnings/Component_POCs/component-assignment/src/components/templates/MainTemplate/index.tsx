import React from 'react';
import { SeederInput } from '../../organisms/SideNavBar';
import { HeaderSection } from '../../organisms/HeaderSection';
import { DisplayData } from '../../organisms/CardInfo'; // Import DisplayData
import FormattedSection from '../../organisms/FormattedSection'; // Import FormattedSection

export const MainTemplate: React.FC = () => {
  return (
    <div>
      {/* HeaderSection Component */}
      <HeaderSection />

      {/* Content Section */}
      <div style={{
        display: 'flex', // Align components side by side
        marginTop: '20px' // Adjust the top margin if needed
      }}>
        {/* SeederInput Component */}
        <div style={{ flex: 1 }}>
          <SeederInput />
        </div>

        {/* DisplayData Component */}
        <div style={{ flex: 1, marginRight: '480px', paddingTop: '130px' }}>
          <DisplayData />
        </div>
      </div>


      {/* FormattedSection Component below DisplayData */}
      <div style={{
      }}>
        <FormattedSection />
      </div>
    </div>
  );
};

