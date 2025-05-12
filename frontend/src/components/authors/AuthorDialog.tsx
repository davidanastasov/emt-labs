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
import { type AuthorDTO, type CreateAuthorDTO } from "../../api-client";
import useCountries from "../../data/countries";

const initialFormData: CreateAuthorDTO = {
  name: "",
  surname: "",
  countryId: undefined,
};

interface AuthorDialogProps {
  open: boolean;
  author?: AuthorDTO;
  onClose: () => void;
  onSubmit: (data: typeof initialFormData) => void;
}

export default function AuthorDialog({
  open,
  author,
  onClose,
  onSubmit,
}: AuthorDialogProps) {
  const isEditing = !!author;
  const { countries } = useCountries();

  const [formData, setFormData] = useState<CreateAuthorDTO>(initialFormData);

  useEffect(() => {
    if (author) {
      setFormData({
        name: author.name,
        surname: author.surname,
        countryId: author.country?.id,
      });
    }
  }, [author]);

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
      <DialogTitle>{isEditing ? "Update Author" : "Add Author"}</DialogTitle>
      <DialogContent>
        <TextField
          margin="dense"
          label="Name"
          name="name"
          value={formData.name}
          onChange={handleChange}
          fullWidth
        />

        <TextField
          margin="dense"
          label="Surname"
          name="surname"
          value={formData.surname}
          onChange={handleChange}
          fullWidth
        />

        <FormControl fullWidth margin="dense">
          <InputLabel>Category</InputLabel>
          <Select
            name="countryId"
            value={formData.countryId}
            onChange={handleChange}
            label="Country"
            variant="outlined"
          >
            {countries.map((country) => (
              <MenuItem key={country.id} value={country.id}>
                {country.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
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
