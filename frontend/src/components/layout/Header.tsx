import { Link } from "react-router";

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
    <header>
      <h3>Book Library</h3>

      <nav>
        <ul>
          {navLinks.map((navLink) => (
            <Link key={navLink.label} to={navLink.path}>
              <li>{navLink.label}</li>
            </Link>
          ))}
        </ul>
      </nav>
    </header>
  );
}
