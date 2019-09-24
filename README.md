# Welcome to the Macro Calculator. Please continue reading for instructions on how to access various endpoints.



## Macro Calculator API

**User Metrics Schema (attached to the user object, accessed by the GET listed below)**

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**age** | **integer** |  | [optional] [default to null]
**exercisefrequency** | **string** |  | [optional] [default to null]
**gender** | **string** |  | [optional] [default to null]
**goal** | **string** |  | [optional] [default to null]
**height** | **string** |  | [optional] [default to null]
**meals** | **string** |  | [optional] [default to null]
**user** | [**User**] |  | [optional] [default to null]
**usermetricsid** | **integer** |  | [optional] [default to null]
**weight** | **integer** |  | [optional] [default to null]


**User Metrics Endpoints**


Method | HTTP request | Description
------------- | ------------- | -------------
[**Add New User - POST**] | **POST** https://buildweek-macrocalc.herokuapp.com/createnewuser | addNewUser
[**Sign In - POST**] | **POST** https://buildweek-macrocalc.herokuapp.com/login | signIn
[**Get User By Name - GET**] | **GET** https://buildweek-macrocalc.herokuapp.com/users/username/{userName} | getUserByName
[**Add User Metrics By UserName - POST**] | **POST** https://buildweek-macrocalc.herokuapp.com/usermetrics/add/{username} | addUserMetricsByUserName
[**Delete User Metrics By User Metrics ID - DELETE**] | **DELETE** https://buildweek-macrocalc.herokuapp.com/usermetrics/delete/{usermetricsid} | deleteMetrics
[**Update User Metrics By User Metrics ID - PUT**] | **PUT** https://buildweek-macrocalc.herokuapp.com/usermetrics/edit/{usermetricsid} | updateMetrics


## **Add New User - POST**

Sign up a new user with this endpoint. Upon successful submission, reroute to login to receive your token.

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
 
 
 ## **Sign In - POST**

Sign in with your user profile. 

**IMPORTANT, PLEASE READ**: this application uses OAuth2. In order to receive your token, you will have to send an additional client ID and secret in the request header. Upon logging in and receiving your token, you will have to send your token labeled as "Bearer" to hit endpoints.

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
 

## **Get User By Name - GET**

Use this endpoint to access the full user object, including user id, user name, and the full list of user metrics. Pass in the username as a param upon logging in, and use the return object to generate the application's content.

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json


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
