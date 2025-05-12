# CountryManagementApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**deleteCountryById**](#deletecountrybyid) | **DELETE** /api/countries/{id} | Delete a country by ID|
|[**getAllCountries**](#getallcountries) | **GET** /api/countries | Get all countries|
|[**getCountryById**](#getcountrybyid) | **GET** /api/countries/{id} | Get a country by ID|
|[**saveCountry**](#savecountry) | **POST** /api/countries | Create a new country|
|[**updateCountry**](#updatecountry) | **PATCH** /api/countries/{id} | Update an existing country|

# **deleteCountryById**
> deleteCountryById()

Removes a country from the database

### Example

```typescript
import {
    CountryManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CountryManagementApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.deleteCountryById(
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

# **getAllCountries**
> Array<CountryDTO> getAllCountries()

Returns a list of all countries

### Example

```typescript
import {
    CountryManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CountryManagementApi(configuration);

const { status, data } = await apiInstance.getAllCountries();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**Array<CountryDTO>**

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

# **getCountryById**
> CountryDTO getCountryById()

Fetches a country by its unique ID

### Example

```typescript
import {
    CountryManagementApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new CountryManagementApi(configuration);

let id: number; // (default to undefined)

const { status, data } = await apiInstance.getCountryById(
    id
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CountryDTO**

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

# **saveCountry**
> CountryDTO saveCountry(createCountryDTO)

Saves a new country to the database

### Example

```typescript
import {
    CountryManagementApi,
    Configuration,
    CreateCountryDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new CountryManagementApi(configuration);

let createCountryDTO: CreateCountryDTO; //

const { status, data } = await apiInstance.saveCountry(
    createCountryDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **createCountryDTO** | **CreateCountryDTO**|  | |


### Return type

**CountryDTO**

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

# **updateCountry**
> CountryDTO updateCountry(updateCountryDTO)

Updates a country\'s details

### Example

```typescript
import {
    CountryManagementApi,
    Configuration,
    UpdateCountryDTO
} from './api';

const configuration = new Configuration();
const apiInstance = new CountryManagementApi(configuration);

let id: number; // (default to undefined)
let updateCountryDTO: UpdateCountryDTO; //

const { status, data } = await apiInstance.updateCountry(
    id,
    updateCountryDTO
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **updateCountryDTO** | **UpdateCountryDTO**|  | |
| **id** | [**number**] |  | defaults to undefined|


### Return type

**CountryDTO**

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

