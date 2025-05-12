import useBooks from "../data/books";
import BookCard from "../components/books/BookCard";
import { Button, Grid } from "@mui/material";
import BookDialog from "../components/books/BookDialog";
import { useState } from "react";

export default function BooksPage() {
  const { books, loading, onAdd, onEdit, onDelete } = useBooks();

  const [isAddBookDialogOpen, setIsAddBookDialogOpen] = useState(false);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <>
      <h1>Books</h1>

      <Button variant="contained" onClick={() => setIsAddBookDialogOpen(true)}>
        Add Book
      </Button>

      <Grid container spacing={2}>
        {books.map((book) => (
          <Grid key={book.id} size={{ xs: 12, sm: 6, md: 4 }}>
            <BookCard book={book} onEdit={onEdit} onDelete={onDelete} />
          </Grid>
        ))}
      </Grid>

      <BookDialog
        open={isAddBookDialogOpen}
        onSubmit={onAdd}
        onClose={() => setIsAddBookDialogOpen(false)}
      />
    </>
  );
}
