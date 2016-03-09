package com.example.rsvaio.send_receive_data;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;


public class Receive_Data extends AppCompatActivity{
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive__data);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        textView = (TextView) findViewById(R.id.ReceiveText);
        imageView = (ImageView) findViewById(R.id.imageView);
        if(Intent.ACTION_SEND.equals(action) && type!=null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent);
            }
            else if(type.startsWith("image/")){
                handleSendImage(intent);
            }
        }

    }

    void handleSendImage(Intent intent) {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            imageView.setImageURI(imageUri);
        }
    }

    private void handleSendText(Intent intent) {
        // Get the text from intent
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        // When Text is not null
        if (sharedText != null) {
            // Show the text as Toast message
            textView.setText(sharedText);
        }
    }
}
