// Importing React to use JSX and create the functional component
import React from 'react';

// Importing the MyButton1 component to use within this component
import MyButton1 from './MyButton1';

// Defining the MyApp component
const MyApp: React.FunctionComponent = () => {
  return (
    <div>
      {/* Displaying a welcome message */}
      <h1>Welcome to my app</h1>
      
      {/* Rendering the MyButton1 component */}
      <MyButton1 />
    </div>
  );
};

// Exporting the MyApp component so it can be used in other parts of the application
export default MyApp;
