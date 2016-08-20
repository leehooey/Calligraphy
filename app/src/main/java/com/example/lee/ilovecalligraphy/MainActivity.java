package com.example.lee.ilovecalligraphy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.lee.constant.Constant;
import com.example.lee.dialog.Dialog;
import com.example.lee.network.NetWork;
import com.example.lee.register.Register;
import com.example.lee.thread.MyThread;

import java.io.ByteArrayOutputStream;


public class MainActivity extends Constant
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Register.getRegister(this);//注册控件
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.instruction) {
            Dialog.getdialog1(this);
        } else if (id == R.id.textColor) {
            Dialog.getdialog2(this, 1, item);
        } else if (id == R.id.bgColor) {
            Dialog.getdialog2(this, 2, item);
        } else if (id == R.id.textSize) {
            Dialog.getdialog3(this, 1, item);
        } else if (id == R.id.widths) {
            Dialog.getdialog3(this, 2, item);
        } else if (id == R.id.heights) {
            Dialog.getdialog3(this, 3, item);
        } else if (id == R.id.suggest) {
            Intent intent = new Intent(MainActivity.this, Suggest.class);
            startActivity(intent);
        } else if (id == R.id.about_me) {
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
        } else if (id == R.id.update) {
            Toast.makeText(MainActivity.this, "暂不支持该功能!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(MainActivity.this, "暂不支持该功能!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.update) {
            Toast.makeText(MainActivity.this, "暂不支持该功能!", Toast.LENGTH_SHORT).show();
        }
        //点击item后侧边栏消失
       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);*/
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chooseText:
                Dialog.getdialog(this);
                break;
            case R.id.onlineTranslation:
                if (tb == 0 && content.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "请选择字体及填写内容!", Toast.LENGTH_SHORT).show();
                } else if (tb == 0) {
                    Toast.makeText(MainActivity.this, "请选择字体!", Toast.LENGTH_SHORT).show();
                } else if (content.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "请填写内容!", Toast.LENGTH_SHORT).show();
                } else if (NetWork.isNetWorkAvailable(MainActivity.this) == false) {
                    Toast.makeText(MainActivity.this, "当前网络不可用", Toast.LENGTH_SHORT).show();
                } else {
                    bitmap = new Bitmap[100];
                    con = content.getText().toString().toCharArray();
                    for (int i = 0; i < con.length; i++) {
                        Message message = new Message();
                        message.what = 0x345;
                        message.obj = this;
                        MainActivity.handler.sendMessage(message);
                        new Thread(new MyThread(tb + "", size + "", width + "", height + "", con[i] + "", bgC, textC, i, this)).start();
                    }
                }
                break;

        }
    }

    /*
    * 点击图片产生事件
    * */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(bitmap[position]==null){
            Toast.makeText(MainActivity.this, "图片正在加载中...", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(MainActivity.this, DialogPicture.class);
            Bundle bundle = new Bundle();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            bitmap[position].compress(Bitmap.CompressFormat.PNG, 100, os);
            byte[] by = os.toByteArray();
            bundle.putByteArray("picture", by);
            intent.putExtras(bundle);
            MainActivity.this.startActivity(intent);
        }

    }
}
