package com.randompandaa.plandaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Camera extends AppCompatActivity {

    private ImageView imgView;
    private Button camBtn, backBtn;

    private static final int REQUEST_CODE_GET_CONTENT = 10;
    private static final int REQUEST_CODE_IMAGE_CAPTURE = 20;
    private static final int REQUEST_CODE_PERMISSIONS_CAMERA = 30;

    ImageView ivImage;
    TextView tvUserAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        tvUserAction = findViewById(R.id.textView);
        ivImage = findViewById(R.id.imageView);
        Button bCamera = findViewById(R.id.button);
        Button bGallery = findViewById(R.id.button2);
        Button backBtn = findViewById(R.id.back_btn);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camera.this, MainActivity.class);
                startActivity(intent);
            }
        });



        bCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePictureFromCamera();
            }
        });
        bGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                if(galleryIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(galleryIntent, REQUEST_CODE_GET_CONTENT);
                }
            }
        });
    }
    public void cameraIntent() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(cameraIntent, REQUEST_CODE_IMAGE_CAPTURE);
        }
    }
    public void takePictureFromCamera() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(Camera.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Camera.this, Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions(Camera.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_PERMISSIONS_CAMERA);
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(Camera.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_PERMISSIONS_CAMERA);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            cameraIntent();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE_PERMISSIONS_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    cameraIntent();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(getApplicationContext(), "Camera permission denied by the user", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_GET_CONTENT && resultCode==RESULT_OK) {
            try {
                Uri imageUri = data.getData();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                ivImage.setImageBitmap(bitmap);
                tvUserAction.setText("Image picked from Gallery");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Exception: "+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        if(requestCode==REQUEST_CODE_IMAGE_CAPTURE && resultCode==RESULT_OK) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            ivImage.setImageBitmap(bitmap);
            tvUserAction.setText("Image captured by Camera");
        }
    }
}


//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_camera);
//        imgView = findViewById(R.id.capturedImage);
//        camBtn = findViewById(R.id.openCam);
//
//        camBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(open_camera, 100);
//            }
//        });
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Bitmap photo = (Bitmap)data.getExtras().get("data");
//        imgView.setImageBitmap(photo);
//    }
//}