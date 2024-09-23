import React from 'react';
import { Divider as MUIDivider } from '@mui/material';
import styled from 'styled-components';

const StyledDivider = styled(MUIDivider)`
  width: 380px;          
  border-width: 2px;    
  margin: 0 auto;        
`;

export const Divider: React.FC = () => {
  return (
    <StyledDivider />
  );
};
