import React, { useState, useEffect } from 'react';

const CounterFunctional: React.FC = () => {
  const [count, setCount] = useState<number>(0);
  const [incrementClicks, setIncrementClicks] = useState<number>(0);

  // Effect that runs only when `count` changes
  useEffect(() => {
    console.log(`Increment button clicked ${incrementClicks} times`);
  }, [count]); // Runs on updates to `count`

  const increment = () => {
    setCount((prevCount) => prevCount + 1);
    setIncrementClicks((prevClicks) => prevClicks + 1);
  };


  return (
    <div>
      <h3>Count: {count}</h3>
      <button onClick={increment}>Increment</button>
    </div>
  );
};

export default CounterFunctional;
