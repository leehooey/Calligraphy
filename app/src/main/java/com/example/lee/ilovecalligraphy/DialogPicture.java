package com.example.lee.ilovecalligraphy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lee.saveimage.SaveImage;

import java.io.ByteArrayInputStream;

/**
 * Created by Lee on 2015/11/6.
 */
public class DialogPicture extends Activity {
    ImageView imageView;
    Bitmap bitmap;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        imageView = (ImageView) this.findViewById(R.id.imagV);

        Bundle bundle = getIntent().getExtras();
        byte[] bt = bundle.getByteArray("picture");
        ByteArrayInputStream os = new ByteArrayInputStream(bt);
        bitmap = BitmapFactory.decodeStream(os);
        button=(Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bitmap == null) {
                    Toast.makeText(DialogPicture.this, "没有可保存的图片", Toast.LENGTH_SHORT).show();
                } else {
                   SaveImage.saveImage(bitmap, DialogPicture.this);
                }
            }
        });
        Matrix m = new Matrix();
        m.setRotate(90, (float) bitmap.getWidth() / 2, (float) bitmap.getHeight() / 2);
        try {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
        } catch (OutOfMemoryError ex) {
        }
        imageView.setImageBitmap(bitmap);
    }


}
