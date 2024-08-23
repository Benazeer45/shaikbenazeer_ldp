// Importing React to use JSX and create the functional component
import React from 'react';

// Importing a CSS file for styling (adjust the path if necessary)
import './styles.css';

// Defining the User interface to type-check user data
// 'name' is the name of the user
// 'imageUrl' is the URL for the user's profile image
// 'imageSize' is the size (width and height) of the profile image
interface User {
  name: string;
  imageUrl: string;
  imageSize: number;
}

// Creating a user object that adheres to the User interface
const user: User = {
  name: 'Hedy Lamarr', // User's name
  imageUrl: 'https://i.imgur.com/yXOvdOSs.jpg', // URL of the user's profile image
  imageSize: 90, // Size of the profile image in pixels
};

// Defining the Profile1 component
const Profile: React.FC = () => {
  return (
    <>
      {/* Displaying the user's name */}
      <h1>{user.name}</h1>

      {/* Displaying the user's profile image */}
      {/* The image's width and height are set to 'imageSize' */}
      <img
        className="avatar" // CSS class for styling the image
        src={user.imageUrl} // Source URL of the image
        alt={`Photo of ${user.name}`} // Alt text for accessibility
        style={{
          width: user.imageSize, // Setting the width of the image
          height: user.imageSize // Setting the height of the image
        }}
      />
    </>
  );
};

// Uncomment the following code if you want to use Profile2 instead

// const Profile2: React.FC = () => {
//   return (
//     <div>
//       {/* Heading for Profile2 component */}
//       <h3>Adding Styles</h3>
      
//       {/* Displaying another profile image with styling */}
//       <img className="avatar" src="https://i.natgeofe.com/k/520e971d-7a22-4a6f-90dc-258df74e45bc/american-goldfinch_3x2.jpg" alt="Profile" />
      
//       {/* Displaying a profile description with styling */}
//       <p className="description">This is a profile description.</p>
//     </div>
//   );
// };

export default Profile;
