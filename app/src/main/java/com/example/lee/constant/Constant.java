package com.example.lee.constant;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lee.ilovecalligraphy.MainActivity;
import com.example.lee.ilovecalligraphy.R;

/**
 * java不能多继承
 * Mainactivity既要继承Constant又要继承appcompatactivity只能让constant继承appcompatactivity
 * 在让mainavtivity继承content
 * <p>
 * <p>
 * Created by Lee on 2015/11/11.
 */
public class Constant extends AppCompatActivity {
    public static int width = 489, height = 359, size = 220;
    public static String textC = "#000000", bgC = "#FFFFFF";
    public static Button onlineTranslation;
    public static TextView chooseText;
    public static EditText content;
    public static ListView gridView;
    public static int tb = 0;
    public static char[] con;
    public static BaseAdapter adapter;
    public static Bitmap[] bitmap;
    public static Handler handler = new Handler() {

        public void handleMessage(Message mg) {
            if (mg.what == 0x345) {
                final Activity activity = (Activity) mg.obj;
                for (int i = 0; i < MainActivity.con.length; i++) {
                    adapter = new BaseAdapter() {
                        @Override
                        public int getCount() {
                            return con.length;
                        }

                        @Override
                        public Object getItem(int position) {
                            return null;
                        }

                        @Override
                        public long getItemId(int position) {
                            return 0;
                        }

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            if (convertView == null) {
                                convertView=activity.getLayoutInflater().inflate(R.layout.item,null);
                            }
                            ProgressBar progressBar= (ProgressBar) convertView.findViewById(R.id.progressBar13);
                            if(bitmap[position]!=null){
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                            ImageView imageView= (ImageView) convertView.findViewById(R.id.img);
                            imageView.setImageBitmap(bitmap[position]);
                            return convertView;
                        }
                    };
                }
                gridView.setAdapter(adapter);


            }
        }
    };

}
