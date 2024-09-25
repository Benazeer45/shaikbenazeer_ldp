import React, { useState, useEffect } from 'react';
import styled from 'styled-components';

interface PostCreate {
  title: string;
  views: number;
}

interface PostUpdate extends PostCreate {
  id: string;
}

interface PostFormProps {
  onSubmit: (post: PostCreate | PostUpdate) => Promise<void>; 
  initialPost?: PostUpdate | null; 
}

const FormContainer = styled.div`
  margin: 20px;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  background-color: #f9f9f9;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
`;

const InputField = styled.input`
  display: block;
  width: 95%;
  margin: 10px 0;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;

  &:focus {
    border-color: #007bff;
    outline: none;
  }
`;

const SubmitButton = styled.button`
  background-color: #007bff;
  color: white;
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;

  &:hover {
    background-color: #0056b3;
  }
`;

const PostForm: React.FC<PostFormProps> = ({ onSubmit, initialPost }) => {
  const [title, setTitle] = useState(initialPost ? initialPost.title : '');
  const [views, setViews] = useState(initialPost ? initialPost.views : '');

  useEffect(() => {
    if (initialPost) {
      setTitle(initialPost.title);
      setViews(initialPost.views);
    } else {
      setTitle('');
      setViews('');
    }
  }, [initialPost]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    const postToSubmit: PostCreate | PostUpdate = {
      title,
      views: Number(views),
      ...(initialPost ? { id: initialPost.id } : {}),
    };

    await onSubmit(postToSubmit);
    setTitle('');
    setViews('');
  };

  return (
    <FormContainer>
      <form onSubmit={handleSubmit}>
        <InputField
          type="text"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="Post Title"
          required
        />
        <InputField
          type="number"
          value={views === '' ? '' : views} 
          onChange={(e) => setViews(e.target.value)} 
          placeholder="Views"
          required
        />
        <SubmitButton type="submit">Submit</SubmitButton>
      </form>
    </FormContainer>
  );
};

export default PostForm;
