import { Outlet } from "react-router";
import Header from "./Header";
import { Box, Container } from "@mui/material";

export default function Layout() {
  return (
    <Box
      sx={{
        display: "flex",
        flexDirection: "column",
        minHeight: "100vh",
      }}
    >
      <Header />

      <Container
        component="main"
        maxWidth="lg"
        sx={{
          flexGrow: 1,
          py: 2,
        }}
      >
        <Outlet />
      </Container>
    </Box>
  );
}
