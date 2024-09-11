import React from 'react';
import Heading from '../../atoms/Typography';
import Button from '../../atoms/Button';

export interface FormattedSectionProps {
    heading: string;
    subheading: string;
    availableAmount: string;
    buttonText: string;
}

const FormattedSection: React.FC<FormattedSectionProps> = ({ heading, subheading, availableAmount, buttonText }) => (
    <div style={{
        width: '300px',
        height: '200px',
        borderRadius: '12px',
        border: '1px solid #28272B',
        padding: '32px',
        gap: '20px',
        fontFamily: 'Gilroy-Bold',
        backgroundColor: '#201F24',
        position: 'absolute',
        top: '150px',
        left: '1070px',
    }}>
        <Heading 
            size="24px"
            weight={600}
            color="#E8E7F0"
            lineHeight="29.4px"
            style={{
                fontFamily: 'Gilroy-Bold',
                width: '276px',
                height: '58px',
            }}
        >
            <div style={{ lineHeight: '29.4px' }}>
                {heading}<br/>
                <span style={{ fontWeight: 600 }}>
                    {subheading}
                </span>
            </div>
        </Heading>
        <br/>
        <div style={{
            width: '276px',
            height: '44px',
            display: 'flex',
            flexDirection: 'column',
            gap: '12px',
        }}>
            <Heading 
                size="16px"
                weight={500}
                color="#E8E7F0"
                lineHeight="22.4px"
                style={{
                    fontFamily: 'Gilroy, sans-serif',
                }}
            >
                You have up to <span style={{ fontWeight: 700 }}>${availableAmount.toLocaleString()}</span> available for a new cash advance
            </Heading>
        </div>
        <br/>
        <Button 
            text={buttonText}
            style={{
                width: '276px',
                height: '58px',
                fontFamily: 'Gilroy-Bold',
                borderRadius: '10px',
                fontWeight: 600,
                fontSize: '16px',
                lineHeight: '19px',
                backgroundColor: '#6C5DD3',
                color: '#FFFFFF',
            }}
        />
    </div>
);

export default FormattedSection;
