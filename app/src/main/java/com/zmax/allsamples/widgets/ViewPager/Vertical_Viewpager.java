package com.zmax.allsamples.widgets.ViewPager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.zmax.allsamples.R;
public class Vertical_Viewpager extends AppCompatActivity
{
    SharedPreferences userPref;
    boolean isLoggedIn = false;
    Context ctx;
    boolean ischecked;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_viewpager);
        ctx = Vertical_Viewpager.this;
    }
}
