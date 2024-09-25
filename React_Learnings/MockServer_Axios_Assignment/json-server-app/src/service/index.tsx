import axios from 'axios';

const API_URL = 'http://localhost:5000/posts';

// Fetch all posts with error handling
export const fetchPosts = async () => {
  try {
    const response = await axios.get(API_URL);
    return response.data; 
  } catch (error) {
    handleAxiosError(error); // Custom error handler
  }
};

// Create a new post with error handling
export const createPost = async (post: { title: string; views: number }) => {
  try {
    const response = await axios.post(API_URL, post, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return response.data;
  } catch (error) {
    handleAxiosError(error); // Custom error handler
  }
};

// Update an existing post with error handling
export const updatePost = async (post: { id: string; title: string; views: number }) => {
  try {
    const response = await axios.put(`${API_URL}/${post.id}`, post, {
      headers: {
        'Content-Type': 'application/json',
      },
    });
    return response.data; 
  } catch (error) {
    handleAxiosError(error); // Custom error handler
  }
};

// Delete a post by ID with error handling
export const deletePost = async (id: string) => {
  try {
    await axios.delete(`${API_URL}/${id}`);
  } catch (error) {
    handleAxiosError(error); // Custom error handler
  }
};

// Custom error handler for Axios requests
const handleAxiosError = (error: any) => {
  if (axios.isAxiosError(error)) {
    if (error.response) {
      // Server responded with a status other than 2xx
      console.error(`Error: ${error.response.status} - ${error.response.statusText}`);
      if (error.response.status === 404) {
        console.error('Error 404: The requested resource was not found.');
      } else if (error.response.status === 500) {
        console.error('Error 500: Server error.');
      } else {
        console.error(`Unexpected error: ${error.response.data}`);
      }
    } else if (error.request) {
      // Request was made but no response received
      console.error('No response received from the server.');
    } else {
      // Something went wrong setting up the request
      console.error('Error in setting up the request:', error.message);
    }
  } else {
    // Non-Axios error
    console.error('An unexpected error occurred:', error);
  }
};
