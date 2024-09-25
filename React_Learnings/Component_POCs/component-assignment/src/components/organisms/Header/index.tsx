// src/components/Header.tsx
import React from 'react';
import AvatarWithIcon from '../../molecules/AvatarWithIcon';
import Heading from '../../atoms/Typography';
import { ICONS, TEXT } from '../../../constants';

const Header: React.FC = () => (
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
        {TEXT.CASH_ACCELERATION}
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
        {TEXT.PLACE_TO_CREATE_CASH_KICKS}
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
        avatarSrc={ICONS.AVATAR}
        avatarAlt="User Avatar"
        avatarWidth="32px"
        avatarHeight="32px"
        iconSrc={ICONS.ARROW_BOTTOM}
        iconAlt="Arrow Down Icon"
        iconWidth="16px"
        iconHeight="16px"
      />
    </div>
  </div>
);

export default Header;
