package com.madebyasshad.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView img;
    private static final int CAMERA_REQUEST = 1888;

    String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap mImageUri;
    private static final  int GALLERY_REQUEST =1;

    private static final int CAMERA_REQUEST_CODE=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.buttonfor);
        img=findViewById(R.id.imageViewfor);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, CAMERA_REQUEST_CODE);
                }

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){
        if(requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK){


            mImageUri = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(mImageUri);


            show();










        }
    }

    public void show()
    {
        Toast.makeText(getApplicationContext(),"imageuri"+mImageUri,Toast.LENGTH_SHORT).show();

    }

}
