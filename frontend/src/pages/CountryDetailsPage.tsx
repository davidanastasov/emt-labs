import {
  Box,
  CircularProgress,
  Divider,
  Paper,
  Typography,
} from "@mui/material";
import { useParams } from "react-router";
import BooksTable from "~/components/books/BooksTable";
import { useBooksByCountryId } from "~/data/books";
import { useCountry } from "~/data/countries";

export default function CountryDetailsPage() {
  const { id } = useParams();
  const { country } = useCountry(Number(id));
  const { books, loading } = useBooksByCountryId(Number(id));

  return (
    <>
      <Typography variant="h4" gutterBottom>
        Country Details
      </Typography>

      <Paper elevation={3} sx={{ p: 3, mb: 4 }}>
        {country ? (
          <Box>
            <Typography variant="h5">{country.name}</Typography>
            <Typography color="text.secondary">
              Continent: {country.continent}
            </Typography>
          </Box>
        ) : (
          <Typography>Loading country information...</Typography>
        )}
      </Paper>

      <Typography variant="h5" gutterBottom>
        Books from this Country
      </Typography>
      <Divider sx={{ mb: 2 }} />

      {loading ? (
        <CircularProgress sx={{ display: "block", margin: "auto" }} />
      ) : (
        <Paper elevation={2} sx={{ p: 2 }}>
          <BooksTable books={books} onEdit={() => {}} onDelete={() => {}} />
        </Paper>
      )}
    </>
  );
}
