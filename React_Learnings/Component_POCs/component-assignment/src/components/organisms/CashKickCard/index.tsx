// src/components/organisms/CashKickCard/index.tsx
import React from 'react';
import Heading from '../../atoms/Typography';
import Button from '../../atoms/Button';
import { CARD_STYLES, HEADING_STYLES, SUBTEXT_STYLES, BUTTON_STYLES } from '../../../constants';

interface CashKickCardProps {
  amount: string;
  title: string;
  buttonText: string;
  onClick: () => void; // onClick handler prop
}

const CashKickCard: React.FC<CashKickCardProps> = ({ amount, title, buttonText, onClick }) => (
  <div style={CARD_STYLES}>
    <Heading
      size="24px"
      weight={600}
      color="#E8E7F0"
      lineHeight="29.4px"
      style={HEADING_STYLES}
    >
      <div style={{ lineHeight: '29.4px' }}>
        Launch a new <br />
        Cash Kick<br/>
        <span style={{ fontWeight: 600 }}>
          {title} {/* Title passed as a prop */}
        </span>
      </div>
    </Heading>
    <br />
    <div style={SUBTEXT_STYLES}>
      <Heading
        size="16px"
        weight={500}
        color="#E8E7F0"
        lineHeight="22.4px"
        style={{ fontFamily: 'Gilroy, sans-serif' }}
      >
        You have upto <span style={{ fontWeight: 700 }}>$880,000.00</span> available for a new cash advance
      </Heading>
    </div>
    <br />
    <Button
      text='Launch New Kick'
      onClick={onClick} // Button click event handled by prop
      style={BUTTON_STYLES}
    />
  </div>
);

export default CashKickCard;
