// Importing React and the useState hook for managing state in functional components
import React, { useState } from 'react';

// Define the MyButton component
const MyButton: React.FC = () => {
  // Declare a state variable 'count' with an initial value of 0
  // 'setCount' is used to update the 'count' value
  const [count, setCount] = useState<number>(0);

  // Function to handle button clicks and increment the count
  function handleClick() {
    setCount(count + 1);
  }

  return (
    // Button element that displays how many times it has been clicked
    // Calls handleClick when the button is clicked
    <button onClick={handleClick}>
      Clicked {count} times
    </button>
  );
};

// Define the main Counter component that uses two MyButton components
const Counter: React.FC = () => {
  return (
    <div>
      {/* A header for the Counter component */}
      <h1>Counters that update separately</h1>
      
      {/* Two instances of MyButton, each with its own independent state */}
      <MyButton />
      <MyButton />
    </div>
  );
};

// Export the Counter component so it can be used in other parts of the application
export default Counter;
