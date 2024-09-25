import React from 'react';
import { styled } from '@mui/material/styles';

const CenteredLayout = styled('div')(() => ({
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
  minHeight: '100vh',
}));

const TemplateContainer = styled('div')(({ theme }) => ({
  width: theme.spacing(71.375),
  height: theme.spacing(19.875),
  padding: `${theme.spacing(2)} ${theme.spacing(2.375)}`,
  gap: theme.spacing(1.25),
  borderRadius: `${theme.shape.borderRadius} ${theme.shape.borderRadius} ${theme.shape.borderRadius} 0px`,
  opacity: 1,
  backgroundColor: theme.palette.background.paper,
  position: 'relative',
}));

interface CustomTemplateProps {
  children: React.ReactNode;
}

const CustomTemplate: React.FC<CustomTemplateProps> = ({ children }) => {
  return (
    <CenteredLayout>
      <TemplateContainer>
        {children}
      </TemplateContainer>
    </CenteredLayout>
  );
};

export default CustomTemplate;
