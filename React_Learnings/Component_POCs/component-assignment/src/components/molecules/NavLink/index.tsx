import React from 'react';

interface NavLinkProps {
    text: string;
    active: boolean;
    icon: React.ReactNode;
    style?: React.CSSProperties;
    onClick?: () => void; // Add onClick prop
}

export const NavLink: React.FC<NavLinkProps> = ({ text, active, icon, style, onClick }) => {
    return (
        <button
            style={{
                ...style,
                backgroundColor: active ? '#3A3B3E' : 'transparent', // Background color for active state
                border: 'none',
                cursor: 'pointer',
                display: 'flex',
                alignItems: 'center',
                color: '#E8E7F0', // Font color for the text
            }}
            onClick={onClick} // Add onClick event handler
        >
            {icon}
            <span>{text}</span>
        </button>
    );
};
