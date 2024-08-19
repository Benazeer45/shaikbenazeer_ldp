// Importing React to use JSX and create the functional component
import React from 'react';

// Defining the Jsx component
const Jsx: React.FC = () => {
  return (
    <>
      {/* A header element displaying "About" */}
      <h1>About</h1>
      
      {/* A paragraph with a line break */}
      <p>
        Hello there.<br /> {/* Line break in the text */}
        How do you do?
      </p>
    </>
  );
};

// Exporting the Jsx component so it can be used in other parts of the application
export default Jsx;
