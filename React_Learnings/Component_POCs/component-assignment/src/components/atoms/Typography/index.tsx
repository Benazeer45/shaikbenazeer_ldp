import React from 'react';

interface HeadingProps {
  children: React.ReactNode; // Content to be displayed
  size: string; // Font size
  weight: number; // Font weight
  color: string; // Font color
  lineHeight: string; // Line height
  style?: React.CSSProperties; // Optional additional styles
}

const Heading: React.FC<HeadingProps> = ({ children, size, weight, color, lineHeight, style }) => (
  <div
    style={{
      fontSize: size,
      fontWeight: weight,
      color: color,
      lineHeight: lineHeight,
      ...style,
    }}
  >
    {children}
  </div>
);

export default Heading;
