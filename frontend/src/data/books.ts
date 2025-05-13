import { useCallback, useEffect, useState } from "react";
import {
  booksApi,
  type BookDTO,
  type CreateBookDTO,
  type UpdateBookDTO,
} from "../api-client";

interface State {
  books: BookDTO[];
  loading: boolean;
}

const initialState: State = {
  books: [],
  loading: true,
};

const useBooks = () => {
  const [state, setState] = useState(initialState);

  const fetchBooks = useCallback(() => {
    booksApi
      .getAllBooks()
      .then((response) => {
        setState({
          books: response.data,
          loading: false,
        });
      })
      .catch((error) => console.log(error));
  }, []);

  const onAdd = useCallback(
    (data: CreateBookDTO) => {
      booksApi
        .saveBook(data)
        .then(() => {
          console.log("Successfully added a new book.");
          fetchBooks();
        })
        .catch((error) => console.log(error));
    },
    [fetchBooks]
  );

  const onEdit = useCallback(
    (id: number, data: UpdateBookDTO) => {
      booksApi
        .updateBook(id, data)
        .then(() => {
          console.log(`Successfully edited the book with ID ${id}.`);
          fetchBooks();
        })
        .catch((error) => console.log(error));
    },
    [fetchBooks]
  );

  const onDelete = useCallback(
    (id: number) => {
      booksApi
        .deleteBookById(id)
        .then(() => {
          console.log(`Successfully deleted the book with ID ${id}.`);
          fetchBooks();
        })
        .catch((error) => console.log(error));
    },
    [fetchBooks]
  );

  useEffect(() => {
    fetchBooks();
  }, [fetchBooks]);

  return { ...state, onAdd: onAdd, onEdit: onEdit, onDelete: onDelete };
};

export const useBooksByCountryId = (countryId: number) => {
  const [state, setState] = useState(initialState);

  const fetchBooks = useCallback(() => {
    booksApi
      .findBooksByCountryId(countryId)
      .then((response) => {
        setState({
          books: response.data,
          loading: false,
        });
      })
      .catch((error) => console.log(error));
  }, []);

  const onAdd = useCallback(
    (data: CreateBookDTO) => {
      booksApi
        .saveBook(data)
        .then(() => {
          console.log("Successfully added a new book.");
          fetchBooks();
        })
        .catch((error) => console.log(error));
    },
    [fetchBooks]
  );

  const onEdit = useCallback(
    (id: number, data: UpdateBookDTO) => {
      booksApi
        .updateBook(id, data)
        .then(() => {
          console.log(`Successfully edited the book with ID ${id}.`);
          fetchBooks();
        })
        .catch((error) => console.log(error));
    },
    [fetchBooks]
  );

  const onDelete = useCallback(
    (id: number) => {
      booksApi
        .deleteBookById(id)
        .then(() => {
          console.log(`Successfully deleted the book with ID ${id}.`);
          fetchBooks();
        })
        .catch((error) => console.log(error));
    },
    [fetchBooks]
  );

  useEffect(() => {
    fetchBooks();
  }, [fetchBooks]);

  return { ...state, onAdd: onAdd, onEdit: onEdit, onDelete: onDelete };
};

export default useBooks;
