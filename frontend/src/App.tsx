import { BrowserRouter, Route, Routes } from "react-router";
import Homepage from "./pages/Homepage";
import BooksPage from "./pages/BooksPage";
import AuthorsPage from "./pages/AuthorsPage";
import CountriesPage from "./pages/CountriesPage";
import Layout from "./components/layout/Layout";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          <Route index element={<Homepage />} />
          <Route path="books" element={<BooksPage />} />
          <Route path="authors" element={<AuthorsPage />} />
          <Route path="countries" element={<CountriesPage />} />
          <Route path="*" element={<h1>Page not Found</h1>} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
