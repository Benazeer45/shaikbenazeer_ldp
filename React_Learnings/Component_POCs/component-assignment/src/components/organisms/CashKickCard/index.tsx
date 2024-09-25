// src/components/organisms/CashKickCard/index.tsx
import React from 'react';
import Heading from '../../atoms/Typography';
import Button from '../../atoms/Button';
import {
  CARD_STYLES,
  HEADING_STYLES,
  SUBTEXT_STYLES,
  BUTTON_STYLES,
  AVAILABLE_AMOUNT_TEXT, // Import the new constant
} from '../../../constants'; // Adjusted path for constants
import { TEXT } from '../../../constants'; // Import TEXT constants

interface CashKickCardProps {
  amount: string;
  title: string;
  buttonText: string;
  availableAmount: string; // New prop for available amount
  onClick: () => void; // onClick handler prop
}

const CashKickCard: React.FC<CashKickCardProps> = ({
  amount,
  title,
  buttonText,
  availableAmount, // Using the availableAmount prop
  onClick,
}) => (
  <div style={CARD_STYLES}>
    <Heading
      size="24px"
      weight={600}
      color="#E8E7F0"
      lineHeight="29.4px"
      style={HEADING_STYLES}
    >
      <div style={{ lineHeight: '29.4px' }}>
        {TEXT.PLACE_TO_CREATE_CASH_KICKS} {/* Using constant from TEXT */}
        <br />
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
        {/* Using the AVAILABLE_AMOUNT_TEXT constant with dynamic availableAmount */}
        {AVAILABLE_AMOUNT_TEXT(availableAmount)}
      </Heading>
    </div>
    <br />
    <Button
      text={buttonText} // Button text passed as a prop
      onClick={onClick} // Button click event handled by prop
      style={BUTTON_STYLES}
    />
  </div>
);

export default CashKickCard;
