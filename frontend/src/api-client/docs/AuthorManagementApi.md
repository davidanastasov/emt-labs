# AuthorManagementApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**deleteAuthorById**](#deleteauthorbyid) | **DELETE** /api/authors/{id} | Delete an author by ID|
|[**getAllAuthors**](#getallauthors) | **GET** /api/authors | Get all authors|
|[**getAuthorById**](#getauthorbyid) | **GET** /api/authors/{id} | Get an author by ID|
|[**getAuthorCountsPerCountry**](#getauthorcountspercountry) | **GET** /api/authors/by-country | Get author counts per country|
|[**getAuthorNames**](#getauthornames) | **GET** /api/authors/names | Get all author names|
|[**saveAuthor**](#saveauthor) | **POST** /api/authors | Create a new author|
|[**updateAuthor**](#updateauthor) | **PATCH** /api/authors/{id} | Update an existing author|

# **deleteAuthorById**
> deleteAuthorById()

Removes an author from the database

### Example

```typescript
import {
    AuthorManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthorManagementApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteAuthorById(
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

# **getAllAuthors**
> Array<AuthorDTO> getAllAuthors()

Returns a list of all authors

### Example

```typescript
import {
    AuthorManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthorManagementApi(configuration);

const { status, data } = await apiInstance.getAllAuthors();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<AuthorDTO>**

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

# **getAuthorById**
> AuthorDTO getAuthorById()

Fetches an author by their unique ID

### Example

```typescript
import {
    AuthorManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthorManagementApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getAuthorById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


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

# **getAuthorCountsPerCountry**
> Array<AuthorCountsPerCountryDTO> getAuthorCountsPerCountry()

Retrieves a list showing the number of authors grouped by their country.

### Example

```typescript
import {
    AuthorManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthorManagementApi(configuration);

const { status, data } = await apiInstance.getAuthorCountsPerCountry();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<AuthorCountsPerCountryDTO>**

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

# **getAuthorNames**
> Array<AuthorNameDTO> getAuthorNames()

Retrieves a list of all authors\' names.

### Example

```typescript
import {
    AuthorManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthorManagementApi(configuration);

const { status, data } = await apiInstance.getAuthorNames();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<AuthorNameDTO>**

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

# **saveAuthor**
> AuthorDTO saveAuthor(createAuthorDTO)

Saves a new author to the database

### Example

```typescript
import {
    AuthorManagementApi,
    Configuration,
    CreateAuthorDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthorManagementApi(configuration);

let createAuthorDTO: CreateAuthorDTO; //

const { status, data } = await apiInstance.saveAuthor(
    createAuthorDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createAuthorDTO** | **CreateAuthorDTO**|  | |


### Return type

**AuthorDTO**

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

# **updateAuthor**
> AuthorDTO updateAuthor(updateAuthorDTO)

Updates an author\'s details

### Example

```typescript
import {
    AuthorManagementApi,
    Configuration,
    UpdateAuthorDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new AuthorManagementApi(configuration);

let id: number; // (default to undefined)
let updateAuthorDTO: UpdateAuthorDTO; //

const { status, data } = await apiInstance.updateAuthor(
    id,
    updateAuthorDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateAuthorDTO** | **UpdateAuthorDTO**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**AuthorDTO**

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

