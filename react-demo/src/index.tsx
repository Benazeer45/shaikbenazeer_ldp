// Importing StrictMode from React to help highlight potential issues in the application
import { StrictMode } from "react";

// Importing createRoot from React DOM to create a root for rendering the React application
import { createRoot } from "react-dom/client";

// Importing the main App component that will be rendered
import App from "./App";

// Getting the root DOM element by its ID ('root') where the React app will be mounted
const rootElement = document.getElementById("root");

// Checking if the root DOM element exists
if (rootElement) {
  // Creating a React root to render the app
  const root = createRoot(rootElement);

  // Rendering the App component inside the StrictMode component
  // StrictMode doesn't render any visible UI; it only activates additional checks and warnings for its children
  root.render(
    <StrictMode>
      <App />
    </StrictMode>
  );
}
