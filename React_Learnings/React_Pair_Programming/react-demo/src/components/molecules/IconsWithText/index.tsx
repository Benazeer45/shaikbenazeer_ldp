import React from 'react';
import { styled, useTheme } from '@mui/material/styles';
import { Icon } from '../../atoms/Icon';
import { TypographyText } from '../../atoms/Typography';

const Container = styled('div')(({ theme }) => ({
  display: 'flex',
  justifyContent: 'space-between',
  alignItems: 'center',
  width: theme.spacing(58),
  height: theme.spacing(3),
}));

const IconContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  gap: theme.spacing(2.5),
}));

interface IconWithTextProps {
  icons: string[];
  text: string;
  textColor?: string; // Add an optional color prop
  fontWeight?: number; // Add an optional fontWeight prop
}

export const IconsWithText: React.FC<IconWithTextProps> = ({ icons, text, textColor, fontWeight }) => {
  const theme = useTheme();

  return (
    <Container>
      <IconContainer>
        {icons.map((icon, index) => (
          <Icon key={index} src={icon} alt={`Icon ${index}`} width={theme.spacing(3)} height={theme.spacing(3)} />
        ))}
      </IconContainer>
      <TypographyText color={textColor || theme.palette.text.primary} fontSize={theme.typography.pxToRem(14)} fontWeight={fontWeight || 400}>
        {text}
      </TypographyText>
    </Container>
  );
};
