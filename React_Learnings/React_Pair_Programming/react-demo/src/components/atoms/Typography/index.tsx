import React from 'react';
import { Box } from '@mui/material';

interface TypographyTextProps {
  sx: React.CSSProperties; 
  children: React.ReactNode;
}

export const TypographyText: React.FC<TypographyTextProps> = ({ children, sx }) => {
  return (
    <Box
      component="div"
      sx={{
        fontSize: 'inherit',
        fontWeight: 'normal',
        lineHeight: 'inherit',
        textAlign: 'left',
        backgroundColor: 'transparent',
        color: 'text.primary',
        width: 'auto',
        height: 'auto',
        opacity: 1,
        ...sx, // Apply styles from the sx prop
      }}
    >
      {children}
    </Box>
  );
};
