import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import type { AuthorDTO, UpdateAuthorDTO } from "../../api-client";
import { useState } from "react";
import AuthorDialog from "./AuthorDialog";

interface AuthorCardProps {
  author: AuthorDTO;
  onEdit?: (id: number, data: UpdateAuthorDTO) => void;
  onDelete?: (id: number) => void;
}

export default function AuthorCard({
  author,
  onEdit,
  onDelete,
}: AuthorCardProps) {
  const [isEditAuthorDialogOpen, setIsEditAuthorDialogOpen] = useState(false);

  return (
    <>
      <Card>
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {author.name} {author.surname}
          </Typography>
          <Typography variant="body2" sx={{ color: "text.secondary" }}>
            {author.country?.name}
          </Typography>
        </CardContent>
        <CardActions>
          <Button size="small" onClick={() => setIsEditAuthorDialogOpen(true)}>
            Edit
          </Button>
          <Button size="small" onClick={() => onDelete?.(author.id!)}>
            Delete
          </Button>
        </CardActions>
      </Card>

      {isEditAuthorDialogOpen && (
        <AuthorDialog
          open={isEditAuthorDialogOpen}
          author={author}
          onClose={() => setIsEditAuthorDialogOpen(false)}
          onSubmit={(data) => {
            onEdit?.(author.id!, data);
            setIsEditAuthorDialogOpen(false);
          }}
        />
      )}
    </>
  );
}
