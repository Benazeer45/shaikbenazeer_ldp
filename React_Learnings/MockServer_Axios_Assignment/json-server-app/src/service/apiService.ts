import axios from 'axios';
import { HTTP_STATUS } from '../constants/constants';
import axiosInstance from '.';

// Fetch all posts with error handling
export const fetchPosts = async () => {
  try {
    const response = await axiosInstance.get('/');
    return response.data;
  } catch (error) {
    handleAxiosError(error);
  }
};

// Create a new post with error handling
export const createPost = async (post: { title: string; views: number }) => {
  try {
    const response = await axiosInstance.post('/', post);
    return response.data;
  } catch (error) {
    handleAxiosError(error);
  }
};

// Update an existing post with error handling
export const updatePost = async (post: { id: string; title: string; views: number }) => {
  try {
    const response = await axiosInstance.put(`/${post.id}`, post);
    return response.data;
  } catch (error) {
    handleAxiosError(error);
  }
};

// Delete a post by ID with error handling
export const deletePost = async (id: string) => {
  try {
    await axiosInstance.delete(`/${id}`);
  } catch (error) {
    handleAxiosError(error);
  }
};

// Custom error handler for Axios requests
const handleAxiosError = (error: any) => {
  if (axios.isAxiosError(error)) {
    if (error.response) {
      const { status } = error.response;
      switch (status) {
        case HTTP_STATUS.NOT_FOUND:
          console.error('Error 404: The requested resource was not found.');
          break;
        case HTTP_STATUS.SERVER_ERROR:
          console.error('Error 500: Server error.');
          break;
        default:
          console.error(`Unexpected error: ${status} - ${error.response.data}`);
      }
    } else if (error.request) {
      console.error('No response received from the server.');
    } else {
      console.error('Error in setting up the request:', error.message);
    }
  } else {
    console.error('An unexpected error occurred:', error);
  }
};
