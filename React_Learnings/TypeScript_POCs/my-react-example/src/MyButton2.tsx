// Importing React to use JSX and create the functional component
import React from 'react';

// Defining the props type for MyButton2 component
// 'count' is a number representing how many times the button has been clicked
// 'onClick' is a function to be called when the button is clicked
interface MyButtonProps {
  count: number;
  onClick: () => void;
}

// Defining the MyButton2 component and specifying its props type
const MyButton2: React.FC<MyButtonProps> = ({ count, onClick }) => {
  return (
    // Rendering a button element
    // The button displays how many times it has been clicked
    // The onClick handler is passed from the props
    <button onClick={onClick}>
      Clicked {count} times
    </button>
  );
};

// Exporting the MyButton2 component so it can be used in other parts of the application
export default MyButton2;
