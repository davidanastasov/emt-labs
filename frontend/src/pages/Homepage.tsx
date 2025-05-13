import { Box, Typography, Paper, Button, Grid, Container } from "@mui/material";
import { Link } from "react-router";
import { BookOpen, Users, Globe } from "lucide-react";

export default function Homepage() {
  const features = [
    {
      icon: <BookOpen size={40} />,
      title: "Books Management",
      description:
        "Manage your book inventory, track available copies, and organize by categories.",
      path: "/books",
    },
    {
      icon: <Users size={40} />,
      title: "Authors Directory",
      description:
        "Keep track of book authors, their nationality, and complete works.",
      path: "/authors",
    },
    {
      icon: <Globe size={40} />,
      title: "Countries Catalog",
      description:
        "Organize authors by country and continent for better geographical representation.",
      path: "/countries",
    },
  ];

  return (
    <Container maxWidth="lg">
      <Box sx={{ my: 4, textAlign: "center" }}>
        <Typography
          variant="h2"
          component="h1"
          gutterBottom
          sx={{
            fontWeight: 700,
            background: "linear-gradient(45deg, #3f51b5 30%, #00897b 90%)",
            WebkitBackgroundClip: "text",
            WebkitTextFillColor: "transparent",
          }}
        >
          Book Rental System
        </Typography>
        <Typography variant="h5" color="text.secondary" paragraph>
          Manage your library with ease. Add books, track rentals, and organize
          your collection.
        </Typography>
      </Box>

      <Grid container spacing={4} sx={{ mt: 4 }}>
        {features.map((feature, index) => (
          <Grid key={index} size={{ xs: 12, md: 4 }}>
            <Paper
              sx={{
                p: 3,
                height: "100%",
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
                textAlign: "center",
                borderRadius: 2,
                transition: "transform 0.3s, box-shadow 0.3s",
                "&:hover": {
                  transform: "translateY(-8px)",
                  boxShadow: 8,
                },
              }}
              elevation={3}
            >
              <Box
                sx={{
                  mb: 2,
                  p: 2,
                  borderRadius: "50%",
                  backgroundColor: "action.hover",
                  color: "primary.main",
                }}
              >
                {feature.icon}
              </Box>
              <Typography variant="h5" component="h2" gutterBottom>
                {feature.title}
              </Typography>
              <Typography color="text.secondary" sx={{ mb: 2, flexGrow: 1 }}>
                {feature.description}
              </Typography>
              <Button
                variant="outlined"
                component={Link}
                to={feature.path}
                sx={{ mt: "auto" }}
              >
                Explore
              </Button>
            </Paper>
          </Grid>
        ))}
      </Grid>
    </Container>
  );
}
