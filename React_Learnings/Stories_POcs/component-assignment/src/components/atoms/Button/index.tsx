import React from 'react';

interface ButtonProps {
  text: string; // Text to be displayed on the button
  onClick?: () => void; // Optional click handler
  style?: React.CSSProperties; // Optional custom style
}

const Button: React.FC<ButtonProps> = ({ text, onClick, style }) => (
  <button 
    onClick={onClick}
    style={{
      width: 'auto', // Allow width to be dynamic based on content
      height: 'auto', // Allow height to be dynamic based on content
      whiteSpace: 'nowrap', // Prevent text from wrapping
      overflow: 'hidden', // Hide overflow text if necessary
      textOverflow: 'ellipsis', // Add ellipsis if text is too long
      borderRadius: '4px', // You can adjust the radius if needed
      backgroundColor: '#E8E8E8', // Primary color
      color: '#000', // Button text color
      fontFamily: 'Gilroy',
      fontWeight: 600,
      fontSize: '16px',
      lineHeight: '19px',
      textAlign: 'center',
      border: 'none',
      cursor: 'pointer',
      ...style // Apply any additional custom styles
    }}
  >
    {text}
  </button>
);

export default Button;
