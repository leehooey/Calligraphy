package com.example.lee.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.example.lee.ilovecalligraphy.MainActivity;
import com.example.lee.ilovecalligraphy.R;
import com.example.lee.rgbtohex.HexToRgb;
import com.example.lee.rgbtohex.RgbToHex;

/**
 * Created by Lee on 2015/11/11.
 */
public class Dialog {
    static int[] rgb = new int[3];
    static SeekBar red, green, blue, sizeChoose;
    static EditText numbChoose;
    static View text;

    public static Handler handle = new Handler() {

        public void handleMessage(Message mg) {
            if (mg.what == 0x123) {
                text.setBackgroundColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
                red.setProgress(rgb[0]);
                green.setProgress(rgb[1]);
                blue.setProgress(rgb[2]);
            }
            if (mg.what == 0x234) {
                sizeChoose.setProgress(MainActivity.size);
                numbChoose.setText("" + MainActivity.size);
            }
            if (mg.what == 0x345) {
                sizeChoose.setProgress(MainActivity.height);
                numbChoose.setText("" + MainActivity.height);
            }
            if (mg.what == 0x456) {
                sizeChoose.setProgress(MainActivity.width);
                numbChoose.setText("" + MainActivity.width);
            }if(mg.what==0x567){
                numbChoose.setText(""+sizeChoose.getProgress());
            }
        }
    };

    public static void getdialog(final Activity activity) {
        final int[] textNumber = {0, 181, 185, 193, 186, 187, 196, 194, 204, 203, 222, 190, 191, 182,
                183, 188, 208, 216, 192, 195, 205, 206, 184, 225, 220, 221, 197, 198, 199, 200, 201,
                202, 226, 227, 229, 230, 233, 234, 236, 238, 217, 219, 209, 210, 212, 213, 214, 215};
        final String[] item = new String[]{"请选择字体...", "王羲之毛笔行书书法字体", "柳公权毛笔书法字体", "柳公权柳体繁体",
                "赵孟頫楷书毛笔书法", "欧体楷书毛笔字体", "颜真卿楷书毛笔书法字体", "颜体楷书毛笔书法",
                "经典繁颜体毛笔字", "经典繁毛楷字体", "方正狂草毛笔字体", "隶书书法字体", "方正魏碑简体",
                "毛泽东毛笔书法字体", "八大山人毛笔字体", "米芾行书毛笔字体", "文征明楷书字体", "于右任草书毛笔字体",
                "孙过庭毛笔草书字体", "褚遂良毛笔楷书字体", "启功体毛笔书法字体", "启功毛笔字体繁体", "李旭科行书毛笔书法字体",
                "曾正国行楷简体毛笔字", "叶根友行书繁毛笔字体", "书体坊禚效锋行草体毛笔字", "方正大草简体毛笔字",
                "华文行楷毛笔字体", "汉仪大隶书", "汉仪中隶书毛笔字体", "汉仪小隶书简体", "方正魏碑繁体书法字体",
                "钟齐流江毛笔草体", "钟齐王庆华毛笔简体字体", "段宁毛笔行书字体", "方正启笛简体", "良怀行书字体",
                "孙中山行书毛笔字体", "邓小平字体", "方正潇洒隶书繁体", "博洋草书", "日文毛笔行书字体", "叶根友毛笔行书简体",
                "金梅毛笔行书", "原云涯风味毛笔字体", "钟齐翰墨毛笔字体", "蔡云汉毛笔行书", "日本青柳隶书毛笔字体"};
        new AlertDialog.Builder(activity)
                .setTitle("请选择字体")
                .setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = item[which];
                        str = str.substring(0, 5);//显示文字为5个
                        MainActivity.chooseText.setText(str + "...");
                        MainActivity.tb = textNumber[which];
                        dialog.cancel();//点击后自动消失
                    }
                }).create().show();
    }

    public static void getdialog1(Activity activity) {
        new AlertDialog.Builder(activity)
                .setTitle("毛笔字在线生成器转换和使用诀窍")
                .setMessage("       我爱毛笔字网是目前字库最全功能最多的毛笔字体在线生成器，不需要任何软件即可在线生成毛笔字，是书法爱好者练毛笔字必备的查询工具。如果在本站提供的字库中没找到您需要的毛笔字体，请告诉我们帮您添加进来。使用技巧如下：\n" +
                        "1、输入内容：在上面的文本框中输入需要转换的文字内容，字数不限。\n" +
                        "2、选择字体：在选择框下拉菜单中查询你喜欢的字体，具体效果可以在下面的预览区中看到。\n" +
                        "3、生成字体：点击“在线生成”按钮即可。也可以直接在预览区中点击需要在线转换的毛笔字体。\n" +
                        "4、下载存档：点击“保存本地”按钮把在线生成转换的字体图片保存在自己的电脑上，本站不支持长期保存。\n" +
                        "5、分享收藏：通过分享按钮可以添加到网络收藏夹，或把毛笔字生成器在线转换制作的个性字体图片永久分享保存到QQ空间、新浪微博或腾讯微博上欣赏，绝对高端大气上档次。\n" +
                        "6、透明图片：如需在线生成背景透明的字体图片，直接删除背景颜色框里面的代码，或者在“背景颜色”选择框中选择顶部的红色斜杠即可。\n" +
                        "7、高级技巧：如果需要修改格式，可以对在上面的免费毛笔字体在线生成工具设置中设置字体大小、颜色、预览图宽度、高度、背景颜色等，多重复几次即可得到满意的效果。")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create().show();
    }

    public static void getdialog2(final Activity activity, final int i, final MenuItem item) {

        if (i == 1) {
            rgb = HexToRgb.getRgb(MainActivity.textC);
        }
        if (i == 2) {
            rgb = HexToRgb.getRgb(MainActivity.bgC);

        }
        handle.sendEmptyMessage(0x123);
        LinearLayout layout = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.dialog_dolorchoose, null);
        text = layout.findViewById(R.id.textStyle);
        red = (SeekBar) layout.findViewById(R.id.red);
        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rgb[0] = red.getProgress();
                text.setBackgroundColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        green = (SeekBar) layout.findViewById(R.id.green);
        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rgb[1] = green.getProgress();
                text.setBackgroundColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blue = (SeekBar) layout.findViewById(R.id.blue);
        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rgb[2] = blue.getProgress();
                text.setBackgroundColor(Color.rgb(rgb[0], rgb[1], rgb[2]));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new AlertDialog.Builder(activity)
                .setView(layout)
                .setPositiveButton("修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (i == 1) {
                            MainActivity.textC = RgbToHex.getHex(rgb[0], rgb[1], rgb[2]);
                            item.setTitle("字体颜色: " + MainActivity.textC);
                        } else if (i == 2) {
                            MainActivity.bgC = RgbToHex.getHex(rgb[0], rgb[1], rgb[2]);
                            item.setTitle("背景颜色: " + MainActivity.bgC);
                        }
                    }
                })
                .create()
                .show();

    }

    public static void getdialog3(Activity activity, final int i, final MenuItem item) {
        if (i == 1) {
            handle.sendEmptyMessage(0x234);
        } else if (i == 2) {
            handle.sendEmptyMessage(0x456);
        } else if (i == 3) {
            handle.sendEmptyMessage(0x345);
        }
        LinearLayout layout = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.dialog_sizechoose, null);
        numbChoose = (EditText) layout.findViewById(R.id.numbChoose);
        sizeChoose = (SeekBar) layout.findViewById(R.id.sizeChoose);
        sizeChoose.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                handle.sendEmptyMessage(0x567);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new AlertDialog.Builder(activity)
                .setView(layout)
                .setPositiveButton("修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (i == 1) {
                            MainActivity.size = Integer.parseInt(numbChoose.getText().toString());
                            item.setTitle("字体大小: " + MainActivity.size);
                        } else if (i == 2) {
                            MainActivity.width = Integer.parseInt(numbChoose.getText().toString());
                            item.setTitle("图片宽度: " + MainActivity.width);
                        } else if (i == 3) {
                            MainActivity.height = Integer.parseInt(numbChoose.getText().toString());
                            item.setTitle("图片高度: " + MainActivity.height);
                        }
                    }
                })
                .create()
                .show();
    }

}
