/*
 * CcsSso.ContactApi
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package uk.gov.ccs.swagger.sso.api;

import uk.gov.ccs.swagger.sso.ApiCallback;
import uk.gov.ccs.swagger.sso.ApiClient;
import uk.gov.ccs.swagger.sso.ApiException;
import uk.gov.ccs.swagger.sso.ApiResponse;
import uk.gov.ccs.swagger.sso.Configuration;
import uk.gov.ccs.swagger.sso.Pair;
import uk.gov.ccs.swagger.sso.ProgressRequestBody;
import uk.gov.ccs.swagger.sso.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import uk.gov.ccs.swagger.sso.model.ContactAssignedStatus;
import uk.gov.ccs.swagger.sso.model.ContactRequestWithOrgInfo;
import uk.gov.ccs.swagger.sso.model.ContactResponseInfo;
import uk.gov.ccs.swagger.sso.model.CreateContactRequestInfo;
import uk.gov.ccs.swagger.sso.model.CreatedContactResponse;
import uk.gov.ccs.swagger.sso.model.DeletedContatInfo;
import uk.gov.ccs.swagger.sso.model.UpdatedContactInfo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactPointApi {
    private ApiClient apiClient;

    public ContactPointApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ContactPointApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for contactServiceContactPointContactIdPut
     * @param contactId  (required)
     * @param body  (optional)
     * @param siteId  (optional, default to 0)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call contactServiceContactPointContactIdPutCall(Integer contactId, ContactRequestWithOrgInfo body, Integer siteId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/contact-service/contact-point/{contactId}"
            .replaceAll("\\{" + "contactId" + "\\}", apiClient.escapeString(contactId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (siteId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("site-id", siteId));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "ApiKey" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call contactServiceContactPointContactIdPutValidateBeforeCall(Integer contactId, ContactRequestWithOrgInfo body, Integer siteId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'contactId' is set
        if (contactId == null) {
            throw new ApiException("Missing the required parameter 'contactId' when calling contactServiceContactPointContactIdPut(Async)");
        }
        
        com.squareup.okhttp.Call call = contactServiceContactPointContactIdPutCall(contactId, body, siteId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * update contact point details
     * Sample request:        PUT contact-service/contact-point/1      {       \&quot;contactPointReason\&quot;: \&quot;BILLING/SHIPPING\&quot;,       \&quot;contactPointName\&quot;: \&quot;Test User\&quot;,       \&quot;ciiOrganisationId\&quot;: \&quot;1\&quot;,       \&quot;organisationPartyId\&quot;: \&quot;1\&quot;,       \&quot;contacts\&quot;: [        {          contactType: \&quot;EMAIL\&quot;,          contactValue: \&quot;testuser@mail.com\&quot;         },         {           contactType: \&quot;PHONE\&quot;,           contactValue: \&quot;+551155256325\&quot;         },         {           contactType: \&quot;FAX\&quot;,           contactValue: \&quot;+551155256325\&quot;         },         {           contactType: \&quot;WEB_ADDRESS\&quot;,           contactValue: \&quot;test.com\&quot;         },        ]      }
     * @param contactId  (required)
     * @param body  (optional)
     * @param siteId  (optional, default to 0)
     * @return UpdatedContactInfo
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UpdatedContactInfo contactServiceContactPointContactIdPut(Integer contactId, ContactRequestWithOrgInfo body, Integer siteId) throws ApiException {
        ApiResponse<UpdatedContactInfo> resp = contactServiceContactPointContactIdPutWithHttpInfo(contactId, body, siteId);
        return resp.getData();
    }

    /**
     * update contact point details
     * Sample request:        PUT contact-service/contact-point/1      {       \&quot;contactPointReason\&quot;: \&quot;BILLING/SHIPPING\&quot;,       \&quot;contactPointName\&quot;: \&quot;Test User\&quot;,       \&quot;ciiOrganisationId\&quot;: \&quot;1\&quot;,       \&quot;organisationPartyId\&quot;: \&quot;1\&quot;,       \&quot;contacts\&quot;: [        {          contactType: \&quot;EMAIL\&quot;,          contactValue: \&quot;testuser@mail.com\&quot;         },         {           contactType: \&quot;PHONE\&quot;,           contactValue: \&quot;+551155256325\&quot;         },         {           contactType: \&quot;FAX\&quot;,           contactValue: \&quot;+551155256325\&quot;         },         {           contactType: \&quot;WEB_ADDRESS\&quot;,           contactValue: \&quot;test.com\&quot;         },        ]      }
     * @param contactId  (required)
     * @param body  (optional)
     * @param siteId  (optional, default to 0)
     * @return ApiResponse&lt;UpdatedContactInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UpdatedContactInfo> contactServiceContactPointContactIdPutWithHttpInfo(Integer contactId, ContactRequestWithOrgInfo body, Integer siteId) throws ApiException {
        com.squareup.okhttp.Call call = contactServiceContactPointContactIdPutValidateBeforeCall(contactId, body, siteId, null, null);
        Type localVarReturnType = new TypeToken<UpdatedContactInfo>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * update contact point details (asynchronously)
     * Sample request:        PUT contact-service/contact-point/1      {       \&quot;contactPointReason\&quot;: \&quot;BILLING/SHIPPING\&quot;,       \&quot;contactPointName\&quot;: \&quot;Test User\&quot;,       \&quot;ciiOrganisationId\&quot;: \&quot;1\&quot;,       \&quot;organisationPartyId\&quot;: \&quot;1\&quot;,       \&quot;contacts\&quot;: [        {          contactType: \&quot;EMAIL\&quot;,          contactValue: \&quot;testuser@mail.com\&quot;         },         {           contactType: \&quot;PHONE\&quot;,           contactValue: \&quot;+551155256325\&quot;         },         {           contactType: \&quot;FAX\&quot;,           contactValue: \&quot;+551155256325\&quot;         },         {           contactType: \&quot;WEB_ADDRESS\&quot;,           contactValue: \&quot;test.com\&quot;         },        ]      }
     * @param contactId  (required)
     * @param body  (optional)
     * @param siteId  (optional, default to 0)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call contactServiceContactPointContactIdPutAsync(Integer contactId, ContactRequestWithOrgInfo body, Integer siteId, final ApiCallback<UpdatedContactInfo> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = contactServiceContactPointContactIdPutValidateBeforeCall(contactId, body, siteId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<UpdatedContactInfo>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for contactServiceContactPointPost
     * @param body  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call contactServiceContactPointPostCall(CreateContactRequestInfo body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/contact-service/contact-point";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "ApiKey" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call contactServiceContactPointPostValidateBeforeCall(CreateContactRequestInfo body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = contactServiceContactPointPostCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create contact details
     * Sample request:                    POST contact-service/contact-point      {        \&quot;contactRequestInfo\&quot;: {        \&quot;contactPointReason\&quot;: \&quot;string\&quot;,        \&quot;contactPointName\&quot;: \&quot;string\&quot;,        \&quot;contacts\&quot;: [          {            \&quot;contactType\&quot;: \&quot;string\&quot;,            \&quot;contactValue\&quot;: \&quot;string\&quot;          }        ]       },      \&quot;orgnationId\&quot;: 0,      \&quot;partyId\&quot;: 0,      \&quot;partyTypeId\&quot;: 0,      \&quot;isSite\&quot;: true,      \&quot;siteId\&quot;: null      }
     * @param body  (optional)
     * @return CreatedContactResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CreatedContactResponse contactServiceContactPointPost(CreateContactRequestInfo body) throws ApiException {
        ApiResponse<CreatedContactResponse> resp = contactServiceContactPointPostWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Create contact details
     * Sample request:                    POST contact-service/contact-point      {        \&quot;contactRequestInfo\&quot;: {        \&quot;contactPointReason\&quot;: \&quot;string\&quot;,        \&quot;contactPointName\&quot;: \&quot;string\&quot;,        \&quot;contacts\&quot;: [          {            \&quot;contactType\&quot;: \&quot;string\&quot;,            \&quot;contactValue\&quot;: \&quot;string\&quot;          }        ]       },      \&quot;orgnationId\&quot;: 0,      \&quot;partyId\&quot;: 0,      \&quot;partyTypeId\&quot;: 0,      \&quot;isSite\&quot;: true,      \&quot;siteId\&quot;: null      }
     * @param body  (optional)
     * @return ApiResponse&lt;CreatedContactResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CreatedContactResponse> contactServiceContactPointPostWithHttpInfo(CreateContactRequestInfo body) throws ApiException {
        com.squareup.okhttp.Call call = contactServiceContactPointPostValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<CreatedContactResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create contact details (asynchronously)
     * Sample request:                    POST contact-service/contact-point      {        \&quot;contactRequestInfo\&quot;: {        \&quot;contactPointReason\&quot;: \&quot;string\&quot;,        \&quot;contactPointName\&quot;: \&quot;string\&quot;,        \&quot;contacts\&quot;: [          {            \&quot;contactType\&quot;: \&quot;string\&quot;,            \&quot;contactValue\&quot;: \&quot;string\&quot;          }        ]       },      \&quot;orgnationId\&quot;: 0,      \&quot;partyId\&quot;: 0,      \&quot;partyTypeId\&quot;: 0,      \&quot;isSite\&quot;: true,      \&quot;siteId\&quot;: null      }
     * @param body  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call contactServiceContactPointPostAsync(CreateContactRequestInfo body, final ApiCallback<CreatedContactResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = contactServiceContactPointPostValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CreatedContactResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for contactServicePartyIdPartyTypeIdDelete
     * @param partyId  (required)
     * @param partyTypeId  (required)
     * @param contactId  (optional, default to 0)
     * @param siteId  (optional, default to 0)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call contactServicePartyIdPartyTypeIdDeleteCall(Integer partyId, Integer partyTypeId, Integer contactId, Integer siteId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/contact-service/{partyId}/{partyTypeId}"
            .replaceAll("\\{" + "partyId" + "\\}", apiClient.escapeString(partyId.toString()))
            .replaceAll("\\{" + "partyTypeId" + "\\}", apiClient.escapeString(partyTypeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contactId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("contact-id", contactId));
        if (siteId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("site-id", siteId));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "ApiKey" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call contactServicePartyIdPartyTypeIdDeleteValidateBeforeCall(Integer partyId, Integer partyTypeId, Integer contactId, Integer siteId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'partyId' is set
        if (partyId == null) {
            throw new ApiException("Missing the required parameter 'partyId' when calling contactServicePartyIdPartyTypeIdDelete(Async)");
        }
        // verify the required parameter 'partyTypeId' is set
        if (partyTypeId == null) {
            throw new ApiException("Missing the required parameter 'partyTypeId' when calling contactServicePartyIdPartyTypeIdDelete(Async)");
        }
        
        com.squareup.okhttp.Call call = contactServicePartyIdPartyTypeIdDeleteCall(partyId, partyTypeId, contactId, siteId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete contact point details
     * Sample request:        DELETE contact-service/1/1
     * @param partyId  (required)
     * @param partyTypeId  (required)
     * @param contactId  (optional, default to 0)
     * @param siteId  (optional, default to 0)
     * @return List&lt;DeletedContatInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<DeletedContatInfo> contactServicePartyIdPartyTypeIdDelete(Integer partyId, Integer partyTypeId, Integer contactId, Integer siteId) throws ApiException {
        ApiResponse<List<DeletedContatInfo>> resp = contactServicePartyIdPartyTypeIdDeleteWithHttpInfo(partyId, partyTypeId, contactId, siteId);
        return resp.getData();
    }

    /**
     * Delete contact point details
     * Sample request:        DELETE contact-service/1/1
     * @param partyId  (required)
     * @param partyTypeId  (required)
     * @param contactId  (optional, default to 0)
     * @param siteId  (optional, default to 0)
     * @return ApiResponse&lt;List&lt;DeletedContatInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<DeletedContatInfo>> contactServicePartyIdPartyTypeIdDeleteWithHttpInfo(Integer partyId, Integer partyTypeId, Integer contactId, Integer siteId) throws ApiException {
        com.squareup.okhttp.Call call = contactServicePartyIdPartyTypeIdDeleteValidateBeforeCall(partyId, partyTypeId, contactId, siteId, null, null);
        Type localVarReturnType = new TypeToken<List<DeletedContatInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete contact point details (asynchronously)
     * Sample request:        DELETE contact-service/1/1
     * @param partyId  (required)
     * @param partyTypeId  (required)
     * @param contactId  (optional, default to 0)
     * @param siteId  (optional, default to 0)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call contactServicePartyIdPartyTypeIdDeleteAsync(Integer partyId, Integer partyTypeId, Integer contactId, Integer siteId, final ApiCallback<List<DeletedContatInfo>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = contactServicePartyIdPartyTypeIdDeleteValidateBeforeCall(partyId, partyTypeId, contactId, siteId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<DeletedContatInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for contactServicePartyIdPartyTypeIdGet
     * @param partyId  (required)
     * @param partyTypeId  (required)
     * @param contactid  (optional)
     * @param contacttype  (optional)
     * @param isorg  (optional)
     * @param siteid  (optional)
     * @param contactAssignedStatus  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call contactServicePartyIdPartyTypeIdGetCall(Integer partyId, Integer partyTypeId, Integer contactid, String contacttype, Boolean isorg, Integer siteid, ContactAssignedStatus contactAssignedStatus, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/contact-service/{partyId}/{partyTypeId}"
            .replaceAll("\\{" + "partyId" + "\\}", apiClient.escapeString(partyId.toString()))
            .replaceAll("\\{" + "partyTypeId" + "\\}", apiClient.escapeString(partyTypeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (contactid != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("contactid", contactid));
        if (contacttype != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("contacttype", contacttype));
        if (isorg != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("isorg", isorg));
        if (siteid != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("siteid", siteid));
        if (contactAssignedStatus != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("contact-assigned-status", contactAssignedStatus));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "ApiKey" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call contactServicePartyIdPartyTypeIdGetValidateBeforeCall(Integer partyId, Integer partyTypeId, Integer contactid, String contacttype, Boolean isorg, Integer siteid, ContactAssignedStatus contactAssignedStatus, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'partyId' is set
        if (partyId == null) {
            throw new ApiException("Missing the required parameter 'partyId' when calling contactServicePartyIdPartyTypeIdGet(Async)");
        }
        // verify the required parameter 'partyTypeId' is set
        if (partyTypeId == null) {
            throw new ApiException("Missing the required parameter 'partyTypeId' when calling contactServicePartyIdPartyTypeIdGet(Async)");
        }
        
        com.squareup.okhttp.Call call = contactServicePartyIdPartyTypeIdGetCall(partyId, partyTypeId, contactid, contacttype, isorg, siteid, contactAssignedStatus, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get contact details
     * Sample request:                    GET contact-service/1/1
     * @param partyId  (required)
     * @param partyTypeId  (required)
     * @param contactid  (optional)
     * @param contacttype  (optional)
     * @param isorg  (optional)
     * @param siteid  (optional)
     * @param contactAssignedStatus  (optional)
     * @return List&lt;ContactResponseInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<ContactResponseInfo> contactServicePartyIdPartyTypeIdGet(Integer partyId, Integer partyTypeId, Integer contactid, String contacttype, Boolean isorg, Integer siteid, ContactAssignedStatus contactAssignedStatus) throws ApiException {
        ApiResponse<List<ContactResponseInfo>> resp = contactServicePartyIdPartyTypeIdGetWithHttpInfo(partyId, partyTypeId, contactid, contacttype, isorg, siteid, contactAssignedStatus);
        return resp.getData();
    }

    /**
     * Get contact details
     * Sample request:                    GET contact-service/1/1
     * @param partyId  (required)
     * @param partyTypeId  (required)
     * @param contactid  (optional)
     * @param contacttype  (optional)
     * @param isorg  (optional)
     * @param siteid  (optional)
     * @param contactAssignedStatus  (optional)
     * @return ApiResponse&lt;List&lt;ContactResponseInfo&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<ContactResponseInfo>> contactServicePartyIdPartyTypeIdGetWithHttpInfo(Integer partyId, Integer partyTypeId, Integer contactid, String contacttype, Boolean isorg, Integer siteid, ContactAssignedStatus contactAssignedStatus) throws ApiException {
        com.squareup.okhttp.Call call = contactServicePartyIdPartyTypeIdGetValidateBeforeCall(partyId, partyTypeId, contactid, contacttype, isorg, siteid, contactAssignedStatus, null, null);
        Type localVarReturnType = new TypeToken<List<ContactResponseInfo>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get contact details (asynchronously)
     * Sample request:                    GET contact-service/1/1
     * @param partyId  (required)
     * @param partyTypeId  (required)
     * @param contactid  (optional)
     * @param contacttype  (optional)
     * @param isorg  (optional)
     * @param siteid  (optional)
     * @param contactAssignedStatus  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call contactServicePartyIdPartyTypeIdGetAsync(Integer partyId, Integer partyTypeId, Integer contactid, String contacttype, Boolean isorg, Integer siteid, ContactAssignedStatus contactAssignedStatus, final ApiCallback<List<ContactResponseInfo>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = contactServicePartyIdPartyTypeIdGetValidateBeforeCall(partyId, partyTypeId, contactid, contacttype, isorg, siteid, contactAssignedStatus, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<ContactResponseInfo>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
