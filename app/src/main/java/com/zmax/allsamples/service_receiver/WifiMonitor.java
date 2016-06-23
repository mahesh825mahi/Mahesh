package com.zmax.allsamples.service_receiver;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.zmax.allsamples.R;
import java.util.List;
public class WifiMonitor extends Activity
{
	//http://viralpatel.net/blogs/android-internet-connection-status-network-change/
	//http://www.tutorialspoint.com/android/android_wi_fi.htm
	//http://androidexample.com/Scan_wifi_connections_or_Get_number_of_available_wifi_connections/index.php?view=article_discription&aid=90&aaid=1141
	
	TextView textConnected, textIp, textSsid, textBssid, textMac, textSpeed, textRssi;
	Button result;
	WifiManager mainWifi;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifimonitor);
        textConnected = (TextView)findViewById(R.id.Connected);
        textIp = (TextView)findViewById(R.id.Ip);
        textSsid = (TextView)findViewById(R.id.Ssid);
        textBssid = (TextView)findViewById(R.id.Bssid);
        textMac = (TextView)findViewById(R.id.Mac);
        textSpeed = (TextView)findViewById(R.id.Speed);
        textRssi = (TextView)findViewById(R.id.Rssi);
		result = (Button) findViewById(R.id.result);
		mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

		result.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				mainWifi.startScan();
				List<ScanResult> wifiList;
				wifiList = mainWifi.getScanResults();
				System.out.println("WifiMonitor"+"---->count"+wifiList.size());

				for (int i = 0; i < wifiList.size(); i++)
				{
					StringBuilder sb = new StringBuilder();
					String SSID = wifiList.get(i).SSID;
					if (SSID.equals(""))
					{
						SSID = "No name found";
					}
					String bssid = wifiList.get(i).BSSID;
					int frequency = wifiList.get(i).frequency;
					int level = wifiList.get(i).level;
					sb.append("Name : " + SSID + "\nBssid  : " + bssid + "\nLevel  : " + level);
					System.out.println(" WifiMonitor AlermReceiver SSID---->" + SSID);
					System.out.println("WifiMonitor AlermReceiver bssid---->" + bssid);
					System.out.println("WifiMonitor AlermReceiver level---->" + level);
					System.out.println("WifiMonitor AlermReceiver frequency---->" + frequency);
					System.out.println("WifiMonitor-----------------------------------");
					//double distance = calculateDistance(level, frequency);
					/*if (distance < 0)
					{
						sb.append("\nDistance :" + "0.1m");
					} else
						sb.append("\nDistance :" + distance + "m");
					System.out.println(sb.toString());
					String values = bssid.replace(":", "");
					if (!temp_beacons.contains(values)) {
						temp_beacons.add(values);
						Log.d("ONE", "ONE");
						try {
							detectBeacon(values);//Trigger API with the bssid
						} catch (JSONException e) {
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					} else {
						Calendar c = Calendar.getInstance();
						int time_sec = c.get(Calendar.SECOND);
						if (time_sec % 20 == 0) {
							Log.d("COMEEE", "comeee" + time_sec + "");
							hangOnWhile(time_sec);
						}
					}*/
				}
			}
		});

        //DisplayWifiState();
        //this.registerReceiver(this.myWifiReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        //this.registerReceiver(this.myRssiChangeReceiver, new IntentFilter(WifiManager.RSSI_CHANGED_ACTION));
    }
    
    private BroadcastReceiver myRssiChangeReceiver = new BroadcastReceiver()
	{
		@Override
		public void onReceive(Context arg0, Intent arg1)
		{
			System.out.println("WifiMonitor"+"----->111111myRssiChangeReceiver");
			int newRssi = arg1.getIntExtra(WifiManager.EXTRA_NEW_RSSI, 0);
			textRssi.setText(String.valueOf(newRssi));
		}};
    
    private BroadcastReceiver myWifiReceiver = new BroadcastReceiver()
	{
		@Override
		public void onReceive(Context arg0, Intent arg1)
		{
			System.out.println("WifiMonitor"+"----->2222222222myWifiReceiver");
			NetworkInfo networkInfo = (NetworkInfo) arg1.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
			if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
			{
				DisplayWifiState();
			}
		}};
    
    private void DisplayWifiState()
	{
    	ConnectivityManager myConnManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    	NetworkInfo myNetworkInfo = myConnManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    	WifiManager myWifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
		WifiInfo myWifiInfo = myWifiManager.getConnectionInfo();
		
		textMac.setText(myWifiInfo.getMacAddress());
		
    	if (myNetworkInfo.isConnected())
		{
    		int myIp = myWifiInfo.getIpAddress();
        
    		textConnected.setText("--- CONNECTED ---");
        
    		int intMyIp3 = myIp/0x1000000;
    		int intMyIp3mod = myIp%0x1000000;
        
    		int intMyIp2 = intMyIp3mod/0x10000;
    		int intMyIp2mod = intMyIp3mod%0x10000;
        
    		int intMyIp1 = intMyIp2mod/0x100;
    		int intMyIp0 = intMyIp2mod%0x100;
        
    		textIp.setText(String.valueOf(intMyIp0)
    				+ "." + String.valueOf(intMyIp1)
    				+ "." + String.valueOf(intMyIp2)
    				+ "." + String.valueOf(intMyIp3)
    				);
        
    		textSsid.setText(myWifiInfo.getSSID());
    		textBssid.setText(myWifiInfo.getBSSID());
    		
    		textSpeed.setText(String.valueOf(myWifiInfo.getLinkSpeed()) + " " + WifiInfo.LINK_SPEED_UNITS);
    		textRssi.setText(String.valueOf(myWifiInfo.getRssi()));
    	}
    	else{
    		textConnected.setText("--- DIS-CONNECTED! ---");
    		textIp.setText("---");
    		textSsid.setText("---");
    		textBssid.setText("---");
    		textSpeed.setText("---");
    		textRssi.setText("---");
    	}
    	
    }
}