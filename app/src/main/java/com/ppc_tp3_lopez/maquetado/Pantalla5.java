package com.ppc_tp3_lopez.maquetado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Pantalla5 extends AppCompatActivity {

    ImageView img7;
    Button btnEnviar7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla5);

        btnEnviar7 = (Button) findViewById(R.id.btnEnviar7);
        btnEnviar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriImagen = Uri.parse("android.resource://" + getPackageName() +"/"+R.drawable.img7);
                compartirImg(uriImagen);
            }
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