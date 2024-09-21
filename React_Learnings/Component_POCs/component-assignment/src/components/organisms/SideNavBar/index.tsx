import React from 'react';
import { NavLink } from '../../molecules/NavLink';
import { ICONS, TEXT } from '../../../constants';

const TextItem: React.FC<{ imageSrc: string; text: string; isSeeder?: boolean }> = ({ imageSrc, text, isSeeder }) => (
  <div style={{
    width: '210px',
    height: '49px',
    gap: '12px',
    display: 'flex',
    alignItems: 'center',
    padding: '0 12px',
    fontFamily: 'Gilroy-Bold',
    fontWeight: isSeeder ? 700 : 600,
    fontSize: isSeeder ? '24px' : '14px',
    lineHeight: isSeeder ? '29.71px' : '14px',
    color: isSeeder ? '#E8E7F0' : '#A5A5A6',
    textAlign: 'right',
  }}>
    <img src={imageSrc} alt={`${text} Icon`} style={{ width: '24px', height: '24px' }} />
    {text}
  </div>
);

const NavLinkItem: React.FC<{ imageSrc: string; text: string; onClick: () => void }> = ({ imageSrc, text, onClick }) => (
  <NavLink
    text={text}
    active={true}
    icon={<img src={imageSrc} alt={`${text} Icon`} style={{ width: '24px', height: '24px' }} />}
    style={{
      width: '210px',
      height: '49px',
      borderRadius: '12px',
      gap: '12px',
      backgroundColor: '#D4D2D3',
      color: '#A5A5A6',
      fontSize: '14px',
      fontWeight: 600,
      lineHeight: '14px',
      letterSpacing: '0.01em',
      textAlign: 'right',
      display: 'flex',
      alignItems: 'center',
      fontFamily: 'Gilroy-Bold',
    }}
    onClick={onClick}
  />
);

export const SideNavBar: React.FC = () => {
  // Define a single click handler function
  const handleItemClick = (itemName: string) => {
    switch (itemName) {
      case TEXT.CASH_ACCELERATION:
        console.log(`${TEXT.CASH_ACCELERATION} clicked`);
        // Handle specific action for CASH_ACCELERATION
        break;
      case TEXT.HOME:
        console.log(`${TEXT.HOME} clicked`);
        // Handle specific action for HOME
        break;
      case TEXT.WATCH_HOW_TO:
        console.log(`${TEXT.WATCH_HOW_TO} clicked`);
        // Handle specific action for WATCH_HOW_TO
        break;
      default:
        console.log(`Unknown item clicked: ${itemName}`);
        break;
    }
  };

  // Define nav items in an array
  const navItems = [
    { id: '1', imageSrc: ICONS.HOME, text: TEXT.HOME, isNavLink: false },
    { id: '2', imageSrc: ICONS.CASH_ACCELERATION, text: TEXT.CASH_ACCELERATION, isNavLink: true },
    { id: '3', imageSrc: ICONS.WATCH_HOW_TO, text: TEXT.WATCH_HOW_TO, isNavLink: false }
  ];

  return (
    <div style={{
      width: '200px',
      height: '768px',
      borderTop: '0px',
      borderRight: '1px solid #222124',
      borderBottom: '0px',
      borderLeft: '0px',
      padding: '25px 20px 20px 25px',
      gap: '40px',
      backgroundColor: '#201F24',
      boxShadow: '1px 1px 0px rgba(0, 0, 0, 0.1)',
      display: 'flex',
      flexDirection: 'column',
      justifyContent: 'space-between'
    }}>
      <div>
        {/* Seeder TextItem */}
        <TextItem imageSrc={ICONS.SEEDER} text={TEXT.SEEDER} isSeeder={true} />

        {/* Dynamically render the other items */}
        <div style={{ marginTop: '40px', display: 'flex', flexDirection: 'column', gap: '16px' }}>
          {navItems.map((item) => (
            item.isNavLink ? (
              <NavLinkItem
                key={item.id} // Using unique id as key
                imageSrc={item.imageSrc}
                text={item.text}
                onClick={() => handleItemClick(item.text)} // Pass the item name to the handler
              />
            ) : (
              <TextItem
                key={item.id} // Using unique id as key
                imageSrc={item.imageSrc}
                text={item.text}
              />
            )
          ))}
        </div>
      </div>
    </div>
  );
};
