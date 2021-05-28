package com.ppc_tp3_lopez.maquetado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileOutputStream;

public class Pantalla3 extends AppCompatActivity {

    View layoutFotos;
    ImageView img1;
    Button btnEnviar1;
    ImageView img2;
    Button btnEnviar2;
    ImageView img3;
    Button btnEnviar3;
    ImageView img4;
    Button btnEnviar4;
    ImageView img5;
    Button btnEnviar5;
    ImageView img6;
    Button btnEnviar6;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        layoutFotos = findViewById(R.id.layoutFotos);

        img1 = (ImageView) findViewById(R.id.img1);
        btnEnviar1 = (Button) findViewById(R.id.btnEnviar1);
        btnEnviar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirImg(img1);
            }
        });

        img2 = (ImageView) findViewById(R.id.img2);
        btnEnviar2 = (Button) findViewById(R.id.btnEnviar2);
        btnEnviar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirImg(img2);
            }
        });

        img3 = (ImageView) findViewById(R.id.img3);
        btnEnviar3 = (Button) findViewById(R.id.btnEnviar3);
        btnEnviar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirImg(img3);
            }
        });

        img4 = (ImageView) findViewById(R.id.img4);
        btnEnviar4 = (Button) findViewById(R.id.btnEnviar4);
        btnEnviar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirImg(img4);
            }
        });

        img5 = (ImageView) findViewById(R.id.img5);
        btnEnviar5 = (Button) findViewById(R.id.btnEnviar5);
        btnEnviar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirImg(img5);
            }
        });

        img6 = (ImageView) findViewById(R.id.img6);
        btnEnviar6 = (Button) findViewById(R.id.btnEnviar6);
        btnEnviar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirImg(img6);
            }
        });
    }

    private void compartirImg(ImageView imageView){

        if(imageView == null){
            throw new RuntimeException();
        }

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        File file = new File(getExternalCacheDir()+"/ppc_tp3_lopez.png");

        Intent shareIntent = new Intent(Intent.ACTION_SEND);

        try{
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

            outputStream.flush();
            outputStream.close();

            shareIntent.setType("image/*");
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        } catch (Exception e) {
            Snackbar.make(findViewById(R.id.layoutFotos), R.string.msgErrorEnvioImg, Snackbar.LENGTH_SHORT).show();
        }

        startActivity(shareIntent);
    }
}