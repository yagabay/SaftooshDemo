package com.vismus.saftooshdemo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.vismus.saftooshdemo.R;
import com.vismus.saftooshdemo.MediaDisplayPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MediaDisplayFragment extends Fragment {

    Context _context;

    ViewPager _vpgMediaDisplay;
    ImageButton _btnNextItem;

    MediaDisplayPagerAdapter _mediaDisplayPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_media_display, container, false);
        _context = getContext();

        // find views
        _vpgMediaDisplay = rootView.findViewById(R.id.vpg_media_display);
        _btnNextItem = rootView.findViewById(R.id.btn_next_item);

        // set adapters & listeners
        _mediaDisplayPagerAdapter = new MediaDisplayPagerAdapter(getActivity().getSupportFragmentManager());
        _vpgMediaDisplay.setAdapter(_mediaDisplayPagerAdapter);
        _btnNextItem.setOnClickListener(new OnNextItemButtonClickListener());

        addMediaItems();
        return rootView;
    }

    void addMediaItems() {
        List<MediaItemDisplayFragment> items = new ArrayList<>();
        MediaItemDisplayFragment f1 = new PictureItemDisplayFragment();
        Bundle a1 = new Bundle();
        a1.putString("FILE_PATH", Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/img01.jpg");
        f1.setArguments(a1);
        items.add(f1);
        MediaItemDisplayFragment f2 = new PictureItemDisplayFragment();
        Bundle a2 = new Bundle();
        a2.putString("FILE_PATH", Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/img02.jpg");
        f2.setArguments(a2);
        items.add(f2);
        MediaItemDisplayFragment f3 = new PictureItemDisplayFragment();
        Bundle a3 = new Bundle();
        a3.putString("FILE_PATH", Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/img03.jpg");
        f3.setArguments(a3);
        items.add(f3);
        MediaItemDisplayFragment f4 = new VideoItemDisplayFragment();
        Bundle a4 = new Bundle();
        a4.putString("FILE_PATH", Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/vid01.mp4");
        f4.setArguments(a4);
        items.add(f4);
        MediaItemDisplayFragment f5 = new PictureItemDisplayFragment();
        Bundle a5 = new Bundle();
        a5.putString("FILE_PATH", Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/img04.jpg");
        f5.setArguments(a5);
        items.add(f5);
        MediaItemDisplayFragment f6 = new VideoItemDisplayFragment();
        Bundle a6 = new Bundle();
        a6.putString("FILE_PATH", Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/vid02.mp4");
        f6.setArguments(a6);
        items.add(f6);
        _mediaDisplayPagerAdapter.setItems(items);
        _mediaDisplayPagerAdapter.notifyDataSetChanged();
    }

    class OnNextItemButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view){
            MediaItemDisplayFragment itemDisplayFragment =
                    (MediaItemDisplayFragment) _mediaDisplayPagerAdapter.getItem(_vpgMediaDisplay.getCurrentItem());
            itemDisplayFragment.stopPlayback();
            _vpgMediaDisplay.setCurrentItem((_vpgMediaDisplay.getCurrentItem() + 1) % _mediaDisplayPagerAdapter.getCount(), false);
        }
    }

}
