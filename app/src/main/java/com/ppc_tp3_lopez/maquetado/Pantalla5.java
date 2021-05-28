package com.ppc_tp3_lopez.maquetado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pantalla5 extends AppCompatActivity {

    ImageView img7;
    Button btnEnviar7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla5);

        img7 = (ImageView) findViewById(R.id.img7);

        btnEnviar7 = (Button) findViewById(R.id.btnEnviar7);
        btnEnviar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartirImg(img7);
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
            Snackbar.make(findViewById(R.id.layoutPantalla5), R.string.msgErrorEnvioImg, Snackbar.LENGTH_SHORT).show();
        }

        startActivity(shareIntent);
    }
}