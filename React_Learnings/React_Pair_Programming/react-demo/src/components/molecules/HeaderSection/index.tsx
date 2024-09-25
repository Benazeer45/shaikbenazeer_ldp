// src/molecules/HeaderSection.tsx
import React from 'react';
import { styled} from '@mui/material/styles';
import { Icon } from '../../atoms/Icon'; // Make sure to import your Icon component

const HeaderContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  justifyContent: 'space-between',
  alignItems: 'center',
  width: theme.spacing(58),
  height: theme.spacing(8.75),
}));

export interface HeaderSectionProps {
  mainText: React.ReactNode;
  subText1: React.ReactNode;
  subText2: React.ReactNode;
  iconSrc: string; // New prop for the icon source
  onIconClick: () => void; // Function to handle icon click for dropdown
}

export const HeaderSection: React.FC<HeaderSectionProps> = ({
  mainText,
  subText1,
  subText2,
  iconSrc,
  onIconClick,
}) => {
  return (
    <HeaderContainer>
      {mainText}
      {subText1}
      {subText2}
      <Icon
        src={iconSrc} // Use the provided icon source
        alt="Dot Icon"
        onClick={onIconClick} // Attach click handler
      />
    </HeaderContainer>
  );
};
