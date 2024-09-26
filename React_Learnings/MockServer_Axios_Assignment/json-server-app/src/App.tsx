import React, { useEffect, useState } from 'react';
import styled from 'styled-components'; 
import PostForm from './components/PostForm';
import { fetchPosts, createPost, updatePost, deletePost } from './service/apiService';
import { PostList } from './components/PostList';

interface Post {
  id: string; 
  title: string;
  views: number;
}

interface PostCreate {
  title: string;
  views: number;
}

interface PostUpdate extends PostCreate {
  id: string;
}

const App: React.FC = () => {
  const [posts, setPosts] = useState<Post[]>([]);
  const [editingPost, setEditingPost] = useState<PostUpdate | null>(null);

  useEffect(() => {
    const loadPosts = async () => {
      const data = await fetchPosts();
      setPosts(data);
    };

    loadPosts();
  }, []);

  const handleCreatePost = async (post: PostCreate | PostUpdate) => {
    const newPost = await createPost(post);
    setPosts((prev) => [...prev, newPost]);
  };

  const handleUpdatePost = async (post: PostCreate | PostUpdate) => {
    if ('id' in post) { 
      const updatedPost = await updatePost(post);
      setPosts((prev) => prev.map((p) => (p.id === post.id ? updatedPost : p)));
      setEditingPost(null);
    }
  };

  const handleDeletePost = async (id: string) => {
    await deletePost(id);
    setPosts((prev) => prev.filter((post) => post.id !== id));
  };

  return (
    <Container>
      <Title>Posts</Title>
      <PostForm
        onSubmit={editingPost ? handleUpdatePost : handleCreatePost}
        initialPost={editingPost || null}
      />
      <PostList posts={posts} onEdit={setEditingPost} onDelete={handleDeletePost} />
    </Container>
  );
};

const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 60%;
  margin: 0 auto; 
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  background-color: #f9f9f9;
`;

const Title = styled.h1`
  margin-bottom: 20px;
  color: #333;
`;

export default App;
