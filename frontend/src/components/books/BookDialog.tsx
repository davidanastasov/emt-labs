import { useEffect, useState, type ChangeEvent } from "react";
import {
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  TextField,
} from "@mui/material";
import useAuthors from "../../data/authors";
import {
  CreateBookDTOCategoryEnum,
  type BookDTO,
  type CreateBookDTO,
} from "../../api-client";

const initialFormData: CreateBookDTO = {
  name: "",
  category: undefined,
  authorId: undefined,
  availableCopies: 0,
};

interface BookDialogProps {
  open: boolean;
  book?: BookDTO;
  onClose: () => void;
  onSubmit: (data: typeof initialFormData) => void;
}

export default function BookDialog({
  open,
  book,
  onClose,
  onSubmit,
}: BookDialogProps) {
  const isEditing = !!book;
  const { authors } = useAuthors();

  const [formData, setFormData] = useState<CreateBookDTO>(initialFormData);

  useEffect(() => {
    if (book) {
      setFormData({
        name: book.name,
        category: book.category,
        authorId: book.author?.id,
        availableCopies: book.availableCopies,
      });
    }
  }, [book]);

  const handleChange = (event: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = () => {
    onSubmit(formData);
    setFormData(initialFormData);
    onClose();
  };

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>{isEditing ? "Update Book" : "Add Book"}</DialogTitle>
      <DialogContent>
        <TextField
          margin="dense"
          label="Name"
          name="name"
          value={formData.name}
          onChange={handleChange}
          fullWidth
        />

        <FormControl fullWidth margin="dense">
          <InputLabel>Category</InputLabel>
          <Select
            name="category"
            value={formData.category}
            onChange={handleChange}
            label="Category"
            variant="outlined"
          >
            {Object.values(CreateBookDTOCategoryEnum).map((category) => (
              <MenuItem key={category} value={category}>
                {category}
              </MenuItem>
            ))}
          </Select>
        </FormControl>

        <FormControl fullWidth margin="dense">
          <InputLabel>Author</InputLabel>
          <Select
            name="authorId"
            value={formData.authorId}
            onChange={handleChange}
            label="Category"
            variant="outlined"
          >
            {authors.map((author) => (
              <MenuItem key={author.id} value={author.id}>
                {author.name} {author.surname}
              </MenuItem>
            ))}
          </Select>
        </FormControl>

        <TextField
          margin="dense"
          label="Available Copies"
          name="availableCopies"
          type="number"
          value={formData.availableCopies}
          onChange={handleChange}
          fullWidth
        />
      </DialogContent>
      <DialogActions>
        <Button onClick={onClose}>Cancel</Button>
        <Button onClick={handleSubmit} variant="contained" color="primary">
          {isEditing ? "Save" : "Add"}
        </Button>
      </DialogActions>
    </Dialog>
  );
}
