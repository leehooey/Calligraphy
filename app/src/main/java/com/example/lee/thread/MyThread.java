package com.example.lee.thread;


import android.app.Activity;
import android.os.Message;

import com.example.lee.httputil.HttpUtil;
import com.example.lee.ilovecalligraphy.MainActivity;
import com.example.lee.loadpicture.LoadPicture;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Lee on 2015/11/5.
 */
public class MyThread implements Runnable {
    String FontInfoId, FontSize, ImageWidth, ImgeHeight;
    String Content;
    String FontColor;
    String ImageBgColor;
    Activity activity;
    int ActionCategory = 1;
    int i;
    public MyThread(String s, String s1, String s2, String s3, String s4,String s5,String s6,int i,Activity activity) {
        this.FontInfoId = s;
        this.FontSize = s1;
        this.ImageWidth = s2;
        this.ImgeHeight = s3;
        this.Content = s4;
        if(s5.equals("透明")){
            this.ImageBgColor="";
        }else{
            this.ImageBgColor=s5;
        }
        this.FontColor=s6;
        this.i=i;
        this.activity=activity;
    }


    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontInfoId=" + FontInfoId);
        sb.append("&FontSize=" + FontSize);
        sb.append("&FontColor=" + FontColor);
        sb.append("&ImageWidth=" + ImageWidth);
        sb.append("&ImageHeight=" + ImgeHeight);
        sb.append("&ImageBgColor=" + ImageBgColor);
        try {
            Content = URLEncoder.encode(Content, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append("&Content=" + Content);
        sb.append("&ActionCategory=" + ActionCategory);
        String htmlString = HttpUtil.getHtmlContent(sb);
        LoadPicture.getPicture(htmlString);

        MainActivity.bitmap[i] = LoadPicture.getBitmap();
        Message message=new Message();
        message.what=0x345;
        message.obj=activity;
        MainActivity.handler.sendMessage(message);
    }

}
