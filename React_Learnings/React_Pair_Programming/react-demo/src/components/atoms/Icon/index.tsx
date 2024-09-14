import React from 'react';
import { styled, useTheme } from '@mui/material/styles';

interface IconProps {
  src: string; 
  width?: string;
  height?: string;
  alt?: string;
  paddingTop?: string;
  onClick: () => void; // Add onClick prop
}

const StyledIcon = styled('img')<{ width?: string; height?: string; paddingTop?: string }>(({ theme, width, height, paddingTop }) => ({
  width: width || theme.spacing(2.5),
  height: height || theme.spacing(2.5), 
  paddingTop: paddingTop || theme.spacing(0.5),
  cursor: 'pointer', // Change cursor to pointer to indicate clickable area
}));

export const Icon: React.FC<IconProps> = ({ src, width, height, alt = 'Icon', paddingTop, onClick }) => {
  const theme = useTheme();

  return (
    <StyledIcon
      src={src}
      width={width || theme.spacing(2.5)} 
      height={height || theme.spacing(2.5)}
      alt={alt}
      paddingTop={paddingTop || theme.spacing(0.5)} 
      onClick={onClick} // Pass the onClick handler
    />
  );
};
