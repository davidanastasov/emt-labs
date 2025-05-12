import { useCallback, useEffect, useState } from "react";
import {
  authorsApi,
  type AuthorDTO,
  type CreateAuthorDTO,
  type UpdateAuthorDTO,
} from "../api-client";

interface State {
  authors: AuthorDTO[];
  loading: boolean;
}

const initialState: State = {
  authors: [],
  loading: true,
};

const useAuthors = () => {
  const [state, setState] = useState(initialState);

  const fetchAuthors = useCallback(() => {
    authorsApi
      .getAllAuthors()
      .then((response) => {
        setState({
          authors: response.data,
          loading: false,
        });
      })
      .catch((error) => console.log(error));
  }, []);

  const onAdd = useCallback(
    (data: CreateAuthorDTO) => {
      authorsApi
        .saveAuthor(data)
        .then(() => {
          console.log("Successfully added a new book.");
          fetchAuthors();
        })
        .catch((error) => console.log(error));
    },
    [fetchAuthors]
  );

  const onEdit = useCallback(
    (id: number, data: UpdateAuthorDTO) => {
      authorsApi
        .updateAuthor(id, data)
        .then(() => {
          console.log(`Successfully edited the book with ID ${id}.`);
          fetchAuthors();
        })
        .catch((error) => console.log(error));
    },
    [fetchAuthors]
  );

  const onDelete = useCallback(
    (id: number) => {
      authorsApi
        .deleteAuthorById(id)
        .then(() => {
          console.log(`Successfully deleted the book with ID ${id}.`);
          fetchAuthors();
        })
        .catch((error) => console.log(error));
    },
    [fetchAuthors]
  );

  useEffect(() => {
    fetchAuthors();
  }, [fetchAuthors]);

  return { ...state, onAdd: onAdd, onEdit: onEdit, onDelete: onDelete };
};

export default useAuthors;
