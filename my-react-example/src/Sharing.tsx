// Importing React and the useState hook for managing state in functional components
import React, { useState } from 'react';

// Importing the MyButton2 component to be used in this component
import MyButton2 from './MyButton2'; 

// Defining the Sharing component
const Sharing: React.FC = () => {
  // Creating a state variable 'count' with an initial value of 0
  // 'setCount' is a function to update the 'count' value
  const [count, setCount] = useState<number>(0);

  // Function to handle button clicks and increment the count
  const handleClick = () => {
    setCount(count + 1);
  };

  return (
    <div>
      {/* Displaying a header for the Sharing component */}
      <h1>Counters that update together</h1>

      {/* Rendering two MyButton2 components */}
      {/* Both buttons share the same 'count' state and 'handleClick' function */}
      {/* Clicking either button will increment the same 'count' value */}
      <MyButton2 count={count} onClick={handleClick} />
      <MyButton2 count={count} onClick={handleClick} />
    </div>
  );
};

// Exporting the Sharing component so it can be used in other parts of the application
export default Sharing;
