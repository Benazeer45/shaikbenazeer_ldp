import React from "react";
import styled from "styled-components"; // You can keep this for any other styled components.
import { Icon } from "../../atoms/Icons";
import { Box, Typography } from "@mui/material"; // Importing Box and Typography from MUI

interface PortfolioSectionProps {
  title: string;
  iconSrc: string;
}

const SmallIcon = styled(Box)` // Keep SmallIcon styled-component for specific styles
  width: 18px;
  height: 17px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;

const Line = styled(Box)` // Keep Line styled-component for specific styles
  width: 100%;
  height: 2px;
  background-color: '#0052FF'; // Ensured color consistency with theme
`;

export const PortfolioSection: React.FC<PortfolioSectionProps> = ({ title, iconSrc }) => {
  return (
    <Box
      width="380px"
      display="flex"
      justifyContent="space-between"
      alignItems="center"
      padding="0px"
      margin="0 auto"
    >
      {/* Use different typography variants */}
      <Typography variant="h4" color="text.primary" width="95px"> {/* Header variant */}
        {title}
      </Typography>

      <Box display="flex" alignItems="center" justifyContent="center" gap="8px" marginLeft="90px">
        <Icon src={iconSrc} width="32px" height="32px" />
        <SmallIcon>
          <Line />
          <Line />
          <Line />
          <Line />
        </SmallIcon>
      </Box>
    </Box>
  );
};
