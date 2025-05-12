import useAuthors from "../data/authors";
import AuthorCard from "../components/authors/AuthorCard";
import { Button, Grid } from "@mui/material";
import AuthorDialog from "../components/authors/AuthorDialog";
import { useState } from "react";

export default function AuthorsPage() {
  const { authors, loading, onAdd, onEdit, onDelete } = useAuthors();

  const [isAddAuthorDialogOpen, setIsAddAuthorDialogOpen] = useState(false);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <>
      <h1>Authors</h1>

      <Button
        variant="contained"
        onClick={() => setIsAddAuthorDialogOpen(true)}
      >
        Add Author
      </Button>

      <Grid container spacing={2}>
        {authors.map((author) => (
          <Grid key={author.id} size={{ xs: 12, sm: 6, md: 4 }}>
            <AuthorCard author={author} onEdit={onEdit} onDelete={onDelete} />
          </Grid>
        ))}
      </Grid>

      <AuthorDialog
        open={isAddAuthorDialogOpen}
        onSubmit={onAdd}
        onClose={() => setIsAddAuthorDialogOpen(false)}
      />
    </>
  );
}
