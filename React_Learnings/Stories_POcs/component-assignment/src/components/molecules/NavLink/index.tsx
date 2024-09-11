import React from 'react';

export interface NavLinkProps {
    text: string;
    active: boolean;
    icon: React.ReactNode;
    style?: React.CSSProperties;
}

const NavLink: React.FC<NavLinkProps> = ({ text, active, icon, style }) => {
    return (
        <button style={{
            ...style,
            backgroundColor: active ? '#2D2D30' : 'transparent', // Background color for active state
            border: 'none',
            cursor: 'pointer',
            display: 'flex',
            alignItems: 'center',
            color: '#E8E7F0', // Font color for the text
            width: '210px',
            height: '49px',
            borderRadius: '12px',
            gap: '12px',
            fontSize: '14px',
            fontWeight: 600,
            lineHeight: '14px',
            letterSpacing: '0.01em',
            textAlign: 'right',
            fontFamily: 'Gilroy-Bold', // Apply Gilroy-Bold font
        }}>
            {icon}
            <span>{text}</span>
        </button>
    );
};

export default NavLink;
