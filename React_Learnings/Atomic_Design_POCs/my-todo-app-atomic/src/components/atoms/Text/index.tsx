import React from 'react';

interface TextProps {
  type: 'heading' | 'paragraph';
  content: string;
}

const Text: React.FC<TextProps> = ({ type, content }) => {
  return (
    <>
      {type === 'heading' ? (
        <h2>{content}</h2>
      ) : (
        <p>{content}</p>
      )}
    </>
  );
};

export default Text;
