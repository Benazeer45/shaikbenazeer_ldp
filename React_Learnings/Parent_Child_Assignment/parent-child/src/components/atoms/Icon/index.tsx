// src/components/atoms/Icon.tsx
import React from 'react';
import { styled } from '@mui/material/styles';

interface IconProps {
  src: string; // Path to the SVG file
  width?: string;
  height?: string;
  alt?: string;
  paddingTop?: string; // New prop for top padding
}

const StyledIcon = styled('img')<{ width?: string; height?: string; paddingTop?: string }>(({ theme, width, height, paddingTop }) => ({
  width: width || theme.spacing(2.5), // Default width from theme spacing
  height: height || theme.spacing(2.5), // Default height from theme spacing
  paddingTop: paddingTop || theme.spacing(0.5), // Default top padding (added here)
  opacity: 1, // Example opacity
}));

export const Icon: React.FC<IconProps> = ({ src, width, height, alt = 'Icon', paddingTop }) => {
  return <StyledIcon src={src} width={width} height={height} alt={alt} paddingTop={paddingTop} />;
};
