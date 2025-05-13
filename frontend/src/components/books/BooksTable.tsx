import React from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  IconButton,
  Chip,
} from "@mui/material";
import { Edit, Trash } from "lucide-react";
import type { BookDTO } from "~/api-client";

interface BooksTableProps {
  books: BookDTO[];
  onEdit: (id: number) => void;
  onDelete: (id: number) => void;
}

const BooksTable: React.FC<BooksTableProps> = ({ books, onEdit, onDelete }) => {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="books table">
        <TableHead>
          <TableRow>
            <TableCell>Title</TableCell>
            <TableCell>Category</TableCell>
            <TableCell>Author</TableCell>
            <TableCell align="center">Available Copies</TableCell>
            <TableCell></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {books.map((book) => (
            <TableRow
              key={book.id}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {book.name}
              </TableCell>
              <TableCell>
                <Chip label={book.category} color="primary" size="small" />
              </TableCell>
              <TableCell>
                {`${book.author!.name} ${book.author!.surname}`}
              </TableCell>
              <TableCell align="center">{book.availableCopies}</TableCell>
              <TableCell align="right">
                <IconButton
                  size="small"
                  color="primary"
                  onClick={() => onEdit(book.id!)}
                  aria-label="edit"
                >
                  <Edit size={18} />
                </IconButton>

                <IconButton
                  size="small"
                  color="error"
                  onClick={() => onDelete(book.id!)}
                  aria-label="delete"
                >
                  <Trash size={18} />
                </IconButton>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default BooksTable;
