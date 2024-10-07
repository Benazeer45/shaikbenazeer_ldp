import React from "react";
import styled from "styled-components";
import { Icon } from "../../atoms/Icons";
import { Box, Typography } from "@mui/material"; 

interface PortfolioSectionProps {
  title: string;
  iconSrc: string;
}

const PortfolioContainer = styled(Box)`
  width: 380px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0;
  margin: 0 auto;
`;

const Title = styled(Typography)`
  variant: h4;
  color: ${({ theme }) => theme.palette.text.primary}; 
  width: 95px;
`;

const IconContainer = styled(Box)`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  margin-left: 90px;
`;

const SmallIcon = styled(Box)` 
  width: 18px;
  height: 17px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;

const Line = styled(Box)` 
  width: 100%;
  height: 2px;
  background-color: #0052FF;
`;

export const PortfolioSection: React.FC<PortfolioSectionProps> = ({ title, iconSrc }) => {
  return (
    <PortfolioContainer>
      <Title>
        {title}
      </Title>

      <IconContainer>
        <Icon src={iconSrc} width="32px" height="32px" />
        <SmallIcon>
          <Line />
          <Line />
          <Line />
          <Line />
        </SmallIcon>
      </IconContainer>
    </PortfolioContainer>
  );
};
