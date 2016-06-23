package com.zmax.allsamples.appintro;
import android.graphics.Color;
import android.os.Bundle;
import com.github.paolorotolo.appintro.AppIntro;
import com.zmax.allsamples.R;
/**
 * Created by bfonics on 12/22/2015.
 */
public class AppIntro_Samp extends AppIntro
{
    //https://github.com/PaoloRotolo/AppIntro

    @Override
    public void init(Bundle savedInstanceState)
    {
        addSlide(SampleSlide.newInstance(R.layout.intro));
        addSlide(SampleSlide.newInstance(R.layout.intro2));
        addSlide(SampleSlide.newInstance(R.layout.intro3));
        addSlide(SampleSlide.newInstance(R.layout.intro4));
        addSlide(SampleSlide.newInstance(R.layout.intro5));
        setFadeAnimation();

        /*
        setFadeAnimation();
        setZoomAnimation();
        setFlowAnimation();
        setSlideOverAnimation();
        setDepthAnimation();
        */

        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        //addSlide(AppIntroFragment.newInstance("Mahesh", "T", image,Color.parseColor("#ADB1B2") ));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.TRANSPARENT);
        setSeparatorColor(Color.parseColor("#7a7a7a"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permisssion in Manifest.
        //setVibrate(true);
        //setVibrateIntensity(30);

    }

    @Override
    public void onSkipPressed()
    {

    }

    @Override
    public void onNextPressed()
    {

    }

    @Override
    public void onDonePressed()
    {

    }

    @Override
    public void onSlideChanged()
    {

    }
}
