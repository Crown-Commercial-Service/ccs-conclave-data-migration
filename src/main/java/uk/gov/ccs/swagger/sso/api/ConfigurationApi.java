/*
 * CcsSso.WrapperApi
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v2
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


import uk.gov.ccs.swagger.sso.model.IdentityProviderDetail;
import uk.gov.ccs.swagger.sso.model.OrganisationRole;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationApi {
    private ApiClient apiClient;

    public ConfigurationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ConfigurationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for configurationsIdentityProvidersGet
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call configurationsIdentityProvidersGetCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/configurations/identity-providers";

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
    private com.squareup.okhttp.Call configurationsIdentityProvidersGetValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = configurationsIdentityProvidersGetCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Allows a user to get identity provider details
     * Sample request:                    GET configurations/identity-providers
     * @return List&lt;IdentityProviderDetail&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<IdentityProviderDetail> configurationsIdentityProvidersGet() throws ApiException {
        ApiResponse<List<IdentityProviderDetail>> resp = configurationsIdentityProvidersGetWithHttpInfo();
        return resp.getData();
    }

    /**
     * Allows a user to get identity provider details
     * Sample request:                    GET configurations/identity-providers
     * @return ApiResponse&lt;List&lt;IdentityProviderDetail&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<IdentityProviderDetail>> configurationsIdentityProvidersGetWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = configurationsIdentityProvidersGetValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<List<IdentityProviderDetail>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Allows a user to get identity provider details (asynchronously)
     * Sample request:                    GET configurations/identity-providers
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call configurationsIdentityProvidersGetAsync(final ApiCallback<List<IdentityProviderDetail>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = configurationsIdentityProvidersGetValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<IdentityProviderDetail>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for configurationsRolesGet
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call configurationsRolesGetCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/configurations/roles";

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
    private com.squareup.okhttp.Call configurationsRolesGetValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        com.squareup.okhttp.Call call = configurationsRolesGetCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 
     * 
     * @return List&lt;OrganisationRole&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<OrganisationRole> configurationsRolesGet() throws ApiException {
        ApiResponse<List<OrganisationRole>> resp = configurationsRolesGetWithHttpInfo();
        return resp.getData();
    }

    /**
     * 
     * 
     * @return ApiResponse&lt;List&lt;OrganisationRole&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<OrganisationRole>> configurationsRolesGetWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = configurationsRolesGetValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<List<OrganisationRole>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call configurationsRolesGetAsync(final ApiCallback<List<OrganisationRole>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = configurationsRolesGetValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<OrganisationRole>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
