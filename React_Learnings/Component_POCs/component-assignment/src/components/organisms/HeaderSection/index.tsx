import React from 'react';
import AvatarWithIcon from '../../molecules/AvatarWithIcon'; // Import AvatarWithIcon
import Heading from '../../atoms/Typography';
import AvatarImage from '../../../assets/icons/avatar.svg';
import ArrowBottomImage from '../../../assets/icons/arrow-bottom.svg';

export const HeaderSection: React.FC = () => (
  <div style={{
    width: '1060px',
    height: '71px',
    marginTop: '40px',
    marginLeft: '278px',
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',  // Center items vertically
    backgroundColor: 'black',
    position: 'absolute',  // Position it absolutely to stick to the top
    top: 0,  // Align to the top of the page
    left: 0,  // Align to the left of the page
    zIndex: 1  // Ensure it's above other content
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
          whiteSpace: 'nowrap' // Prevent text from wrapping
        }}
      >
        Cash Acceleration
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
        Place to create new cash kicks to run your business
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
        avatarSrc={AvatarImage}  // Pass the Avatar image source
        avatarAlt="User Avatar"
        avatarWidth="32px"
        avatarHeight="32px"
        iconSrc={ArrowBottomImage}  // Pass the Arrow Bottom image source
        iconAlt="Arrow Down Icon"
        iconWidth="16px"
        iconHeight="16px"
      /> {/* Use AvatarWithIcon with props */}
    </div>
  </div>
);

export default HeaderSection;
