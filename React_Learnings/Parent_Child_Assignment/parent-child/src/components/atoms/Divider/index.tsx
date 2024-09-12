// src/components/atoms/Line.tsx
import React from 'react';
import { Divider } from '@mui/material';
import { styled } from '@mui/material/styles';

const StyledDivider = styled(Divider)(({ theme }) => ({
  borderColor: theme.palette.grey[600], // Use theme palette for border color
  opacity: 1,                          // Set opacity
  width: '100%',                       // Set width
}));

export const Line: React.FC = () => {
  return <StyledDivider />;
};
