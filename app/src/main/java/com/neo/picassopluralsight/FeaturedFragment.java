package com.neo.picassopluralsight;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.neo.picassopluralsight.Utilities.FeaturedAdapter;
import com.neo.picassopluralsight.Utilities.FeaturedItem;

import java.util.ArrayList;

public class FeaturedFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_featured, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_featured);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<FeaturedItem> images = new ArrayList<>();
        images.add(new FeaturedItem("ground.jpg", "The Best Cofee", "A very nice way to start your day"));
        images.add(new FeaturedItem("table.jpg", "Stay for a while", "desc 2"));
        images.add(new FeaturedItem("beans.jpg", "Freshly Roasted", "desc 3"));
        images.add(new FeaturedItem("granola.jpg", "Healthy Bites", "desc 4"));
        images.add(new FeaturedItem("bag.jpg", "Smells to go", "desc 5"));

        mAdapter = new FeaturedAdapter(images, getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
