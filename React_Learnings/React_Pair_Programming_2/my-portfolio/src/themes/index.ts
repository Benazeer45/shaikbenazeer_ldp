import { createTheme } from '@mui/material/styles';

const theme = createTheme({
  palette: {
    primary: {
      main: '#0052FF', 
    },
    secondary: {
      main: '#B4B4CF', 
    },
    text: {
      primary: '#343446', 
      secondary: '#7D7D89', 
    },
    background: {
      default: '#f0f0f0',
      paper: '#ffffff',  
    },
  },
  typography: {
    fontFamily: '"Roboto", "Helvetica", "Arial", sans-serif',
    fontSize: 14, 
    h1: {
      fontSize: '2rem',
      fontWeight: 500,
      lineHeight: '2.5rem',
    },
    body1: {
      fontSize: '1rem',
      fontWeight: 400,
      lineHeight: '1.5rem',
    },
  },
  spacing: 8, 
});

export default theme;
