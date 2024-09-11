import React from 'react';

interface IconProps {
    src: string;  // Source of the icon image
    width?: string;  // Optional width
    height?: string; // Optional height
    alt: string;    // Optional alt text for accessibility
}

const Icons: React.FC<IconProps> = ({ src, width = "16px", height = "16px", alt = "Icon" }) => {
    return <img src={src} width={width} height={height} alt={alt} />;
};

export default Icons;
