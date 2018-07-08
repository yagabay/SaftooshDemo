package com.vismus.saftooshdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {

    public static String getBasePath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/saftoosh";
    }

    public static boolean saveBitmapToFile(Context context, Bitmap bitmap, String filePath, String fileName){
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(filePath, fileName);
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, fileOutputStream);
        }
        catch (FileNotFoundException e) {
            return false;
        }
        try{
            fileOutputStream.flush();
            fileOutputStream.close();
        }
        catch(IOException e){
            return false;
        }
        return true;
    }

    public static boolean writeBitmapResourceToFile(Context context, int resourceId, String filePath, String fileName){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        return saveBitmapToFile(context, bitmap, filePath, fileName);
    }

    public static Bitmap readBitmapFromFile(Context context, String filePath){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(filePath, options);
    }
}
