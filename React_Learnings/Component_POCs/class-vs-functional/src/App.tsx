import React, { useState } from 'react';
import CounterClass from './components/CounterClass';
import CounterFunctional from './components/CounterFunctional';

const App: React.FC = () => {
  const [showClassCounter, setShowClassCounter] = useState<boolean>(true);
  const [showFunctionalCounter, setShowFunctionalCounter] = useState<boolean>(true);

  const toggleClassCounter = () => {
    setShowClassCounter((prevShow) => !prevShow);
  };

  const toggleFunctionalCounter = () => {
    setShowFunctionalCounter((prevShow) => !prevShow);
  };

  return (
    <div>
      <h1>Class Vs Functional</h1>

      <div>
      <h2>Class Component</h2>
        <button onClick={toggleClassCounter}>
          {showClassCounter ? 'Hide Class Counter' : 'Show Class Counter'}
        </button>
        {showClassCounter && (
          <>
            <CounterClass />
          </>
        )}
      </div>
      <br /><br />
      <div>
      <h2>Functional Component</h2>
        <button onClick={toggleFunctionalCounter}>
          {showFunctionalCounter ? 'Hide Functional Counter' : 'Show Functional Counter'}
        </button>
        {showFunctionalCounter && (
          <>
            <CounterFunctional />
          </>
        )}
      </div>
    </div>
  );
};

export default App;
