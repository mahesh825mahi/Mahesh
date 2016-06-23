package com.zmax.allsamples.networks;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector
{
	private Context _context;
	public ConnectionDetector(Context context)
	{
		this._context = context;
	}

	/**
	 * Checking for all possible internet providers
	 * **/
	public boolean isConnectingToInternet()
	{
		//if (Constants.use_wifi) {
			ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null)
			{
				NetworkInfo[] info = connectivity.getAllNetworkInfo();
				if (info != null)
					for (int i = 0; i < info.length; i++)
						if (info[i].getState() == NetworkInfo.State.CONNECTED)
						{
							return true;
						}
			}
			return false;

			//return true;
//		}else{
//			try {
//				final ConnectivityManager conMgr = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
//				boolean isMobile = conMgr.getNetworkInfo(
//						ConnectivityManager.TYPE_MOBILE).isConnected();
//				return isMobile;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return false;
//			}
//		}
		//return true;
		//return isMobile;
	}

	//    public boolean isConnectionDer(){
	//         ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
	//           if (connectivity != null)
	//           {
	//               NetworkInfo[] info = connectivity.getAllNetworkInfo();
	//               if (info != null)
	//                   for (int i = 0; i < info.length; i++)
	//                       if (info[i].getState() == NetworkInfo.State.CONNECTED)
	//                       {
	//                           return true;
	//                       }
	//           }
	//           return false;
	//  
	//     }

}
