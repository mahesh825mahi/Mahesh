package com.zmax.allsamples.activity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import com.zmax.allsamples.R;

/**
 * Created by bfonics on 1/25/2016.
 */
public class SplashScreen extends Activity
{
    int PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION = 1;
    LocationManager locMan;
    String TAG = "SplashScreenActivity";

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        System.out.println(TAG + "------>1111111111111");
        if (requestCode == PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION)
        {
            System.out.println(TAG + "------>22222222222~~~~>" + permissions.length + "~~~~~~~~>" + grantResults[0] + "~~~~>" + PackageManager.PERMISSION_GRANTED);
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                System.out.println(TAG + "------>33333333333333");
                startActivity();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //http://inthecheesefactory.com/blog/things-you-need-to-know-about-android-m-permission-developer-edition/en
        //http://stackoverflow.com/questions/32151603/scan-results-available-action-return-empty-list-in-android-6-0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION);
        }
        else
        {
            startActivity();
        }


      /*  try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.facebook.samples.hellofacebook",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));

            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }*/
    }

    public void startActivity()
    {
        Thread background = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3 * 1000);
                    //mUtilities.isLogged() ? HomeActivity.class : SlideOverAnimation.class
                    /*android.content.Intent intent = new android.content.Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    //overridePendingTransition(0, 0);
                    overridePendingTransition(0, R.anim.scale_from_corner);
                    finish();*/
                }
                catch (Exception e)
                {

                }
            }
        };
        background.start();
    }
}