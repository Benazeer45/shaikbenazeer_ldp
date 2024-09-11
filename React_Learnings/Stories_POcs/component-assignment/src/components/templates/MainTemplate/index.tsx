import React from 'react';

// Define props interface
export interface MainTemplateProps {
    seederInputProps?: any; // Adjust type based on actual prop types
    headerSectionProps?: any; // Adjust type based on actual prop types
    displayDataProps?: any; // Adjust type based on actual prop types
    formattedSectionProps?: any; // Adjust type based on actual prop types
}

// Define the MainTemplate component
const MainTemplate: React.FC<MainTemplateProps> = ({ }) => {
    return (
        <div style={{
            display: 'flex',
            width: '100vw',
            height: '115.5vh',
            backgroundColor: 'black',
            position: 'absolute'
        }}>
            {/* Placeholder for SideNavBar */}
            <div style={{
                position: 'absolute',
                width: '200px',
                height: '100%',
                backgroundColor: '#201F24',
                borderRight: '1px solid #222124',
            }}>
                {/* Placeholder for SeederInput component */}
                {/* <SeederInput {...seederInputProps} /> */}
            </div>

            {/* Main Content */}
            <div style={{
                marginLeft: '200px',
                width: 'calc(100% - 200px)',
                padding: '20px',
                display: 'flex',
                flexDirection: 'column',
                gap: '20px'
            }}>
                {/* Placeholder for HeaderSection component */}
                {/* <HeaderSection {...headerSectionProps} /> */}

                {/* Content Section */}
                <div style={{
                    display: 'flex',
                    marginTop: '130px',
                    marginLeft: '54px'
                }}>
                    {/* Placeholder for DisplayData component */}
                    <div style={{ flex: 1 }}>
                        {/* <DisplayData {...displayDataProps} /> */}
                    </div>

                    {/* Placeholder for FormattedSection component */}
                    <div style={{ flex: 1 }}>
                        {/* <FormattedSection {...formattedSectionProps} /> */}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default MainTemplate;
