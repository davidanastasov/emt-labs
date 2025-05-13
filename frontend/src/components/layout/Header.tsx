import { AppBar, Button, Toolbar, Typography } from "@mui/material";
import { BookOpen } from "lucide-react";
import { Link, NavLink } from "react-router";

interface NavLink {
  path: string;
  label: string;
}

const navLinks: NavLink[] = [
  { path: "/", label: "Home" },
  { path: "/books", label: "Books" },
  { path: "/authors", label: "Authors" },
  { path: "/countries", label: "Countries" },
];

export default function Header() {
  return (
    <AppBar component="nav" position="static">
      <Toolbar>
        <Typography
          variant="h6"
          component={Link}
          to="/"
          sx={{
            flexGrow: 1,
            color: "white",
            textDecoration: "none",
            display: "flex",
            alignItems: "center",
          }}
        >
          <BookOpen size={24} style={{ marginRight: "8px" }} />
          Book Library
        </Typography>

        <nav>
          {navLinks.map((navLink) => (
            <Button
              key={navLink.label}
              component={NavLink}
              to={navLink.path}
              sx={{
                color: "#fff",
                mx: 1,
                "&.active": {
                  bgcolor: "rgba(255, 255, 255, 0.1)",
                },
              }}
            >
              {navLink.label}
            </Button>
          ))}
        </nav>
      </Toolbar>
    </AppBar>
  );
}
