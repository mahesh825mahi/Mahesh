package com.zmax.allsamples.activity;
import android.app.Activity;
import android.os.Bundle;
import com.zmax.allsamples.R;
/**
 * Created by bfonics on 1/25/2016.
 */
public class LoginScreen extends Activity
{
   //Custom Login Style
    //http://blog.codeint.com/creating-styled-edittext-in-android/
    String TAG = "SplashScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }
}