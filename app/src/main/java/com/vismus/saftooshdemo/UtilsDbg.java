package com.vismus.saftooshdemo;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UtilsDbg {

    public static void toastStatus(Context context, boolean status, String desc){
        Toast.makeText(context, (status ? "success: " : "fail: ") + desc, Toast.LENGTH_SHORT).show();
    }

    public static void storePictures(Context context) {
//        UtilsDbg.toastStatus(context , Utils.writeBitmapResourceToFile(context, R.mipmap.picture    1, Utils.getBasePath(), "picture1.jpg"), "store picture1");
//        UtilsDbg.toastStatus(context , Utils.writeBitmapResourceToFile(context, R.mipmap.picture2, Utils.getBasePath(), "picture2.jpg"), "store picture2");
//        UtilsDbg.toastStatus(context , Utils.writeBitmapResourceToFile(context, R.mipmap.picture3, Utils.getBasePath(), "picture3.jpg"), "store picture3");
    }

    public static String storeAudios(Context context){
        byte[] buffer;
        //InputStream fIn = context.getResources().openRawResource(R.raw.audio_2);
        InputStream fIn = null;
        int size;

        try {
            size = fIn.available();
            buffer = new byte[size];
            fIn.read(buffer);
            fIn.close();
        } catch (IOException e) {
            Toast.makeText(context, "IOException 1", Toast.LENGTH_SHORT).show();
            return "";
        }

        String path = context.getExternalCacheDir().getAbsolutePath();
        String filename = "audio_2.3gp";

        boolean exists = (new File(path)).exists();
        if (!exists){new File(path).mkdirs();}

        FileOutputStream save;
        try {
            save = new FileOutputStream(path+filename);
            save.write(buffer);
            save.flush();
            save.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "FileNotFoundException", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(context, "IOException 2", Toast.LENGTH_SHORT).show();
        }
        return path+filename;
    }

    public static String storeVideos(Context context){
        byte[] buffer;
        //InputStream fIn = context.getResources().openRawResource(R.raw.video_1);
        InputStream fIn = null;
        int size;

        try {
            size = fIn.available();
            buffer = new byte[size];
            fIn.read(buffer);
            fIn.close();
        } catch (IOException e) {
            Toast.makeText(context, "IOException 1", Toast.LENGTH_SHORT).show();
            return "";
        }

        String path = context.getExternalCacheDir().getAbsolutePath();
        String filename = "video_1.mp4";

        boolean exists = (new File(path)).exists();
        if (!exists){new File(path).mkdirs();}

        FileOutputStream save;
        try {
            save = new FileOutputStream(path+filename);
            save.write(buffer);
            save.flush();
            save.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "FileNotFoundException", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(context, "IOException 2", Toast.LENGTH_SHORT).show();
        }
        return path+filename;
    }

    public static boolean isFileExist(String filePath){
        return new File(filePath).exists();
    }

}
