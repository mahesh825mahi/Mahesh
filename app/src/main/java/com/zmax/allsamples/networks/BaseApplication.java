package com.zmax.allsamples.networks;
import android.app.Application;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
public class BaseApplication extends Application
{
    private static final String TAG = BaseApplication.class.getSimpleName();
    private static BaseApplication appInstance;
    private RequestQueue mRequestQueue;
    private static Typeface robotoLightItalic;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
        appInstance = this;
        //robotoLightItalic = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/li.ttf");
    }

    public static Typeface getRobotoLightItalic()
    {
        return robotoLightItalic;
    }

    public static BaseApplication getInstance()
    {
        return appInstance;
    }

    public RequestQueue getRequestQueue()
    {
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag)
    {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag)
    {
        if (mRequestQueue != null)
        {
            mRequestQueue.cancelAll(tag);
        }
    }
}