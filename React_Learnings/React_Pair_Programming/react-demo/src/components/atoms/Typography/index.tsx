import React from 'react';
import { styled } from '@mui/material/styles';
import { CSSObject } from '@mui/system';

interface TypographyTextProps {
  fontSize?: string;
  fontWeight?: number;
  lineHeight?: string;
  textAlign?: 'left' | 'right' | 'center' | 'justify';
  textBackground?: string;
  color?: string;
  width?: string;
  height?: string;
  opacity?: string;
  children: React.ReactNode;
}

const StyledTypography = styled('div')<TypographyTextProps>(({ theme, fontSize, fontWeight, lineHeight, textAlign, textBackground, color, width, height, opacity }) => {
  const style: CSSObject = {
    fontSize: fontSize || 'inherit',
    fontWeight: fontWeight || 'normal',
    lineHeight: lineHeight || 'inherit',
    textAlign: textAlign || 'left',
    backgroundColor: textBackground || 'transparent',
    color: color || theme.palette.text.primary,
    width: width || 'auto',
    height: height || 'auto',
    opacity: opacity || '1',
  };
  
  return style;
});

export const TypographyText: React.FC<TypographyTextProps> = ({ children, ...props }) => {
  return <StyledTypography {...props}>{children}</StyledTypography>;
};
