package com.zmax.allsamples.utils;

public class Utils
{
	/*static Dialog CustomAlertDialog;
	Context ctx;
	public static Boolean isConnectingToInternet(Context ctx)
	{
		Boolean isConnected=false;
		try
		{
			ConnectivityManager connectivity = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo info = connectivity.getActiveNetworkInfo();
			isConnected = info != null && info.isAvailable() && info.isConnected();
			return isConnected;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Log.d("isConnected: ", "" + isConnected);
		System.out.println("isConnected: "+ ""+isConnected);
		return isConnected;
	}

	public static void defaultalertdialog(Context ctx,String message)
	{
		AlertDialog.Builder builder1 = new AlertDialog.Builder(ctx);
		builder1.setMessage(message);
		builder1.setCancelable(true);
		builder1.setPositiveButton("OK",
		new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int id)
			{
				dialog.cancel();
			}
		});
		AlertDialog alert11 = builder1.create();
		alert11.show();
	}

	public static boolean AlertDialog(final Context ctx, final String content)
	{
		CustomAlertDialog = new Dialog(ctx, R.style.Dialog);
		CustomAlertDialog.setCancelable(false);
		CustomAlertDialog.setContentView(R.layout.custom_alertdialog);
		//CustomAlertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
		TextView dialog_title = (TextView) CustomAlertDialog.findViewById(R.id.dialog_title);
		dialog_title.setText(R.string.app_name);
		TextView Content = (TextView) CustomAlertDialog.findViewById(R.id.dialog_content);
		Button Ok = (Button) CustomAlertDialog.findViewById(R.id.dialog_no);
		Content.setText(content);
		CustomAlertDialog.show();
		Ok.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				CustomAlertDialog.dismiss();
			}
		});

		return true;
		}*/
}
