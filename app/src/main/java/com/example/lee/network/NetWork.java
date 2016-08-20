package com.example.lee.network;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Lee on 2015/11/11.
 */
public class    NetWork {

    public static boolean isNetWorkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            for (int i = 0; i < networkInfo.length; i++) {
           //     System.out.println(networkInfo[i].getTypeName() + "  " + networkInfo[i].getState());
                if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {//获取设备是否可以联网
                    return true;
                }
            }
        }
        return false;
    }
}
