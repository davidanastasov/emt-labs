import useBooks from "../data/books";
import { Box, Button, CircularProgress, Typography } from "@mui/material";
import BookDialog from "../components/books/BookDialog";
import { useState } from "react";
import BooksTable from "../components/books/BooksTable";
import { Plus } from "lucide-react";
import type { CreateBookDTO, UpdateBookDTO } from "~/api-client";

export default function BooksPage() {
  const { books, loading, onAdd, onEdit, onDelete } = useBooks();

  const [isAddBookDialogOpen, setIsAddBookDialogOpen] = useState(false);
  const [selectedBookId, setSelectedBookId] = useState<number | null>(null);

  function handleAddClick() {
    setIsAddBookDialogOpen(true);
  }

  function handleEditClick(id: number) {
    setSelectedBookId(id);
    setIsAddBookDialogOpen(true);
  }

  function handleSubmit(data: CreateBookDTO | UpdateBookDTO) {
    if (selectedBookId) {
      onEdit(selectedBookId, data);
    } else {
      onAdd(data);
    }
    setIsAddBookDialogOpen(false);
    setSelectedBookId(null);
  }

  function handleCloseDialog() {
    setIsAddBookDialogOpen(false);
  }

  const selectedBook = books.find((book) => book.id === selectedBookId);

  return (
    <>
      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          mb: 4,
        }}
      >
        <Typography variant="h4" component="h1">
          Books
        </Typography>

        <Button
          variant="contained"
          color="primary"
          startIcon={<Plus size={20} />}
          onClick={handleAddClick}
          sx={{ display: { xs: "none", sm: "flex" } }}
        >
          Add Book
        </Button>
      </Box>

      {loading ? (
        <CircularProgress sx={{ display: "block", margin: "auto" }} />
      ) : (
        <BooksTable
          books={books}
          onEdit={handleEditClick}
          onDelete={onDelete}
        />
      )}

      <BookDialog
        open={isAddBookDialogOpen}
        book={selectedBook}
        onSubmit={handleSubmit}
        onClose={handleCloseDialog}
      />
    </>
  );
}
