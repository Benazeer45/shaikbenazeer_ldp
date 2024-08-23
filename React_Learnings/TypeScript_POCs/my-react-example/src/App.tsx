import React from 'react';
import logo from './logo.svg';
import './App.css';

// Importing all the components to be rendered
import MyApp from './MyApp';
import Profile from './Profile';
import ShoppingList from './ShoppingList';
import EventExamples from './EventExamples';
import Counter from './Counter';
import Count from './Count';
import Sharing from './Sharing';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* Displaying the logo */}
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
         Learn React
        </a>
      </header>
      <main>
        {/* Rendering all the components inside the App */}
        <MyApp />
        <Profile />
        <ShoppingList />
        <EventExamples />
        <Counter />
        <Count />
        <Sharing />
      </main>
    </div>
  );
}

export default App;
