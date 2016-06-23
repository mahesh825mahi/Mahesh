package com.zmax.allsamples.networks;

/**
 * Created by BMS2 on 10/14/2015.
 */
public interface ApiResponseHandler
{

    void onSuccess(int requestId, String requestUrl, String response);

    void onProgress(int current, int total);

    void onFailure(int requestId, Exception exception);

}
