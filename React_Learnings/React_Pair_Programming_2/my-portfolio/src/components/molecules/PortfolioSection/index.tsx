import React from "react";
import styled from "styled-components";
import { Icon } from "../../atoms/Icons";
import { TypographyText } from "../../atoms/Typography";

interface PortfolioSectionProps {
  title: string;
  iconSrc: string;
}

const PortfolioContainer = styled.div`
  width: 380px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0px 0px;
  margin: 0 auto;
`;

const IconContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  margin-left: 90px;
`;

const SmallIcon = styled.div`
  width: 18px;
  height: 17px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;

const Line = styled.div`
  width: 100%;
  height: 2px;
  background-color: #0052FF;
`;

export const PortfolioSection: React.FC<PortfolioSectionProps> = ({ title, iconSrc }) => {
  return (
    <PortfolioContainer>
      <TypographyText
        fontSize="16px"
        fontWeight={500}
        lineHeight="22px"
        color="#343446"
        width="95px"
      >
        {title}
      </TypographyText>
      <IconContainer>
        <Icon
          src={iconSrc}
          width="32px"
          height="32px"
        />
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
