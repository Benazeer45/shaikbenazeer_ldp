// Importing React to use JSX and create the functional component
import React from 'react';

// Defining the Product interface to type-check product data
// 'title' is the name of the product
// 'isFruit' is a boolean indicating if the product is a fruit
// 'id' is a unique identifier for the product
interface Product {
  title: string;
  isFruit: boolean;
  id: number;
}

// Creating an array of products that adheres to the Product interface
const products: Product[] = [
  { title: 'Cabbage', isFruit: false, id: 1 },
  { title: 'Garlic', isFruit: false, id: 2 },
  { title: 'Apple', isFruit: true, id: 3 },
];

// Defining the ShoppingList component
const ShoppingList: React.FC = () => {
  // Mapping over the products array to create list items
  // Each item is styled based on whether the product is a fruit
  const listItems = products.map(product => (
    <li
      key={product.id} // Unique key for each list item
      style={{
        // Changing text color based on whether the product is a fruit
        color: product.isFruit ? 'magenta' : 'darkgreen'
      }}
    >
      {product.title} {/* Displaying the product title */}
    </li>
  ));

  return (
    // Rendering an unordered list with the generated list items
    <ul>{listItems}</ul>
  );
};

// Exporting the ShoppingList component so it can be used in other parts of the application
export default ShoppingList;
