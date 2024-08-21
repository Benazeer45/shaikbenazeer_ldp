// Importing the useState hook from React to manage state in the component
import { useState } from "react";

// Importing the stylesheet for the component
import "./styles.css";

// Defining a 2D array called 'content' that contains different sections of information
const content: string[][] = [
  // First section: Reasons why React is popular
  [
    "React is extremely popular",
    "It makes building complex, interactive UIs a breeze",
    "It's powerful & flexible",
    "It has a very active and versatile ecosystem"
  ],
  // Second section: Core features of React
  [
    "Components, JSX & Props",
    "State",
    "Hooks (e.g., useEffect())",
    "Dynamic rendering"
  ],
  // Third section: Related resources for learning and using React
  [
    "Official web page (react.dev)",
    "Next.js (Fullstack framework)",
    "React Native (build native mobile apps with React)"
  ],
  // Fourth section: Comparison between React and Vanilla JavaScript
  [
    "Vanilla JavaScript requires imperative programming",
    "Imperative Programming: You define all the steps needed to achieve a result",
    "React on the other hand embraces declarative programming",
    "With React, you define the goal and React figures out how to get there"
  ]
];

// Defining the main App component
export default function App() {
  // Using the useState hook to manage the index of the active content section
  // 'activeContentIndex' is the current index, and 'setActiveContentIndex' is the function to update it
  const [activeContentIndex, setActiveContentIndex] = useState<number>(0);

  return (
    <div>
      {/* Header section with React logo and a brief description */}
      <header>
        <img src="logo192.png" alt="React logo" />
        <div>
          <h1>React.js</h1>
          <p>i.e., using the React library for rendering the UI</p>
        </div>
      </header>

      {/* Main section containing tabs and content */}
      <div id="tabs">
        <menu>
          {/* Button to display "Why React?" section */}
          <button
            className={activeContentIndex === 0 ? "active" : ""}
            onClick={() => setActiveContentIndex(0)}
          >
            Why React?
          </button>
          {/* Button to display "Core Features" section */}
          <button
            className={activeContentIndex === 1 ? "active" : ""}
            onClick={() => setActiveContentIndex(1)}
          >
            Core Features
          </button>
          {/* Button to display "Related Resources" section */}
          <button
            className={activeContentIndex === 2 ? "active" : ""}
            onClick={() => setActiveContentIndex(2)}
          >
            Related Resources
          </button>
          {/* Button to display "React vs JS" section */}
          <button
            className={activeContentIndex === 3 ? "active" : ""}
            onClick={() => setActiveContentIndex(3)}
          >
            React vs JS
          </button>
        </menu>
        {/* Displaying the content of the active tab */}
        <div id="tab-content">
          <ul>
            {/* Mapping over the selected content array to generate list items */}
            {content[activeContentIndex].map((item) => (
              <li key={item}>{item}</li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}
