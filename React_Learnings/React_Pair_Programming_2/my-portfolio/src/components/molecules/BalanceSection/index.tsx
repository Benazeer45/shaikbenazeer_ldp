import React from "react";
import styled from "styled-components";
import { Divider } from "../../atoms/Divider";
import { Box, Typography } from "@mui/material"; 

interface BalanceSectionProps {
  title: string;
  value: string;
}

const DividerWrapper = styled(Box)` 
  margin: 15px 0;
`;

const BalanceContainer = styled(Box)`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
`;

const BalanceInfo = styled(Box)`
  display: flex;
  align-items: center;
  width: 380px;
  padding: 8px 24px;
  gap: 200px; 
`;

export const BalanceSection: React.FC<BalanceSectionProps> = ({ title, value }) => {
  return (
    <BalanceContainer> 
      <DividerWrapper>
        <Divider />
      </DividerWrapper>

      <BalanceInfo> 
        <Typography variant="body1" color="text.secondary"> 
          {title}
        </Typography>
        <Typography variant="body1" color="text.primary">
          {value}
        </Typography>
      </BalanceInfo>

      <DividerWrapper>
        <Divider />
      </DividerWrapper>
    </BalanceContainer>
  );
};
