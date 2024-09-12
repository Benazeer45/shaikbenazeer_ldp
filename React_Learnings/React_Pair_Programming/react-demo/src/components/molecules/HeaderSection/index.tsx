import React from 'react';
import { styled, useTheme } from '@mui/material/styles';
import { TypographyText } from '../../atoms/Typography';

const HeaderContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  justifyContent: 'space-between',
  alignItems: 'center',
  width: theme.spacing(58), 
  height: theme.spacing(8.75), 
}));

const TextSection = styled('div')(({ theme }) => ({
  display: 'flex',
  flexDirection: 'column',
  gap: theme.spacing(1), 
  width: theme.spacing(33), 
  height: theme.spacing(8.75), 
}));

const DotsContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  gap: theme.spacing(0.5), 
  alignItems: 'center',
  marginTop: theme.spacing(-4.375), 
  paddingRight: theme.spacing(1.00), //
}));

const Dot = styled('div')(({ theme }) => ({
  width: theme.spacing(0.625),
  height: theme.spacing(0.625), 
  backgroundColor: theme.palette.text.primary, 
  borderRadius: '50%', 
}));

export interface HeaderSectionProps {
  mainText: React.ReactNode;
  subText1: React.ReactNode; 
  subText2: React.ReactNode; 
}

export const HeaderSection: React.FC<HeaderSectionProps> = ({
  mainText,
  subText1,
  subText2,
}) => {
  const theme = useTheme(); 

  return (
    <HeaderContainer>
      <TextSection>
        <TypographyText color={theme.palette.text.primary} fontSize={theme.typography.pxToRem(16)}>
          {mainText}
        </TypographyText>
        <TypographyText color={theme.palette.text.secondary} fontSize={theme.typography.pxToRem(14)}>
          {subText1}
        </TypographyText>
        <TypographyText color={theme.palette.text.secondary} fontSize={theme.typography.pxToRem(12)}>
          {subText2}
        </TypographyText>
      </TextSection>

      <DotsContainer>
        <Dot />
        <Dot />
        <Dot />
      </DotsContainer>
    </HeaderContainer>
  );
};
