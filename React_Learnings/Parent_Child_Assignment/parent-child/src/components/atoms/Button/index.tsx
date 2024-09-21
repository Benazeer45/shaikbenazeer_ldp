// src/components/atoms/Button.tsx
import React from 'react';
import { Button as MuiButton, ButtonProps } from '@mui/material';
import { styled } from '@mui/material/styles';

const StyledButton = styled(MuiButton)(({ theme }) => ({
  width: '276px',
  height: '59px',
  padding: '20px 40px',
  borderRadius: '12px',
  backgroundColor: theme.palette.primary.main, // Use theme primary color
  color: theme.palette.secondary.main, // Use theme secondary color
  fontSize: theme.typography.button.fontSize, // Use theme button font size
  lineHeight: theme.typography.button.lineHeight, // Use theme button line height
  textAlign: 'center',
  textTransform: 'none',
  opacity: 0.56,
  border: 'none',
  '&:disabled': {
    color: theme.palette.primary.main, // Use theme primary color for disabled
    opacity: theme.palette.action.disabledOpacity, // Use theme disabled opacity
    cursor: 'not-allowed',
  },
}));

interface CustomButtonProps extends ButtonProps {
  children: React.ReactNode;
}

export const Button: React.FC<CustomButtonProps> = ({ onClick, children, ...props }) => {
  return (
    <StyledButton onClick={onClick} {...props}>
      {children}
    </StyledButton>
  );
};
