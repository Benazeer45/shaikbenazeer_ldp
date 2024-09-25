import React from 'react';
import { MainTemplate } from '../../components/templates/MainTemplate';

export const HomePage: React.FC = () => {
    return (
        <div style={{ backgroundColor: 'black', minHeight: '100vh', margin: 0 }}>
            <MainTemplate />
        </div>
    );
};
