// Importing React library to create components
import React from 'react';

// Importing a logo image and CSS file for styling
import logo from './logo.svg';
import './App.css';

// Defining the main App component
function App() {
  // The component returns the UI structure to be rendered
  return (
    <div className="App">
      {/* Header section of the app */}
      <header className="App-header">
        {/* Displaying the logo image */}
        <img src={logo} className="App-logo" alt="logo" />
        
        {/* Displaying a paragraph with instructions */}
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>

        {/* A link that redirects to the React official website */}
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

// Exporting the App component so it can be used in other parts of the application
export default App;

// The following is commented-out code for an alternative App component
// import React from 'react';

// Defining a simple button component named MyButton
// const MyButton: React.FC = () => {
//   return (
//     <button>
//       I'm a button
//     </button>
//   );
// };

// Defining an alternative App component that includes the MyButton component
// const App: React.FC = () => {
//   return (
//     <div>
//       <h1>Welcome to my app</h1>
//       <MyButton />
//     </div>
//   );
// };

// Exporting the alternative App component
// export default App;
