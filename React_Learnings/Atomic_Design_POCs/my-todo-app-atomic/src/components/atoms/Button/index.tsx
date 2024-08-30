import React from 'react';

interface IButtonProps {
  onClick: () => void;
  children: React.ReactNode;
}

const Button: React.FC<IButtonProps> = ({ onClick, children }) => {
  return <button onClick={onClick}>{children}</button>;
};

export default Button;
