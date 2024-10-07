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
    h2: {
      fontSize: '1.5rem',
      fontWeight: 500,
      lineHeight: '2rem',
    },
    h3: {
      fontSize: '1.25rem',
      fontWeight: 500,
      lineHeight: '1.75rem',
    },
    h4: {
      fontSize: '1.125rem',
      fontWeight: 500,
      lineHeight: '1.5rem',
    },
    body1: {
      fontSize: '1rem', 
      fontWeight: 400,
      lineHeight: '1.5rem',
    },
    body2: {
      fontSize: '0.875rem', 
      lineHeight: '1.25rem',
    },
    caption: {
      fontSize: '0.75rem',
      fontWeight: 400,
      lineHeight: '1rem',
      color: '#7D7D89', 
    },
    button: {
      fontSize: '1rem',
      fontWeight: 500,
      textTransform: 'none', 
    },
  },
  spacing: 8,
});

export default theme;
