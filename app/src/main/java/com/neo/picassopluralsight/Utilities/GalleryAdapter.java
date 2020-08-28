package com.neo.picassopluralsight.Utilities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.neo.picassopluralsight.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class GalleryAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data;

    public GalleryAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        int twiceMax = 20;
        int actualMax = 10;
        int degrees = new Random().nextInt(twiceMax) - actualMax;                   // gives us a random int gen btw +10 and -ve 10

        Picasso.with(context).load(UrlHelper.BaseUrl + this.data.get(position))
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                .tag("gallery")                                                     // tag the image request
                .placeholder(R.drawable.ic_image_placeholder)
                .error(R.drawable.ic_error)                                         // loads this inCase image not loaded
                .rotate(degrees)
                .fit().centerCrop()
                .into((ImageView) convertView);

        return convertView;
    }
}