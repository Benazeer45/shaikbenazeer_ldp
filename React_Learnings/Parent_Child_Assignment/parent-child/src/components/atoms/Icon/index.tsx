// src/components/atoms/Icon.tsx
import React from 'react';

interface IconProps {
  src: string;
  width: string;
  height: string;
  onClick?: () => void; // Add onClick prop
}

export const Icon: React.FC<IconProps> = ({ src, width, height, onClick }) => {
  return (
    <img
      src={src}
      width={width}
      height={height}
      alt="icon"
      onClick={onClick} // Attach onClick handler
      style={{ cursor: 'pointer' }} // Optional: Change cursor to pointer
    />
  );
};
