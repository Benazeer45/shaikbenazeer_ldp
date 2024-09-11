import React from 'react';
import AvatarWithIcon from '../../molecules/AvatarWithIcon';
import Heading from '../../atoms/Typography';

export interface HeaderSectionProps {
    mainHeading: string;
    subHeading: string;
    avatarSrc: string;
    avatarAlt: string;
    avatarWidth: string;
    avatarHeight: string;
    iconSrc: string;
    iconAlt: string;
    iconWidth: string;
    iconHeight: string;
}

const HeaderSection: React.FC<HeaderSectionProps> = ({
    mainHeading, 
    subHeading,
    avatarSrc,
    avatarAlt,
    avatarWidth,
    avatarHeight,
    iconSrc,
    iconAlt,
    iconWidth,
    iconHeight
}) => (
    <div style={{
        width: '1060px',
        height: '71px',
        marginTop: '40px',
        marginLeft: '278px',
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        backgroundColor: 'black',
        position: 'absolute',
        top: 0,
        left: 0,
        zIndex: 1
    }}>
        <div style={{
            width: '263px',
            display: 'flex',
            flexDirection: 'column',
            gap: '2px'
        }}>
            <Heading
                size="36px"
                weight={700}
                color="#E8E7F0"
                lineHeight="42px"
                style={{
                    width: '100%',
                    height: '42px',
                    fontFamily: 'Gilroy-Bold',
                    whiteSpace: 'nowrap'
                }}
            >
                {mainHeading}
            </Heading>
            <Heading
                size="18px"
                weight={500}
                color="#A5A5A6"
                lineHeight="27px"
                style={{
                    width: '420px',
                    height: '27px'
                }}
            >
                {subHeading}
            </Heading>
        </div>
        <div style={{
            width: '56px',
            height: '32px',
            display: 'flex',
            alignItems: 'center',
            gap: '8px'
        }}>
            <AvatarWithIcon 
                avatarSrc={avatarSrc}
                avatarAlt={avatarAlt}
                avatarWidth={avatarWidth}
                avatarHeight={avatarHeight}
                iconSrc={iconSrc}
                iconAlt={iconAlt}
                iconWidth={iconWidth}
                iconHeight={iconHeight}
            />
        </div>
    </div>
);

export default HeaderSection;
