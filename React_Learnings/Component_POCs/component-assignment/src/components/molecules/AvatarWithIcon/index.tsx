import React from 'react';

interface AvatarWithIconProps {
    avatarSrc: string;         // Source URL for the avatar image
    avatarAlt?: string;        // Optional alt text for the avatar
    avatarWidth?: string;      // Optional width for the avatar
    avatarHeight?: string;     // Optional height for the avatar
    iconSrc: string;           // Source URL for the icon image
    iconAlt?: string;          // Optional alt text for the icon
    iconWidth?: string;        // Optional width for the icon
    iconHeight?: string;       // Optional height for the icon
}

const AvatarWithIcon: React.FC<AvatarWithIconProps> = ({
    avatarSrc,
    avatarAlt = 'Avatar',
    avatarWidth = '32px',
    avatarHeight = '32px',
    iconSrc,
    iconAlt = 'Icon',
    iconWidth = '16px',
    iconHeight = '16px'
}) => {
    return (
        <div style={{
            display: 'flex',
            alignItems: 'center',
            gap: '8px',
            width: '56px',
            height: '32px',
            paddingLeft: '100px' // Add left padding
        }}>
            <img
                src={avatarSrc}
                alt={avatarAlt}
                width={avatarWidth}
                height={avatarHeight}
                style={{
                    borderRadius: '12px',
                }}
            />
            <img
                src={iconSrc}
                alt={iconAlt}
                width={iconWidth}
                height={iconHeight}
            />
        </div>
    );
};

export default AvatarWithIcon;
