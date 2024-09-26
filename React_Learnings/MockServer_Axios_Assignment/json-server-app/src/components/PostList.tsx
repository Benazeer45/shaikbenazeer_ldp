import React, { useState } from 'react';
import { Box, Stack, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button, TextField, Typography, Paper, TablePagination } from '@mui/material';

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

export const PostList: React.FC<PostListProps> = ({ posts = [], onEdit, onDelete }) => {
  const [searchQuery, setSearchQuery] = useState('');
  const [page, setPage] = useState(0); // Page index starts at 0 for TablePagination
  const [rowsPerPage, setRowsPerPage] = useState(5);

  const filteredPosts = posts?.filter(post =>
    post.title.toLowerCase().includes(searchQuery.toLowerCase())
  ) || [];

  const handleChangePage = (_event: unknown, newPage: number) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event: React.ChangeEvent<HTMLInputElement>) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0); // Reset page when rows per page changes
  };

  return (
    <Box padding={3}>
      <TextField
        fullWidth
        label="Search by title..."
        value={searchQuery}
        onChange={(e) => {
          setSearchQuery(e.target.value);
          setPage(0); // Reset page when searching
        }}
        variant="outlined"
        margin="normal"
      />

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Title</TableCell>
              <TableCell>Views</TableCell>
              <TableCell>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {filteredPosts.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).length > 0 ? (
              filteredPosts.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((post) => (
                <TableRow key={post.id}>
                  <TableCell>{post.title}</TableCell>
                  <TableCell>{post.views}</TableCell>
                  <TableCell>
                    <Stack direction="row" spacing={2}>
                      <Button variant="contained" color="primary" onClick={() => onEdit(post)}>
                        Edit
                      </Button>
                      <Button variant="contained" color="secondary" onClick={() => onDelete(post.id)}>
                        Delete
                      </Button>
                    </Stack>
                  </TableCell>
                </TableRow>
              ))
            ) : (
              <TableRow>
                <TableCell colSpan={3} align="center">
                  No posts found.
                </TableCell>
              </TableRow>
            )}
          </TableBody>
        </Table>
      </TableContainer>

      <TablePagination
        component="div"
        count={filteredPosts.length}
        page={page}
        onPageChange={handleChangePage}
        rowsPerPage={rowsPerPage}
        onRowsPerPageChange={handleChangeRowsPerPage}
      />
    </Box>
  );
};
