# WishlistAPIApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**addBookToWishlist**](#addbooktowishlist) | **POST** /api/wishlist/add-book/{bookId} | Add book to wishlist|
|[**clearWishlist**](#clearwishlist) | **DELETE** /api/wishlist | Clear wishlist|
|[**getActiveWishlist**](#getactivewishlist) | **GET** /api/wishlist | Get active wishlist|
|[**removeBookFromWishlist**](#removebookfromwishlist) | **POST** /api/wishlist/remove-book/{bookId} | Remove book from wishlist|
|[**rentAllBooksFromWishlist**](#rentallbooksfromwishlist) | **POST** /api/wishlist/rent-all | Rent all books from wishlist|

# **addBookToWishlist**
> WishlistDTO addBookToWishlist()

Adds a book to the wishlist for the logged-in user

### Example

```typescript
import {
    WishlistAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new WishlistAPIApi(configuration);

let bookId: number; // (default to undefined)

const { status, data } = await apiInstance.addBookToWishlist(
    bookId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **bookId** | [**number**] |  | defaults to undefined|


### Return type

**WishlistDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Book added to wishlist successfully |  -  |
|**400** | Invalid request |  -  |
|**404** | Book not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **clearWishlist**
> clearWishlist()

Removes all books from the logged-in user\'s wishlist

### Example

```typescript
import {
    WishlistAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new WishlistAPIApi(configuration);

const { status, data } = await apiInstance.clearWishlist();
```

### Parameters
This endpoint does not have any parameters.


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
|**200** | Wishlist cleared successfully |  -  |
|**400** | Invalid request |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getActiveWishlist**
> WishlistDTO getActiveWishlist()

Retrieves the active wishlist for the logged-in user

### Example

```typescript
import {
    WishlistAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new WishlistAPIApi(configuration);

const { status, data } = await apiInstance.getActiveWishlist();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**WishlistDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Wishlist retrieved successfully |  -  |
|**404** | Wishlist not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **removeBookFromWishlist**
> WishlistDTO removeBookFromWishlist()

Removes a book from the wishlist for the logged-in user

### Example

```typescript
import {
    WishlistAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new WishlistAPIApi(configuration);

let bookId: number; // (default to undefined)

const { status, data } = await apiInstance.removeBookFromWishlist(
    bookId
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **bookId** | [**number**] |  | defaults to undefined|


### Return type

**WishlistDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | Book removed from wishlist successfully |  -  |
|**400** | Invalid request |  -  |
|**404** | Book not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rentAllBooksFromWishlist**
> Array<BookRentalDTO> rentAllBooksFromWishlist()

Rents all books currently in the logged-in user\'s wishlist

### Example

```typescript
import {
    WishlistAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new WishlistAPIApi(configuration);

const { status, data } = await apiInstance.rentAllBooksFromWishlist();
```

### Parameters
This endpoint does not have any parameters.


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
|**200** | Books rented successfully |  -  |
|**400** | Invalid request |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

