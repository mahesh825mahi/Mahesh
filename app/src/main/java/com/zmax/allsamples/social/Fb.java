package com.zmax.allsamples.social;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.zmax.allsamples.R;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Created by bfonics on 12/18/2015.
 */
public class Fb extends Activity
{
    Button fblogin,fblogout,fbshare;
    LoginButton loginButton;
    CallbackManager callbackManager;
    //http://blog.nkdroidsolutions.com/android-facebook-login-example-v4/
    //Login Review Doc
    //https://developers.facebook.com/docs/facebook-login/review/how-to-submit
    //Site
    //https://www.simplifiedcoding.net/login-with-facebook-android-studio-using-facebook-sdk-4/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);

        fblogin = (Button) findViewById(R.id.fblogin);
        fblogout = (Button) findViewById(R.id.fblogout);
        fbshare = (Button) findViewById(R.id.fbshare);

        try
        {
            PackageInfo info = getPackageManager().getPackageInfo("com.facebook.samples.hellofacebook", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        }
        catch (PackageManager.NameNotFoundException e)
        {

        }
        catch (NoSuchAlgorithmException e)
        {

        }
        init();
        process();
    }

    private void init()
    {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                // App code
            }

            @Override
            public void onCancel()
            {
                // App code
            }

            @Override
            public void onError(FacebookException exception)
            {
                // App code
            }
        });



        fblogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


            }
        });

        fblogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });

        fbshare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
    }

    private void process()
    {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
