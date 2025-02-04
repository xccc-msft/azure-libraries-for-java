/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in DatabaseAccountRegions.
 */
public class DatabaseAccountRegionsInner {
    /** The Retrofit service to perform REST calls. */
    private DatabaseAccountRegionsService service;
    /** The service client containing this operation class. */
    private CosmosDBImpl client;

    /**
     * Initializes an instance of DatabaseAccountRegionsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public DatabaseAccountRegionsInner(Retrofit retrofit, CosmosDBImpl client) {
        this.service = retrofit.create(DatabaseAccountRegionsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for DatabaseAccountRegions to be
     * used by Retrofit to perform actually REST calls.
     */
    interface DatabaseAccountRegionsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.cosmosdb.DatabaseAccountRegions listMetrics" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.DocumentDB/databaseAccounts/{accountName}/region/{region}/metrics")
        Observable<Response<ResponseBody>> listMetrics(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("accountName") String accountName, @Path("region") String region, @Query("api-version") String apiVersion, @Query("$filter") String filter, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Retrieves the metrics determined by the given filter for the given database account and region.
     *
     * @param resourceGroupName Name of an Azure resource group.
     * @param accountName Cosmos DB database account name.
     * @param region Cosmos DB region, with spaces between words and each word capitalized.
     * @param filter An OData filter expression that describes a subset of metrics to return. The parameters that can be filtered are name.value (name of the metric, can have an or of multiple names), startTime, endTime, and timeGrain. The supported operator is eq.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;MetricInner&gt; object if successful.
     */
    public List<MetricInner> listMetrics(String resourceGroupName, String accountName, String region, String filter) {
        return listMetricsWithServiceResponseAsync(resourceGroupName, accountName, region, filter).toBlocking().single().body();
    }

    /**
     * Retrieves the metrics determined by the given filter for the given database account and region.
     *
     * @param resourceGroupName Name of an Azure resource group.
     * @param accountName Cosmos DB database account name.
     * @param region Cosmos DB region, with spaces between words and each word capitalized.
     * @param filter An OData filter expression that describes a subset of metrics to return. The parameters that can be filtered are name.value (name of the metric, can have an or of multiple names), startTime, endTime, and timeGrain. The supported operator is eq.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<MetricInner>> listMetricsAsync(String resourceGroupName, String accountName, String region, String filter, final ServiceCallback<List<MetricInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listMetricsWithServiceResponseAsync(resourceGroupName, accountName, region, filter), serviceCallback);
    }

    /**
     * Retrieves the metrics determined by the given filter for the given database account and region.
     *
     * @param resourceGroupName Name of an Azure resource group.
     * @param accountName Cosmos DB database account name.
     * @param region Cosmos DB region, with spaces between words and each word capitalized.
     * @param filter An OData filter expression that describes a subset of metrics to return. The parameters that can be filtered are name.value (name of the metric, can have an or of multiple names), startTime, endTime, and timeGrain. The supported operator is eq.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MetricInner&gt; object
     */
    public Observable<List<MetricInner>> listMetricsAsync(String resourceGroupName, String accountName, String region, String filter) {
        return listMetricsWithServiceResponseAsync(resourceGroupName, accountName, region, filter).map(new Func1<ServiceResponse<List<MetricInner>>, List<MetricInner>>() {
            @Override
            public List<MetricInner> call(ServiceResponse<List<MetricInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Retrieves the metrics determined by the given filter for the given database account and region.
     *
     * @param resourceGroupName Name of an Azure resource group.
     * @param accountName Cosmos DB database account name.
     * @param region Cosmos DB region, with spaces between words and each word capitalized.
     * @param filter An OData filter expression that describes a subset of metrics to return. The parameters that can be filtered are name.value (name of the metric, can have an or of multiple names), startTime, endTime, and timeGrain. The supported operator is eq.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MetricInner&gt; object
     */
    public Observable<ServiceResponse<List<MetricInner>>> listMetricsWithServiceResponseAsync(String resourceGroupName, String accountName, String region, String filter) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (accountName == null) {
            throw new IllegalArgumentException("Parameter accountName is required and cannot be null.");
        }
        if (region == null) {
            throw new IllegalArgumentException("Parameter region is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Parameter filter is required and cannot be null.");
        }
        return service.listMetrics(this.client.subscriptionId(), resourceGroupName, accountName, region, this.client.apiVersion(), filter, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<MetricInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<MetricInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<MetricInner>> result = listMetricsDelegate(response);
                        List<MetricInner> items = null;
                        if (result.body() != null) {
                            items = result.body().items();
                        }
                        ServiceResponse<List<MetricInner>> clientResponse = new ServiceResponse<List<MetricInner>>(items, result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<MetricInner>> listMetricsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<MetricInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<MetricInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
