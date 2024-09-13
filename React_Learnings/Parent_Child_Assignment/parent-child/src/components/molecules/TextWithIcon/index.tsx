// src/components/atoms/TextWithIcon.tsx
import React from 'react';
import { styled } from '@mui/material/styles';
import { Box, Typography } from '@mui/material'; // Import MUI components and hook
import { Icon } from '../../atoms/Icon';

interface TextWithIconProps {
  text: string;
  iconSrc: string; // Prop to use icon source
  color?: string; // Add color prop
  onClick: () => void; // Add onClick prop
}

// Styled Box component
const StyledBox = styled(Box)(({ theme }) => ({
  display: 'flex',
  alignItems: 'center',
  gap: theme.spacing(0.5), // Use theme spacing
  width: '276px',
  height: '29px',
}));

// Styled Typography component
const StyledText = styled(Typography)<{ color?: string }>(({ theme, color }) => ({
  fontSize: theme.typography.h6.fontSize, // Use theme typography for font size
  fontWeight: theme.typography.fontWeightBold, // Use theme typography for font weight
  color: color || "#E8E7F0", // Use provided color or default color
  lineHeight: theme.typography.h6.lineHeight, // Use theme typography for line height
}));

export const TextWithIcon: React.FC<TextWithIconProps> = ({ text, iconSrc, color, onClick }) => {
  return (
    <StyledBox>
      <StyledText color={color}>{text}</StyledText>
      <Icon src={iconSrc} width="20px" height="20px" onClick={onClick} /> {/* Pass onClick here */}
    </StyledBox>
  );
};
