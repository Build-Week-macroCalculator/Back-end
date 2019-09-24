# Welcome to the Macro Calculator. Please continue reading for instructions on how to access various endpoints.



# UserMetricsControllerApi

Method | HTTP request | Description
------------- | ------------- | -------------
[**Add User Metrics By UserName - POST**](UserMetricsControllerApi.md#addUserMetricsByUserNameUsingPOST) | **POST** https://buildweek-macrocalc.herokuapp.com//usermetrics/add/{username} | addUserMetricsByUserName
[**Delete User Metrics By User Metrics ID - DELETE**](UserMetricsControllerApi.md#deleteMetricsUsingDELETE) | **DELETE** https://buildweek-macrocalc.herokuapp.com//usermetrics/delete/{usermetricsid} | deleteMetrics
[**Update User Metrics By User Metrics ID - PUT**](UserMetricsControllerApi.md#updateMetricsUsingPUT) | **PUT** https://buildweek-macrocalc.herokuapp.com//usermetrics/edit/{usermetricsid} | updateMetrics


## **Add User Metrics By UserName - POST**

Use this endpoint to add a new set of metrics to a user that currently has no metrics. Pass in the username with your request, and you will add the metrics to the user profile. **IMPORTANT** - only use this endpoint for a user that currently has NO metrics attached. For editing a user's metrics, use PUT (instructions below).

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

## **Delete User Metrics By User Metrics ID - DELETE**

Use this endpoint to delete the full set of metrics from a user. This will return the user to a state with no metrics. If you delete a full set of metrics, you will then have to POST to add a new set of metrics.

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: */*

## **Update User Metrics By User Metrics ID - PUT**

Use this endpoint to EDIT user metrics.


### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
