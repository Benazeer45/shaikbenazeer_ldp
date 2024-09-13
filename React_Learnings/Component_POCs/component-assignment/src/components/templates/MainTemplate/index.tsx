import React from 'react';
import { SideNavBar } from '../../organisms/SideNavBar';
import CashAccelerationGridContainer from '../../organisms/CardInfo';
import CashKickCard from '../../organisms/CashKickCard';
import Header from '../../organisms/Header';

export const MainTemplate: React.FC = () => {
  return (
    <div>
      {/* HeaderSection Component */}
      <Header />

      {/* Content Section */}
      <div style={{
        display: 'flex', // Align components side by side
        marginTop: '20px' // Adjust the top margin if needed
      }}>
        {/* SeederInput Component */}
        <div style={{ flex: 1 }}>
          <SideNavBar />
        </div>

        {/* DisplayData Component */}
        <div style={{ flex: 1, marginRight: '480px', paddingTop: '130px' }}>
          <CashAccelerationGridContainer />
        </div>
      </div>


      {/* FormattedSection Component below DisplayData */}
      <div style={{
      }}>
        <CashKickCard amount={''} title={''} buttonText={''} onClick={function (): void {
          throw new Error('Function not implemented.');
        } } availableAmount={''} />
      </div>
    </div>
  );
};

