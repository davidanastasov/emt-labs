import { useCallback, useEffect, useState } from "react";
import {
  countriesApi,
  type CountryDTO,
  type CreateCountryDTO,
  type UpdateCountryDTO,
} from "../api-client";

interface State {
  countries: CountryDTO[];
  loading: boolean;
}

const initialState: State = {
  countries: [],
  loading: true,
};

const useCountries = () => {
  const [state, setState] = useState(initialState);

  const fetchCountries = useCallback(() => {
    countriesApi
      .getAllCountries()
      .then((response) => {
        setState({
          countries: response.data,
          loading: false,
        });
      })
      .catch((error) => console.log(error));
  }, []);

  const onAdd = useCallback(
    (data: CreateCountryDTO) => {
      countriesApi
        .saveCountry(data)
        .then(() => {
          console.log("Successfully added a new book.");
          fetchCountries();
        })
        .catch((error) => console.log(error));
    },
    [fetchCountries]
  );

  const onEdit = useCallback(
    (id: number, data: UpdateCountryDTO) => {
      countriesApi
        .updateCountry(id, data)
        .then(() => {
          console.log(`Successfully edited the book with ID ${id}.`);
          fetchCountries();
        })
        .catch((error) => console.log(error));
    },
    [fetchCountries]
  );

  const onDelete = useCallback(
    (id: number) => {
      countriesApi
        .deleteCountryById(id)
        .then(() => {
          console.log(`Successfully deleted the book with ID ${id}.`);
          fetchCountries();
        })
        .catch((error) => console.log(error));
    },
    [fetchCountries]
  );

  useEffect(() => {
    fetchCountries();
  }, [fetchCountries]);

  return { ...state, onAdd, onEdit, onDelete };
};

export const useCountry = (countryId: number) => {
  const [country, setCountry] = useState<CountryDTO | null>(null);
  const [loading, setLoading] = useState(true);

  const fetchCountry = useCallback((id: number) => {
    countriesApi
      .getCountryById(id)
      .then((response) => {
        setCountry(response.data);
        setLoading(false);
      })
      .catch((error) => console.log(error));
  }, []);

  useEffect(() => {
    fetchCountry(countryId);
  }, [fetchCountry, countryId]);

  return { country, loading, fetchCountry };
};

export default useCountries;
