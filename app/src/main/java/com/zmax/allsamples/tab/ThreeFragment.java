package com.zmax.allsamples.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zmax.allsamples.R;


public class ThreeFragment extends Fragment
{
    public ThreeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        System.out.println("Fragment----->3");
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        System.out.println("Fragment----->3---->OnStart");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        System.out.println("Fragment----->3---->onResume");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        System.out.println("Fragment----->3---->onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        System.out.println("Fragment----->1---->onStop");
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        System.out.println("Fragment----->3---->onDestroyView");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        System.out.println("Fragment----->3---->onDestroy");
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        System.out.println("Fragment----->3---->onDetach");
    }
}
