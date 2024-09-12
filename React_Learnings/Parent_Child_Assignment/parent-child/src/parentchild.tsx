// import React, { useState } from 'react';

// // Child Component
// interface ChildProps {
//   parentData: string;
//   sendDataToParent: (childData: string) => void;
// }

// const Child: React.FC<ChildProps> = ({ parentData, sendDataToParent }) => {
//   const [childData, setChildData] = useState('Hello from Child');

//   // Function to send data back to the parent
//   const sendToParent = () => {
//     sendDataToParent(childData);
//   };

//   return (
//     <div>
//       <h2>Child Component</h2>
//       <p>Received from Parent: {parentData}</p>
//       <button onClick={sendToParent}>Send Data to Parent</button>
//     </div>
//   );
// };

// // Parent Component
// const AppPC: React.FC = () => {
//   const [parentData, setParentData] = useState('Hello from Parent');
//   const [dataFromChild, setDataFromChild] = useState('');

//   // Function to handle data from child
//   const handleChildData = (childData: string) => {
//     setDataFromChild(childData);
//   };

//   return (
//     <div>
//       <h1>Parent Component</h1>
//       <p>Data from Child: {dataFromChild}</p>

//       {/* Passing data and function as props to Child */}
//       <Child parentData={parentData} sendDataToParent={handleChildData} />
//     </div>
//   );
// };

// export default AppPC;
