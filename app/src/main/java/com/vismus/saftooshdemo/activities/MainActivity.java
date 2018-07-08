package com.vismus.saftooshdemo.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.vismus.saftooshdemo.UtilsDbg;
import com.vismus.saftooshdemo.fragments.MediaDisplayFragment;
import com.vismus.saftooshdemo.R;

public class MainActivity extends AppCompatActivity {

    MediaDisplayFragment _mediaDisplayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions();
        showMainFragment();
//        boolean b = UtilsDbg.isFileExist(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures/img01.jpg");
//        Toast.makeText(this, b ? "yes" : "no", Toast.LENGTH_SHORT).show();
    }

    void showMainFragment(){
        _mediaDisplayFragment = new MediaDisplayFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.lay_main, _mediaDisplayFragment)
                .commit();
    }


    void requestPermissions(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
    }

}
