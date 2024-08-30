import React from 'react';

interface IInputProps {
  value: string;
  onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
  placeholder?: string;
}

const Input: React.FC<IInputProps> = ({ value, onChange, placeholder }) => {
  return <input type="text" value={value} onChange={onChange} placeholder={placeholder} />;
};

export default Input;
