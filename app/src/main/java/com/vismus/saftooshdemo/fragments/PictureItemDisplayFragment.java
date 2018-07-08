package com.vismus.saftooshdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.vismus.saftooshdemo.R;
import com.vismus.saftooshdemo.Utils;

public class PictureItemDisplayFragment extends MediaItemDisplayFragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout rootView = (FrameLayout) super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_picture_item_display, container, false);
        ImageView imvPhotoItem = viewGroup.findViewById(R.id.imv_photo_item);
        imvPhotoItem.setImageBitmap(Utils.readBitmapFromFile(getContext(), _filePath));
        rootView.addView(viewGroup);
        return rootView;
    }

    @Override
    public void startPlayback(){ }

    @Override
    public void stopPlayback(){  }

    @Override
    public boolean isPlaying(){
        return false;
    }

}
