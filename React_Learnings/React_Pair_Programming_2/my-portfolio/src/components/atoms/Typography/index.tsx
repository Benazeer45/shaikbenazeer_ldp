import React from 'react';
import { CSSObject, styled } from '@mui/material/styles';


interface TypographyTextProps{
    fontSize?:string;
    fontWeight?:number;
    lineHeight?:string;
    textAlign?:'left'|'right'|'center'|'justify';
    color?:string;
    width?:string;
    height?:string;
    children:React.ReactNode;
}

const StyledTypography=styled('div')<TypographyTextProps>(({theme,fontSize,fontWeight,lineHeight,textAlign,color,width,height})=>{
    const style:CSSObject={
        fontSize:fontSize || 'inherit',
        fontWeight: fontWeight || 'inherit',
        lineHeight: lineHeight || 'inherit',
        textAlign: textAlign || 'inherit',
        color: color || theme.palette.text.primary,
        width: width || 'auto',
        height: height || 'auto'
        
    };
    return style;
});


export const TypographyText: React.FC<TypographyTextProps>=({children,...props})=>
{
    return <StyledTypography {...props}>{children}</StyledTypography>;
};