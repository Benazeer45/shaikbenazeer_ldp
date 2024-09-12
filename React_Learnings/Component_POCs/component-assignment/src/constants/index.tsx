// src/components/organisms/CashKickCard/constants.ts
export const CARD_STYLES = {
  width: '300px',
  height: '200px',
  borderRadius: '12px',
  border: '1px solid #28272B',
  padding: '32px',
  gap: '20px',
  fontFamily: 'Gilroy-Bold',
  backgroundColor: '#201F24',
  position: 'absolute' as const, // To avoid type error for position
  top: '150px',
  left: '1070px',
};

export const HEADING_STYLES = {
  fontFamily: 'Gilroy-Bold',
  width: '276px',
  height: '58px',
  lineHeight: '29.4px',
};

export const SUBTEXT_STYLES = {
  width: '276px',
  height: '44px',
  display: 'flex',
  flexDirection: 'column' as const, // Type for flexDirection
  gap: '12px',
};

export const BUTTON_STYLES = {
  width: '276px',
  height: '58px',
  fontFamily: 'Gilroy-Bold',
  borderRadius: '10px',
  fontWeight: 600,
  fontSize: '16px',
  lineHeight: '19px',
  backgroundColor: '#6C5DD3',
  color: '#FFFFFF',
};

// src/constants.ts

export const ICONS = {
    CALENDAR: require('../assets/icons/calendar.svg').default,
    DOCUMENT_DOWNLOAD: require('../assets/icons/document-download.svg').default,
    PERCENTAGE_SQUARE: require('../assets/icons/percentage-square.svg').default,
    FRAME: require('../assets/icons/Frame 1000004272.svg').default,
    HOME: require('../assets/icons/home-2.svg').default,
    SEEDER: require('../assets/icons/icon1.svg').default,
    WATCH_HOW_TO: require('../assets/icons/flash.svg').default,
    CASH_ACCELERATION: require('../assets/icons/coin.svg').default,
    AVATAR: require('../assets/icons/avatar.svg').default,
    ARROW_BOTTOM: require('../assets/icons/arrow-bottom.svg').default,
  };
  
  export const TEXT = {
    TERM_CAP: 'Term Cap',
    AVAILABLE_CREDIT: 'Available credit',
    MAX_INTEREST_RATE: 'Max interest rate',
    SEEDER: 'Seeder',
    HOME: 'Home',
    CASH_ACCELERATION: 'Cash Acceleration',
    WATCH_HOW_TO: 'Watch How To',
    TERM_CAP_SUBTITLE: '12 months',
    AVAILABLE_CREDIT_SUBTITLE: '$880.0k',
    MAX_INTEREST_RATE_SUBTITLE: '12.00%',
    PLACE_TO_CREATE_CASH_KICKS: 'Place to create cash kicks', // Add this line
  };
  