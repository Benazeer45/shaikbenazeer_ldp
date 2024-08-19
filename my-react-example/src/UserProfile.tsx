// Importing React to use JSX and create the functional component
import React from 'react';

// Defining the props type for the UserProfile component
// 'isLoggedIn' is a boolean that determines whether the user is logged in
interface UserProfileProps {
  isLoggedIn: boolean; // This prop is required
}

// Defining a component to render the Admin Panel
const AdminPanel: React.FC = () => <div>Admin Panel</div>;

// Defining a component to render the Login Form
const LoginForm: React.FC = () => <div>Login Form</div>;

// Defining the UserProfile component and specifying its props type
const UserProfile: React.FC<UserProfileProps> = (props) => {
  // Destructuring 'isLoggedIn' from props
  const { isLoggedIn } = props;

  return (
    <div>
      {/* Conditionally rendering AdminPanel or LoginForm based on 'isLoggedIn' */}
      {isLoggedIn ? <AdminPanel /> : <LoginForm />}
    </div>
  );
};

// Exporting the UserProfile component so it can be used in other parts of the application
export default UserProfile;
