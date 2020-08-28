package com.neo.picassopluralsight;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.neo.picassopluralsight.Utilities.BannerTransformation;
import com.squareup.picasso.Picasso;

import java.net.URI;


public class CompanyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company, container, false);

        // picasso operation
        ImageView imgBanner = view.findViewById(R.id.image_banner);
//        Picasso.with(getContext()).load(R.drawable.beans).fit().centerCrop().into(imgBanner);
        Picasso.with(getContext()).load(R.drawable.beans).transform(new BannerTransformation()).into(imgBanner);

        ImageView imgAboutOne = view.findViewById(R.id.image_about_one);
        ImageView imgAboutTwo = view.findViewById(R.id.image_about_two);
        ImageView imgAboutThree = view.findViewById(R.id.image_about_three);

        Picasso.with(getContext()).load(R.drawable.check).resize(96, 96).into(imgAboutOne);
        Picasso.with(getContext()).load(R.drawable.check).into(imgAboutTwo);
        Picasso.with(getContext()).load(R.drawable.check).into(imgAboutThree);

        Button btnSubmit = view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri ImageUri = data.getData();                          // returns uri of image selected by user
        ImageView imgPreview = getActivity().findViewById(R.id.image_submission);
        Picasso.with(getContext()).load(ImageUri).into(imgPreview);
    }
}
