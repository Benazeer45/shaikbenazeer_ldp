import React from "react";
import styled from "styled-components";
import { Divider } from "../../atoms/Divider";
import { Box, Typography } from "@mui/material"; // Importing Box and Typography from MUI

interface BalanceSectionProps {
  title: string;
  value: string;
}

const DividerWrapper = styled(Box)` // Use Box instead of styled.div
  margin: 15px 0;
`;

export const BalanceSection: React.FC<BalanceSectionProps> = ({ title, value }) => {
  return (
    <Box display="flex" flexDirection="column" alignItems="center" width="100%"> {/* Using Box for the container */}
      <DividerWrapper>
        <Divider />
      </DividerWrapper>

      <Box display="flex" alignItems="center" width="380px" padding="8px 24px" gap="200px"> {/* Using Box for balance content */}
        <Typography variant="body1" color="text.secondary"> 
          {title}
        </Typography>
        <Typography variant="body1" color="text.primary">
          {value}
        </Typography>
      </Box>

      <DividerWrapper>
        <Divider />
      </DividerWrapper>
    </Box>
  );
};
