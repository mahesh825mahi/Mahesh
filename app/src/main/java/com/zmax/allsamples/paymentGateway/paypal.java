package com.zmax.allsamples.paymentGateway;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.zmax.allsamples.R;

/**
 * Created by bfonics on 1/25/2016.
 */
public class paypal extends Activity
{
    Button pay;
    TextView result;
    private static PayPalConfiguration config = new PayPalConfiguration()

            // Start with mock environment.  When ready, switch to sandbox (ENVIRONMENT_SANDBOX)
            // or live (ENVIRONMENT_PRODUCTION)
            .environment(PayPalConfiguration.ENVIRONMENT_NO_NETWORK)

            .clientId("<YOUR_CLIENT_ID>");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        pay = (Button) findViewById(R.id.pay);
        result = (TextView) findViewById(R.id.result);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });

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

                }
                catch (Exception e)
                {

                }
            }
        };
        background.start();
    }
}