import useAuthors from "../data/authors";
import AuthorCard from "../components/authors/AuthorCard";
import { Box, Button, Grid, Typography } from "@mui/material";
import AuthorDialog from "../components/authors/AuthorDialog";
import { useState } from "react";
import { Plus } from "lucide-react";

export default function AuthorsPage() {
  const { authors, loading, onAdd, onEdit, onDelete } = useAuthors();

  const [isAddAuthorDialogOpen, setIsAddAuthorDialogOpen] = useState(false);

  function handleAddClick() {
    setIsAddAuthorDialogOpen(true);
  }

  function handleCloseDialog() {
    setIsAddAuthorDialogOpen(false);
  }

  if (loading) {
    return <p>Loading...</p>;
  }

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
          Authors
        </Typography>

        <Button
          variant="contained"
          color="primary"
          startIcon={<Plus size={20} />}
          onClick={handleAddClick}
          sx={{ display: { xs: "none", sm: "flex" } }}
        >
          Add Author
        </Button>
      </Box>

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
        onClose={handleCloseDialog}
      />
    </>
  );
}
