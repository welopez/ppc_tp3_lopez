package com.ppc_tp3_lopez.maquetado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class Pantalla3 extends AppCompatActivity {

    View layoutFotos;
    ImageView img1;
    Button btnEnviar1;

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
                Uri uriImagen = Uri.parse("android.resource://" + getPackageName() +"/"+R.drawable.img2);
                compartirImg(uriImagen);
            }


//            @Override
//            public void onClick(View v) {
//                img1.buildDrawingCache();
//                Bitmap bitmap = img1.getDrawingCache();
//
//                /***** COMPARTIR IMAGEN *****/
//                try {
//                    File file = new File(getCacheDir(), bitmap + ".png");
//                    FileOutputStream fOut = null;
//                    fOut = new FileOutputStream(file);
//                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
//                    fOut.flush();
//                    fOut.close();
//                    file.setReadable(true, false);
//                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
//                    intent.setType("image/png");
//                    startActivity(intent);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
        });
    }
    private void compartirImg(Uri uriImg){
        Intent shareIntent = new Intent();
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uriImg);

        startActivity(shareIntent);
    }
}