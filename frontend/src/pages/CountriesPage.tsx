import useCountries from "../data/countries";
import CountryCard from "../components/countries/CountryCard";
import { Button, Grid } from "@mui/material";
import CountryDialog from "../components/countries/CountryDialog";
import { useState } from "react";

export default function CountriesPage() {
  const { countries, loading, onAdd, onEdit, onDelete } = useCountries();

  const [isAddCountryDialogOpen, setIsAddCountryDialogOpen] = useState(false);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <>
      <h1>Countries</h1>

      <Button
        variant="contained"
        onClick={() => setIsAddCountryDialogOpen(true)}
      >
        Add Country
      </Button>

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
        onClose={() => setIsAddCountryDialogOpen(false)}
      />
    </>
  );
}
