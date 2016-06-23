package com.zmax.allsamples.lib;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.zmax.allsamples.R;
import com.zmax.maheshlib.WifiScanner;
import com.zmax.maheshlib.WifiScannerResult;
import java.util.List;
public class Lib_Main extends Activity implements WifiScannerResult
{
    Context ctx;
    WifiScanner wifiScanner;
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_fb);
        ctx = Lib_Main.this;
        wifiScanner = new WifiScanner();
        wifiScanner.startScan(ctx, this, 5);
    }

    @Override
    public void onWifiDiscovered(List<String> list)
    {

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        wifiScanner.stopScan();
    }
}
