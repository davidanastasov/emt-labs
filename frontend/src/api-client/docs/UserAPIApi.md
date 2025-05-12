# UserAPIApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**fetchAll**](#fetchall) | **GET** /api/user/fetch | Fetch all users|
|[**getUserRentals**](#getuserrentals) | **GET** /api/user/rentals | |
|[**login**](#login) | **POST** /api/user/login | User login|
|[**loginForm**](#loginform) | **POST** /api/user/login-form | User login|
|[**logout**](#logout) | **GET** /api/user/logout | User logout|
|[**register**](#register) | **POST** /api/user/register | Register a new user|

# **fetchAll**
> Array<UserDTO> fetchAll()

Retrieves a list of all users.

### Example

```typescript
import {
    UserAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UserAPIApi(configuration);

const { status, data } = await apiInstance.fetchAll();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<UserDTO>**

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

# **getUserRentals**
> Array<BookRentalDTO> getUserRentals()


### Example

```typescript
import {
    UserAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UserAPIApi(configuration);

const { status, data } = await apiInstance.getUserRentals();
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
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **login**
> LoginResponseDTO login(loginUserDTO)

Authenticates a user and starts a session

### Example

```typescript
import {
    UserAPIApi,
    Configuration,
    LoginUserDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new UserAPIApi(configuration);

let loginUserDTO: LoginUserDTO; //

const { status, data } = await apiInstance.login(
    loginUserDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **loginUserDTO** | **LoginUserDTO**|  | |


### Return type

**LoginResponseDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | User authenticated successfully |  -  |
|**401** | Invalid username or password |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **loginForm**
> UserDTO loginForm()

Authenticates a user and starts a session

### Example

```typescript
import {
    UserAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UserAPIApi(configuration);

const { status, data } = await apiInstance.loginForm();
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
|**200** | User authenticated successfully |  -  |
|**401** | Invalid username or password |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **logout**
> logout()

Ends the user\'s session

### Example

```typescript
import {
    UserAPIApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new UserAPIApi(configuration);

const { status, data } = await apiInstance.logout();
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
|**200** | User logged out successfully |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **register**
> UserDTO register(createUserDTO)

Creates a new user account

### Example

```typescript
import {
    UserAPIApi,
    Configuration,
    CreateUserDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new UserAPIApi(configuration);

let createUserDTO: CreateUserDTO; //

const { status, data } = await apiInstance.register(
    createUserDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createUserDTO** | **CreateUserDTO**|  | |


### Return type

**UserDTO**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | User registered successfully |  -  |
|**400** | Invalid input or passwords do not match |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

