package com.vismus.saftooshdemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vismus.saftooshdemo.R;

public abstract class MediaItemDisplayFragment extends Fragment{

    String _filePath;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_media_item_display, container, false);
        _filePath = getArguments().getString("FILE_PATH");
        return rootView;
    }

    public abstract void startPlayback();

    public abstract void stopPlayback();

    public abstract boolean isPlaying();
}
