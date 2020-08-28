package com.neo.picassopluralsight.Utilities;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.neo.picassopluralsight.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ItemViewHolder> {
    private ArrayList<FeaturedItem> mItems;
    private Context mContext;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView mItemName;
        public TextView mItemDesc;
        public ImageView mImageView;

        public ItemViewHolder(View v) {
            super(v);
            mItemDesc = (TextView) v.findViewById(R.id.item_desc);
            mItemName = (TextView) v.findViewById(R.id.item_name);
            mImageView = (ImageView) v.findViewById(R.id.item_image);
        }
    }

    public FeaturedAdapter(ArrayList<FeaturedItem> items, Context context) {
        mItems = items;
        mContext = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.featured_view, parent, false);

        ItemViewHolder itemHolder = new ItemViewHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.mItemDesc.setText(mItems.get(position).getDescription());
        holder.mItemName.setText(mItems.get(position).getName());

        Picasso.with(mContext).load(UrlHelper.BaseUrl + mItems.get(position).getImageUrl())
//                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)                        // tells picasso not to retrieve image from mem cache
//                .networkPolicy(NetworkPolicy.NO_CACHE)
                .fit().centerCrop()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}