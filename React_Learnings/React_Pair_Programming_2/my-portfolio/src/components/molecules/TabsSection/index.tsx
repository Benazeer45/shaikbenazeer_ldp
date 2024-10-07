import React from 'react';
import styled from 'styled-components';
import { Icon } from "../../atoms/Icons";
import { Box, Typography } from "@mui/material";

interface CryptoInfoDisplayProps {
  iconSrc: string; 
  cryptoName: string;  
  cryptoSymbol: string;
  price: string;       
  priceChange: string; 
  priceChangeColor?: string; 
}

const Container = styled(Box)`
  width: 380px;  
  height: 30px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0;
  background-color: #fff;     
  margin: 0 auto;
`;

const LeftLayout = styled(Box)`
  display: flex;
  align-items: center;
  gap: 10px;
`;

const RightLayout = styled(Box)`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
`;

const PriceChangeText = styled(Typography)<{ color: string }>`
  color: ${({ color }) => color};
`;

export const CryptoInfoDisplay: React.FC<CryptoInfoDisplayProps> = ({
  iconSrc,
  cryptoName,
  cryptoSymbol,
  price,
  priceChange,
  priceChangeColor = "#20B03F", 
}) => {
  return (
    <Container>
      <LeftLayout>
        <Icon src={iconSrc} width="42px" height="42px" />
        <div>
          <Typography variant="body1" fontWeight={500} color="text.primary">
            {cryptoName}
          </Typography>
          <Typography variant="body2" fontWeight={400} color="text.secondary">
            {cryptoSymbol}
          </Typography>
        </div>
      </LeftLayout>
      <RightLayout>
        <Typography variant="body1" fontWeight={500} color="text.primary">
          {price}
        </Typography>
        <PriceChangeText variant="body2" fontWeight={400} color={priceChangeColor}>
          {priceChange}
        </PriceChangeText>
      </RightLayout>
    </Container>
  );
};
