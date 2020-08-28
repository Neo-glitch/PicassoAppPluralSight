package com.neo.picassopluralsight;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.neo.picassopluralsight.Utilities.UrlHelper;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class LandingActivity extends AppCompatActivity {

    private Target mTarget;                                 // used to helping in loading images and image retrieval errors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        final ImageView landingLogo = (ImageView) findViewById(R.id.image_logo);
        mTarget = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                landingLogo.setImageBitmap(bitmap);                             // if image was downloaded successfully set image view to it
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                // when image not received display this
                Toast.makeText(LandingActivity.this, "Your internet connection needs more espresso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };

        Picasso.with(this).setLoggingEnabled(true);                     // sets piasso logging across app
        Picasso.with(this).setIndicatorsEnabled(true);                  // sets picasso cache indicators on and works globally
//        Picasso.with(this).load("http://www.alexwolfps.com/images/logo.png").into(landingLogo);
        Picasso.with(this).load("http://www.alexwolfps.com/images/logo.png").into(mTarget);

        // preCatching operations using fetch
        String[] urls = new String[]{
                "ground.jpg",
                "table.jpg",
                "beans.jpg",
                "granola.jpg",
                "bag.jpg"
        };

        for(String url : urls){
            Picasso.with(this).load(UrlHelper.BaseUrl + url).fetch();
        }
    }

    public void getStarted(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
