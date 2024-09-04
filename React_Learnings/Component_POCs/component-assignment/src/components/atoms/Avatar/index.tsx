import React from 'react';

interface AvatarProps {
    src?: string;      // Source URL for the avatar image
    alt?: string;      // Alt text for accessibility
    width?: string;    // Width of the avatar
    height?: string;   // Height of the avatar
}

const Avatar: React.FC<AvatarProps> = ({ src, alt = 'Avatar', width = '32px', height = '32px' }) => {
    return (
        <img
            src={src}
            alt={alt}
            width={width}
            height={height}
            style={{
                borderRadius: '12px',
                backgroundColor: '#ccc'
            }}
        />
    );
};

export default Avatar;
