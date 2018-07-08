package com.vismus.saftooshdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vismus.saftooshdemo.fragments.MediaItemDisplayFragment;

import java.util.ArrayList;
import java.util.List;

public class MediaDisplayPagerAdapter extends FragmentStatePagerAdapter {

    List<MediaItemDisplayFragment> _items;

    public MediaDisplayPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        _items = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return _items.size();
    }

    @Override
    public Fragment getItem(int position) {
        return _items.get(position);
    }

    public void setItems(List<MediaItemDisplayFragment> items){
        _items = items;
    }

}
