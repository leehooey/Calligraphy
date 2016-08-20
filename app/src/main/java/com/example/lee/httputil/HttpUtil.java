package com.example.lee.httputil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lee on 2015/11/6.
 */
public class HttpUtil {
    public void HttpUtil(){

    }
    public static String getHtmlContent(StringBuilder date){
        try {
            URL url=new URL("http://www.52maobizi.com/");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(8000);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(date.toString().getBytes().length));
            PrintWriter pw=new PrintWriter(connection.getOutputStream());
            pw.print(date);
            pw.flush();
            pw.close();
            int code=connection.getResponseCode();
            if(code==200){
                return changeInputStream(connection.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String changeInputStream(InputStream is){
        String xmlString="";
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        int len=0;
        byte[] date=new byte[1024];
        try {
            while ((len=is.read(date))!=-1){
                    outputStream.write(date,0,len);
            }
            xmlString=new String(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xmlString;
    }
}
