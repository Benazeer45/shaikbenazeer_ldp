// src/components/atoms/Text.tsx
import React from 'react';
import Typography from '@mui/material/Typography';
import { styled } from '@mui/material/styles';

interface TextProps {
  children: React.ReactNode;
  fontSize?: string;
  fontWeight?: number;
  color?: string;
  textAlign?: 'left' | 'center' | 'right' | 'justify';
  lineHeight?: string;
}

const StyledText = styled(Typography)<TextProps>(({ theme, fontSize, fontWeight, color, textAlign, lineHeight }) => ({
  fontFamily: 'Gilroy, sans-serif', // Custom font
  fontSize: fontSize || theme.typography.fontSize, // Default to theme font size
  fontWeight: fontWeight || theme.typography.fontWeightMedium, // Default font weight
  color: color || theme.palette.text.primary, // Default to theme primary text color
  lineHeight: lineHeight || 'normal', // Fallback to normal line height if not provided
  textAlign: textAlign || 'left', // Left align by default
}));

export const Text: React.FC<TextProps> = ({
  children,
  fontSize,
  fontWeight,
  color,
  textAlign = 'left',
  lineHeight,
}) => {
  return (
    <StyledText
      fontSize={fontSize}
      fontWeight={fontWeight}
      color={color}
      textAlign={textAlign}
      lineHeight={lineHeight}
    >
      {children}
    </StyledText>
  );
};
