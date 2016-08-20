package com.example.lee.register;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lee.ilovecalligraphy.MainActivity;
import com.example.lee.ilovecalligraphy.R;

/**
 * Created by Lee on 2015/11/11.
 */
public class Register {

    public static void getRegister(Activity activity) {
        MainActivity.chooseText = (TextView) activity.findViewById(R.id.chooseText);
        MainActivity.chooseText.setOnClickListener((View.OnClickListener) activity);
        MainActivity.onlineTranslation = (Button) activity.findViewById(R.id.onlineTranslation);
        MainActivity.onlineTranslation.setOnClickListener((View.OnClickListener) activity);
        MainActivity.content = (EditText) activity.findViewById(R.id.content);
        MainActivity.content.setOnClickListener((View.OnClickListener) activity);
        MainActivity.gridView = (ListView) activity.findViewById(R.id.gridView);
        MainActivity.gridView.setOnItemClickListener((AdapterView.OnItemClickListener) activity);
        NavigationView navigationView = (NavigationView) activity.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) activity);

    }

}
