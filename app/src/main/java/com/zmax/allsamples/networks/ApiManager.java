package com.zmax.allsamples.networks;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApiManager
{
    private RequestQueue mRequestQueue;
    private Context mContext;
    private String mApiEndURL;
    private ApiResponseHandler mRespHandler;
    private int mRequestId;
    public ApiManager(Context context, String endURL, ApiResponseHandler responseHandler, ApiRequestId requestId)
    {
        this.mContext = context;
        this.mApiEndURL = endURL;
        this.mRespHandler = responseHandler;
        this.mRequestId = requestId.getId();
        mRequestQueue = BaseApplication.getInstance().getRequestQueue();
    }
    //method to add the headers dynamically
    private HashMap<String, String> addHeaders(ArrayList<ApiHeader> newHeaderList)
    {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        if (newHeaderList != null && newHeaderList.size() > 0)
        {
            for (ApiHeader newHeader : newHeaderList)
                headers.put(newHeader.getName(), newHeader.getValue());
        }
        return headers;
    }
    //method to make the post call
    public void executePost(final Map<String, String> postObject, final ArrayList<ApiHeader> newHeaderList)
    {
        StringRequest postRequest = new StringRequest(Request.Method.POST, mApiEndURL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                mRespHandler.onSuccess(mRequestId, mApiEndURL, response.toString());
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                mRespHandler.onFailure(mRequestId, new Exception(error));
                showDialog(error);
            }
        })
        {
            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders()
            {
                return addHeaders(newHeaderList);
            }

            @Override
            protected Map<String, String> getParams()
            {
                return postObject;
            }

            @Override
            public byte[] getBody()
            {
                JSONObject obj = new JSONObject(postObject);
                try
                {
                    return obj.toString().getBytes(getParamsEncoding());
                }
                catch (UnsupportedEncodingException e)
                {
                    throw new RuntimeException("Encoding not supported: " + getParamsEncoding(), e);
                }
            }
        };

        // Adding request to request queue
        BaseApplication.getInstance().addToRequestQueue(postRequest, "");
    }

    public void executeGet(final ArrayList<ApiHeader> newHeaderList)
    {
        // Request a string response from the provided URL.
        StringRequest getRequest = new StringRequest(Request.Method.GET, mApiEndURL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                mRespHandler.onSuccess(mRequestId, mApiEndURL, response.toString());
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                mRespHandler.onFailure(mRequestId, new Exception(error));
                showDialog(error);
            }
        })
        {
            @Override
            public Map<String, String> getHeaders()
            {
                return addHeaders(newHeaderList);
            }
        };
        // Adding request to request queue
        BaseApplication.getInstance().addToRequestQueue(getRequest, "");
    }

    //method to show dialog if some error occue during network call
    private void showDialog(VolleyError error)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setCancelable(true);
        if (error instanceof TimeoutError)
        {
            builder.setMessage("timeout_error");
            builder.setPositiveButton("retry", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                }
            });
        } else if (error instanceof NoConnectionError)
        {
            builder.setMessage("network_error");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                }
            });
        }

        if (error instanceof NetworkError)
        {

        }
 //       else if( error instanceof ClientError) {
//       }
        else if (error instanceof ServerError)
        {

        }
        else if (error instanceof AuthFailureError)
        {

        }
        else if (error instanceof ParseError)
        {

        }
        else if (error instanceof NoConnectionError)
        {

        }
        else if (error instanceof TimeoutError)
        {

        }
    }
}
