package com.zmax.allsamples.networks;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by BMS2 on 10/15/2015.
 */
public class ImageLoader {
    public static final int CENTER_CROP = 1, CENTER_INSIDE = 2;

    private static ImageLoader instance = null;

    private ImageLoader() {
        // Exists only to defeat instantiation.
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    public void simpleImageLoad(Context context, String imageUrl, ImageView imageView) {

        Picasso.with(context).load(imageUrl).into(imageView);
    }

    public void croppedImageLoad(Context context, String imageUrl, ImageView imageView, int cropType) {
        switch (cropType) {
            case CENTER_CROP:
                Picasso.with(context).load(imageUrl).centerCrop().into(imageView);
                break;
            case CENTER_INSIDE:
                Picasso.with(context).load(imageUrl).centerInside().into(imageView);
                break;
        }
    }

    public void resizeImageLoad(Context context, String imageUrl, ImageView imageView, int resizeWidth, int resizeHeight) {
        Picasso.with(context).load(imageUrl).resize(resizeWidth, resizeHeight).into(imageView);
    }

    public void effectImageLoad(Context context, String imageUrl, ImageView imageView, int resizeWidth, int resizeHeight) {
        Picasso.with(context).load(imageUrl).noFade().into(imageView);
    }


    public void loadImage(Context context, String imageUrl, ImageView imageView,
                          int rotateAngle) {
        Picasso.with(context)
                .load(imageUrl)
                .rotate(rotateAngle)
                .into(imageView);
    }
}
