import React from 'react';
import { styled, Box } from '@mui/material';

const Container = styled(Box)(({ theme }) => ({
  width: 340,
  height: 470,
  position: 'absolute',
  top: '50%', // Center vertically
  left: '50%', // Center horizontally
  transform: 'translate(-50%, -50%)', // Offset by half the width/height to truly center
  padding: theme.spacing(4, 0, 0, 0), // Using theme spacing for padding
  gap: theme.spacing(2.5), // Using theme spacing for gap
  borderRadius: theme.shape.borderRadius, // Applying border radius from the theme
  border: `1px solid ${theme.palette.divider}`, // Using theme palette for border color
  backgroundColor: '#201F24', // Custom background color
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center', // Center items horizontally
}));

interface SummaryTemplateProps {
  children: React.ReactNode;
}

export const SummaryTemplate: React.FC<SummaryTemplateProps> = ({ children }) => {
  return (
    <Container>
      {children} {/* Render children */}
    </Container>
  );
};


