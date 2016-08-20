package com.example.lee.ilovecalligraphy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Lee on 2015/11/16.
 */
public class Suggest extends AppCompatActivity {
    EditText editText;
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggest);
        editText=(EditText)this.findViewById(R.id.suggest);
        button=(Button)this.findViewById(R.id.sent);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }
}
