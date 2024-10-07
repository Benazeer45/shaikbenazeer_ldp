import React from 'react';
import styled from 'styled-components';
import { PortfolioSection } from '../../molecules/PortfolioSection';
import { CryptoInfoDisplay } from '../../molecules/TabsSection';
import { BalanceSection } from '../../molecules/BalanceSection';
import { SideBar } from '../../atoms/SideBar';
import { balanceData, cryptoData, portfolioData } from '../../../utils/Constants';
import { Box } from '@mui/material'; // Import Box and Typography from MUI

const MainSectionContainer = styled(Box)`
  display: flex;
  flex-direction: column;
  gap: 10px;
`;

const CryptoTabsContainer = styled(Box)`
  width: 380px;  
  padding: 16px 0 16px 26px; 
  margin-left: -17px;
  display: flex;
  flex-direction: column;
  gap: 20px;
`;

const EthereumContainer = styled(Box)`
  width: 380px;  
  border: 2px solid #E5E7EB;
  box-shadow: 0px 0px 5px 0px rgba(4, 4, 4, 0.14);
  border-radius: 0px;
  padding: 16px 0 16px 26px; 
  margin-left: -25px;
`;

const SidebarContainer = styled(Box)`
  display: flex;
`;

export const MainSection: React.FC = () => {
  return (
    <MainSectionContainer>
      {/* Portfolio Section */}
      <PortfolioSection
        title={portfolioData.title}
        iconSrc={portfolioData.iconSrc} 
      />

      <SidebarContainer>
        <CryptoTabsContainer>
          {cryptoData.map((crypto, index) => (
            <div key={index} style={{ width: '380px' }}>
              {crypto.cryptoName === 'Ethereum' ? (
                <EthereumContainer>
                  <CryptoInfoDisplay
                    iconSrc={crypto.iconSrc} 
                    cryptoName={crypto.cryptoName}
                    cryptoSymbol={crypto.cryptoSymbol}
                    price={crypto.price}
                    priceChange={crypto.priceChange}
                  />
                </EthereumContainer>
              ) : (
                <CryptoInfoDisplay
                  iconSrc={crypto.iconSrc} 
                  cryptoName={crypto.cryptoName}
                  cryptoSymbol={crypto.cryptoSymbol}
                  price={crypto.price}
                  priceChange={crypto.priceChange}
                  priceChangeColor={crypto.priceChangeColor}
                />
              )}
            </div>
          ))}
        </CryptoTabsContainer>

        <SideBar />
      </SidebarContainer>

      {/* Balance Section */}
      <BalanceSection
        title={balanceData.title}
        value={balanceData.value} 
      />
    </MainSectionContainer>
  );
};
