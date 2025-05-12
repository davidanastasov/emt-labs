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
import {
  CreateCountryDTOContinentEnum,
  type CountryDTO,
  type CreateCountryDTO,
} from "../../api-client";

const initialFormData: CreateCountryDTO = {
  name: "",
  continent: undefined,
};

interface CountryDialogProps {
  open: boolean;
  country?: CountryDTO;
  onClose: () => void;
  onSubmit: (data: typeof initialFormData) => void;
}

export default function CountryDialog({
  open,
  country,
  onClose,
  onSubmit,
}: CountryDialogProps) {
  const isEditing = !!country;

  const [formData, setFormData] = useState<CreateCountryDTO>(initialFormData);

  useEffect(() => {
    if (country) {
      setFormData({
        name: country.name,
        continent: country.continent,
      });
    }
  }, [country]);

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
      <DialogTitle>{isEditing ? "Update Country" : "Add Country"}</DialogTitle>
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
          <InputLabel>Continent</InputLabel>
          <Select
            name="continent"
            value={formData.continent}
            onChange={handleChange}
            label="Continent"
            variant="outlined"
          >
            {Object.values(CreateCountryDTOContinentEnum).map((continent) => (
              <MenuItem key={continent} value={continent}>
                {continent}
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
