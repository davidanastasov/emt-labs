import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import type { CountryDTO, UpdateCountryDTO } from "../../api-client";
import { useState } from "react";
import CountryDialog from "./CountryDialog";
import { Link } from "react-router";

interface CountryCardProps {
  country: CountryDTO;
  onEdit?: (id: number, data: UpdateCountryDTO) => void;
  onDelete?: (id: number) => void;
}

export default function CountryCard({
  country,
  onEdit,
  onDelete,
}: CountryCardProps) {
  const [isEditCountryDialogOpen, setIsEditCountryDialogOpen] = useState(false);

  return (
    <>
      <Card>
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {country.name}
          </Typography>
          <Typography variant="body2" sx={{ color: "text.secondary" }}>
            {country.continent}
          </Typography>
        </CardContent>
        <CardActions>
          <Link to={`/countries/${country.id}`}>
            <Button size="small">View</Button>
          </Link>

          <Button size="small" onClick={() => setIsEditCountryDialogOpen(true)}>
            Edit
          </Button>
          <Button size="small" onClick={() => onDelete?.(country.id!)}>
            Delete
          </Button>
        </CardActions>
      </Card>

      {isEditCountryDialogOpen && (
        <CountryDialog
          open={isEditCountryDialogOpen}
          country={country}
          onClose={() => setIsEditCountryDialogOpen(false)}
          onSubmit={(data) => {
            onEdit?.(country.id!, data);
            setIsEditCountryDialogOpen(false);
          }}
        />
      )}
    </>
  );
}
