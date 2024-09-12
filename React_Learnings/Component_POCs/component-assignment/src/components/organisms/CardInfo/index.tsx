// src/components/CashAccelerationGridContainer.tsx
import React from 'react';
import CashAccelerationGridItems from '../../molecules/DataBlock';
import { ICONS, TEXT } from '../../../constants';

const data = [
  {
    icon: ICONS.CALENDAR,
    title: TEXT.TERM_CAP,
    subtitle: TEXT.TERM_CAP_SUBTITLE,
    extraIcon: ICONS.FRAME,
  },
  {
    icon: ICONS.DOCUMENT_DOWNLOAD,
    title: TEXT.AVAILABLE_CREDIT,
    subtitle: TEXT.AVAILABLE_CREDIT_SUBTITLE,
    extraIcon: ICONS.FRAME,
  },
  {
    icon: ICONS.PERCENTAGE_SQUARE,
    title: TEXT.MAX_INTEREST_RATE,
    subtitle: TEXT.MAX_INTEREST_RATE_SUBTITLE,
    extraIcon: ICONS.FRAME,
  },
];

export const CashAccelerationGridContainer: React.FC = () => (
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
    {data.map((item, index) => (
      <CashAccelerationGridItems
        key={index}
        icon={<img src={item.icon} style={{ width: '40px', height: '40px' }} alt={`${item.title} Icon`} />}
        title={item.title}
        subtitle={item.subtitle}
        extraIcon={<img src={item.extraIcon} style={{ width: '16px', height: '16px' }} alt="Extra Icon" />}
      />
    ))}
  </div>
);

export default CashAccelerationGridContainer;
