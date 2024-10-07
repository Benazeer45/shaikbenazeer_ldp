import React from "react";
import { styled } from "@mui/material/styles";
import { Box } from "@mui/material"; 

interface LayoutTemplateProps{
    children: React.ReactNode;
}

const CenteredWrapper = styled(Box)({
    display: 'flex',
    justifyContent: 'center',  
    alignItems: 'center',      
    minHeight: '100vh',        
    backgroundColor: '#f0f0f0',
});

const LayoutContainer = styled(Box)(({ theme }) => ({
    width: '420px',
    height: '330px',
    display: 'flex',
    flexDirection: 'column',
    gap: theme.spacing(1.5),
    padding: theme.spacing(2),
    backgroundColor: '#ffffff',
    border: '2px solid #E0E0E0', 
}));

export const LayoutTemplate: React.FC<LayoutTemplateProps> = ({ children }) => {
    return (
        <CenteredWrapper>
            <LayoutContainer>{children}</LayoutContainer>
        </CenteredWrapper>
    );
};
