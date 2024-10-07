import React from "react";
import { LayoutTemplate } from "../../components/templates/MainTemplate";
import { MainSection } from "../../components/organisms/MainSection";

export const HomePage: React.FC=()=>{
    return (
        <LayoutTemplate>
            <MainSection/>
        </LayoutTemplate>
    );
};