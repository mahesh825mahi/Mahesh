package com.zmax.allsamples.service_receiver;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
public class BluetoothStatChangedReceiver extends BroadcastReceiver
{
    Context context;
    public BluetoothStatChangedReceiver()
    {

    }

    private static final String TAG = "BluetoothReceiver";
    private static final int FAIL = -1;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        this.context =context;
        String action = intent.getAction();            // Get intent's action string
        Bundle extras = intent.getExtras();            // Get all the Intent's extras
        if (extras == null) return;                    // All intents of interest have extras.

        switch (action)
        {
            case "android.bluetooth.adapter.action.STATE_CHANGED":
            {
                bluetoothStateChanged(extras.getInt("android.bluetooth.adapter.extra.STATE", FAIL));
                break;
            }
        }
    }


    private void bluetoothStateChanged(int state)
    {
        switch (state)
        {
            case BluetoothAdapter.STATE_TURNING_ON:
                Log.d(TAG, "STATE_TURNING_ON " + state);
                //Toast.makeText(context,"Bluetooth state changed to:---> " + state,Toast.LENGTH_SHORT).show();
                break;

            case BluetoothAdapter.STATE_TURNING_OFF:
                Log.d(TAG, "STATE_TURNING_OFF" + state);
                //Toast.makeText(context,"Bluetooth state changed to:---> " + state,Toast.LENGTH_SHORT).show();
                break;
        }
    }


}