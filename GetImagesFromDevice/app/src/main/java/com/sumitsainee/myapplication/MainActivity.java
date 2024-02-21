package com.sumitsainee.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final int CAMERA_REQ_CODE=100;
    private final int GALARY_REQ_CODE=101;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCameraSelect,btnGalarySelect,btnPicUpload;
        btnPicUpload=findViewById(R.id.btnPicUpload);
        btnGalarySelect=findViewById(R.id.btnGalarySelect);
        btnCameraSelect=findViewById(R.id.btnCameraSelect);
        imageView=findViewById(R.id.upload_pic_frag_imageview);
        btnCameraSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera,CAMERA_REQ_CODE);
            }
        });
        btnGalarySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGalary=new Intent(Intent.ACTION_PICK);
                iGalary.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGalary,GALARY_REQ_CODE);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==CAMERA_REQ_CODE){
                Bitmap img=(Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(img);
            } else if (requestCode==GALARY_REQ_CODE) {

                imageView.setImageURI(data.getData());
            }
        }
    }
}