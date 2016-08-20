package com.example.lee.saveimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.example.lee.ilovecalligraphy.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Lee on 2015/11/11.
 */
public class SaveImage {
    public static void saveImage(Bitmap bmp,Activity activity) {
        File file = new File("/sdcard/myFolder");
        if (!file.exists())
            file.mkdir();
        file = new File("/sdcard/" + MainActivity.content.getText().toString() + ".jpg".trim());
        String fileName = file.getName();
        String mName = fileName.substring(0, fileName.lastIndexOf("."));
        String sName = fileName.substring(fileName.lastIndexOf("."));
        // /sdcard/myFolder/temp_cropped.jpg
        String newFilePath = "/sdcard/myFolder" + "/" + mName + sName;
        file = new File(newFilePath);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 50, fos);
            fos.flush();
            fos.close();
            Toast.makeText(activity, "保存图片路径:/sdcard/myFolder", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
