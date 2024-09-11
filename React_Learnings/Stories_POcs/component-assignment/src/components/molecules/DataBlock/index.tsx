import React from 'react';
import Heading from '../../atoms/Typography';

export interface DataBlockProps {
  icon: React.ReactNode;
  title: string;
  subtitle: string;
  extraIcon: React.ReactNode; // Add extraIcon prop
}

export const DataBlock: React.FC<DataBlockProps> = ({ icon, title, subtitle, extraIcon }) => {
  return (
    <div style={{
      width: '204px',
      height: '168px',
      borderRadius: '12px',
      padding: '20px',
      display: 'flex',
      flexDirection: 'column',
      gap: '24px',
    }}>
      <div style={{
        width: '80px',
        height: '80px',
        borderRadius: '12px',
        border: '1px solid #28272B',
        backgroundColor: '#28272B',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
      }}>
        {icon}
      </div>
      <div style={{
        display: 'flex',
        flexDirection: 'column',
        gap: '8px',
      }}>
        <div style={{ 
          display: 'flex', 
          alignItems: 'center', 
          gap: '8px' // Ensure the gap is appropriate
        }}>
          <Heading size="16px" weight={500} color="#C9C8CC" lineHeight="22.4px">
            {title}
          </Heading>
          {extraIcon && <div style={{ paddingTop: '7px' }}>{extraIcon}</div>}
        </div>
        <Heading size="24px" weight={600} color="#E8E7F0" lineHeight="29.4px">
          {subtitle}
        </Heading>
      </div>
    </div>
  );
};
