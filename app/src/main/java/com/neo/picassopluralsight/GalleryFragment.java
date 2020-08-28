package com.neo.picassopluralsight;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;

import androidx.annotation.Nullable;


import com.neo.picassopluralsight.Utilities.GalleryAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryFragment extends Fragment implements AbsListView.OnScrollListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        ArrayList<String> imageUrls = new ArrayList<>();
        imageUrls.add("bag.jpg");
        imageUrls.add("beans.jpg");
        imageUrls.add("granola.jpg");
        imageUrls.add("ground.jpg");
        imageUrls.add("table.jpg");
        imageUrls.add("trail.jpg");
        imageUrls.add("coffee.jpg");
        imageUrls.add("bag.jpg");
        imageUrls.add("beans.jpg");
        imageUrls.add("granola.jpg");
        imageUrls.add("ground.jpg");
        imageUrls.add("table.jpg");
        imageUrls.add("trail.jpg");
        imageUrls.add("coffee.jpg");
        imageUrls.add("bag.jpg");
        imageUrls.add("beans.jpg");
        imageUrls.add("granola.jpg");
        imageUrls.add("ground.jpg");
        imageUrls.add("table.jpg");
        imageUrls.add("trail.jpg");
        imageUrls.add("coffee.jpg");
        imageUrls.add("bag.jpg");
        imageUrls.add("beans.jpg");
        imageUrls.add("granola.jpg");
        imageUrls.add("ground.jpg");
        imageUrls.add("table.jpg");
        imageUrls.add("trail.jpg");
        imageUrls.add("coffee.jpg");

        GridView gridGallery = (GridView) view.findViewById(R.id.grid_gallery);
        GalleryAdapter gridAdapter = new GalleryAdapter(getContext(), R.layout.gallery_item_layout, imageUrls);
        gridGallery.setAdapter(gridAdapter);
        gridGallery.setOnScrollListener(this);

        return view;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(scrollState == SCROLL_STATE_IDLE || scrollState == SCROLL_STATE_TOUCH_SCROLL){
            Picasso.with(getContext()).resumeTag("gallery");
        } else{
            Picasso.with(getContext()).pauseTag("gallery");
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
