package com.example.tom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    ImageButton btnpic;
    ImageView imgtakenpic;
    private static final int CAM_REQUEST=1313;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnpic = (ImageButton) findViewById(R.id.imageButton);
        imgtakenpic = (ImageView) findViewById(R.id.imageView);
        btnpic.setOnClickListener(new btntakephotoclicker());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAM_REQUEST){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgtakenpic.setImageBitmap(bitmap);
        }
    }

    class btntakephotoclicker implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAM_REQUEST);
        }
    }
}
