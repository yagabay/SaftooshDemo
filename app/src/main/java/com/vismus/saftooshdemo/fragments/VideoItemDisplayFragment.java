package com.vismus.saftooshdemo.fragments;

import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

import com.vismus.saftooshdemo.R;

public class VideoItemDisplayFragment extends MediaItemDisplayFragment {

    VideoView _vdvVideoItem;
    ImageView _imvVideoItemThumb;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        FrameLayout rootView = (FrameLayout) super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_video_item_display, container, false);

        // find views
        _vdvVideoItem = viewGroup.findViewById(R.id.vdv_video_item);
        _imvVideoItemThumb = viewGroup.findViewById(R.id.imv_video_item_thumb);
        ImageButton btnPlayback = viewGroup.findViewById(R.id.btn_playback);

        // init views
        _vdvVideoItem.setMediaController(null);
        _vdvVideoItem.setVideoPath(_filePath);
        _imvVideoItemThumb.setImageBitmap(ThumbnailUtils.createVideoThumbnail(_filePath, MediaStore.Images.Thumbnails.MINI_KIND));

        btnPlayback.setOnClickListener(new OnPlaybackButtonClickListener());

        rootView.addView(viewGroup);
        return rootView;
    }

    @Override
    public void startPlayback(){
        _imvVideoItemThumb.setVisibility(View.INVISIBLE);
        _vdvVideoItem.start();
    }

    @Override
    public void stopPlayback(){
        _imvVideoItemThumb.setVisibility(View.VISIBLE);
        _vdvVideoItem.pause();
        _vdvVideoItem.seekTo(0);
    }

    @Override
    public boolean isPlaying(){
        return _vdvVideoItem.isPlaying();
    }

    class OnPlaybackButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(!isPlaying()){
                startPlayback();
            }
            else{
                stopPlayback();
            }
        }
    }

}
