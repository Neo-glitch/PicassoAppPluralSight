package com.neo.picassopluralsight.Utilities;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;


/**
 * class that handles image transformation
 */
public class BannerTransformation implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        int originalHeight = source.getHeight();
        int totalMargin = originalHeight / 2;                                   // gets total amount of margin to crop out for wider view
        int croppedImageHeight = originalHeight/2;

        Bitmap croppedImage =
                Bitmap.createBitmap(source, 0, totalMargin / 2, source.getWidth(), croppedImageHeight);

        if(croppedImage != source){
            source.recycle();
        }

        return croppedImage;
    }

    @Override
    public String key() {
        return "BannerTransformation";              // identifier for this transformation
    }
}
