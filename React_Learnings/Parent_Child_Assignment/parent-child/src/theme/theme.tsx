import { createTheme } from '@mui/material/styles';

// Create a theme instance
const theme = createTheme({
  palette: {
    primary: {
      main: '#6C5DD3', // Primary color
    },
    secondary: {
      main: '#fefef9', // Secondary color
    },
    grey: {
      600: '#585664', // Define the grey colors you need
    },
    action: {
      disabledOpacity: 0.56, // Define the disabled opacity
    },
  },
  typography: {
    button: {
      fontSize: '16px',
      lineHeight: '19px',
    },
  },
});

export default theme;
