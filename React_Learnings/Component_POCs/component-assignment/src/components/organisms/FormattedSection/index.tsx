// src/components/organisms/FormattedSection/index.tsx
import React from 'react';
import Heading from '../../atoms/Typography'; // Import Heading
import Button from '../../atoms/Button'; // Import Button

const FormattedSection: React.FC = () => (
  <div style={{
    width: '300px',
    height: '200px',
    borderRadius: '12px',
    border: '1px solid #28272B',
    padding: '32px',
    gap: '20px',
    fontFamily: 'Gilroy-Bold', // Apply Gilroy Bold font
    backgroundColor: '#201F24',
    position: 'absolute',
    top: '150px',
    left: '1070px',
  }}>
    <Heading 
      size="24px"
      weight={600} // Font weight for Heading 2
      color="#E8E7F0" // High emphasis color
      lineHeight="29.4px"
      style={{
        fontFamily: 'Gilroy-Bold',
        width: '276px',
        height: '58px',
      }}
    >
      <div style={{ lineHeight: '29.4px' }}> {/* Ensure proper line height */}
        Launch a new<br/>
        <span style={{ fontWeight: 600 }}> {/* Optional: Ensure bold text */}
          Cash Kick
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
        weight={500} // Default copy weight
        color="#E8E7F0"
        lineHeight="22.4px"
        style={{
          fontFamily: 'Gilroy, sans-serif', // Non-bold font for text
        }}
      >
        You have up to <span style={{ fontWeight: 700 }}>$880,000.00</span> available for a new cash advance
      </Heading>
    </div>
    <br/>
    <Button 
      text="New Cash Kick"
      style={{
        width: '276px',
        height: '58px',
        fontFamily: 'Gilroy-Bold',
        borderRadius: '10px',
        fontWeight: 600, // Font weight for button text
        fontSize: '16px',
        lineHeight: '19px',
        backgroundColor: '#6C5DD3', // Ensure button color matches if needed
        color: '#FFFFFF', // Button text color, adjust if needed
      }}
    />
  </div>
);

export default FormattedSection;
