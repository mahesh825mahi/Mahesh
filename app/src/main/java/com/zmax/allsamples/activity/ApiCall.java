package com.zmax.allsamples.activity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.zmax.allsamples.R;
import com.zmax.allsamples.app.AppController;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
public class ApiCall extends Activity
{
    ProgressDialog pDialog;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_call);
        ctx = ApiCall.this;
    }

    public void loginpostRegistartion(final String username,final String password)
    {
        showProgressDialog();
        StringRequest strngReq = new StringRequest(Request.Method.POST, "", new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                hideProgressDialog();
                System.out.println("responseBody----> " + response.toString());
                //{"login": {"slim.flash":[],"uid":"8","user_name":"mahesh@gmail.com","is_logged":"Y"}}

                if (response != null)
                {
                    try
                    {
                        JSONObject jsonObj = new JSONObject(response);
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                hideProgressDialog();
                String responseBody = "";
                try
                {
                    responseBody = new String(error.networkResponse.data, "utf-8");
                    System.out.println("responseBody" + responseBody);
                }
                catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                // params.put("username", username);
                // params.put("password", pass);
                System.out.println("params" + params);
                return params;
            }

            @Override
            public byte[] getBody() throws AuthFailureError
            {
                System.out.println("Getting body ");
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);
                System.out.println("params" + params);
                JSONObject obj = new JSONObject(params);
                try
                {
                    return obj.toString().getBytes(getParamsEncoding());
                }
                catch (UnsupportedEncodingException uee)
                {
                    throw new RuntimeException("Encoding not supported: " + getParamsEncoding(), uee);
                }
            }
        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strngReq, "");
        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

    public void hideProgressDialog()
    {
        if(pDialog!=null)
        {
            pDialog.dismiss();
        }
    }

    public void  showProgressDialog()
    {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
    }
}