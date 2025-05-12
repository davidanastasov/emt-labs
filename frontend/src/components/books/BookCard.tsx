import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import type { BookDTO, UpdateBookDTO } from "../../api-client";
import { useState } from "react";
import BookDialog from "./BookDialog";

interface BookCardProps {
  book: BookDTO;
  onEdit?: (id: number, data: UpdateBookDTO) => void;
  onDelete?: (id: number) => void;
}

export default function BookCard({ book, onEdit, onDelete }: BookCardProps) {
  const [isEditBookDialogOpen, setIsEditBookDialogOpen] = useState(false);

  return (
    <>
      <Card>
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {book.name}
          </Typography>
          <Typography variant="body2" sx={{ color: "text.secondary" }}>
            {book.category}
          </Typography>
          <Typography variant="body2" sx={{ color: "text.secondary" }}>
            Author: {book.author?.name} {book.author?.surname}
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="small" onClick={() => setIsEditBookDialogOpen(true)}>
            Edit
          </Button>
          <Button size="small" onClick={() => onDelete?.(book.id!)}>
            Delete
          </Button>
        </CardActions>
      </Card>

      {isEditBookDialogOpen && (
        <BookDialog
          open={isEditBookDialogOpen}
          book={book}
          onClose={() => setIsEditBookDialogOpen(false)}
          onSubmit={(data) => {
            onEdit?.(book.id!, data);
            setIsEditBookDialogOpen(false);
          }}
        />
      )}
    </>
  );
}
