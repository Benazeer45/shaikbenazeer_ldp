import React from 'react';
import CalenderImage from '../../../assets/icons/calendar.svg';
import DocumentDownloadImage from '../../../assets/icons/document-download.svg';
import PercentageSquareImage from '../../../assets/icons/percentage-square.svg';
import FrameImage from '../../../assets/icons/Frame 1000004272.svg';
import { DataBlock } from '../../molecules/DataBlock';

export const DisplayData: React.FC = () => (
  <div style={{
    width: '700px',
    height: '200px',
    borderRadius: '12px',
    border: '1px solid #28272B',
    backgroundColor: '#201F24',
    padding: '32px',
    display: 'flex',
    gap: '12px',
    justifyContent: 'space-between',
  }}>
    <DataBlock
      icon={<img src={CalenderImage} style={{ width: '40px', height: '40px' }} alt="Calender Icon" />}
      title="Term Cap"
      subtitle="12 months"
      extraIcon={<img src={FrameImage} style={{ width: '16px', height: '16px' }} alt="Frame Icon" />}
    />
    <DataBlock
      icon={<img src={DocumentDownloadImage} style={{ width: '40px', height: '40px' }} alt="Document Download Icon" />}
      title="Available credit"
      subtitle="$880.0k"
      extraIcon={<img src={FrameImage} style={{ width: '16px', height: '16px' }} alt="Frame Icon" />}
    />
    <DataBlock
      icon={<img src={PercentageSquareImage} style={{ width: '40px', height: '40px' }} alt="Percentage Square Icon" />}
      title="Max interest rate"
      subtitle="12.00%"
      extraIcon={<img src={FrameImage} style={{ width: '16px', height: '16px' }} alt="Frame Icon" />}
    />
  </div>
);

export default DisplayData;
