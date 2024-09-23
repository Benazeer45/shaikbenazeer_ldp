import React from 'react';
import styled from 'styled-components';
import { Icon } from "../../atoms/Icons";
import { TypographyText } from "../../atoms/Typography";

interface CryptoInfoDisplayProps {
  iconSrc: string; 
  cryptoName: string;  
  cryptoSymbol: string;
  price: string;       
  priceChange: string; 
  style?: React.CSSProperties;
}

const Container = styled.div<{ customStyle?: React.CSSProperties }>`
  width: 380px;  
  height: 30px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0px;
  background-color: #fff;     
  margin: 0 auto;
  ${({ customStyle }) => customStyle && { ...customStyle }}
`;

const LeftLayout = styled.div`
  display: flex;
  align-items: center;
  gap: 10px;
`;

const RightLayout = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
`;

export const CryptoInfoDisplay: React.FC<CryptoInfoDisplayProps & { priceChangeColor?: string }> = ({
  iconSrc,
  cryptoName,
  cryptoSymbol,
  price,
  priceChange,
  priceChangeColor
}) => {
  return (
    <Container>
      <LeftLayout>
        <Icon src={iconSrc} width="42px" height="42px" />
        
        <div>
          <TypographyText fontSize="16px" fontWeight={500} lineHeight="22px" color="#343446">
            {cryptoName}
          </TypographyText>
          <TypographyText fontSize="14px" fontWeight={400} lineHeight="16px" color="#7D7D89">
            {cryptoSymbol}
          </TypographyText>
        </div>
      </LeftLayout>

      <RightLayout>
        <TypographyText fontSize="16px" fontWeight={500} lineHeight="22px" color="#343446">
          {price}
        </TypographyText>
        <TypographyText fontSize="14px" fontWeight={400} lineHeight="16px" color={priceChangeColor || "#20B03F"}>
          {priceChange}
        </TypographyText>
      </RightLayout>
    </Container>
  );
};
