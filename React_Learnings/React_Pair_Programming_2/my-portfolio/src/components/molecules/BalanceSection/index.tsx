import React from "react";
import styled from "styled-components";
import { Divider } from "../../atoms/Divider";
import { TypographyText } from "../../atoms/Typography";

interface BalanceSectionProps {
  title: string;
  value: string;
}

const BalanceSectionContainer = styled.div`
  display: flex;
  flex-direction: column; 
  align-items: center;
  width: 100%; 
`;

const BalanceContent = styled.div`
  display: flex;
  align-items: center;
  width: 380px;
  padding: 8px 24px; 
  gap: 200px;
`;

const DividerWrapper = styled.div`
  margin: 15px 0;
`;

export const BalanceSection: React.FC<BalanceSectionProps> = ({ title, value }) => {
  return (
    <BalanceSectionContainer>
      <DividerWrapper>
        <Divider />
      </DividerWrapper>
      
      <BalanceContent>
        <TypographyText
          fontSize="16px"
          fontWeight={500}
          lineHeight="22px"
          color="#7D7D89"
          width="auto"
        >
          {title}
        </TypographyText>
        <TypographyText
          fontSize="16px"
          fontWeight={500}
          lineHeight="22px"
          color="#343446"
          width="auto"
        >
          {value}
        </TypographyText>
      </BalanceContent>

      <DividerWrapper>
        <Divider />
      </DividerWrapper>
    </BalanceSectionContainer>
  );
};
