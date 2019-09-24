# Welcome to the Macro Calculator. Please continue reading for instructions on how to access various endpoints.



# UserMetricsControllerApi

Method | HTTP request | Description
------------- | ------------- | -------------
[**addUserMetricsByUserNameUsingPOST**](UserMetricsControllerApi.md#addUserMetricsByUserNameUsingPOST) | **POST** /usermetrics/add/{username} | addUserMetricsByUserName
[**deleteMetricsUsingDELETE**](UserMetricsControllerApi.md#deleteMetricsUsingDELETE) | **DELETE** /usermetrics/delete/{usermetricsid} | deleteMetrics
[**updateMetricsUsingPUT**](UserMetricsControllerApi.md#updateMetricsUsingPUT) | **PUT** /usermetrics/edit/{usermetricsid} | updateMetrics


## **addUserMetricsByUserNameUsingPOST**

addUserMetricsByUserName

### Example
```bash
 addUserMetricsByUserNameUsingPOST username=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newMetrics** | [**Usermetrics**](Usermetrics.md) | newMetrics |
 **username** | **string** | username |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteMetricsUsingDELETE**

deleteMetrics

### Example
```bash
 deleteMetricsUsingDELETE usermetricsid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **usermetricsid** | **integer** | usermetricsid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **updateMetricsUsingPUT**

updateMetrics

### Example
```bash
 updateMetricsUsingPUT usermetricsid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **usermetrics** | [**Usermetrics**](Usermetrics.md) | usermetrics |
 **usermetricsid** | **integer** | usermetricsid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
