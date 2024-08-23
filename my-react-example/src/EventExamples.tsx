// Importing React and the useState hook for managing state in functional components
import React, { useState } from 'react';

// Define the EventExamples component
const EventExamples: React.FC = () => {
  // State to keep track of input field value
  const [inputValue, setInputValue] = useState('');

  // State to keep track of form data
  const [formData, setFormData] = useState('');

  // Function to handle button clicks
  function handleClick() {
    alert('Button clicked!');
  }

  // Function to handle changes in the input field
  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    // Update the inputValue state with the new input
    setInputValue(event.target.value);
  }

  // Function to handle form submission
  function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    // Prevent the default form submission behavior (like page reload)
    event.preventDefault();
    // Show an alert with the form data
    alert(`Form submitted with data: ${formData}`);
  }

  // Function to handle mouse hovering over the paragraph
  function handleMouseOver() {
    console.log('Mouse is over the text!');
  }

  return (
    <div>
      {/* Button with a click event listener */}
      <button onClick={handleClick}>
        Click me
      </button><br/>

      {/* Input field with a change event listener */}
      <div>
        <input
          type="text"
          value={inputValue} // The value of the input field
          onChange={handleChange} // Updates inputValue when the input changes
          placeholder="Type something" // Placeholder text
        />
        {/* Displaying the current value of the input */}
        Current Input: {inputValue}
      </div>

      {/* Form with a submit event listener */}
      <form onSubmit={handleSubmit}>
        {/* Input field for form data */}
        <input
          type="text"
          value={formData} // The value of the form input field
          onChange={e => setFormData(e.target.value)} // Updates formData when the input changes
          placeholder="Enter form data" // Placeholder text
        />
        {/* Submit button */}
        <button type="submit">Submit</button>
      </form>

      {/* Paragraph with a mouse over event listener */}
      <p onMouseOver={handleMouseOver}>
        {/* Instructions for the user */}
        Hover over this text to see a message in the console.
      </p>
    </div>
  );
};

// Exporting the EventExamples component so it can be used in other parts of the application
export default EventExamples;
