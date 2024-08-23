// Importing React and the useState hook, which allows us to use state in this functional component
import React, { useState } from 'react';

// Defining a functional component named Count
const Count: React.FC = () => {
  // Using the useState hook to create a state variable called 'count' and a function 'setCount' to update it.
  // The initial value of 'count' is set to 0. The type of 'count' is number.
  const [count, setCount] = useState<number>(0);

  // Function to increase the 'count' by 1
  const increment = () => setCount(count + 1);

  // Function to decrease the 'count' by 1
  const decrement = () => setCount(count - 1);

  // Returning JSX to render the UI
  return (
    <div>
      {/* Displaying the current value of 'count' inside an h1 element */}
      <h1>Count: {count}</h1>

      {/* A button that calls the 'increment' function when clicked */}
      <button onClick={increment}>Increment</button>

      {/* A button that calls the 'decrement' function when clicked */}
      <button onClick={decrement}>Decrement</button>
    </div>
  );
};

// Exporting the Count component so it can be used in other parts of the application
export default Count;
