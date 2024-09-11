import React from 'react';
import TextItem from '../../molecules/TextItem'; // Ensure the correct import path
import NavLink from '../../molecules/NavLink'; // Ensure the correct import path

export interface SeederInputProps {
    seeder: string;
    menuItems: string[];
    watchHowTos: string[];
}

const SeederInput: React.FC<SeederInputProps> = ({ seeder, menuItems, watchHowTos }) => {
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
                <TextItem 
                  imageSrc={`${process.env.PUBLIC_URL}/assets/icons/icon1.svg`} 
                  text={seeder} 
                  isSeeder={true} 
                />
                <div style={{ marginTop: '40px', display: 'flex', flexDirection: 'column', gap: '16px' }}>
                    {menuItems.map((item, index) => (
                        <TextItem 
                          key={index}
                          imageSrc={`${process.env.PUBLIC_URL}/assets/icons/home-2.svg`} 
                          text={item} 
                        />
                    ))}
                    <NavLink 
                      text="Cash Acceleration" 
                      active={true}
                      icon={<img src={`${process.env.PUBLIC_URL}/assets/icons/coin.svg`} alt="Cash Acceleration Icon" style={{ width: '24px', height: '24px' }} />}
                    /> 
                </div>
            </div>
            <div>
                {watchHowTos.map((howTo, index) => (
                    <TextItem 
                      key={index}
                      imageSrc={`${process.env.PUBLIC_URL}/assets/icons/flash.svg`} 
                      text={howTo} 
                    />
                ))}
            </div>
        </div>
    );
};

export default SeederInput;
