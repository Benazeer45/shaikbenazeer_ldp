import React from 'react';
import { styled, useTheme } from '@mui/material/styles';

interface IconProps {
  src: string; 
  width?: string;
  height?: string;
  alt?: string;
  paddingTop?: string;
}

const StyledIcon = styled('img')<{ width?: string; height?: string; paddingTop?: string }>(({ theme, width, height, paddingTop }) => ({
  width: width || theme.spacing(2.5),
  height: height || theme.spacing(2.5), 
  paddingTop: paddingTop || theme.spacing(0.5),
}));

export const Icon: React.FC<IconProps> = ({ src, width, height, alt = 'Icon', paddingTop }) => {
  const theme = useTheme(); // 

  return (
    <StyledIcon
      src={src}
      width={width || theme.spacing(2.5)} 
      height={height || theme.spacing(2.5)}
      alt={alt}
      paddingTop={paddingTop || theme.spacing(0.5)} 
    />
  );
};
