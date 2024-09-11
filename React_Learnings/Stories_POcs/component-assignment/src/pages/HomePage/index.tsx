// src/components/templates/MainTemplate/index.tsx
import React from 'react';
import SeederInput, { SeederInputProps } from '../../components/organisms/SideNavBar';
import HeaderSection, { HeaderSectionProps } from '../../components/organisms/HeaderSection';
import DisplayData, { DisplayDataProps } from '../../components/organisms/CardInfo';
import FormattedSection, { FormattedSectionProps } from '../../components/organisms/FormattedSection';

const HomePage: React.FC = () => {
    // Sample props data
    const seederInputProps: SeederInputProps = {
        seeder: "Seeder",
        menuItems: ["Home"],
        watchHowTos: ["Watch how to"]
    };

    const headerSectionProps: HeaderSectionProps = {
        mainHeading: "Cash acceleration",
        subHeading: "Place to create new cash kicks to run your business",
        avatarSrc: `${process.env.PUBLIC_URL}/assets/icons/avatar.svg`,
        avatarAlt: "User Avatar",
        avatarWidth: "40px",
        avatarHeight: "40px",
        iconSrc: `${process.env.PUBLIC_URL}/assets/icons/arrow-bottom.svg`,
        iconAlt: "Settings Icon",
        iconWidth: "24px",
        iconHeight: "24px"
    };

    const displayDataProps: DisplayDataProps = {
        blocks: [
            { id: 1, title: "Block 1", content: "Content 1", iconUrl: `${process.env.PUBLIC_URL}/assets/icons/calendar.svg` },
            { id: 2, title: "Block 2", content: "Content 2", iconUrl: `${process.env.PUBLIC_URL}/assets/icons/document-download.svg` },
            { id: 3, title: "Block 3", content: "Content 1", iconUrl: `${process.env.PUBLIC_URL}/assets/icons/percentage-square.svg` }
        ]
    };

    const formattedSectionProps: FormattedSectionProps = {
        heading: "Launch a new",
        subheading: "Cash Kick",
        availableAmount: "880000.00",
        buttonText: "Apply Now"
    };

    // Apply a black background color to the entire body
    React.useEffect(() => {
        document.body.style.backgroundColor = 'black';
        return () => {
            document.body.style.backgroundColor = ''; // Reset to default on unmount
        };
    }, []);

    return (
        <div style={{
            display: 'flex',
            flexDirection: 'row',
            minHeight: '100vh',
            color: 'white',
            width: '100vw'
        }}>
            <SeederInput {...seederInputProps} />
            <div style={{ flex: 1, padding: '20px' }}>
                <HeaderSection {...headerSectionProps} />
                <DisplayData {...displayDataProps} />
                <FormattedSection {...formattedSectionProps} />
            </div>
        </div>
    );
};

export default HomePage;
