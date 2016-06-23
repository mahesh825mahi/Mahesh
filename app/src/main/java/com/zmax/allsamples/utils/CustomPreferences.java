package com.zmax.allsamples.utils;
import android.content.Context;
import android.content.SharedPreferences;

public class CustomPreferences
{
	Context mContext;
	SharedPreferences settings;
	SharedPreferences.Editor editor;
	public CustomPreferences(Context mContext)
	{
		super();
		this.mContext = mContext;
		settings = mContext.getSharedPreferences(AppConstants.APPLICATION_PACKAGE_NAME, Context.MODE_PRIVATE);
		editor = settings.edit();
	}

	public String getGCM_reg_id(String key)
	{
		return settings.getString(key, "");
	}

	public void setGCM_reg_id(String key,String value)
	{
		editor.putString(key, value);
		editor.apply();
	}

	public void setPreferenceFor(String key, String value)
	{
		editor.putString(key, value);
		editor.apply();
	}

	public void setPreferenceFor(String key, Boolean value)
	{
		editor.putBoolean(key, value);
		editor.apply();

	}
	public void setPreferenceFor(String key, Float value)
	{
		editor.putFloat(key, value);
		editor.apply();
	}
	
	public String getPreferenceForString(String key)
	{
		return settings.getString(key, "");
	}

	public Boolean getPreferenceForBoolean(String key)
	{
		return settings.getBoolean(key, false);
	}

	public Float getPreferenceForFloat(String key)
	{
		return settings.getFloat(key, 0);
	}
}
