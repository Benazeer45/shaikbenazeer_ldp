import React from 'react';
import { DataBlock } from '../../molecules/DataBlock';

export interface DisplayDataProps {
    blocks: {
        id: number;
        title: string;
        content: string;
        iconUrl: string; // Add iconUrl to the block
    }[];
}

const DisplayData: React.FC<DisplayDataProps> = ({ blocks }) => {
  console.log("Blocks received:", blocks); // Debugging line
  return (
      <div style={{
          width: '700px',
          height: '200px',
          borderRadius: '12px',
          border: '1px solid #28272B',
          backgroundColor: '#201F24',
          padding: '32px',
          marginTop: '130px',
          marginLeft: '10px',
          display: 'flex',
          gap: '12px',
          justifyContent: 'space-between',
      }}>
          {blocks.map(block => (
              <DataBlock
                  key={block.id}
                  icon={<img src={block.iconUrl} style={{ width: '40px', height: '40px' }} alt="Icon" />} // Use the block's iconUrl
                  title={block.title}
                  subtitle={block.content}
                  extraIcon={<img src={`${process.env.PUBLIC_URL}/assets/icons/Frame 1000004272.svg`} style={{ width: '16px', height: '16px' }} alt="Extra Icon" />}
              />
          ))}
      </div>
  );
};

export default DisplayData;
