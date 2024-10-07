import React from 'react';
import { styled, useTheme } from '@mui/material/styles';

interface IconProps{
    src:string;
    width?:string;
    height?:string;
    alt?:string;
}

const StyledIcon=styled('img')<{width?:string;height?:string}>(({theme,width,height})=>({
    width:width||theme.spacing(1),
    height:height||theme.spacing(1),
    cursor:'pointer',
}));

export const Icon: React.FC<IconProps>=({src,width,height,alt='Icon'})=>
{
    const theme=useTheme();
    return(
        <StyledIcon
        src={src}
        width={width||theme.spacing(1)}
        height={height||theme.spacing(1)}
        alt={alt}
        />
    );
};