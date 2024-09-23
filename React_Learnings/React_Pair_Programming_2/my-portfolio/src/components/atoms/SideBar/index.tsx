import React from "react";
import styled from "styled-components";

const CustomAtom = styled.div`
  height: 170px;  
  border: 3px solid #B4B4CF;  
  border-radius: 8px;
  transform: rotate(0deg); 
`;

export const SideBar: React.FC = () => {
  return <CustomAtom />;
};
