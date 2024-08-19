// Importing React for building user interfaces
import React from 'react';

// Importing ReactDOM to render the React component tree to the DOM
import ReactDOM from 'react-dom/client';

// Importing the main CSS file for styling the application
import './index.css';

// Importing various React components to be rendered in the application
import App from './App';
import MyApp from './MyApp';
import Profile from './Profile';
import Jsx from './JSX';
import ShoppingList from './ShoppingList';
import EventExamples from './EventExamples';
import Counter from './Counter';
import Count from './Count';
import Sharing from './Sharing';

// Importing a function to measure and report web app performance metrics
import reportWebVitals from './reportWebVitals';

// Creating the root element where the React application will be mounted
const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement // The root element in the HTML file (usually a div with id 'root')
);

// Rendering the React component tree inside the root element
root.render(
  // React.StrictMode is a wrapper to highlight potential problems in an application during development
  <React.StrictMode>
    {/* Rendering multiple components in the application */}
    <MyApp />
    <Profile />
    <Jsx />
    <ShoppingList />
    <EventExamples />
    <Counter />
    <Count />
    <Sharing />
    <br /> {/* Adding a line break in the rendered output */}
    <App /> {/* Rendering the App component */}
  </React.StrictMode>
);

// Measuring performance of the app by logging results or sending them to an analytics endpoint
// This is optional and helps in tracking performance issues
reportWebVitals();
