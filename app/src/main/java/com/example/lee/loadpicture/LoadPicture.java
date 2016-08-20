package com.example.lee.loadpicture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lee on 2015/11/6.
 */
public class LoadPicture {
    static Bitmap bitmap;
    public static String getPicturePath(String xmlContent){
        String getSignInfo = xmlContent.substring(xmlContent.indexOf("id=\"imgResult\"")+14,xmlContent.indexOf("</section>"));
        getSignInfo=getSignInfo.substring(0,200);
        getSignInfo=getSignInfo.substring(getSignInfo.indexOf("src=\"")+5,getSignInfo.indexOf("\"/>"));
        return getSignInfo;
    }
    public static void getPicture(String xmlContent){
        String url_path=getPicturePath(xmlContent);
        try {
            URL url=new URL(url_path);
            InputStream is=url.openStream();
            bitmap= BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Bitmap getBitmap(){
        return bitmap;
    }
}
