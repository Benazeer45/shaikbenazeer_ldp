// Function that takes a callback function and two numbers
function applyOperation(math_operation, num1, num2) {
    return math_operation(num1, num2);
  }
  // Function to add two numbers
  function add(a, b) {
    return a + b;
  }
  // Function to multiply two numbers
  function multiply(a, b) {
    return a * b;
  }
  // Using the applyOperation function with the add callback
  const sum = applyOperation(add, 5, 3);
  console.log(`Sum: ${sum}`); // Output: Sum: 8
  // Using the applyOperation function with the multiply callback
  const product = applyOperation(multiply, 5, 3);
  console.log(`Product: ${product}`); // Output: Product: 15


// function greetUser(greetingFunction, name) {
//     console.log(greetingFunction(name));
// }
// function sayHello(name) {
//     return `Hello, ${name}!`;
// }
// greetUser(sayHello, 'Alice'); // Output: Hello, Alice!


//-----------------------------------------------------------------------------------------------------------------------------------
  
//const getInitials = (firstName, lastName) => firstName[0] + lastName[0];

const getInitials = (firstName, lastName) => {
    return `${firstName[0]}${lastName[0]}`;

    //  return firstName.charAt(0) + lastName.charAt(0);

  };
 console.log(getInitials("Roger", "Waters")); // Output: 'RW'
  