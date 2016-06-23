package com.zmax.allsamples.utils;
public class AppConstants
{
    //GCM
    public static final String GOOGLE_PROJECT_ID = "1071079533241";
    public static final String MESSAGE_KEY = "message";
    //GCM
    public static final String APPLICATION_PACKAGE_NAME = "com.carexpert.serviceprovider";
    public static final String APPLICATION_TAG = "SP" + APPLICATION_PACKAGE_NAME;
    public static boolean RELEASE_BUILD = false;
    public static boolean LIVE_BUILD = true;
    private static String BASE_URL;
    public static String WEBSERVICE_HOST;
    public static String PHONE_NO="0377778888";

    static
    {
        if (LIVE_BUILD)
        {
            WEBSERVICE_HOST = "http://124.40.245.154/carxpert/api/";
        }
        else
        {
            WEBSERVICE_HOST = "http://xyz.com";
        }
        BASE_URL = WEBSERVICE_HOST;
    }

    //---------------- Debug Options---------------------
    //Server Url
    //public static final String api_serverUrl= "http://124.40.245.154/carxpert/api/";
    //Internal Url
    public static final String api_serverUrl= "http://192.168.1.200/carxpert/api/";
    public static final String api_Register= api_serverUrl+"co/register";
    public static final String api_Login= api_serverUrl+"co/login";
    public static final String api_Mycar_Add= api_serverUrl+"co/mycar/add";

    //http://192.168.1.200/carxpert/api/co/login
    //preferences
    public static final String PREF_FILE_NAME = " com.bmsils.carexpertuserapp";
    //KEY
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_UID = "uid";
    public static final String KEY_IS_LOGGED = "islogged";
}
