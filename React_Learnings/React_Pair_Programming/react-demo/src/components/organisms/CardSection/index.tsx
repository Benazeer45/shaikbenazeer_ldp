// src/components/organisms/MainSection.tsx
import React from 'react';
import { styled, useTheme } from '@mui/material/styles';
import { IconsWithText } from '../../molecules/IconsWithText';
import { HeaderSection } from '../../molecules/HeaderSection';
import { Icon } from '../../atoms/Icon';
import { TypographyText } from '../../atoms/Typography';
import { jobData } from '../../../utils';

const SingleCardContainer = styled('div')(({ theme }) => ({
  width: theme.spacing(66.5),
  padding: theme.spacing(2),
  borderRadius: theme.shape.borderRadius,
  backgroundColor: theme.palette.background.paper,
  boxShadow: theme.shadows[2],
  display: 'flex',
  flexDirection: 'column',
  gap: theme.spacing(2),
}));

const ContentContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  alignItems: 'center',
  gap: theme.spacing(2),
}));

const LogoContainer = styled('div')(({ theme }) => ({
  width: theme.spacing(6.875),
  height: theme.spacing(6.875),
  position: 'relative',
  top: theme.spacing(-1.25),
}));

const IconsWithTextContainer = styled('div')(({ theme }) => ({
  paddingLeft: theme.spacing(8.125),
  paddingTop: theme.spacing(3.75),
  display: 'flex',
  alignItems: 'center',
}));

const timeTextStyles = {
  color: '#656E66', // Common color for all timeText
  fontWeight: 700,  // Common fontWeight for all timeText
};

interface JobData {
  heading: string;
  subheading: string;
  address: string;
  icons: string[];
  timeText: string;
}

const MainSection: React.FC = () => {
  const theme = useTheme();
  const logoSrc = '/assets/icons/Logo.svg'; // Logo source defined here
  const dotIconSrc = '/assets/icons/Dot.svg'; // Dot icon source defined here

  const handleDotClick = () => {
    // Handle the dropdown logic here
    console.log('Dot icon clicked');
  };

  return (
    <>
      {jobData.map((data: JobData, index: number) => (
        <SingleCardContainer key={`job-${index}`}>
          <ContentContainer>
            <LogoContainer>
              <Icon
                src={logoSrc}
                width={theme.spacing(6.875)}
                height={theme.spacing(6.875)}
                alt="Logo"
                onClick={() => {
                  throw new Error('Function not implemented.');
                }}
              />
            </LogoContainer>
            <HeaderSection
              mainText={
                <TypographyText
                  sx={{
                    fontSize: theme.typography.pxToRem(20),
                    fontWeight: 500,
                    lineHeight: theme.typography.pxToRem(30),
                    textAlign: 'left',
                    color: theme.palette.text.primary,
                    width: theme.spacing(33),
                    height: theme.typography.pxToRem(30),
                    opacity: 1,
                  }}
                >
                  {data.heading}
                </TypographyText>
              }
              subText1={
                <TypographyText
                  sx={{
                    fontSize: theme.typography.pxToRem(12),
                    fontWeight: 500,
                    lineHeight: theme.typography.pxToRem(16),
                    textAlign: 'left',
                    color: '#FF725E',
                    width: theme.spacing(5.5),
                    height: theme.typography.pxToRem(16),
                    opacity: 1,
                  }}
                >
                  {data.subheading}
                </TypographyText>
              }
              subText2={
                <TypographyText
                  sx={{
                    fontSize: theme.typography.pxToRem(11),
                    fontWeight: 500,
                    lineHeight: theme.typography.pxToRem(16),
                    textAlign: 'left',
                    color: theme.palette.text.secondary,
                    width: theme.spacing(24.25),
                    height: theme.typography.pxToRem(16),
                    opacity: 1,
                  }}
                >
                  {data.address}
                </TypographyText>
              }
              iconSrc={dotIconSrc} // Pass the Dot.svg icon source
              onIconClick={handleDotClick} // Pass the click handler
            />
          </ContentContainer>
          <IconsWithTextContainer>
            <IconsWithText
              icons={data.icons}
              text={data.timeText}
              textColor={timeTextStyles.color} // Use common timeTextColor
              fontWeight={timeTextStyles.fontWeight} // Use common timeTextFontWeight
            />
          </IconsWithTextContainer>
        </SingleCardContainer>
      ))}
    </>
  );
};

export default MainSection;
