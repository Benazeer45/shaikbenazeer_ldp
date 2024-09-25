import React, { useState } from 'react';
import styled from 'styled-components';

interface Post {
  id: string;
  title: string;
  views: number;
}

interface PostListProps {
  posts: Post[];
  onEdit: (post: Post) => void;
  onDelete: (id: string) => void;
}

const PostList: React.FC<PostListProps> = ({ posts, onEdit, onDelete }) => {
  const [currentPage, setCurrentPage] = useState(1);
  const [searchQuery, setSearchQuery] = useState('');
  const postsPerPage = 5;

  const filteredPosts = posts.filter(post =>
    post.title.toLowerCase().includes(searchQuery.toLowerCase())
  );

  const totalPages = Math.ceil(filteredPosts.length / postsPerPage);

  const indexOfLastPost = currentPage * postsPerPage;
  const indexOfFirstPost = indexOfLastPost - postsPerPage;
  const currentPosts = filteredPosts.slice(indexOfFirstPost, indexOfLastPost);

  const handleNextPage = () => {
    if (currentPage < totalPages) {
      setCurrentPage(currentPage + 1);
    }
  };

  const handlePreviousPage = () => {
    if (currentPage > 1) {
      setCurrentPage(currentPage - 1);
    }
  };

  return (
    <Container>
      <SearchInput
        type="text"
        placeholder="Search by title..."
        value={searchQuery}
        onChange={(e) => {
          setSearchQuery(e.target.value);
          setCurrentPage(1); 
        }}
      />

      <Table>
        <thead>
          <TableRow>
            <TableHeader>Title</TableHeader>
            <TableHeader>Views</TableHeader>
            <TableHeader>Actions</TableHeader>
          </TableRow>
        </thead>
        <tbody>
          {currentPosts.length > 0 ? (
            currentPosts.map((post) => (
              <TableRow key={post.id}>
                <TableCell>{post.title}</TableCell>
                <TableCell>{post.views}</TableCell>
                <TableCell>
                  <ActionButton onClick={() => onEdit(post)}>Edit</ActionButton>
                  <ActionButton onClick={() => onDelete(post.id)}>Delete</ActionButton>
                </TableCell>
              </TableRow>
            ))
          ) : (
            <TableRow>
              <TableCell colSpan={3}>No posts found.</TableCell>
            </TableRow>
          )}
        </tbody>
      </Table>

      {/* Pagination Controls */}
      <Pagination>
        <PageButton onClick={handlePreviousPage} disabled={currentPage === 1}>
          Previous
        </PageButton>
        <PageInfo>
          Page {currentPage} of {totalPages}
        </PageInfo>
        <PageButton onClick={handleNextPage} disabled={currentPage === totalPages}>
          Next
        </PageButton>
      </Pagination>
    </Container>
  );
};

const Container = styled.div`
  padding: 20px;
`;

const SearchInput = styled.input`
  padding: 10px;
  margin-bottom: 20px;
  width: 70%;
  border: 1px solid #ccc;
  border-radius: 4px;
`;

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
`;

const TableRow = styled.tr`
  border-bottom: 1px solid #ddd;
`;

const TableHeader = styled.th`
  padding: 12px;
  text-align: left;
  background-color: #f4f4f4;
`;

const TableCell = styled.td`
  padding: 12px;
`;

const ActionButton = styled.button`
  margin-right: 10px;
  padding: 8px 12px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;

  &:hover {
    background-color: #0056b3;
  }

  &:disabled {
    background-color: #c0c0c0;
    cursor: not-allowed;
  }
`;

const Pagination = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 10px;
`;

const PageButton = styled.button`
  padding: 8px 12px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;

  &:hover {
    background-color: #0056b3;
  }

  &:disabled {
    background-color: #c0c0c0;
    cursor: not-allowed;
  }
`;

const PageInfo = styled.span`
  margin: 0 10px;
`;

export default PostList;
