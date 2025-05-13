import useCountries from "../data/countries";
import CountryCard from "../components/countries/CountryCard";
import { Box, Button, Grid, Typography } from "@mui/material";
import CountryDialog from "../components/countries/CountryDialog";
import { useState } from "react";
import { Plus } from "lucide-react";

export default function CountriesPage() {
  const { countries, loading, onAdd, onEdit, onDelete } = useCountries();

  const [isAddCountryDialogOpen, setIsAddCountryDialogOpen] = useState(false);

  function handleAddClick() {
    setIsAddCountryDialogOpen(true);
  }

  function handleCloseDialog() {
    setIsAddCountryDialogOpen(false);
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
          Countries
        </Typography>

        <Button
          variant="contained"
          color="primary"
          startIcon={<Plus size={20} />}
          onClick={handleAddClick}
          sx={{ display: { xs: "none", sm: "flex" } }}
        >
          Add Country
        </Button>
      </Box>

      <Grid container spacing={2}>
        {countries.map((country) => (
          <Grid key={country.id} size={{ xs: 12, sm: 6, md: 4 }}>
            <CountryCard
              country={country}
              onEdit={onEdit}
              onDelete={onDelete}
            />
          </Grid>
        ))}
      </Grid>

      <CountryDialog
        open={isAddCountryDialogOpen}
        onSubmit={onAdd}
        onClose={handleCloseDialog}
      />
    </>
  );
}
