import React from "react";
import styled from "styled-components";
import { Box } from "@mui/material";

const CustomAtom = styled(Box)`
  height: 170px;  
  border: 3px solid #B4B4CF;  
  border-radius: 8px;
  transform: rotate(0deg); 
`;

export const SideBar: React.FC = () => {
  return <CustomAtom />;
};
