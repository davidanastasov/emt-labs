# BookManagementApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**deleteBookById**](#deletebookbyid) | **DELETE** /api/books/{id} | Delete a book by ID|
|[**findAllRentalsById**](#findallrentalsbyid) | **GET** /api/books/{id}/rentals | Get all book rentals by ID|
|[**getAllBooks**](#getallbooks) | **GET** /api/books | Get all books|
|[**getAuthorWithMostRentals**](#getauthorwithmostrentals) | **GET** /api/books/most-rented-author | |
|[**getBookById**](#getbookbyid) | **GET** /api/books/{id} | Get a book by ID|
|[**getBookCountsPerAuthor**](#getbookcountsperauthor) | **GET** /api/books/by-author | Get book counts per author|
|[**getBookWithMostRentals**](#getbookwithmostrentals) | **GET** /api/books/most-rented-book | |
|[**getUserWithMostRentals**](#getuserwithmostrentals) | **GET** /api/books/most-rentals-user | |
|[**rentBook**](#rentbook) | **POST** /api/books/{id}/rent | Rent a book by its ID|
|[**saveBook**](#savebook) | **POST** /api/books | Create a new book|
|[**updateBook**](#updatebook) | **PATCH** /api/books/{id} | Update an existing book|

# **deleteBookById**
> deleteBookById()

Removes a book from the database

### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteBookById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

void (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **findAllRentalsById**
> Array<BookRentalDTO> findAllRentalsById()

This endpoint returns all the rentals for a given book.

### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.findAllRentalsById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**Array<BookRentalDTO>**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAllBooks**
> Array<BookDTO> getAllBooks()

Returns a list of all books

### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

const { status, data } = await apiInstance.getAllBooks();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<BookDTO>**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getAuthorWithMostRentals**
> AuthorDTO getAuthorWithMostRentals()


### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

const { status, data } = await apiInstance.getAuthorWithMostRentals();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**AuthorDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBookById**
> BookDTO getBookById()

Fetches a book by its unique ID

### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getBookById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**BookDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBookCountsPerAuthor**
> Array<BookCountsPerAuthorDTO> getBookCountsPerAuthor()

Retrieves a list of authors along with the number of books they have authored.

### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

const { status, data } = await apiInstance.getBookCountsPerAuthor();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<BookCountsPerAuthorDTO>**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getBookWithMostRentals**
> BookDTO getBookWithMostRentals()


### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

const { status, data } = await apiInstance.getBookWithMostRentals();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**BookDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getUserWithMostRentals**
> UserDTO getUserWithMostRentals()


### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

const { status, data } = await apiInstance.getUserWithMostRentals();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**UserDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rentBook**
> BookDTO rentBook()

This endpoint allows renting a book if it is available.

### Example

```typescript
import {
    BookManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.rentBook(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**BookDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **saveBook**
> BookDTO saveBook(createBookDTO)

Saves a new book to the database

### Example

```typescript
import {
    BookManagementApi,
    Configuration,
    CreateBookDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

let createBookDTO: CreateBookDTO; //

const { status, data } = await apiInstance.saveBook(
    createBookDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createBookDTO** | **CreateBookDTO**|  | |


### Return type

**BookDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateBook**
> BookDTO updateBook(updateBookDTO)

Updates a book\'s details

### Example

```typescript
import {
    BookManagementApi,
    Configuration,
    UpdateBookDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new BookManagementApi(configuration);

let id: number; // (default to undefined)
let updateBookDTO: UpdateBookDTO; //

const { status, data } = await apiInstance.updateBook(
    id,
    updateBookDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateBookDTO** | **UpdateBookDTO**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**BookDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

