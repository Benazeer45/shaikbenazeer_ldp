import React from 'react';

interface TextItemProps {
  imageSrc: string;
  text: string;
  isSeeder?: boolean;
  color?: string; // Add color prop
}

const TextItem: React.FC<TextItemProps> = ({ imageSrc, text, isSeeder, color }) => (
  <div style={{
    width: '210px',
    height: isSeeder ? '36px' : '49px',
    display: 'flex',
    alignItems: 'center',
    padding: isSeeder ? '2px 4px' : '0 12px',
    gap: isSeeder ? '8px' : '12px',
    fontFamily: isSeeder ? 'Gilroy-Bold' : 'inherit',
    fontWeight: isSeeder ? 700 : 600,
    fontSize: isSeeder ? '24px' : '14px',
    lineHeight: isSeeder ? '29.71px' : '14px',
    color: color || (isSeeder ? '#E8E7F0' : '#A5A5A6'), // Use color prop if provided
    textAlign: 'right',
  }}>
    <img
      src={imageSrc}
      alt={`${text} Icon`}
      style={{
        width: isSeeder ? '29.88px' : '24px',
        height: isSeeder ? '28px' : '24px'
      }}
    />
    <span style={{
      height: isSeeder ? '32px' : 'auto'
    }}>
      {text}
    </span>
  </div>
);

export default TextItem;
